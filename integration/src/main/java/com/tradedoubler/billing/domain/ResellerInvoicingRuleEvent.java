package com.tradedoubler.billing.domain;

import java.sql.Date;

/**
 * Defines an event regarding an invoice-rule in PAN. Either a create or an update event can be modeled.
 */
public class ResellerInvoicingRuleEvent {

    /** The guid for this event. */
    private String resellerInvoicingRuleEventGuid;

    /** The foreign key to the reseller_invoice_rules table denoting which invoice-rule the event targets. */
    private Long resellerInvoiceRuleId;

    /** The time when the event occurred. */
    private Date eventCreateDate;

    /** Determines if the event represents a create-invoicing-rule (true) or update-invoicing-rule (false). */
    private boolean createEvent;


    public ResellerInvoicingRuleEvent(String resellerInvoicingRuleEventGuid, Long resellerInvoiceRuleId, java.sql.Timestamp eventCreateDate, Integer createEvent){
        this.resellerInvoicingRuleEventGuid = resellerInvoicingRuleEventGuid;
        this.resellerInvoiceRuleId = resellerInvoiceRuleId;

        this.eventCreateDate = new Date(eventCreateDate.getTime());
        this.createEvent = createEvent != null && createEvent == 1;
    }

    public String getResellerInvoicingRuleEventGuid() {
        return resellerInvoicingRuleEventGuid;
    }

    public void setResellerInvoicingRuleEventGuid(String resellerInvoicingRuleEventGuid) {
        this.resellerInvoicingRuleEventGuid = resellerInvoicingRuleEventGuid;
    }

    public Long getResellerInvoiceRuleId() {
        return resellerInvoiceRuleId;
    }

    public Date getEventCreateDate() {
        return eventCreateDate;
    }

    public boolean isCreateEvent() {
        return createEvent;
    }
}
