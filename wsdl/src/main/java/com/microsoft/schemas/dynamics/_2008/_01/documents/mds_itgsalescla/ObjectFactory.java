
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MDSITGSalesClA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "MDS_ITGSalesClA");
    private final static QName _AxdMDSITGSalesClASenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "SenderId");
    private final static QName _AxdMDSITGSalesClADocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "DocPurpose");
    private final static QName _AxdEntityMDSSalesClientAgreementDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "_DocumentHash");
    private final static QName _AxdEntityMDSSalesClientAgreementRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "RecId");
    private final static QName _AxdEntityMDSSalesClientAgreementDocumentLink_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "DocumentLink");
    private final static QName _AxdEntityMDSSalesClientAgreementRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "RecVersion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AxdMDSITGSalesClA }
     * 
     */
    public AxdMDSITGSalesClA createAxdMDSITGSalesClA() {
        return new AxdMDSITGSalesClA();
    }

    /**
     * Create an instance of {@link AxdEntityMDSSalesClientAgreement }
     * 
     */
    public AxdEntityMDSSalesClientAgreement createAxdEntityMDSSalesClientAgreement() {
        return new AxdEntityMDSSalesClientAgreement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGSalesClA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "MDS_ITGSalesClA")
    public JAXBElement<AxdMDSITGSalesClA> createMDSITGSalesClA(AxdMDSITGSalesClA value) {
        return new JAXBElement<AxdMDSITGSalesClA>(_MDSITGSalesClA_QNAME, AxdMDSITGSalesClA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "SenderId", scope = AxdMDSITGSalesClA.class)
    public JAXBElement<String> createAxdMDSITGSalesClASenderId(String value) {
        return new JAXBElement<String>(_AxdMDSITGSalesClASenderId_QNAME, String.class, AxdMDSITGSalesClA.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "DocPurpose", scope = AxdMDSITGSalesClA.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdMDSITGSalesClADocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdMDSITGSalesClADocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdMDSITGSalesClA.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "_DocumentHash", scope = AxdEntityMDSSalesClientAgreement.class)
    public JAXBElement<String> createAxdEntityMDSSalesClientAgreementDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesClientAgreementDocumentHash_QNAME, String.class, AxdEntityMDSSalesClientAgreement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "RecId", scope = AxdEntityMDSSalesClientAgreement.class)
    public JAXBElement<Long> createAxdEntityMDSSalesClientAgreementRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesClientAgreementRecId_QNAME, Long.class, AxdEntityMDSSalesClientAgreement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "DocumentLink", scope = AxdEntityMDSSalesClientAgreement.class)
    public JAXBElement<String> createAxdEntityMDSSalesClientAgreementDocumentLink(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesClientAgreementDocumentLink_QNAME, String.class, AxdEntityMDSSalesClientAgreement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", name = "RecVersion", scope = AxdEntityMDSSalesClientAgreement.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesClientAgreementRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesClientAgreementRecVersion_QNAME, Integer.class, AxdEntityMDSSalesClientAgreement.class, value);
    }

}
