package com.tradedoubler.billing.service.ax;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.exception.AxValidationException;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.cache.CacheService;
import com.tradedoubler.billing.service.transform.AxConverterService;
import com.tradedoubler.billing.transform.webservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import java.util.*;

/**
 * @author Thomas Rambrant (thore)
 */

@Component
public class AxComparator
{
    private static final Timestamp DEFAULT_NULL_VALID_FROM_DATE = new Timestamp("1901-01-01T00:00:00.000+02:00");
    private static final Timestamp DEFAULT_NULL_VALID_TO_DATE   = new Timestamp("2154-12-31T00:00:00.000+02:00");

    @Autowired
    private AxReader reader;

    @Autowired
    AxConverterService converter;

    @Autowired
    private CacheService cacheService;

    public AxComparator()
    {
        reader = new AxReader();
    }

    public void validateInvoicingRule( InvoicingRule invoicingRule) throws AxValidationException
    {
        AxValidationException exception = new AxValidationException(
            "invoicingRule",
            invoicingRule.getInvoicingRuleId().toString());

        AxdEntityMDSSalesInvoiceRule axInvoiceRule =
            reader.getInvoicingRule( invoicingRule.getInvoicingRuleId().toString());

        List< AxdEntityMDSSalesInvoiceRecipient> axRecipients =
            reader.getInvoiceRecipientByInvoicingRuleId( invoicingRule.getInvoicingRuleId().toString());

        //
        // Validate the presence and content in AX
        //
        validatePresence( exception, axInvoiceRule);

        try
        {
            //
            // Take care of all single fields
            //
            validateField(
                exception,
                "marketId",
                converter.convert( invoicingRule.getMarketId()),
                getValue( axInvoiceRule.getBelongsToDataAreaId()));

            validateField(
                exception,
                "currencyCode",
                invoicingRule.getCurrencyCode().getCurrencyCode(),
                axInvoiceRule.getCurrencyCode());

            validateField(
                exception,
                "clientReference",
                invoicingRule.getClientReference(),
                getValue( axInvoiceRule.getCustomerReference()));

            validateField(
                exception,
                "description",
                invoicingRule.getDescription(),
                getValue( axInvoiceRule.getDescription()));

            validateField(
                exception,
                "deviatingExchangeRate",
                translateBooleanToYesNo( invoicingRule.isDeviatingExchangeRate()),
                getValue( axInvoiceRule.getDeviatingExchRate()));

            validateField(
                exception,
                "displayTDCommission",
                translateBooleanToYesNo( invoicingRule.isDisplayTradeDoublerCommission()),
                getValue( axInvoiceRule.getDisplayTDComission()));

            validateField(
                exception,
                "distributionMode",
                translateDistributionMode( invoicingRule.getDistributionMode()),
                axInvoiceRule.getDistributionMode());

            validateField(
                exception,
                "invoicingRuleId",
                invoicingRule.getInvoicingRuleId().getGuidForAx(),
                axInvoiceRule.getInvoiceRuleId());

            validateField(
                exception,
                "issuerReference",
                invoicingRule.getIssuerReference(),
                getValue( axInvoiceRule.getIssuerReference()));

            validateField(
                exception,
                "invoicingRuleName",
                invoicingRule.getInvoicingRuleName(),
                axInvoiceRule.getName());

            validateField(
                exception,
                "paymentMethod",
                converter.convert( invoicingRule.getPaymentMethod()),
                getValue( axInvoiceRule.getPaymModeId()));

            validateField(
                exception,
                "termsOfPayment",
                converter.convert( invoicingRule.getTermsOfPayment()),
                axInvoiceRule.getPaymTermId());

            validateField(
                exception,
                "postingProfile",
                converter.convert( invoicingRule.getPostingProfile()),
                axInvoiceRule.getPostingProfile());

            validateField(
                exception,
                "revenueType",
                Integer.toString( invoicingRule.getRevenueType().getValue()),
                axInvoiceRule.getRevenueTypeId());

            //
            // Treat all purchase orders. There might be more orders in AX since we never delete any old ones
            //
            validateTrue(
                exception,
                "The number of PurchaseOrders is wrong",
                invoicingRule.getPurchaseOrders().size() <= axInvoiceRule.getMDSSalesInvoiceMessage().size());

            for( PurchaseOrder purchaseOrder : invoicingRule.getPurchaseOrders())
            {
                validatePurchaseOrder( exception, purchaseOrder, axInvoiceRule.getMDSSalesInvoiceMessage());
            }

            //
            // Take care of the message rules. They are stored in the same structure in AX as the purchase orders.
            // The same rule applies that there might be more orders in AX...
            //
            validateTrue(
                exception,
                "The number of Message Rules is wrong",
                invoicingRule.getInvoiceMessageRules().size() <= axInvoiceRule.getMDSSalesInvoiceMessage().size());

            for( InvoicingRuleMessageRule messageRule : invoicingRule.getInvoiceMessageRules())
            {
                validateInvoicingMessageRule( exception, messageRule, axInvoiceRule.getMDSSalesInvoiceMessage());
            }

            //
            // Take care of all invoice recipients
            //
            validateTrue(
                exception,
                "The number of Invoice Recipients is wrong",
                invoicingRule.getInvoiceRecipients().size() <= axRecipients.size());

            for( InvoiceRecipient recipient: invoicingRule.getInvoiceRecipients())
            {
                validateRecipient( exception, recipient, axRecipients);
            }
        }
        catch( BillingServiceException e)
        {
            exception.addError( e.getMessage());
        }

        //
        // Signal existing errors
        //
        if( exception.hasErrors())
        {
            throw exception;
        }
    }

