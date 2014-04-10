
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr package. 
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

    private final static QName _MDSITGSalesInvR_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "MDS_ITGSalesInvR");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "RecId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRefRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "RefRecId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRefTableId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "RefTableId");
    private final static QName _AxdEntityMDSSalesInvoiceMessageRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "RecVersion");
    private final static QName _AxdEntityMDSSalesInvoiceRuleDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "_DocumentHash");
    private final static QName _AxdEntityMDSSalesInvoiceRulePaymModeId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "PaymModeId");
    private final static QName _AxdEntityMDSSalesInvoiceRuleBelongsToDataAreaId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "BelongsToDataAreaId");
    private final static QName _AxdEntityMDSSalesInvoiceRuleCustomerReference_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "CustomerReference");
    private final static QName _AxdEntityMDSSalesInvoiceRuleIssuerReference_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "IssuerReference");
    private final static QName _AxdEntityMDSSalesInvoiceRuleDescription_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "Description");
    private final static QName _AxdMDSITGSalesInvRSenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "SenderId");
    private final static QName _AxdMDSITGSalesInvRDocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", "DocPurpose");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr
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
     * Create an instance of {@link AxdEntityMDSSalesInvoiceRule }
     * 
     */
    public AxdEntityMDSSalesInvoiceRule createAxdEntityMDSSalesInvoiceRule() {
        return new AxdEntityMDSSalesInvoiceRule();
    }

    /**
     * Create an instance of {@link AxdMDSITGSalesInvR }
     * 
     */
    public AxdMDSITGSalesInvR createAxdMDSITGSalesInvR() {
        return new AxdMDSITGSalesInvR();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGSalesInvR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "MDS_ITGSalesInvR")
    public JAXBElement<AxdMDSITGSalesInvR> createMDSITGSalesInvR(AxdMDSITGSalesInvR value) {
        return new JAXBElement<AxdMDSITGSalesInvR>(_MDSITGSalesInvR_QNAME, AxdMDSITGSalesInvR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RecId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceMessageRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceMessageRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RefRecId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceMessageRefRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceMessageRefRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RefTableId", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceMessageRefTableId(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceMessageRefTableId_QNAME, Integer.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RecVersion", scope = AxdEntityMDSSalesInvoiceMessage.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceMessageRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceMessageRecVersion_QNAME, Integer.class, AxdEntityMDSSalesInvoiceMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "_DocumentHash", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRuleDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRuleDocumentHash_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RecId", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceRuleRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceMessageRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "PaymModeId", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRulePaymModeId(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRulePaymModeId_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "BelongsToDataAreaId", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRuleBelongsToDataAreaId(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRuleBelongsToDataAreaId_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "CustomerReference", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRuleCustomerReference(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRuleCustomerReference_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "RecVersion", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceRuleRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceMessageRecVersion_QNAME, Integer.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "IssuerReference", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRuleIssuerReference(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRuleIssuerReference_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "Description", scope = AxdEntityMDSSalesInvoiceRule.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRuleDescription(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRuleDescription_QNAME, String.class, AxdEntityMDSSalesInvoiceRule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "SenderId", scope = AxdMDSITGSalesInvR.class)
    public JAXBElement<String> createAxdMDSITGSalesInvRSenderId(String value) {
        return new JAXBElement<String>(_AxdMDSITGSalesInvRSenderId_QNAME, String.class, AxdMDSITGSalesInvR.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", name = "DocPurpose", scope = AxdMDSITGSalesInvR.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdMDSITGSalesInvRDocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdMDSITGSalesInvRDocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdMDSITGSalesInvR.class, value);
    }

}
