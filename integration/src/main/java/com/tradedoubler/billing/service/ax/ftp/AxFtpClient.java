package com.tradedoubler.billing.service.ax.ftp;

import com.tradedoubler.billing.platform.logging.LogError;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Ftp client that fetches and deletes invoices from the AX Ftp server.
 */
public class AxFtpClient {

    private final static Logger log = LoggerFactory.getLogger(AxFtpClient.class);

    /** The ftp host. Injected by spring. */
    private String host;

    /** The ftp path relative the home directory to where the invoices are located. Injected by spring. */
    private String path;

    /** The ftp account username. Injected by spring. */
    private String username;

    /** The ftp account password. Injected by spring. */
    private String password;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Connects to the FTP server as specified by the spring injected configuration.
     * @return A ftp client
     * @throws Exception When connection fails.
     */
    private FTPClient connect() throws Exception {
        FTPClient ftp = new FTPClient();

        log.info("About to connect to ftp server: " + host);

        ftp.connect(host);

        ftp.setSoTimeout(10000);
        ftp.setDataTimeout(10000);

        ftp.enterLocalPassiveMode();

        int reply = ftp.getReplyCode();
        log.debug("Reply code: " + reply);

        if(!FTPReply.isPositiveCompletion(reply)) {
            String error = "FTP server refused connection.";
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
            throw new Exception(error);
        }

        log.info("About to send login credentials");
        if (!ftp.login(username, password) || !FTPReply.isPositiveCompletion(ftp.getReplyCode())){
            String error = "Can't login to the ftp server";
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
            throw new Exception(error);
        }

        return ftp;
    }

    /**
     * Fetches one invoice, if available, from the dynamics AX located FTP server.
     * @return The invoice or null if no invoice is available.
     * @exception Exception When something goes wrong
     */
    public AxInvoice fetchInvoice() throws Exception {

        FTPClient ftp = null;
        try{
            int reply;
            ftp = connect();

            log.info("About to change directory to: " + path);
            if (!ftp.changeWorkingDirectory(path)){
                reply = ftp.getReplyCode();
                String error = "Reply code: " + reply + " Could not change working directory to: " + path + " at the FTP server. Aborts.";
                log.error( LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
                throw new Exception(error);
            }

            // List directory
            ftp.setFileType(FTPClient.ASCII_FILE_TYPE);

            FTPFile[] files = ftp.listFiles();

            if (true) throw new Exception();
            InputStream is;
            BufferedInputStream bis = null;
            for(FTPFile file : files){
                if ( !file.isFile()){
                    log.warn(LogError.OPERATIONAL_DISTURBANCE.name() + " - Expected only invoice files in the directory but found something else: " +
                            file.getName() + "     Moving on...");
                    continue;
                }
                String fileName = file.getName();
                fileName = fileName == null ? "" : fileName.trim();
                if( fileName.endsWith(".xml")){
                    try{
                        // Found a valid invoice
                        log.info("Attempting to fetch file: " + fileName);
                        is = ftp.retrieveFileStream(fileName);
                        if ( !ftp.completePendingCommand()){
                            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " -  Could not complete transfer of " + fileName);
                            if ( is != null) is.close();
                            continue;
                        }
                        if ( is == null){
                            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - Could not get InputStream for file: " + fileName);
                            continue;
                        }
                        bis = new BufferedInputStream(is);
                        int bytesRead;
                        byte[] data = new byte[32];
                        StringBuilder sb = new StringBuilder();
                        while ((bytesRead = is.read(data)) != -1) {
                            sb.append(new String(data, 0, bytesRead));
                        }

                        AxInvoice invoice = new AxInvoice();
                        invoice.setInvoiceXml(sb.toString());
                        invoice.setFileName(path + "/" + fileName);

                        log.info("Fetched invoice: " + fileName);
                        return invoice;
                    }finally {
                        if ( bis != null){
                            bis.close();
                            bis = null;
                        }
                        is = null;
                    }
                }else {
                    log.warn("Found file which is not xml: " + file.getName() + "     Moving on...");
                }
            }

        }finally{

            if (ftp != null){
                try {
                    ftp.disconnect();
                    ftp = null;
                } catch (IOException e) {
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp", e);
                    throw new Exception(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp");
                }
            }
        }

        return null;
    }

    /**
     * Deletes the given invoice from the AX Ftp server.
     * @param invoice The invoice to delete permanently.
     * @throws Exception When the deletion fails.
     */
    public void deleteInvoice(AxInvoice invoice) throws Exception{
        FTPClient ftp = null;
        try{
            ftp = connect();
            if ( !ftp.deleteFile(invoice.getFileName())){
                throw new Exception("Could not delete invoice with name: " + invoice.getFileName());
            }
        }finally{

            if (ftp != null){
                try {
                    ftp.disconnect();
                    ftp = null;
                } catch (IOException e) {
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
                    throw new Exception(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp");

                }
            }
        }
    }

    /**
     * Returns the configuration settings for the FTP server.
     */
    public String getInfo(){
        return "Host: " + host + " path: " + path + " username: " + username + " password: " + password;
    }

}