    public void validateClient( Client client) throws AxValidationException
    {
        AxValidationException exception = new AxValidationException( "Client", client.getClientId());


        List< Market> allMarkets;
        try
        {
            if (client.getClientType() == ClientType.RESELLER) {
                //For reseller, get all markets.
                allMarkets = cacheService.getAllMarkets();
            } else {
                // Get hold of the union of markets for banks and clients
                allMarkets = getAllMarkets( client.getMarketIds(), client.getBankAccounts());
            }


            for( Market clientMarket: allMarkets)
            {
                AxdEntityCustTable axClient = reader.getClient( client.getClientId(), clientMarket);

                //
                // Validate the presence and content in AX
                //
                validatePresence( exception, axClient);

                //
                // Take care of all single fields
                //
                validateField(
                    exception,
                    "businessFormCode",
                    emptyStringToNull( client.getBusinessFormCode()),
                    getValue( axClient.getIdentificationNumber()));

                validateField(
                    exception,
                    "vatNumber",
                    client.getVatNumber(),
                    getValue( axClient.getVATNum()));

                List<AxdEntityDirPartyDirPartyTable> dirParties = axClient.getDirParty();

                validateTrue( exception, "Number of DirParty's is wrong. Should be just one", dirParties.size() == 1);

                if( dirParties.size() == 1)
                {
                    AxdEntityDirPartyDirOrganization dirParty = (AxdEntityDirPartyDirOrganization) dirParties.get( 0);

                    validateField(
                        exception,
                        "invoiceLanguage",
                        converter.convert( client.getInvoiceLanguage()).toUpperCase(),
                        getValue( dirParty.getLanguageId()).toUpperCase());

                    validateField(
                        exception,
                        "registeredCompanyName",
                        client.getRegisteredCompanyName(),
                        getValue( dirParty.getName()));

                    validateField(
                        exception,
                        "companyRegistrationNumber",
                        client.getCompanyRegistrationNumber(),
                        getValue( dirParty.getOrgNumber()));


                    List< AxdEntityDirPartyPostalAddressView> postalAddresses = dirParty.getDirPartyPostalAddressView();

                    validateTrue( exception, "Number of 'postal addresses' is wrong. Should be just one", postalAddresses.size() == 1);

                    if( postalAddresses.size() == 1)
                    {
                        AxdEntityDirPartyPostalAddressView postalAddress = postalAddresses.get( 0);

                        validateField(
                            exception,
                            "registeredAddress.city",
                            client.getRegisteredAddress().getCity(),
                            getValue( postalAddress.getCity()));

                        validateField(
                            exception,
                            "registeredAddress.country",
                            converter.convert(client.getRegisteredAddress().getCountryCode()),
                            getValue( postalAddress.getCountryRegionId()));

                        validateField(
                            exception,
                            "registeredAddress.addressType",
                            converter.convert(client.getRegisteredAddress().getAddressType()),
                            getValue( postalAddress.getRoles()));

                        validateField(
                            exception,
                            "registeredAddress.street",
                            cleanNewLine( AxUtil.createStreet( client.getRegisteredAddress().getLine1(), client.getRegisteredAddress().getLine2() )),
                            cleanNewLine( getValue( postalAddress.getStreet())));

                        validateField(
                            exception,
                            "registeredAddress.county",
                            client.getRegisteredAddress().getCounty(),
                            getValue( postalAddress.getBuildingCompliment()));

                        validateField(
                            exception,
                            "registeredAddress.postalCode",
                            client.getRegisteredAddress().getPostalCode(),
                            getValue( postalAddress.getZipCode()));
                    }
                }
            }

            //
            // Take care of the message rules. They are stored in the same structure in AX as the purchase orders.
            // The same rule applies that there might be more orders in AX...
            //
            for( ClientMessageRule messageRule : client.getInvoiceMessageRules())
            {
                validateClientMessageRule(
                    exception,
                    messageRule,
                    reader.getInvoiceMessageRule( messageRule.getInvoiceMessageRuleId().toString()));
            }

            //
            // Banks
            //
            for( Bank bank: client.getBankAccounts())
            {
                validateBank( exception, client.getClientId(), bank);
            }
        }
        catch( BillingServiceException e)
        {
            exception.addError( e.getMessage());
        }

        //
        // Signal existing errors
        //
        if( exception.hasErrors())
        {
            throw exception;
        }
    }

