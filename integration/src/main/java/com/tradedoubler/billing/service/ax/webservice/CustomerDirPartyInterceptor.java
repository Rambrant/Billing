package com.tradedoubler.billing.service.ax.webservice;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.*;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Interceptor to patch the SOAP-request as to comply with the AX-webservice. It:
 * 1. Adds an xmlns=http://schemas.microsoft.com/dynamics/2008/01/documents/Customer attribute to the Customer tag
 * 2. Changes the xsi:type attribute of the DirParty tag to AxdEntity_DirParty_DirOrganization
 * User: erigu
 * Date: 2012-08-22
 */
class CustomerDirPartyInterceptor extends AbstractSoapInterceptor {
    private String pathToLogFile;

    public CustomerDirPartyInterceptor() {
        super(Phase.SEND);
    }

    public CustomerDirPartyInterceptor(String pathToLogFile) {
        this();
        this.pathToLogFile = pathToLogFile;
    }

    /**
     * Patches the SOAP-request. TODO: how and why?
     *
     * @param soapMessage
     * @throws Fault
     */
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        SOAPMessage ssaj = soapMessage.getContent(SOAPMessage.class);
        // This returns a SOAPPart instance, implemented by the w3c Document interface
        Document doc = ssaj.getSOAPPart();
        Element customerElement = (Element) doc.getDocumentElement().getElementsByTagNameNS("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Customer").item(0);
        Element dirPartyElement = (Element) doc.getDocumentElement().getElementsByTagNameNS("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DirParty").item(0);
        if (customerElement != null && dirPartyElement != null) {
            customerElement.setAttribute("xmlns", "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer");
            dirPartyElement.setAttribute("xsi:type", "AxdEntity_DirParty_DirOrganization");

        }
        dumpSOAPXml(doc);

    }


    void dumpSOAPXml(Document doc) {
        if (pathToLogFile != null && doc != null) {
            try {
                // Prepare the DOM document for writing
                Source source = new DOMSource(doc);

                // Prepare the output file
                File file = new File(pathToLogFile);

                Result result = new StreamResult(file);

                // Write the DOM document to the file
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            } catch (Exception e) {
                //Quiet exit
            }
        }
    }
}
