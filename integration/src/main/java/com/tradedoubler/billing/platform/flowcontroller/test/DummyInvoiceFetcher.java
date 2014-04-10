package com.tradedoubler.billing.platform.flowcontroller.test;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.ax.ftp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock invoice fetching mule component.
 */
public class DummyInvoiceFetcher {

    private final static Logger log = LoggerFactory.getLogger(DummyInvoiceFetcher.class);

    private AxFtpClient axFtpClient;

    public AxFtpClient getAxFtpClient() {
        return axFtpClient;
    }

    public void setAxFtpClient(AxFtpClient axFtpClient) {
        this.axFtpClient = axFtpClient;
    }

    public ServiceResult execute(ServiceResult result) {

        try {
            log.info("FTP: " + axFtpClient.getInfo());

            AxInvoice invoice = axFtpClient.fetchInvoice();

            if (invoice != null) {

                result.setCommitInfo(invoice);
                result.setRawData(invoice.getInvoiceXml());

                MetaData metaData = new MetaData("testInvoice", new Guid(invoice.getFileName()), new Timestamp("2012-08-16T15:30:01.999+02:00"), "1", "CRM");
                IntegrationMessage intMessage = new IntegrationMessage("15", metaData);
                result.setIntegrationMessage(intMessage);

            }
        } catch (Exception e) {
            log.error(LogError.BUG_DISTURBANCE.name(), e);
        } finally {
            return result;
        }
    }

}