    public void validateAgreement( Agreement agreement) throws AxValidationException
    {
        AxValidationException exception = new AxValidationException( "Agreement", agreement.getSourceSystemAgreementId());

        AxdEntityMDSSalesClientAgreement axAgreement = reader.getAgreement(
            agreement.getSourceSystemAgreementId(),
            agreement.getMarketId());

        //
        // Validate the presence and content in AX
        //
        validatePresence( exception, axAgreement);

        //
        // Take care of all single fields
        //
        validateField(
            exception,
            "clientId",
            agreement.getClientId(),
            axAgreement.getCustId());

        validateField(
            exception,
            "currencyCode",
            converter.convert( agreement.getCurrencyCode() ),
            axAgreement.getCurrencyCode());

        validateField(
            exception,
            "description",
            agreement.getDescription(),
            axAgreement.getDescription());

        validateField(
            exception,
            "documentLink",
            agreement.getDocumentLink(),
            getValue( axAgreement.getDocumentLink() ));

        validateField(
            exception,
            "invoicingRuleId",
            agreement.getInvoicingRuleId().getGuidForAx(),
            axAgreement.getInvoiceRuleId());

        validateField(
            exception,
            "productType",
            converter.convert( agreement.getProductType() ),
            axAgreement.getProductTypeId());

        validateField(
            exception,
            "validFrom",
            translateFromDate( agreement.getValidFrom()),
            axAgreement.getValidFrom());

        validateField(
            exception,
            "validTo",
            translateToDate( agreement.getValidTo()),
            axAgreement.getValidTo());

        //
        // Signal existing errors
        //
        if( exception.hasErrors())
        {
            throw exception;
        }
    }

    public void validateMarketMessage( InvoiceIssuerMessageRule marketMessage) throws AxValidationException
    {
        AxValidationException exception = new AxValidationException( "MarketMessage", marketMessage.getInvoiceMessageRuleId().toString());

        com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage
            axMarketMessage = reader.getMarketMessage(
                marketMessage.getInvoiceMessageRuleId().toString(),
                marketMessage.getMarketId());

        //
        // Validate the presence and content in AX
        //
        validatePresence( exception, axMarketMessage);

        //
        // Take care of all single fields
        //
        validateField(
            exception,
            "invoicingMessageRule.sourceType",
            marketMessage.getSourceType(),
            axMarketMessage.getSourceType());

        validateField(
            exception,
            "invoicingMessageRule.messageText",
            marketMessage.getMessageText(),
            axMarketMessage.getText());

        validateField(
            exception,
            "invoicingMessageRule.validFrom",
            translateFromDate( marketMessage.getValidFrom()),
            axMarketMessage.getValidFrom());

        validateField(
            exception,
            "invoicingMessageRule.validTo",
            translateToDate( marketMessage.getValidTo()),
            axMarketMessage.getValidTo());

        //
        // Signal existing errors
        //
        if( exception.hasErrors())
        {
            throw exception;
        }
    }

