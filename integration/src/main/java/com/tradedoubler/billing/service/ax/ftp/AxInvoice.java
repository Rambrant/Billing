package com.tradedoubler.billing.service.ax.ftp;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.tradedoubler.billing.domain.InvoiceOrderLineStatus.PROCESSED;

/** Represents a fetched invoice from the AX FTP server. <br/>
 * This class contains references to the original XML as well as to the corresponding domain invoice object.
 *
 */
public class AxInvoice {

    /** The actual xml data representing the invoice. */
    private String invoiceXml;

    /** The absolute file path to the fetched file on the FTP server. Used to remove the file from the ftp once handled. */
    private String fileName;


    private Timestamp timeStampForInvoiceFile;

    private Guid guidForInvoiceFile;

    /** The invoice domain object */
    private Invoice invoice;

    /** The invoice domain object */
    private MetaData metaData;

    private transient boolean isMigratedInvoice;

    /** The status of the invoice as stated in enum InvoiceStatus */
    private InvoiceStatus invoiceStatus = InvoiceStatus.INCOMPLETE;
    private String rawXML;

    public void setInvoice(Invoice invoice){

        this.invoice = invoice;
    }

    public String getInvoiceXml() {
        return invoiceXml;
    }

    public void setInvoiceXml(String invoiceXml) {
        this.invoiceXml = invoiceXml;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public Invoice getInvoice(){
        return invoice;
    }

    public Timestamp getTimeStampForInvoiceFile() {
        return timeStampForInvoiceFile;
    }

    public void setTimeStampForInvoiceFile(Timestamp timeStampForInvoiceFile) {

        this.timeStampForInvoiceFile = timeStampForInvoiceFile;
    }
    public JsonMessage getInvoiceJson() {

        Gson gson = GsonFactory.getGson();
        String json;
        if (invoice.getEvent() == Event.POSTED) {
            InvoiceEnvelope invoiceEnvelope = new InvoiceEnvelope(invoice, metaData);
            json = gson.toJson(invoiceEnvelope);
        } else{
            InvoiceEnvelopeUpdate invoiceEnvelope = new InvoiceEnvelopeUpdate(invoice, metaData);
            json = gson.toJson(invoiceEnvelope);

        }
        return new JsonMessage(json);

    }


    List<InvoicedAgreement> getInvoicedAgreements(){
        return invoice.getInvoicedAgreements();
    }

    public Guid getGuidForInvoiceFile() {

        return guidForInvoiceFile;
    }

    public void setGuidForInvoiceFile(Guid guidForInvoiceFile) {
        this.guidForInvoiceFile = guidForInvoiceFile;
    }


    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Determines if orderlines should be sent to Pan as described in the documentation.
     */
    public boolean doInsertForPan(){
        return  invoice.getEvent() == Event.POSTED &&
                invoice.getOrderLineStatus() == PROCESSED &&
                invoice.getOriginalInvoiceId() == null &&
                getInvoicedOrderLines().size() > 0;
    }

    /**
     * Determines if invoice state should be updated.
     */
    public boolean doInvoiceStatusChanged() {
        return
          invoice.getEvent() == Event.PAID && BigDecimal.ZERO.compareTo(invoice.getAmountOpen()) == 0
       || invoice.getEvent() == Event.WRITE_OFF/*WRITE_OFF is the same as BAD_DEBT in Pan*/
       || invoice.getEvent() == Event.SETTLED && invoice.getOrderLineStatus() == PROCESSED && BigDecimal.ZERO.compareTo(invoice.getAmountOpen()) == 0;
    }

    public List<InvoicedOrderLine> getInvoicedOrderLines(){
        List<InvoicedOrderLine> listOut = new ArrayList<InvoicedOrderLine>();
        for (InvoicedAgreement invoicedAgreement : getInvoicedAgreements()){
            listOut.addAll(invoicedAgreement.getInvoicedOrderLines());
        }

        return listOut;
    }

    public boolean isMigratedInvoice() {
        return isMigratedInvoice;
    }

    public void setMigratedInvoice(boolean migratedInvoice) {
        isMigratedInvoice = migratedInvoice;
    }

    //Raw string format used for logging
    public void setRawXML(String rawXML) {
        this.rawXML = rawXML;
    }

    public String getRawXML() {
        return rawXML;
    }
}
