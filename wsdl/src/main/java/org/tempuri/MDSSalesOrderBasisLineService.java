package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-03-20T13:23:28.757+01:00
 * Generated source version: 2.6.1
 * 
 */
@WebService(targetNamespace = "http://tempuri.org", name = "MDS_SalesOrderBasisLineService")
@XmlSeeAlso({ObjectFactory.class, com.microsoft.schemas.dynamics._2010._01.datacontracts.ObjectFactory.class, org.datacontract.schemas._2004._07.dynamics_ax.ObjectFactory.class, com.microsoft.schemas.dynamics._2008._01.documents.fault.ObjectFactory.class, com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework.ObjectFactory.class, com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class, org.datacontract.schemas._2004._07.microsoft_dynamics_ax.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MDSSalesOrderBasisLineService {

    @WebResult(name = "MDS_SalesOrderBasisLineServiceOrderBasisLineInboundResponse", targetNamespace = "http://tempuri.org", partName = "parameters")
    @Action(input = "http://tempuri.org/MDS_SalesOrderBasisLineService/orderBasisLineInbound", output = "http://tempuri.org/MDS_SalesOrderBasisLineService/orderBasisLineInboundResponse", fault = {@FaultAction(className = MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage.class, value = "http://tempuri.org/MDS_SalesOrderBasisLineService/orderBasisLineInboundAifFaultFault")})
    @WebMethod(action = "http://tempuri.org/MDS_SalesOrderBasisLineService/orderBasisLineInbound")
    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse orderBasisLineInbound(
        @WebParam(partName = "parameters", name = "MDS_SalesOrderBasisLineServiceOrderBasisLineInboundRequest", targetNamespace = "http://tempuri.org")
        MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest parameters,
        @WebParam(partName = "context", name = "CallContext", targetNamespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", header = true)
        com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext context
    ) throws MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage;
}