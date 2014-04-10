package com.tradedoubler.billing.service.ax.ftp.call;

import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/** Handles moving of faulty invoices files on the ftp-area. */
@Component
public class MoveInvoiceCall extends AbstractFtpCall {
    private final static Logger log = LoggerFactory.getLogger(DeleteInvoiceCall.class);
    private FTPClient ftp;

    /**
     * Moves an invoice file to directory for faulty invoices. Adds a time stamp (in ms) to file name .
     *
     * @param invoice The invoice to move.
     * @param errorMessage
     * @throws BillingServiceException When move fails.
     */
    public void executeFailed(AxInvoice invoice, String errorMessage) throws BillingServiceException {
        try {

            ftp = ftpSetup.connect();

            long time = System.currentTimeMillis();
            //First move failed invoice
            if (!ftp.rename(invoice.getFileName(), ftpSetup.getFailPath() + "/" + time + "_" + FilenameUtils.getName(invoice.getFileName()))) {
                log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " : Could not move invoice with name: " + ftp.getReplyString() + " for " + invoice.getFileName());
                throw BillingServiceException.createIntegrationDisturbance("Could not move invoice with name: " + ftp.getReplyString() + " for " + invoice.getFileName());

            }

            //Second create fail-info file. This is less critical
            createInfoFile(invoice, errorMessage, time);

        } catch (Exception e) {
            log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
            throw BillingServiceException.createIntegrationDisturbance(String.format("%s Exception when attempting ftp on %s: %s", LogError.OPERATIONAL_DISTURBANCE.name(), invoice.getFileName(), e.getMessage()));

        } finally {
            if (ftp != null) {
                try {
                    ftp.disconnect();
                    ftp = null;
                } catch (IOException e) {
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
                    throw BillingServiceException.createIntegrationDisturbance(String.format("%s IOException when disconnecting ftp", LogError.OPERATIONAL_DISTURBANCE.name()));

                }
            }
        }
    }

    /**
     * Creates file containing information of why an invoice failed. This file will be placed next to and have the same name as the invoice xml-file
     * but with the prefix _info.txt
     * @param invoice the failed invoice
     * @param errorMessage detailed error message
     * @param time time stamp. Used in the file name.
     */
    private void createInfoFile(AxInvoice invoice, String errorMessage, long time)  {
        String description = invoice.getInvoiceStatus().getDescription();
        if (invoice.getInvoiceStatus() == InvoiceStatus.INVOICE_OK) description = "\"Unknown status\" - check log.";

        description = description.concat(". Detailed message: " + errorMessage);
        String failInfo = String.format("Failed to complete invoice %s due to %s", (invoice.getInvoice() != null)? invoice.getInvoice().getInvoiceId() : "\"No invoice ID-Number\"", description);
        InputStream is = new ByteArrayInputStream(failInfo.getBytes());

        try {
            ftp.storeFile(ftpSetup.getFailPath() + "/" + time + "_" + FilenameUtils.getBaseName(invoice.getFileName()) + "_info.txt", is);
        } catch (Exception e) {
            //Silent exception. Not necessary to create disturbance call. Info in log instead.
            log.info(String.format("Failed to create info file for invoice file %s with info %s . Message: %s. Continues anyway", invoice.getFileName(), description, e.getMessage()));
        }
    }

    /**
     * Moves invoice to archive directory on the ftp-server. Adds current time in milliseconds to the moved file.
     * If method fails an Integration Disturbance is flagged
     * @param invoice the successful invoice
     * @throws BillingServiceException This exception flags an integration disturbance
     */
    public void executeSuccessful(AxInvoice invoice) throws BillingServiceException {
        FTPClient ftp = null;
        try {
            ftp = ftpSetup.connect();

            if (!ftp.rename(invoice.getFileName(), ftpSetup.getOkPath() + "/" + System.currentTimeMillis() + "_" + new File(invoice.getFileName()).getName())) {
                log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " : Could not move invoice with name: " + ftp.getReplyString() + " for " + invoice.getFileName());
                throw BillingServiceException.createIntegrationDisturbance("Could not move invoice with name: " + ftp.getReplyString() + " for " + invoice.getFileName());

            }
        } catch (Exception e) {
            log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
            throw BillingServiceException.createIntegrationDisturbance(String.format("%s Exception when attempting ftp on %s: %s", LogError.OPERATIONAL_DISTURBANCE.name(), invoice.getFileName(), e.getMessage()));

        } finally {
            if (ftp != null) {
                try {
                    ftp.disconnect();
                    ftp = null;
                } catch (IOException e) {
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
                    throw BillingServiceException.createIntegrationDisturbance(String.format("%s IOException when disconnecting ftp: %s", LogError.OPERATIONAL_DISTURBANCE.name(), e.getMessage()));

                }
            }
        }
    }
}
