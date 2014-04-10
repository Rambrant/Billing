package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import mds_salesorderbasisline.*;

/**
 * Executes a web service call to Ax to start invoice batch job.
 * User: erigu
 * Date: 2012-09-14
 */
public class StartOrderLineProcessingCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final SalesOrderBasisLineProcessing servicePort;
    private SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse response;


    public StartOrderLineProcessingCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getOrderBasisLineProcessingPort();
    }

    public void execute(String dataAreaId) {
        SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingRequest request = new SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingRequest();
        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.scheduleOrderBasisLineProcessing(request, callContext);
            setCallOperationSuccess();

        } catch (SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("SalesOrderLineCreation", "", dataAreaId));
        }
    }


    /**
     * The AX response contains a boolean flag that indicates if AX successfully scheduled the processing job <br/>
     * <b>Note:</b> the response flag only indicates status of the scheduling and not of the success of the final processing jobs
     */
    public boolean isOrderLineProcessingStarted() {
        return response.isResponse();
    }
}
