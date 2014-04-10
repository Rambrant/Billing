package com.tradedoubler.billing.service.ax.ftp;

import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.ParameterUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * This class provides a connection based on the setup for the ftp, from the provided properties such as logon credentials and working directory.
 */
@Component
public class FtpSetupServiceSetupImpl {
    private final static Logger log = LoggerFactory.getLogger(FtpSetupServiceSetupImpl.class);

    //ftp ip-address
    @Value("${FTP.HOST}")
    private String host;

    //working directory for the invoices
    @Value("${FTP.PATH}")
    private String path;

    //user name
    @Value("${FTP.USERNAME}")
    private String username;

    //password
    @Value("${FTP.PASSWORD}")
    private String password;

    //directory for failed invoices
    @Value("${FTP.PATH.FAILED}")
    private String failPath;

    //directory for archived successful invoices
    @Value("${FTP.PATH.OK}")
    private String okPath;

    //Set socket time out for complete handshake in milli-seconds
    @Value("${FTP.SOCKET.TIMEOUT}")
    private int socketTimeOut;

    //Set socket time out for complete handshake in milli-seconds
    @Value("${FTP.DATA.TIMEOUT}")
    private int dataTimeOut;


    @PostConstruct
    public void setUp() {
        ParameterUtil.checkParameter(host);
        ParameterUtil.checkParameter(path);
        ParameterUtil.checkParameter(username);
        ParameterUtil.checkParameter(password);
        ParameterUtil.checkParameter(failPath);
        ParameterUtil.checkParameter(okPath);
        ParameterUtil.checkParameter(socketTimeOut);
        ParameterUtil.checkParameter(dataTimeOut);
    }

    public String getPath() {
        return path;
    }

    /**
     * Connects to the FTP server as specified by the spring injected configuration.
     * @return A ftp client
     * @throws Exception When connection fails.
     */
    public FTPClient connect() throws Exception {
        FTPClient ftp = new FTPClient();

        log.debug("About to connect to ftp server: " + host);

        ftp.setDefaultTimeout(120000);
        ftp.connect(host);
        ftp.setSoTimeout(120000);
        ftp.setDataTimeout(120000);
        ftp.enterLocalPassiveMode();

        int reply = ftp.getReplyCode();
        log.debug("Reply code: " + reply);

        if(!FTPReply.isPositiveCompletion(reply)) {
            String error = "FTP server refused connection.";
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
            throw new Exception(error);
        }

        log.debug("About to send login credentials");
        if (!ftp.login(username, password) || !FTPReply.isPositiveCompletion(ftp.getReplyCode())){
            String error = "Can't login to the ftp server";
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
            throw new Exception(error);
        }
        log.debug("About to change directory to: " + path);
        if (!ftp.changeWorkingDirectory(path)){
            reply = ftp.getReplyCode();
            String error = "Reply code: " + reply + " Could not change working directory to: " + path + " at the FTP server. Aborts.";
            log.error( LogError.OPERATIONAL_DISTURBANCE.name() + " - " + error);
            throw new Exception(error);
        }
        ftp.setFileType(FTPClient.ASCII_FILE_TYPE);
        return ftp;
    }

    public String getFailPath() {
        return failPath;
    }

    public String getOkPath() {
        return okPath;
    }
}
