
package com.microsoft.schemas.netfx._2009._05.routing;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import com.tradedoubler.webservice.routing.schedulesalesorderbasisline.RoutingService;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-03-20T13:23:29.112+01:00
 * Generated source version: 2.6.1
 * 
 */
public final class IRequestReplyRouter_ReqReplyEndpoint_Client {

    private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "RoutingService");

    private IRequestReplyRouter_ReqReplyEndpoint_Client() {
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
        IRequestReplyRouter port = ss.getReqReplyEndpoint();  
        

        System.exit(0);
    }

}
