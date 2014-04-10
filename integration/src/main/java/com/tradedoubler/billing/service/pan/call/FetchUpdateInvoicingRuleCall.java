package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.fetch.FlowName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetch an update-invoicing-rule row from Pan.
 */
public class FetchUpdateInvoicingRuleCall extends AbstractDatabaseCall {

    private final static Logger log = LoggerFactory.getLogger(FetchUpdateInvoicingRuleCall.class);

    private static final RowMapper<ResellerInvoicingRuleEvent> rowMapperEvent = new ParameterizedRowMapper<ResellerInvoicingRuleEvent>() {
        @Override
        public ResellerInvoicingRuleEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ResellerInvoicingRuleEvent(Guid.createFromOracleDbGuid(rs.getString("reseller_inv_rule_event_id")).getGuid(), rs.getLong("reseller_invoice_rule_id"),rs.getTimestamp("create_date"),rs.getInt("event_type"));
        }
    };

    private static final RowMapper<ResellerInvoicingRule> rowMapperResellerInvoicingRule = FetchCreateInvoicingRuleCall.createRowMapperResellerInvoicingRule();

    public FetchUpdateInvoicingRuleCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public ResellerInvoicingRuleUpdated fetchResellerInvoicingRule() {

        List<ResellerInvoicingRuleEvent> events = getJdbcTemplate().query(
                "SELECT * FROM RESELLER_INVOICE_RULES_EVENTS " +
                        "WHERE processed='N' AND event_type=2 " +
                        "AND ROWNUM = 1", rowMapperEvent
        );


        if (events == null || events.isEmpty()){
            return null;
        }

        ResellerInvoicingRuleEvent event = events.get(0);

        log.info("Fetched one ResellerInvoicingRuleEvent: Guid=" + event.getResellerInvoicingRuleEventGuid() + " : Create Date=" + event.getEventCreateDate() +
                " : ResellerInvoicingRuleFk=" + event.getResellerInvoiceRuleId());

        List<ResellerInvoicingRule> invoicingRules = getJdbcTemplate().query(
                "SELECT rir.*, nvl(p.FIRSTNAME,'') || ' ' || nvl(p.LASTNAME,'') as issuer_reference_name\n" +
                "FROM reseller_invoice_rules rir,persons p \n" +
                "WHERE rir.id=" + event.getResellerInvoiceRuleId() + " and p.id=rir.issuer_ref_person_id",
                rowMapperResellerInvoicingRule
        );

        if (invoicingRules == null || invoicingRules.isEmpty()){
            // If it happens then adminDb has inconsistencies between reseller_invoice_rules_events and reseller_invoice_rules
            log.error("Inconsistency between reseller_invoice_rules_events and reseller_invoice_rules");
            return null;
        }

        // Extract the parameters from the fetched invoicing rule
        ResellerInvoicingRule resellerInvoicingRule = invoicingRules.get(0);

        log.info(resellerInvoicingRule.toString());

        int addressType = 1; // Always invoicing address
        Address invoicingAddress = new Address(resellerInvoicingRule.getAddressLine1(),resellerInvoicingRule.getAddressLine2(),
                resellerInvoicingRule.getCity(), resellerInvoicingRule.getCounty(), resellerInvoicingRule.getPostalCode(),
                resellerInvoicingRule.getCountryCode(), addressType);

        List<SplittingRule> splittingRules = new ArrayList<SplittingRule>();

        InvoiceRecipient invoiceRecipient = new InvoiceRecipient(
                resellerInvoicingRule.getInvoiceRecipientId(), resellerInvoicingRule.getInvoicingRuleId(),
                resellerInvoicingRule.getAttentionRow1(), resellerInvoicingRule.getAttentionRow2(),
                resellerInvoicingRule.getEmailAddress(),resellerInvoicingRule.isDefaultRecipient(),
                invoicingAddress,splittingRules);

        List<InvoiceRecipient> invoiceRecipients = new ArrayList<InvoiceRecipient>();
        invoiceRecipients.add(invoiceRecipient);
        List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();

        List<InvoicingRuleMessageRule> invoiceMessageRules = new ArrayList<InvoicingRuleMessageRule>();
        List<String> sourceSystemAgreementIds = new ArrayList<String>();
        sourceSystemAgreementIds.add(resellerInvoicingRule.getSourceSystemAgreementId());


        // Client parameters
        List<ClientMessageRule> clientInvoiceMessageRules = new ArrayList<ClientMessageRule>();
        // Should an invoice message rule be created?
        if (resellerInvoicingRule.getInvoiceMessage() != null && !resellerInvoicingRule.getInvoiceMessage().trim().isEmpty()){
            ClientMessageRule clientMessageRule = new ClientMessageRule(resellerInvoicingRule.getInvoiceMessageRuleId(),
                    String.valueOf(resellerInvoicingRule.getClientId()),resellerInvoicingRule.getInvoiceMessage(),
                    resellerInvoicingRule.getInvoiceMessageValidFrom(), resellerInvoicingRule.getInvoiceMessageValidTo());
            clientInvoiceMessageRules.add(clientMessageRule);
        }


        List<Integer> clientMarketIds = new ArrayList<Integer>();
        clientMarketIds.add(resellerInvoicingRule.getMarketId());

        // Create the meta data
        MetaData metaData = new MetaData(FlowName.UpdateInvoicingRulePan.name(), new Guid(event.getResellerInvoicingRuleEventGuid()),
                new Timestamp(event.getEventCreateDate()), "1.0","PAN");



        // Create the invoicing rule
        InvoicingRule invoicingRule = new InvoicingRule(String.valueOf(resellerInvoicingRule.getClientId()),resellerInvoicingRule.getMarketId(),
                    resellerInvoicingRule.getInvoicingRuleId(), resellerInvoicingRule.getInvoicingRuleName(),
                    resellerInvoicingRule.getDescription(), resellerInvoicingRule.getIssuerReference(),
                    resellerInvoicingRule.getClientReference(), resellerInvoicingRule.getCurrencyCode(),
                    resellerInvoicingRule.getDistributionMode(), resellerInvoicingRule.getTermsOfPayment(),
                    resellerInvoicingRule.getPostingProfile(), resellerInvoicingRule.isDisplayTDcommission(),
                    resellerInvoicingRule.getRevenueType() ,resellerInvoicingRule.getPaymentMethod(),
                    resellerInvoicingRule.isDeviatingExchangeRate(),invoiceRecipients,
                    purchaseOrders,invoiceMessageRules,sourceSystemAgreementIds);

        // Create the agreement
        String documentLink = null;
        Agreement agreement = new Agreement(resellerInvoicingRule.getSourceSystemAgreementId(), String.valueOf(resellerInvoicingRule.getClientId()),
                resellerInvoicingRule.getInvoicingRuleId(), resellerInvoicingRule.getAgreementDescription(),
                resellerInvoicingRule.getProductType(), resellerInvoicingRule.getAgreementMarketId(),
                resellerInvoicingRule.getAgreementCurrencyCode(), resellerInvoicingRule.getValidFrom(),
                resellerInvoicingRule.getValidTo(), documentLink);

        // Assemble necessary data
        InvoicingRuleUpdated invoicingRuleUpdated = new InvoicingRuleUpdated(metaData, invoicingRule);
        AgreementUpdated agreementUpdated = new AgreementUpdated(metaData, agreement);

        ResellerInvoicingRuleUpdated resellerInvoicingRuleUpdated = new ResellerInvoicingRuleUpdated(metaData,invoicingRuleUpdated,agreementUpdated);
        return resellerInvoicingRuleUpdated;
    }
}