    private void validatePurchaseOrder(
        AxValidationException                  exception,
        PurchaseOrder                          purchaseOrder,
        List< AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessages)
    {
        for( AxdEntityMDSSalesInvoiceMessage message: salesInvoiceMessages)
        {
            if( purchaseOrder.getPurchaseOrderId().getGuidForAx().equals( message.getInvoiceMessageId()))
            {
                validateField(
                    exception,
                    "purchaseOrder.sourceType",
                    AxdEnumMDSSalesMessageSourceType.INVOICE_RULE_PURCHASE_ORDER,
                    message.getSourceType());

                validateField(
                    exception,
                    "purchaseOrder.poNumber",
                    purchaseOrder.getPoNumber(),
                    message.getText());

                validateField(
                    exception,
                    "purchaseOrder.validFrom",
                    translateFromDate( purchaseOrder.getValidFrom()),
                    message.getValidFrom());

                validateField(
                    exception,
                    "purchaseOrder.validTo",
                    translateToDate( purchaseOrder.getValidTo()),
                    message.getValidTo());

                return;
            }
        }

        exception.addError( "The purchaseOrder '" + purchaseOrder.getPurchaseOrderId() + "'  don't exist in AX");
    }

    private void validateInvoicingMessageRule(
        AxValidationException                  exception,
        InvoicingRuleMessageRule               messageRule,
        List< AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessages)
    {
        for( AxdEntityMDSSalesInvoiceMessage message: salesInvoiceMessages)
        {
            if( messageRule.getInvoiceMessageRuleId().getGuidForAx().equals( message.getInvoiceMessageId()))
            {
                validateField(
                    exception,
                    "invoicingMessageRule.sourceType",
                    messageRule.getSourceType(),
                    message.getSourceType());

                validateField(
                    exception,
                    "invoicingMessageRule.messageText",
                    messageRule.getMessageText(),
                    message.getText());

                validateField(
                    exception,
                    "invoicingMessageRule.validFrom",
                    translateFromDate( messageRule.getValidFrom()),
                    message.getValidFrom());

                validateField(
                    exception,
                    "invoicingMessageRule.validTo",
                    translateToDate( messageRule.getValidTo()),
                    message.getValidTo());

                return;
            }
        }

        exception.addError( "The invoiceMessageRule '" + messageRule.getInvoiceMessageRuleId() + "'  don't exist in AX");
    }

    private void validateClientMessageRule(
        AxValidationException exception,
        ClientMessageRule     messageRule,
        com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage message)
    {
        validateField(
            exception,
            "invoicingMessageRule.sourceType",
            messageRule.getSourceType(),
            message.getSourceType());

        validateField(
            exception,
            "invoicingMessageRule.messageText",
            messageRule.getMessageText(),
            message.getText());

        validateField(
            exception,
            "invoicingMessageRule.validFrom",
            DateConverter.convertISO8601ToXMLGregorianCalendar( messageRule.getValidFrom().getTimestamp()),
            message.getValidFrom());

        validateField(
            exception,
            "invoicingMessageRule.validTo",
            DateConverter.convertISO8601ToXMLGregorianCalendar( messageRule.getValidTo().getTimestamp() ),
            message.getValidTo() );
    }

