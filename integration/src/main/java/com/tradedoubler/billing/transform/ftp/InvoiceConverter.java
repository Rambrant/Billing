package com.tradedoubler.billing.transform.ftp;

import com.tradedoubler.billing.domain.Event;
import com.tradedoubler.customerinvoice.AxdEnumMDSSalesInvoiceEvent;

/**
 * Transforms events between Ax and domain representation.
 */
public class InvoiceConverter {

    public static final int NO_REVENUE_TYPE = -1;

    public Event convertEventFromAXToDomain(AxdEnumMDSSalesInvoiceEvent axSalesInvoiceEvent){
        Event event = null;
        if (axSalesInvoiceEvent == AxdEnumMDSSalesInvoiceEvent.POSTED) event = Event.POSTED;
        if (axSalesInvoiceEvent == AxdEnumMDSSalesInvoiceEvent.PAID) event = Event.PAID;
        if (axSalesInvoiceEvent == AxdEnumMDSSalesInvoiceEvent.REMINDED) event = Event.REMINDED;
        if (axSalesInvoiceEvent == AxdEnumMDSSalesInvoiceEvent.WRITE_OFF) event = Event.WRITE_OFF;
        if (axSalesInvoiceEvent == AxdEnumMDSSalesInvoiceEvent.SETTLED) event = Event.SETTLED;

        if (event == null) throw new IllegalArgumentException("Non existing Event type for invoice" + axSalesInvoiceEvent);
        return event;
    }

    public int convertEventFromDomainToCRM(Event event){
        int crmEvent = -1;
        if (event == Event.POSTED) crmEvent = 1;
        if ( event == Event.PAID) crmEvent = 2;
        if (event == Event.REMINDED) crmEvent = 4;
        if (event == Event.WRITE_OFF) crmEvent = 5;
        if (event == Event.SETTLED) crmEvent = 6;

        if (crmEvent == -1) throw new IllegalArgumentException("Non existing Event type for invoice" + event.name());
        return crmEvent;
    }

    public int convertEventFromDomainToPan(Event event){
        int panStatus = -1;
        if (event == Event.WRITE_OFF) panStatus = 7;
        if ( event == Event.PAID) panStatus = 6;
        if ( event == Event.POSTED) panStatus = 4; //Should not be needed - only PAID WRITE_OFF set to Pan

        if (panStatus == -1) throw new IllegalArgumentException("Non existing Event type for invoice" + event.name());
        return panStatus;
    }
    public int convertRevenueTypeFromAXToDomain(String revenueTypeAx){

        int revenueType = NO_REVENUE_TYPE;
        if (revenueTypeAx != null) {
            if (revenueTypeAx.trim().equals("1")) revenueType = 1;
            if (revenueTypeAx.trim().equals("2")) revenueType = 2;

            if (revenueType == NO_REVENUE_TYPE) throw new IllegalArgumentException("Non existing Revenue type for invoice " + revenueTypeAx);
        }
        return revenueType;
    }
}
