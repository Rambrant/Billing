package com.tradedoubler.billing.domain;

import java.math.BigDecimal;

/**
 * Order lines are used by Ax to create invoices.
 */
public class OrderLine {

    private String systemAgreementId;
    private String orderLineId;
    private final boolean invoiceable;
    private final String salesPart;
    private final String description;
    private int quantity;
    private final Money total;
    private final Money cost;
    private final Timestamp dateOfPrepayment;
    private DebitOrCredit debitOrCredit;
    private final String creditedInvoiceID;
    private final String splitter;
    private final int year;
    private final int month;
    private OrderLineStatus status = OrderLineStatus.NOT_PROCESSED;
    private final String period;
    private String errorMessage;

    public OrderLine(String systemAgreementId, String orderLineId, boolean invoiceable, String salesPart, String description,
                     BigDecimal total, BigDecimal cost, String period, Timestamp dateOfPrepayment, String creditedInvoiceID,
                     String splitter) {
        this.year = 2000 + Integer.parseInt(period.substring(0, 2));
        int month = Integer.parseInt(period.substring(2, 4));
        validateMonth(month);
        this.month = month;
        this.systemAgreementId = systemAgreementId.trim();
        this.orderLineId = orderLineId;
        this.invoiceable = invoiceable;
        this.salesPart = salesPart;
        this.description = description;
        this.total = total == null ? new Money(BigDecimal.ZERO) : new Money(total);
        this.cost = cost == null ? new Money(BigDecimal.ZERO) : new Money(cost);
        this.period = period;
        this.dateOfPrepayment = dateOfPrepayment;
        this.creditedInvoiceID = creditedInvoiceID;
        this.splitter = splitter;
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month is not valid. It has to be between 1 and 12, was: " + month);
        }
    }

    public void setSystemAgreementId( String systemAgreementId) {
        this.systemAgreementId = systemAgreementId.trim();
    }

    public String getSystemAgreementId() {
        return systemAgreementId;
    }

    public void setOrderLineId( String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public boolean isInvoiceable() {
        return invoiceable;
    }

    public String getSalesPart() {
        return salesPart;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotal() {
        return total;
    }

    public Money getCost() {
        return cost;
    }

    public String getPeriod() {
        return period;
    }

    public Timestamp getDateOfPrepayment() {
        return dateOfPrepayment;
    }

    public DebitOrCredit getDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(DebitOrCredit debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    public String getCreditedInvoiceID() {
        return creditedInvoiceID;
    }

    public String getSplitter() {
        return splitter;
    }

    public OrderLineStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSentToAxSucceeded() {
        status = OrderLineStatus.SENT_TO_AX_SUCCEEDED;
    }

    public void setSentToAxFailed(String errorMessage) {
        status = OrderLineStatus.SENT_TO_AX_FAILED;
        this.errorMessage = errorMessage;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setValidationFailed(String errorMessage) {
        status = OrderLineStatus.VALIDATION_FAILED;
        this.errorMessage = errorMessage;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
