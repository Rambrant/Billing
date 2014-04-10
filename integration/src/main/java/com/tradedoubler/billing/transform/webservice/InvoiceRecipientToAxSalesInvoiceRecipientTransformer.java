package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYesCombo;
import com.tradedoubler.billing.domain.InvoiceRecipient;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.FindInvoiceRecipientCall;
import com.tradedoubler.billing.service.transform.AxConverterService;

import java.util.List;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;

/**
 * Convert an InvoiceRecipient to Ax representation of the same.
 * 
 * User: erigu
 * Date: 2012-09-04
 */
public class InvoiceRecipientToAxSalesInvoiceRecipientTransformer {
    private final AxConverterService converter;
    private final InvoiceRecipient invoiceRecipient;

    public InvoiceRecipientToAxSalesInvoiceRecipientTransformer(AxConverterService converter, InvoiceRecipient invoiceRecipient) {
        this.converter = converter;
        this.invoiceRecipient = invoiceRecipient;
    }

    public AxdEntityMDSSalesInvoiceRecipient transform() throws BillingServiceException {
        ObjectFactory objectFactory = new ObjectFactory();

        AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient = objectFactory.createAxdEntityMDSSalesInvoiceRecipient();

        axInvoiceRecipient.setClazz("entity");
        axInvoiceRecipient.setAttentionRow1(objectFactory.createAxdEntityMDSSalesInvoiceRecipientAttentionRow1(
                convertNullToEmptyString(invoiceRecipient.getAttentionRow1())));
        axInvoiceRecipient.setAttentionRow2(objectFactory.createAxdEntityMDSSalesInvoiceRecipientAttentionRow2(
                convertNullToEmptyString(invoiceRecipient.getAttentionRow2())));
        axInvoiceRecipient.setEmail(objectFactory.createAxdEntityMDSSalesInvoiceRecipientEmail(
                convertNullToEmptyString(invoiceRecipient.getEmailAddress())));


        AxdEnumNoYesCombo defaultRecipient = invoiceRecipient.isDefaultRecipient() ? AxdEnumNoYesCombo.YES : AxdEnumNoYesCombo.NO;
        axInvoiceRecipient.setDefaultRecipient(defaultRecipient);
        axInvoiceRecipient.setInvoiceRecipientId(invoiceRecipient.getInvoiceRecipientId().getGuidForAx());
        axInvoiceRecipient.setInvoiceRuleId(objectFactory.createAxdEntityMDSSalesInvoiceRecipientInvoiceRuleId(invoiceRecipient.getInvoicingRuleId().getGuidForAx()));

        //Add Logistic location - one location per recipient
        AxdEntityLogisticsLocation axLogisticLocation = new AddressToWsLogisticLocationTransformer(converter, invoiceRecipient.getRegisteredAddress()).transform();
        axInvoiceRecipient.getLogisticsLocation().add(axLogisticLocation);

        //Add splits
        List<AxdEntityMDSSalesSplitter> salesInvoiceMessages = new SplittingRuleToAxSalesSplitterTransformer(invoiceRecipient.getSplittingRules()).transform();
        for (AxdEntityMDSSalesSplitter salesSplitter : salesInvoiceMessages) {
            axInvoiceRecipient.getMDSSalesSplitter().add(salesSplitter);
        }

        return axInvoiceRecipient;
    }

    public AxdEntityMDSSalesInvoiceRecipient transformForUpdate(FindInvoiceRecipientCall findCall) throws BillingServiceException {
        //First do same transform as for create Invoice Recipient
        AxdEntityMDSSalesInvoiceRecipient axdInvoiceRecipient = transform();

        //Then add update specific tags. Some which are taken from the previous read-call
        AxUtil.addUpdateInfoOnInvoiceRecipient(findCall, axdInvoiceRecipient);

        return axdInvoiceRecipient;
    }

    public static AxdEntityMDSSalesInvoiceRecipient transformFindCallDirectlyToUpdate(FindInvoiceRecipientCall findCall) throws BillingServiceException {
        // Recipient is already transformed
        AxdEntityMDSSalesInvoiceRecipient axdInvoiceRecipient = findCall.getInvoiceRecipient();

        //Then add update specific tags. Some which are taken from the previous read-call
        AxUtil.addUpdateInfoOnInvoiceRecipient(findCall, axdInvoiceRecipient);

        return axdInvoiceRecipient;
    }
}
