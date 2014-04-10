package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.datacontract.schemas._2004._07.dynamics_ax.*;
import org.tempuri.*;
import org.tempuri.ObjectFactory;

import java.util.*;

/**
 * This class performs the update/insert request web service call to Ax for order lines.<br/>
 * if necessary,  a list, extracted from the web service response (see IDD), of failed order lines is provided.
 * Date: 2012-09-14
 */
public class InsertAndUpdateOrderLinesCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSSalesOrderBasisLineService servicePort;
    private MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse response;
    private final List<OrderLineResponseResult> listOfFailedOrderLines = new ArrayList<OrderLineResponseResult>();


    public InsertAndUpdateOrderLinesCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getOrderBasisLinePort();
    }

    public void execute(ArrayOfMDSITGSalesOrderBasisLineContract axOrderBasisLineArray, String dataAreaId) {
        ObjectFactory objectFactory = new ObjectFactory();
        MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest request = new MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest();

        request.setOrderBasisLine(objectFactory.createMDSSalesOrderBasisLineServiceOrderBasisLineInboundRequestOrderBasisLine(axOrderBasisLineArray));
        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.orderBasisLineInbound(request, callContext);
            setCallOperationSuccess();

            analyzeOrderLineResponse();

        } catch (MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("OrderLines", getOrderLineIds(axOrderBasisLineArray), dataAreaId));
        }

    }

    private String getOrderLineIds(ArrayOfMDSITGSalesOrderBasisLineContract axOrderBasisLineArray) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MDSITGSalesOrderBasisLineContract> mdsitgSalesOrderBasisLineContract = axOrderBasisLineArray.getMDSITGSalesOrderBasisLineContract();
        for (MDSITGSalesOrderBasisLineContract contract : mdsitgSalesOrderBasisLineContract) {
            String value = contract.getParmOrderBasisLineId().getValue();
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    /** The ax response contains failed order lines, if present. This method flags for such error and extract the failed lines and put them in a failure list */
    private void analyzeOrderLineResponse() {
        //Assume all is well to start with
        for (MDSITGSalesOrderBasisLineContract orderBasisLineContract : response.getResponse().getValue().getMDSITGSalesOrderBasisLineContract()) {
            MDSITGSalesOrderBasisLineImportError status = orderBasisLineContract.getParmException();
            //if update was of no success, add it to the failure list and flag an error in the axResult object
            if (status != MDSITGSalesOrderBasisLineImportError.UPDATE_SUCCESSFUL) {
                String orderLineId = orderBasisLineContract.getParmOrderBasisLineId().getValue();
                String errorMessage = orderBasisLineContract.getParmErrorMsg() != null ? orderBasisLineContract.getParmErrorMsg().getValue() : "Empty error message";
                OrderLineResponseResult orderLineResponseResult = new OrderLineResponseResult(orderLineId, errorMessage, status.value());
                listOfFailedOrderLines.add(orderLineResponseResult);
            }

        }
    }

    /**
     * Retrieves the list of failed order lines.
     */
    public List<OrderLineResponseResult> getListOfFailedOrderLines() {
        return listOfFailedOrderLines;
    }
}
