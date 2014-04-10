package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory to create (instantiate) web service call. The calls use AxWebServiceSetup to find their web service ports.
 * This class was originally created to simplify testing of flows with dummy web service calls.
 *
 * @author bjoek
 * @since 2012-08-30
 */
@SuppressWarnings("unchecked")
@Component
public class WebServiceCallFactory {

    //Contains setup information for the web service
    @Autowired
    private AxWebServiceSetup serviceSetup;

    /** Creates a call of the desired Class type */
    public <T extends AbstractWebServiceCall> T createCall(Class<T> clazz) {
        // -------- Read calls
        if (clazz == ReadClientCall.class) {
            return (T) new ReadClientCall(serviceSetup);
        }

        // -------- Find calls
        if (clazz == FindAgreementCall.class) {
            return (T) new FindAgreementCall(serviceSetup);
        }
        if (clazz == FindBankCall.class) {
            return (T) new FindBankCall(serviceSetup);
        }
        if (clazz == FindClientCall.class) {
            return (T) new FindClientCall(serviceSetup);
        }
        if (clazz == FindInvoiceRecipientCall.class) {
            return (T) new FindInvoiceRecipientCall(serviceSetup);
        }
        if (clazz == FindInvoiceMessageRuleCall.class) {
            return (T) new FindInvoiceMessageRuleCall(serviceSetup);
        }
        if (clazz == FindInvoicingRuleCall.class) {
            return (T) new FindInvoicingRuleCall(serviceSetup);
        }
        if (clazz == FindInvoiceRecipientsByInvoicingRuleCall.class) {
            return (T) new FindInvoiceRecipientsByInvoicingRuleCall(serviceSetup);
        }

        // -------- Insert calls
        if (clazz == InsertBankCall.class) {
            return (T) new InsertBankCall(serviceSetup);
        }
        if (clazz == InsertClientCall.class) {
            return (T) new InsertClientCall(serviceSetup);
        }
        if (clazz == InsertAgreementCall.class) {
            return (T) new InsertAgreementCall(serviceSetup);
        }
        if (clazz == InsertInvoicingRuleCall.class) {
            return (T) new InsertInvoicingRuleCall(serviceSetup);
        }
        if (clazz == InsertInvoiceRecipientCall.class) {
            return (T) new InsertInvoiceRecipientCall(serviceSetup);
        }
        if (clazz == InsertInvoiceRecipientsCall.class) {
            return (T) new InsertInvoiceRecipientsCall(serviceSetup);
        }
        if (clazz == InsertInvoiceMessageRuleCall.class) {
            return (T) new InsertInvoiceMessageRuleCall(serviceSetup);
        }
        if (clazz == InsertAndUpdateOrderLinesCall.class) {
            return (T) new InsertAndUpdateOrderLinesCall(serviceSetup);
        }

        // -------- Update calls
        if (clazz == UpdateBankCall.class) {
            return (T) new UpdateBankCall(serviceSetup);
        }
        if (clazz == UpdateClientCall.class) {
            return (T) new UpdateClientCall(serviceSetup);
        }
        if (clazz == UpdateAgreementCall.class) {
            return (T) new UpdateAgreementCall(serviceSetup);
        }
        if (clazz == UpdateInvoicingRuleCall.class) {
            return (T) new UpdateInvoicingRuleCall(serviceSetup);
        }
        if (clazz == UpdateInvoiceRecipientCall.class) {
            return (T) new UpdateInvoiceRecipientCall(serviceSetup);
        }
        if (clazz == UpdateInvoiceMessageRuleCall.class) {
            return (T) new UpdateInvoiceMessageRuleCall(serviceSetup);
        }

        // -------- Delete calls
        if (clazz == DeleteInvoiceRecipientCall.class) {
            return (T) new DeleteInvoiceRecipientCall(serviceSetup);
        }
        if (clazz == StartOrderLineProcessingCall.class) {
            return (T) new StartOrderLineProcessingCall(serviceSetup);
        }


        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
