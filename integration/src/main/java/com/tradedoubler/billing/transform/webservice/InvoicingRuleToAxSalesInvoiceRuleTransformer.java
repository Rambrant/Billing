package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.InvoicingRule;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

import java.util.List;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;

/**
 * This class transforms a domain invoicing rule, and its nested objects, to an Ax SalesInvoiceRule.
 * @author bjoek
 * @since 2012-06-13
 */
public class InvoicingRuleToAxSalesInvoiceRuleTransformer {

    private final AxConverterService converter;
    private final InvoicingRule invoicingRule;
    private final String dataAreaId;

    /**
     *  Creates an transformer
     * @param converter converter service
     * @param invoicingRule -domain object
     * @param dataAreaId market
     */
    public InvoicingRuleToAxSalesInvoiceRuleTransformer(AxConverterService converter, InvoicingRule invoicingRule, String dataAreaId) {
        this.converter = converter;
        this.invoicingRule = invoicingRule;
        this.dataAreaId = dataAreaId;
    }

     /**
     * Transforms with adding documentHash as stated in the MDS_ITG documentation.
     *
     * @param documentHash .
     */
    public AxdEntityMDSSalesInvoiceRule transformForUpdate(String documentHash) throws BillingServiceException {
        AxdEntityMDSSalesInvoiceRule rule = transform();
        updateSalesInvoiceRuleWithDocumentHash(documentHash, rule);
        return rule;
    }

    private AxdEntityMDSSalesInvoiceRule updateSalesInvoiceRuleWithDocumentHash(String documentHash, AxdEntityMDSSalesInvoiceRule salesInvoiceRule) {
        ObjectFactory objectFactory = new ObjectFactory();

        salesInvoiceRule.setClazz("entity");
        salesInvoiceRule.setAction(AxdEnumAxdEntityAction.UPDATE);
        salesInvoiceRule.setDocumentHash(objectFactory.createAxdEntityMDSSalesInvoiceRuleDocumentHash(documentHash));
        List<AxdEntityMDSSalesInvoiceMessage> invoiceMessages = salesInvoiceRule.getMDSSalesInvoiceMessage();
        for (AxdEntityMDSSalesInvoiceMessage invoiceMessage : invoiceMessages) {
            invoiceMessage.setAction(AxdEnumAxdEntityAction.UPDATE);
        }
        return salesInvoiceRule;
    }

     /**
     * Transforms the provided domain object.
     *
     */
    public AxdEntityMDSSalesInvoiceRule transform() throws BillingServiceException {
        AxdEntityMDSSalesInvoiceRule rule = transformRule();

        //Add the invoice messages
        List<AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessages = new InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer(invoicingRule.getInvoiceMessageRules()).transform();
        for (AxdEntityMDSSalesInvoiceMessage salesInvoiceMessage : salesInvoiceMessages) {
            rule.getMDSSalesInvoiceMessage().add(salesInvoiceMessage);
        }

        //Add the purchase orders
        List<AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessagesFromPurchaseOrders = new PurchaseOrderToAxSalesInvoiceMessageTransformer(invoicingRule.getPurchaseOrders()).transform();
        for (AxdEntityMDSSalesInvoiceMessage salesInvoiceMessage : salesInvoiceMessagesFromPurchaseOrders) {
            rule.getMDSSalesInvoiceMessage().add(salesInvoiceMessage);
        }

        return rule;
    }

    private AxdEntityMDSSalesInvoiceRule transformRule() throws BillingServiceException {
        ObjectFactory objectFactory = new ObjectFactory();
        AxdEntityMDSSalesInvoiceRule salesInvoiceRule = objectFactory.createAxdEntityMDSSalesInvoiceRule();

        salesInvoiceRule.setClazz("entity");
        salesInvoiceRule.setBelongsToDataAreaId(objectFactory.createAxdEntityMDSSalesInvoiceRuleBelongsToDataAreaId(dataAreaId));
        salesInvoiceRule.setCurrencyCode(converter.convert(invoicingRule.getCurrencyCode()));
        salesInvoiceRule.setCustomerReference(objectFactory.createAxdEntityMDSSalesInvoiceRuleCustomerReference(invoicingRule.getClientReference()));

        salesInvoiceRule.setDescription(objectFactory.createAxdEntityMDSSalesInvoiceRuleDescription(
                convertNullToEmptyString(invoicingRule.getDescription())));

        AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate devExchangeRate = (invoicingRule.isDeviatingExchangeRate()) ? AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate.YES : AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate.NO;
        salesInvoiceRule.setDeviatingExchRate(devExchangeRate);

        AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission displayTDCommission = invoicingRule.isDisplayTradeDoublerCommission() ? AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission.YES : AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission.NO;
        salesInvoiceRule.setDisplayTDComission(displayTDCommission);

        salesInvoiceRule.setDistributionMode(retrieveDistributionMode());
        salesInvoiceRule.setInvoiceRuleId(invoicingRule.getInvoicingRuleId().getGuidForAx());
        salesInvoiceRule.setIssuerReference(objectFactory.createAxdEntityMDSSalesInvoiceRuleIssuerReference(invoicingRule.getIssuerReference()));
        salesInvoiceRule.setName(invoicingRule.getInvoicingRuleName());


        salesInvoiceRule.setPaymModeId(objectFactory.createAxdEntityMDSSalesInvoiceRulePaymModeId(converter.convert(invoicingRule.getPaymentMethod())));
        salesInvoiceRule.setPaymTermId(converter.convert(invoicingRule.getTermsOfPayment()));
        salesInvoiceRule.setPostingProfile(converter.convert(invoicingRule.getPostingProfile()));
        salesInvoiceRule.setRevenueTypeId(Integer.toString(invoicingRule.getRevenueType().getValue()));

        return salesInvoiceRule;
    }

    /**
     * Converts distribution mode values.
     * @return converted value
     */
    private AxdEnumMDSSalesInvoiceRuleDistributionMode retrieveDistributionMode() {
        AxdEnumMDSSalesInvoiceRuleDistributionMode distributionMode = null;
        switch (invoicingRule.getDistributionMode().getValue()) {
            case 1:
                distributionMode = AxdEnumMDSSalesInvoiceRuleDistributionMode.MAIL;
                break;
            case 2:
                distributionMode = AxdEnumMDSSalesInvoiceRuleDistributionMode.EMAIL;
                break;
            case 3:
                distributionMode = AxdEnumMDSSalesInvoiceRuleDistributionMode.MAIL_AND_EMAIL;
        }
        return distributionMode;
    }

}
