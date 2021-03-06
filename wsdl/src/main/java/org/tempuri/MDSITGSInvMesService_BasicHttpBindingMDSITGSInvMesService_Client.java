
package org.tempuri;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import com.tradedoubler.webservice.routing.invoicemessage.RoutingService;
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
 * 2013-03-20T13:23:28.251+01:00
 * Generated source version: 2.6.1
 * 
 */
public final class MDSITGSInvMesService_BasicHttpBindingMDSITGSInvMesService_Client {

    private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "RoutingService");

    private MDSITGSInvMesService_BasicHttpBindingMDSITGSInvMesService_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = RoutingService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        RoutingService ss = new RoutingService(wsdlURL, SERVICE_NAME);
        MDSITGSInvMesService port = ss.getBasicHttpBindingMDSITGSInvMesService();  
        
        {
        System.out.println("Invoking find...");
        org.tempuri.MDSITGSInvMesServiceFindRequest _find_parameters = null;
        com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext _find_context = null;
        try {
            org.tempuri.MDSITGSInvMesServiceFindResponse _find__return = port.find(_find_parameters, _find_context);
            System.out.println("find.result=" + _find__return);

        } catch (MDSITGSInvMesServiceFindAifFaultFaultFaultMessage e) { 
            System.out.println("Expected exception: MDS_ITGSInvMesService_find_AifFaultFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking read...");
        org.tempuri.MDSITGSInvMesServiceReadRequest _read_parameters = null;
        com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext _read_context = null;
        try {
            org.tempuri.MDSITGSInvMesServiceReadResponse _read__return = port.read(_read_parameters, _read_context);
            System.out.println("read.result=" + _read__return);

        } catch (MDSITGSInvMesServiceReadAifFaultFaultFaultMessage e) { 
            System.out.println("Expected exception: MDS_ITGSInvMesService_read_AifFaultFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking update...");
        org.tempuri.MDSITGSInvMesServiceUpdateRequest _update_parameters = null;
        com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext _update_context = null;
        try {
            org.tempuri.MDSITGSInvMesServiceUpdateResponse _update__return = port.update(_update_parameters, _update_context);
            System.out.println("update.result=" + _update__return);

        } catch (MDSITGSInvMesServiceUpdateAifFaultFaultFaultMessage e) { 
            System.out.println("Expected exception: MDS_ITGSInvMesService_update_AifFaultFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking create...");
        org.tempuri.MDSITGSInvMesServiceCreateRequest _create_parameters = null;
        com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext _create_context = null;
        try {
            org.tempuri.MDSITGSInvMesServiceCreateResponse _create__return = port.create(_create_parameters, _create_context);
            System.out.println("create.result=" + _create__return);

        } catch (MDSITGSInvMesServiceCreateAifFaultFaultFaultMessage e) { 
            System.out.println("Expected exception: MDS_ITGSInvMesService_create_AifFaultFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
