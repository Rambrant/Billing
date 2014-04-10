package com.tradedoubler.billing.service.ax.ftp.call;

import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class uses a provided ftp-connection to delete an AxInvoice.
 */
@Component
public class DeleteInvoiceCall extends AbstractFtpCall {
    private final static Logger log = LoggerFactory.getLogger(DeleteInvoiceCall.class);


    /**
     * Deletes the given invoice from the AX Ftp server.
     * @param invoice The invoice to delete permanently.
     * @throws Exception When the deletion fails.
     */
    public void execute(AxInvoice invoice) throws Exception{
     //TODO: kepp the code below. This is commented to avoid accidental delete of ftp-area during test-period
//        FTPClient ftp = null;
//        try{
//             ftp = ftpSetup.connect();
//
//                if ( !ftp.deleteFile(invoice.getFileName())){
//                    throw new Exception("Could not delete invoice with name: " + ftp.getReplyString() + " for " + invoice.getFileName());
//                }
//
//        }finally{
//            if (ftp != null){
//                try {
//                    ftp.disconnect();
//                    ftp = null;
//                } catch (IOException e) {
//                    log.error(LogError.OPERATIONAL_DISTURBANCE.name(), e);
//                    throw new Exception(LogError.OPERATIONAL_DISTURBANCE.name() + " IOException when disconnecting ftp");
//
//                }
//            }
//        }
    }

}
