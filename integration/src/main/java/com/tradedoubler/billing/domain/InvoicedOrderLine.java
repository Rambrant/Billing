package com.tradedoubler.billing.domain;

/**
* Domain object for the invoiced order line, extracted from an AxInvoice.
 */
public class InvoicedOrderLine {

    private final String orderLineId;
    private final String invoiceId;
    private final Market  market;
    private final Currency currencyCode;
    private final OrderLine orderLine;
    private final String invoiceRevenueType;
    private final transient InvoiceOrderLineStatus status;

    public InvoicedOrderLine(String orderLineId, String invoiceId, Market market, Currency currencyCode, OrderLine orderLine, String invoiceRevenueType, InvoiceOrderLineStatus status) {
        this.orderLineId = orderLineId;
        this.invoiceId = invoiceId;
        this.market = market;
        this.currencyCode = currencyCode;
        this.orderLine = orderLine;
        this.invoiceRevenueType = invoiceRevenueType;
        this.status = status;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Market getMarket() {
        return market;
    }

    public Currency getCurrencyCode() {
        return currencyCode;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public String getInvoiceRevenueType() {
        return invoiceRevenueType;
    }

    public InvoiceOrderLineStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoicedOrderLine that = (InvoicedOrderLine) o;

        if (orderLine.getSystemAgreementId() != null) {
            if (!orderLine.getSystemAgreementId().equals(that.orderLine.getSystemAgreementId())) {
                return false;
            }
        } else {
            if (that.orderLine.getSystemAgreementId() != null) {
                return false;
            }
        }
        if (orderLine.getSalesPart() != null) {
            if (!orderLine.getSalesPart().equals(that.orderLine.getSalesPart())) {
                return false;
            }
        } else {
            if (that.orderLine.getSalesPart() != null) {
                return false;
            }
        }

        return true;
    }

    public String getUpdateForecastKey(){
        return orderLine.getSystemAgreementId();// + orderLine.getSalesPart();
    }
    @Override
    public int hashCode() {
        int result = orderLine.getSystemAgreementId() != null ? orderLine.getSystemAgreementId().hashCode() : 0;
        result = 31 * result + (orderLine.getSalesPart() != null ? orderLine.getSalesPart().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvoicedOrderLine{" +
                "orderLineId='" + orderLineId + '\'' +
                ", invoiceId='" + invoiceId + '\'' +
                '}';
    }
}
