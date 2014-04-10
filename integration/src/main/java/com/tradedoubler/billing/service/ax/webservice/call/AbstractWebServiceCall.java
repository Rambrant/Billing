package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.fault.*;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework.*;
import org.slf4j.*;

import java.util.List;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.*;

/**
 * This class defines common behaviour for Ax web service calls.
 * Date: 2012-08-27
 */
public class AbstractWebServiceCall {

    private final static Logger log = LoggerFactory.getLogger(AbstractWebServiceCall.class);

    private AxRequestResult axRequestResult = UNKNOWN;
    private int errorCode;
    private String errorMessage;
    private LogInformation callLogInformation;

    /**
     * Ax throws exceptions for both internal errors and data errors.
     * This method checks the AX exceptions' fault info code against an enum containing the error codes from the IDD-Exception document (table 1 and 2).<br/>
     * If an error code is not CATEGORIZED, an exception is thrown.
     *
     * @param faultMessage The parent exception
     * @param aifFault     The fault info by the web service
     */
    void analyzeAXFaultInfo(Exception faultMessage, AifFault aifFault, LogInformation callLogInformation) {
        log.debug(faultMessage.getMessage());

        analyzeAifFaultMessage(aifFault);
        axRequestResult = forError(errorCode, errorMessage);
        this.callLogInformation = callLogInformation;
    }

    private void analyzeAifFaultMessage(AifFault faultInfo) {
        Integer xppExceptionType = faultInfo.getXppExceptionType();
        if (xppExceptionType != null) {
            errorCode = xppExceptionType;
        }

        StringBuilder msg = new StringBuilder();
        ArrayOfInfologMessage arrayOfInfologMessage = faultInfo.getInfologMessageList().getValue();
        msg = appendInfologMessages(msg, arrayOfInfologMessage);

        ArrayOfFaultMessageList arrayOfFaultMessageList = faultInfo.getFaultMessageListArray().getValue();
        errorMessage = appendFaultMessages(msg, arrayOfFaultMessageList).toString();
    }


    private static StringBuilder appendInfologMessages(StringBuilder msg, ArrayOfInfologMessage infologMessages) {
        if (infologMessages != null) {
            boolean first = true;
            for (InfologMessage infologMessage : infologMessages.getInfologMessage()) {
                if (first) {
                    first = false;
                } else {
                    msg.append(", ");
                }
                msg.append(infologMessage.getMessage().getValue());
            }
        }
        return msg;
    }

    private static StringBuilder appendFaultMessages(StringBuilder msg, ArrayOfFaultMessageList faultMessageList) {
        if (faultMessageList != null) {
            boolean first = true;
            for (FaultMessageList messageList : faultMessageList.getFaultMessageList()) {
                List<FaultMessage> faultMessage = messageList.getFaultMessageArray().getValue().getFaultMessage();
                for (FaultMessage message : faultMessage) {
                    if (first) {
                        first = false;
                    } else {
                        msg.append(", ");
                    }
                    msg.append(message.getMessage().getValue());
                }
            }
        }
        return msg;
    }

    void setCallOperationSuccess() {
        axRequestResult = ALL_IS_WELL;
    }

    public AxRequestResult getAxRequestResult() {
        return axRequestResult;
    }

    /** Return error message or null if none */
    public String getErrorMessage() {
        return errorMessage;
    }

    /** Return error code or zero if none */
    public int getErrorCode() {
        return errorCode;
    }

    /** This information is used for logging when the call fails */
    public String getCallLogInformation() {
        return callLogInformation.toString();
    }

    /** This information is used for logging when the call fails */
    static class LogInformation {
        private final String info;

        public LogInformation(String domainObjectName, String primaryKeyValue, String dataAreaId) {
            info = String.format("%s PK: %s, dataAreaId: %s  ", domainObjectName, primaryKeyValue, dataAreaId);
        }

        @Override
        public String toString() {
            return info;
        }
    }

}
