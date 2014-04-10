package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.fetch.FlowName;
import org.slf4j.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.*;

/**
 * Fetch one create-invoicing-rule row from Pan.
 */
public class FetchCreateInvoicingRuleCall extends AbstractDatabaseCall {

    private final static Logger log = LoggerFactory.getLogger(FetchCreateInvoicingRuleCall.class);

    private static final RowMapper<ResellerInvoicingRuleEvent> rowMapperEvent = new ParameterizedRowMapper<ResellerInvoicingRuleEvent>() {
        @Override
        public ResellerInvoicingRuleEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ResellerInvoicingRuleEvent(Guid.createFromOracleDbGuid(rs.getString("reseller_inv_rule_event_id")).getGuid(), rs.getLong("reseller_invoice_rule_id"),rs.getTimestamp("create_date"),rs.getInt("event_type"));
        }
    };

    private static final RowMapper<ResellerInvoicingRule> rowMapperResellerInvoicingRule = createRowMapperResellerInvoicingRule();

    public static RowMapper<ResellerInvoicingRule> createRowMapperResellerInvoicingRule(){
        return
            new ParameterizedRowMapper<ResellerInvoicingRule>() {
            @Override
            public ResellerInvoicingRule mapRow(ResultSet rs, int rowNum) throws SQLException {
                ResellerInvoicingRule rule = new ResellerInvoicingRule();

                // Client
                rule.setClientId(rs.getLong("RESELLER_ID"));

                // Invoicing rule
                rule.setResellerInvoicingRulePk(rs.getLong("ID"));
                rule.setMarketId(rs.getInt("TD_ORGANIZATION_ID"));
                rule.setInvoicingRuleId(Guid.createFromOracleDbGuid(rs.getString("INVOICING_RULE_ID")).getGuid());
                rule.setInvoicingRuleName(rs.getString("INVOICING_RULE_NAME"));
                rule.setDescription(rs.getString("DESCRIPTION"));
                rule.setIssuerReference(rs.getString("ISSUER_REFERENCE_NAME"));
                rule.setClientReference(rs.getString("CLIENT_REFERENCE"));
                if(rule.getClientReference()==null){
                    rule.setClientReference("-");
                }
                rule.setCurrencyCode(rs.getString("CURRENCY_CODE"));
                rule.setDistributionMode(rs.getInt("DISTRIBUTION_MODE"));
                rule.setTermsOfPayment(rs.getInt("TERMS_OF_PAYMENT"));
                rule.setPostingProfile(rs.getInt("POSTING_PROFILE"));
                rule.setDisplayTDcommission("Y".equalsIgnoreCase(rs.getString("DISPLAY_TD_COMMISSION")));
                rule.setPaymentMethod(rs.getInt("PAYMENT_METHOD"));
                rule.setDeviatingExchangeRate("Y".equalsIgnoreCase(rs.getString("DEVIATING_EXCHANGE_RATE")));

                // Invoicing rule message
                rule.setInvoiceMessageRuleId(Guid.createFromOracleDbGuid(rs.getString("INVOICE_MESSAGE_RULE_ID")).getGuid());
                rule.setInvoiceMessage(rs.getString("INVOICE_MESSAGE"));
                java.sql.Date validFromDate = rs.getDate("INVOICE_MESSAGE_VALID_FROM");
                if (validFromDate != null){
                    rule.setInvoiceMessageValidFrom(new Timestamp(validFromDate));
                }
                java.sql.Date validToDate = rs.getDate("INVOICE_MESSAGE_VALID_TO");
                if (validToDate != null){
                    rule.setInvoiceMessageValidTo(new Timestamp(validToDate));
                }

                // Invoice recipient
                rule.setInvoiceRecipientId(Guid.createFromOracleDbGuid(rs.getString("INVOICE_RECIPIENT_ID")).getGuid());
                rule.setAttentionRow1(rs.getString("ATTENTION_ROW_0"));
                rule.setAttentionRow2(rs.getString("ATTENTION_ROW_1"));
                rule.setEmailAddress(rs.getString("EMAIL"));
                rule.setCity(rs.getString("CITY"));
                rule.setCountryCode(rs.getString("COUNTRY_CODE"));
                rule.setAddressLine1(rs.getString("ADDRESS_LINE_0"));
                rule.setAddressLine2(rs.getString("ADDRESS_LINE_1"));
                rule.setPostalCode(rs.getString("POSTAL_CODE"));
                rule.setCounty(rs.getString("COUNTY"));

                // Agreement
                rule.setSourceSystemAgreementId("1-" + rs.getString("PROGRAM_ID"));
                rule.setAgreementDescription(rs.getString("AGREEMENT_DESCRIPTION"));
                rule.setProductType(rs.getInt("AGREEMENT_PRODUCT_TYPE"));
                rule.setAgreementMarketId(rs.getInt("AGREEMENT_MARKET_ID"));
                rule.setAgreementCurrencyCode(rs.getString("AGREEMENT_CURRENCY_CODE"));
                java.sql.Date agreementValidFromDate = rs.getDate("AGREEMENT_VALID_FROM");
                if (agreementValidFromDate != null){
                    rule.setValidFrom(new Timestamp(agreementValidFromDate));
                }
                java.sql.Date agreementValidToDate = rs.getDate("AGREEMENT_VALID_TO");
                if (agreementValidToDate != null){
                    rule.setValidTo(new Timestamp(agreementValidToDate));
                }

                return rule;
            }
        };
    }

    FetchCreateInvoicingRuleCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public InvoicingRuleCreated fetchInvoicingRule() {

        List<ResellerInvoicingRuleEvent> events = getJdbcTemplate().query(
                "SELECT * FROM RESELLER_INVOICE_RULES_EVENTS " +
                        "WHERE processed='N' AND event_type=1 " +
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


        // Invoicing rule parameters
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
        String defaultContent = "Not used from PAN";
        String registeredCompanyName = defaultContent;
        String companyRegistrationNumber = defaultContent;
        String vatNumber = defaultContent;
        String invoiceLanguage = "sv";
        String businessFormCode = null;
        List<Bank> bankAccounts = new ArrayList<Bank>();
        Address registeredAddress = new Address(defaultContent,defaultContent,defaultContent,defaultContent,"12345","SE",1);
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
        MetaData metaData = new MetaData(FlowName.CreateInvoicingRulePan.name(),new Guid(event.getResellerInvoicingRuleEventGuid()),
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

        // Create a fake client by using the reseller's organization id
        Client client = new Client(String.valueOf(resellerInvoicingRule.getClientId()),registeredCompanyName,
                companyRegistrationNumber,vatNumber, ClientType.ADVERTISER, invoiceLanguage,
                businessFormCode,bankAccounts,registeredAddress,clientInvoiceMessageRules,clientMarketIds);

        // Assemble all data into a create-invoicing-rule
        InvoicingRuleCreated invoicingRuleCreated = new InvoicingRuleCreated(metaData, invoicingRule, agreement, client);

        return invoicingRuleCreated;
    }
}