    private void validateRecipient(
        AxValidationException                   exception,
        InvoiceRecipient                        recipient,
        List<AxdEntityMDSSalesInvoiceRecipient> axRecipients)
    {
        for( AxdEntityMDSSalesInvoiceRecipient axRecipient : axRecipients)
        {
            if( recipient.getInvoiceRecipientId().getGuidForAx().equals( axRecipient.getInvoiceRecipientId()))
            {
                validateField(
                    exception,
                    "invoiceRecipient.attentionRow1",
                    recipient.getAttentionRow1(),
                    getValue( axRecipient.getAttentionRow1() ));

                validateField(
                    exception,
                    "invoiceRecipient.attentionRow2",
                    recipient.getAttentionRow2(),
                    getValue( axRecipient.getAttentionRow2() ));

                validateField(
                    exception,
                    "invoiceRecipient.emailAddress",
                    recipient.getEmailAddress(),
                    getValue( axRecipient.getEmail() ));

                validateField(
                    exception,
                    "invoiceRecipient.defaultRecipient",
                    translateBooleanToYesNo( recipient.isDefaultRecipient() ),
                    getValue( axRecipient.getDefaultRecipient() ));

                validateField(
                    exception,
                    "invoiceRecipient.invoicingRuleId",
                    recipient.getInvoicingRuleId().getGuidForAx(),
                    getValue( axRecipient.getInvoiceRuleId()));

                validateTrue(
                    exception,
                    "invoiceRecipient.Only one address is allowed",
                    (axRecipient.getLogisticsLocation().size() == 1));

                if( axRecipient.getLogisticsLocation().size() == 1)
                {
                    validateAddress(
                        exception,
                        recipient.getRegisteredAddress(),
                        axRecipient.getLogisticsLocation().get( 0));
                }

                for( SplittingRule splittingRule: recipient.getSplittingRules())
                {
                    validateSplittingRules(
                        exception,
                        splittingRule,
                        axRecipient.getMDSSalesSplitter());
                }

                return;
            }
        }

        exception.addError( "The invoiceRecipient '" + recipient.getInvoiceRecipientId() + "'  don't exist in AX" );
    }

    private void validateAddress(
        AxValidationException      exception,
        Address                    address,
        AxdEntityLogisticsLocation logisticsLocation)
    {
        try
        {
            validateTrue(
                exception,
                "Only one postal address is allowed",
                (logisticsLocation.getLogisticsPostalAddress().size() == 1));

            if( logisticsLocation.getLogisticsPostalAddress().size() == 1)
            {
                AxdEntityLogisticsPostalAddress axAddress = logisticsLocation.getLogisticsPostalAddress().get( 0);

                validateField(
                    exception,
                    "address.city",
                    address.getCity(),
                    getValue( axAddress.getCity()));

                validateField(
                    exception,
                    "address.countryCode",
                    converter.convert( address.getCountryCode()),
                    axAddress.getCountryRegionId());

                validateField(
                    exception,
                    "address.streetAddress",
                    cleanNewLine( AxUtil.createStreet( address.getLine1(), address.getLine2())),
                    cleanNewLine( getValue( axAddress.getStreet())));

                validateField(
                    exception,
                    "address.postalCode",
                    address.getPostalCode(),
                    getValue( axAddress.getZipCode()));

                validateField(
                    exception,
                    "address.county",
                    address.getCounty(),
                    getValue( axAddress.getBuildingCompliment()));
            }
        }
        catch( BillingServiceException e)
        {
            exception.addError( e.getMessage());
        }
    }

    private void validateSplittingRules(
        AxValidationException            exception,
        SplittingRule                    splittingRule,
        List< AxdEntityMDSSalesSplitter> splitters)
    {
        for( AxdEntityMDSSalesSplitter axSplitter : splitters)
        {
            if( splittingRule.getSplittingRuleId().getGuidForAx().equals( axSplitter.getSplitterId()))
            {
                validateField(
                    exception,
                    "splitting.invoiceRecipientId",
                    splittingRule.getInvoiceRecipientId().getGuidForAx(),
                    axSplitter.getInvoiceRecipientId());

                validateField(
                    exception,
                    "splitting.splitter",
                    splittingRule.getSplitter(),
                    axSplitter.getSplitterValue());

                return;
            }
        }

        exception.addError( "The splittingRule '" + splittingRule.getSplittingRuleId() + "'  don't exist in AX");
    }

