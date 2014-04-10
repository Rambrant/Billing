
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes package. 
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

    private final static QName _MDSITGSInvMes_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "MDS_ITGSInvMes");
    private final static QName _AxdMDSITGSInvMesSenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "SenderId");
    private final static QName _AxdMDSITGSInvMesKeyId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "KeyId");
    private final static QName _AxdMDSITGSInvMesDocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "DocPurpose");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "RecId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "_DocumentHash");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRefRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "RefRecId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRefTableId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "RefTableId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "RecVersion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AxdEntityMDSSalesInvoiceMessage }
     * 
     */
    public AxdEntityMDSSalesInvoiceMessage createAxdEntityMDSSalesInvoiceMessage() {
        return new AxdEntityMDSSalesInvoiceMessage();
    }

    /**
     * Create an instance of {@link AxdMDSITGSInvMes }
     * 
     */
    public AxdMDSITGSInvMes createAxdMDSITGSInvMes() {
        return new AxdMDSITGSInvMes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGSInvMes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "MDS_ITGSInvMes")
    public JAXBElement<AxdMDSITGSInvMes> createMDSITGSInvMes(AxdMDSITGSInvMes value) {
        return new JAXBElement<AxdMDSITGSInvMes>(_MDSITGSInvMes_QNAME, AxdMDSITGSInvMes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "SenderId", scope = AxdMDSITGSInvMes.class)
    public JAXBElement<String> createAxdMDSITGSInvMesSenderId(String value) {
        return new JAXBElement<String>(_AxdMDSITGSInvMesSenderId_QNAME, String.class, AxdMDSITGSInvMes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "KeyId", scope = AxdMDSITGSInvMes.class)
    public JAXBElement<String> createAxdMDSITGSInvMesKeyId(String value) {
        return new JAXBElement<String>(_AxdMDSITGSInvMesKeyId_QNAME, String.class, AxdMDSITGSInvMes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "DocPurpose", scope = AxdMDSITGSInvMes.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdMDSITGSInvMesDocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdMDSITGSInvMesDocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdMDSITGSInvMes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "RecId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceMessageRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceMessageRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "_DocumentHash", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceMessageDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceMessageDocumentHash_QNAME, String.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "RefRecId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceMessageRefRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceMessageRefRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "RefTableId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceMessageRefTableId(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceMessageRefTableId_QNAME, Integer.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", name = "RecVersion", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceMessageRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceMessageRecVersion_QNAME, Integer.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

}
