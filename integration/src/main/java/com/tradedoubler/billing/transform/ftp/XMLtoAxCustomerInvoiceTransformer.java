package com.tradedoubler.billing.transform.ftp;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.customerinvoice.AxdMDSITGSCustInv;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

/**
 * This class converts the invoice XML to a Java-representation. The conversion is based on Jaxb generated classes created from the invoice XSD files.
 */
class XMLtoAxCustomerInvoiceTransformer {


    private Guid invoiceMessageGUID;

    public AxdMDSITGSCustInv transform(String invoiceXML) throws BillingServiceException {

        AxdMDSITGSCustInv axdMDSITGSCustInv;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.tradedoubler.customerinvoice");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new ByteArrayInputStream(invoiceXML.getBytes()));


            Node custInvoiceNode = doc.getDocumentElement().getElementsByTagNameNS("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSCustInv", "MDS_ITGSCustInv").item(0);
            if (custInvoiceNode == null){
                throw new Exception("No MDS_ITGSCustInv node is present in the XML -> the XML structure is wrong.");
            }
            JAXBElement salesCustomerInvoice = unmarshaller.unmarshal( custInvoiceNode, AxdMDSITGSCustInv.class);

            NodeList messageIds = doc.getDocumentElement().getElementsByTagName("MessageId");
            if (messageIds.getLength() != 1){
                throw new Exception("Message Id for invoice XML is missing or more than one id is present");
            }
            invoiceMessageGUID = Guid.createFromAxGuid(messageIds.item(0).getChildNodes().item(0).getNodeValue());

            axdMDSITGSCustInv = (AxdMDSITGSCustInv) salesCustomerInvoice.getValue();
        } catch (SAXException e) {
            throw BillingServiceException.createBugDisturbance("Fails when transforming caused by XML-parser: " + e.getMessage());
        }
        catch (DOMException e) {
            throw BillingServiceException.createBugDisturbance("Fails when retrieving element from DOM: " + e.getMessage());
        }
        catch(Exception e){
            throw BillingServiceException.createBugDisturbance("Fails when transforming Invoice XML: " + e.getMessage());
        }

        return axdMDSITGSCustInv;

    }

    public Guid getInvoiceMessageGUID() {
        return invoiceMessageGUID;
    }
}