    private void validateBank(
        AxValidationException exception,
        String                clientId,
        Bank                  bank)
    {
        AxdEntityCustBankAccount axBank = reader.getBank( clientId, bank.getMarketId());

        validateField(
            exception,
            "bank.bankAccount",
            bank.getBankAccount(),
            getValue( axBank.getAccountNum()));

        validateField(
            exception,
            "bank.accountOwner",
            bank.getAccountOwner(),
            getValue( axBank.getName()));

        validateField(
            exception,
            "bank.bankCode",
            bank.getBankCode(),
            getValue( axBank.getRegistrationNum()));

        validateField(
            exception,
            "bank.clientId",
            bank.getClientId(),
            axBank.getCustAccount() );
    }

    private List< Market> getAllMarkets( List< Market> marketIds, List< Bank> bankAccounts)
    {
        List< Market> uniqueMarkets = new ArrayList< Market>();
        List< Integer>   seenIds    = new ArrayList< Integer>();

        //
        // Add all unique markets from the client
        //
        for( Market clientMarket: marketIds)
        {
            if( ! seenIds.contains( clientMarket.getOrganizationId()))
            {
                seenIds.add(  clientMarket.getOrganizationId());

                uniqueMarkets.add( clientMarket);
            }
        }

        //
        // Add all unique markets found in the bank info
        //
        for( Bank bank: bankAccounts)
        {
            if( ! seenIds.contains( bank.getMarketId().getOrganizationId()))
            {
                seenIds.add( bank.getMarketId().getOrganizationId());

                uniqueMarkets.add( bank.getMarketId());
            }
        }

        return uniqueMarkets;
    }

    private void validatePresence( AxValidationException exception, Object object) throws AxValidationException
    {
        if( object == null)
        {
            exception.addError( "Does not exist in AX");

            throw exception;
        }
    }

    private void validateTrue( AxValidationException exception, String message, boolean bool)
    {
        if( ! bool)
        {
            exception.addError( message);
        }
    }

    private void validateField( AxValidationException exception, String fieldName, Object obj1, Object obj2)
    {
        if( obj1 == null && obj2 == null)
        {
            return;
        }

        if( obj1 == null)
        {
            String values =  "(" + obj2 + ")";

            exception.addError( fieldName + " is null but not in AX " + values.replace( "\n", " "));
            return;
        }

        if( obj2 == null)
        {
            String values =  "(" + obj1 + ")";

            exception.addError( fieldName + " is null in AX " + values.replace(  "\n", " "));
            return;
        }

        if( ! obj1.equals( obj2))
        {
            String values = "(" + obj1 + " != " + obj2 + ")";

            exception.addError( fieldName + " does not compare equal to AX " + values.replace(  "\n", " "));
        }
    }

    private AxdEnumMDSSalesInvoiceRuleDistributionMode translateDistributionMode( DistributionMode distMode)
    {
        AxdEnumMDSSalesInvoiceRuleDistributionMode distributionMode = null;

        switch( distMode.getValue())
        {
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

    private String translateBooleanToYesNo( Boolean bool)
    {
        if( bool == null)
        {
            return null;
        }

        return bool ? "Yes" : "No";
    }

    private Object translateFromDate( Timestamp date)
    {
        Timestamp timestamp = (date == null) ? DEFAULT_NULL_VALID_FROM_DATE : date;

        return DateConverter.convertISO8601ToXMLGregorianCalendar( timestamp.getTimestamp());
    }

    private Object translateToDate( Timestamp date)
    {
        Timestamp timestamp = (date == null) ? DEFAULT_NULL_VALID_TO_DATE : date;

        return DateConverter.convertISO8601ToXMLGregorianCalendar( timestamp.getTimestamp());
    }

    private Object cleanNewLine( String string)
    {
        return string.replace( "\r", "");
    }

    private String emptyStringToNull( String string)
    {
        if( string.length() == 0)
        {
            return null;
        }

        return string;
    }

    private <T> T getValue( JAXBElement<T> object)
    {
        if( object == null)
        {
            return null;
        }

        return object.getValue();
    }

    private String getValue( AxdEnumNoYesCombo object)
    {
        if( object == null)
        {
            return null;
        }

        return object.value();
    }

    private String getValue( AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate object)
    {
        if( object == null)
        {
            return null;
        }

        return object.value();
    }

    private String getValue( AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission object)
    {
        if( object == null)
        {
            return null;
        }

        return object.value();
    }
}
