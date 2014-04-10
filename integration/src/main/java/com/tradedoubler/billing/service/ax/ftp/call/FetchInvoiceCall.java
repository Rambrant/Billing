package com.tradedoubler.billing.service.ax.ftp.call;

import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import static com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus.FAILED_READ_FROM_FTP;

/** This class uses a provided ftp-connection to fetch an AxInvoice. */
@Component
public class FetchInvoiceCall extends AbstractFtpCall {
    private final static Logger log = LoggerFactory.getLogger(FetchInvoiceCall.class);

    private AxInvoice axInvoice;


    public void execute() throws BillingServiceException {
        axInvoice = null;
        FTPClient ftp = null;
        try {
            ftp = ftpSetup.connect();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            //No ordering of files
            FTPFile[] files = ftp.listFiles();


            InputStream is;
            BufferedInputStream bis = null;
            for (FTPFile file : files) {
                if (!file.isFile()) {
                    log.debug(" - Expected only invoice files in the directory but found something else: " +
                            file.getName() + "     Moving on...");
                    continue;
                }
                String fileName = file.getName();
                fileName = fileName == null ? "" : fileName.trim();
                if (fileName.endsWith(".xml")) {
                    axInvoice = new AxInvoice();

                    try {
                        // Found a valid invoice
                        log.debug("Attempting to fetch file: " + fileName);
                        synchronized (this) {
                            is = ftp.retrieveFileStream(fileName);
                        }

                        if (is == null) {
                            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - Could not get InputStream for file: " + fileName);
                            axInvoice.setInvoiceStatus(FAILED_READ_FROM_FTP);
                            continue;
                        }
                        bis = new BufferedInputStream(is);

                        StringWriter writer = new StringWriter();
                        IOUtils.copy(is, writer, "UTF-8");
                        String theString = writer.toString();

                        //Note: the completePendingCommand must be here. If it is invoked earlier the ftp-hangs on file sizes larger than 400k
                        if (!ftp.completePendingCommand()) {
                            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " -  Could not complete transfer of " + fileName);
                            axInvoice.setInvoiceStatus(FAILED_READ_FROM_FTP);

                            if (is != null) is.close();
                            continue;
                        }

                        //
                        axInvoice.setRawXML(theString);
                        //Clean characters that otherwise crashes the XML-parser
                        axInvoice.setInvoiceXml(cleanXMLForDummyCharacters(theString));
                        axInvoice.setFileName(ftpSetup.getPath() + "/" + fileName);

                        log.debug("Fetched invoice: " + fileName);

                    } finally {
                        if (bis != null) {
                            bis.close();
                            bis = null;
                        }
                        is = null;
                    }
                    break;
                }
            }

        } catch (IOException e) {
            throw BillingServiceException.createIntegrationDisturbance(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when connecting to ftp: " + e.getMessage(), -1);
        } catch (Exception e) {
            throw BillingServiceException.createIntegrationDisturbance(LogError.OPERATIONAL_DISTURBANCE.name() + ". Exception when reading file list from ftp: " + e.getMessage(), -1);
        } finally {

            if (ftp != null) {
                try {
                    ftp.disconnect();
                    ftp = null;
                } catch (IOException e) {
                    //Catch the specific IOException for clarity.
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp", e);
                    throw BillingServiceException.createIntegrationDisturbance(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp", -1);
                } catch (Exception e) {
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " Untyped Exception when disconnecting ftp", e);
                    throw BillingServiceException.createIntegrationDisturbance(LogError.OPERATIONAL_DISTURBANCE.name() + " Untyped Exception when disconnecting ftp", -1);
                }
            }
        }

    }

    /**
     * Removes any characters outside the valid UTF-8 range as well as all control characters
     * except tabs and new lines
     */
    private String removeNonUtf8CompliantCharacters(final String inString) {
        if (null == inString) return null;
        byte[] byteArr = inString.getBytes();
        for (int i = 0; i < byteArr.length; i++) {
            byte ch = byteArr[i];

            if (!((ch > 31 && ch < 253) || ch == '\t' || ch == '\n' || ch == '\r')) {
                byteArr[i] = ' ';
            }
        }
        return new String(byteArr);
    }

    /**
     * Removing unnecessary BOM that crashes the XML-parser.
     *
     * @param originalXML xml that may contain BOM
     * @return BOM-free XML
     */
    private String cleanXMLForDummyCharacters(String originalXML) {
        if (originalXML == null) return null;

        StringBuilder cleanedXML = new StringBuilder();
        char ch;

        for (int i = 0; i < originalXML.length(); i++) {
            ch = originalXML.charAt(i);
            if (ch != 0xFEFF) {
                cleanedXML.append(ch);
            }

        }
        return removeNonUtf8CompliantCharacters(cleanedXML.toString());
    }

    public AxInvoice getAxInvoice() {
        return axInvoice;
    }
}
