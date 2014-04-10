package com.tradedoubler.billing.platform.flowcontroller.test;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.ax.ftp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A mock mule component to handle invoices.
 */
public class BusinessComponentInvoiceMock {

    private final static Logger log = LoggerFactory.getLogger(BusinessComponentMock.class);

    private AxFtpClient axFtpClient;

    public AxFtpClient getAxFtpClient() {
        return axFtpClient;
    }

    public void setAxFtpClient(AxFtpClient axFtpClient) {
        this.axFtpClient = axFtpClient;
    }

    public ServiceResult execute(ServiceResult input) {

        IntegrationMessage intMess = input.getIntegrationMessage();
        if (intMess.isOutOfSequence()) {

        }


        // Handle invoice
        try {
            AxInvoice invoice = (AxInvoice) input.getCommitInfo();
            log.error("About to delete invoice: " + invoice.getFileName());
            axFtpClient.deleteInvoice(invoice);
        } catch (Exception e) {
            input.setBugDisturbance(true);
            input.setErrorMessage("Couldnt delete invoice");
            input.setDetailedErrorMessage(e);
            log.error("ERROR", e);
        }

        return input;
    }
}

