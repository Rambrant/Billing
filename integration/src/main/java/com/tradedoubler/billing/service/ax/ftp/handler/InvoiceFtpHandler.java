package com.tradedoubler.billing.service.ax.ftp.handler;

import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.ax.ftp.call.DeleteInvoiceCall;
import com.tradedoubler.billing.service.ax.ftp.call.FetchInvoiceCall;
import com.tradedoubler.billing.service.ax.ftp.call.MoveInvoiceCall;
import com.tradedoubler.billing.service.transform.AxConverterService;
import com.tradedoubler.billing.transform.ftp.AxCustomerInvoiceToInvoiceTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This class contains convenient methods to retrieve invoices created by AX with ftp.
 */
@Component
public class InvoiceFtpHandler {

    @Autowired
    protected AxConverterService converter;

    @Autowired
    FetchInvoiceCall fetchInvoiceCall;

    @Autowired
    DeleteInvoiceCall deleteInvoiceCall;

    @Autowired
    MoveInvoiceCall moveInvoiceCall;


    private final static Logger log = LoggerFactory.getLogger(InvoiceFtpHandler.class);

    /**
     * Fetches an invoice-container  from the ftp server.
     * @return the invoice container
     * @throws BillingServiceException
     */
    public AxInvoice fetchInvoice() throws BillingServiceException {

        log.debug("About to fetch invoice: ");

        fetchInvoiceCall.execute();


        return fetchInvoiceCall.getAxInvoice();
    }

    /**
     * Extracts the domain invoice and meta-data from the XML.
     * @param axInvoice
     * @throws BillingServiceException
     */
    public void doTransformation(AxInvoice axInvoice) throws BillingServiceException {

        AxCustomerInvoiceToInvoiceTransformer transformer = new AxCustomerInvoiceToInvoiceTransformer(converter);
        transformer.transform(axInvoice);
    }

    /**
     * Deletes Invoice after successful handling of content. <br>
     * This method is kept on hold. FO not delete For now, successful invoices are instead moved to the archive directory.
     *
     * @param axInvoice
     * @throws Exception
     */
    public void deleteInvoice(AxInvoice axInvoice) throws Exception {
        log.debug("About to delete invoice: " + axInvoice.getFileName());

        deleteInvoiceCall.execute(axInvoice);

    }
         /**
     * Archives Invoice after successful handling of content.
     * @param axInvoice
     * @throws Exception
     */
    public void archiveSuccessfulInvoice(AxInvoice axInvoice) throws BillingServiceException {
        log.debug("About to archive invoice: " + axInvoice.getFileName());

        moveInvoiceCall.executeSuccessful(axInvoice);

    }
    /**
     * Moves a failed invoice to the appropriate directory given in the property file. It adds current time in milliseconds to the moved file.
     * @param axInvoice
     * @throws BillingServiceException
     */
    public void moveFailedInvoice(AxInvoice axInvoice, String errorMessage) throws BillingServiceException {
        if (axInvoice != null) {
            log.debug("About to move invoice: " + axInvoice.getFileName());
            moveInvoiceCall.executeFailed(axInvoice, errorMessage);
        } else{
            log.info("Attempted to move nulled invoice: ");
        }
    }
}
