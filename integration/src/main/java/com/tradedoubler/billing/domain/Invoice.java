package com.tradedoubler.billing.domain;

import com.tradedoubler.billing.transform.ftp.InvoiceConverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.tradedoubler.billing.domain.InvoiceOrderLineStatus.NONE;
import static com.tradedoubler.billing.domain.InvoiceOrderLineStatus.NO_ORDER_LINES;

/**
 * Domain object for the invoice
 */
public class Invoice {
    private  String invoiceId;
    private  transient int invoiceIssuer;
    private  String invoicingDate;
    private  String dueDate;
    private  BigDecimal netAmount;
    private  BigDecimal vat = BigDecimal.ZERO;
    private  BigDecimal totalInvoiced;
    private  String currency;
    private  String linkToInvoiceDocument;
    private  String linkToInvoiceDocumentCopy;
    private  String invoicePeriod;
    private  BigDecimal gp;
    private  Event event;
    private  String paidDate;
    private  BigDecimal amountOpen = BigDecimal.ZERO;
    private int revenueType = InvoiceConverter.NO_REVENUE_TYPE;
    private  String originalInvoiceId;
    private transient List<InvoicedAgreement> invoicedAgreements = new ArrayList<InvoicedAgreement>();
    private String clientId;
    private String modifiedOn;
    private Market marketId;
    private transient InvoiceOrderLineStatus orderLineStatus = NONE;

    //To many arguments to use constructor...
    public Invoice(){//String invoiceId, String customer, String invoiceIssuer, Timestamp invoicingDate, TimeStamp dueDate, BigDecimal netAmount, BigDecimal vat, BigDecimal totalAmount, String currency, String linkToInvoiceDocument, String linkToInvoiceDocumentCopy, String invoicingPeriod, BigDecimal gp, Event event, Timestamp paidDate, BigDecimal amountOpen, String revenueType, String originalInvoiceId) {
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }


    public int getInvoiceIssuer() {
        return invoiceIssuer;
    }

    public void setInvoiceIssuer(int invoiceIssuer) {
        this.invoiceIssuer = invoiceIssuer;
    }

    public String getInvoicingDate() {
        return invoicingDate;
    }

    public void setInvoicingDate(String invoicingDate) {
        this.invoicingDate = invoicingDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getTotalInvoiced() {
        return totalInvoiced;
    }

    public void setTotalInvoiced(BigDecimal totalInvoiced) {
        this.totalInvoiced = totalInvoiced;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLinkToInvoiceDocument() {
        return linkToInvoiceDocument;
    }

    public void setLinkToInvoiceDocument(String linkToInvoiceDocument) {
        this.linkToInvoiceDocument = linkToInvoiceDocument;
    }

    public String getLinkToInvoiceDocumentCopy() {
        return linkToInvoiceDocumentCopy;
    }

    public void setLinkToInvoiceDocumentCopy(String linkToInvoiceDocumentCopy) {
        this.linkToInvoiceDocumentCopy = linkToInvoiceDocumentCopy;
    }


    public BigDecimal getGp() {
        return gp;
    }

    public void setGp(BigDecimal gp) {
        this.gp = gp;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public BigDecimal getAmountOpen() {
        return amountOpen;
    }

    public void setAmountOpen(BigDecimal amountOpen) {
        this.amountOpen = amountOpen;
    }

    public int getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(int revenueType) {
        this.revenueType = revenueType;
    }

    public String getOriginalInvoiceId() {
        return originalInvoiceId;
    }

    public void setOriginalInvoiceId(String originalInvoiceId) {
        this.originalInvoiceId = originalInvoiceId;
    }

    public List<InvoicedAgreement> getInvoicedAgreements() {
        return invoicedAgreements;
    }

    public void setInvoicedAgreements(List<InvoicedAgreement> invoicedAgreements) {
        this.invoicedAgreements = invoicedAgreements;
    }

    public String getInvoicePeriod() {
        return invoicePeriod;
    }

    public void setInvoicePeriod(String invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Market getMarketId() {
        return marketId;
    }

    public void setMarketId(Market marketId) {
        this.marketId = marketId;
    }

    /**
     * Retrieves the order lines status. Same assumed for ALL order lines => only looks at the first line.
     * @return  The order line status
     */
    public InvoiceOrderLineStatus getOrderLineStatus() {
        if (invoicedAgreements.size() == 0 || invoicedAgreements.get(0).getInvoicedOrderLines().size() == 0) return NO_ORDER_LINES;
        return invoicedAgreements.get(0).getInvoicedOrderLines().get(0).getStatus();
    }

}
