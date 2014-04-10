
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;


/**
 * <p>Java class for AxdEntity_MDS_SalesClientAgreement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_MDS_SalesClientAgreement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_DocumentHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BelongsToDataAreaId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesBelongsToDataAreaId"/>
 *         &lt;element name="CurrencyCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CurrencyCode_AxdType_ExtCodeValue"/>
 *         &lt;element name="CustId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustAccount_AxdType_ExtCodeValue"/>
 *         &lt;element name="Description" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesClientAgreementDescription"/>
 *         &lt;element name="DocumentLink" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesDocumentLink" minOccurs="0"/>
 *         &lt;element name="InvoiceRuleId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleId"/>
 *         &lt;element name="ProductTypeId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesProductTypeId"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="SourceSystemAgreementId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesSourceSystemAgreementId"/>
 *         &lt;element name="ValidFrom" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesValidFrom"/>
 *         &lt;element name="ValidTo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesValidTo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="entity" />
 *       &lt;attribute name="action" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_AxdEntityAction" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_MDS_SalesClientAgreement", propOrder = {
    "documentHash",
    "belongsToDataAreaId",
    "currencyCode",
    "custId",
    "description",
    "documentLink",
    "invoiceRuleId",
    "productTypeId",
    "recId",
    "recVersion",
    "sourceSystemAgreementId",
    "validFrom",
    "validTo"
})
public class AxdEntityMDSSalesClientAgreement {

    @XmlElementRef(name = "_DocumentHash", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", type = JAXBElement.class)
    protected JAXBElement<String> documentHash;
    @XmlElement(name = "BelongsToDataAreaId", required = true)
    protected String belongsToDataAreaId;
    @XmlElement(name = "CurrencyCode", required = true)
    protected String currencyCode;
    @XmlElement(name = "CustId", required = true)
    protected String custId;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElementRef(name = "DocumentLink", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", type = JAXBElement.class)
    protected JAXBElement<String> documentLink;
    @XmlElement(name = "InvoiceRuleId", required = true)
    protected String invoiceRuleId;
    @XmlElement(name = "ProductTypeId", required = true)
    protected String productTypeId;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElement(name = "SourceSystemAgreementId", required = true)
    protected String sourceSystemAgreementId;
    @XmlElement(name = "ValidFrom", required = true)
    protected XMLGregorianCalendar validFrom;
    @XmlElement(name = "ValidTo", required = true)
    protected XMLGregorianCalendar validTo;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;

    /**
     * Gets the value of the documentHash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentHash() {
        return documentHash;
    }

    /**
     * Sets the value of the documentHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentHash(JAXBElement<String> value) {
        this.documentHash = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the belongsToDataAreaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongsToDataAreaId() {
        return belongsToDataAreaId;
    }

    /**
     * Sets the value of the belongsToDataAreaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongsToDataAreaId(String value) {
        this.belongsToDataAreaId = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the custId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustId() {
        return custId;
    }

    /**
     * Sets the value of the custId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustId(String value) {
        this.custId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the documentLink property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentLink() {
        return documentLink;
    }

    /**
     * Sets the value of the documentLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentLink(JAXBElement<String> value) {
        this.documentLink = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoiceRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRuleId() {
        return invoiceRuleId;
    }

    /**
     * Sets the value of the invoiceRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRuleId(String value) {
        this.invoiceRuleId = value;
    }

    /**
     * Gets the value of the productTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTypeId() {
        return productTypeId;
    }

    /**
     * Sets the value of the productTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTypeId(String value) {
        this.productTypeId = value;
    }

    /**
     * Gets the value of the recId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRecId() {
        return recId;
    }

    /**
     * Sets the value of the recId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRecId(JAXBElement<Long> value) {
        this.recId = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the recVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getRecVersion() {
        return recVersion;
    }

    /**
     * Sets the value of the recVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setRecVersion(JAXBElement<Integer> value) {
        this.recVersion = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the sourceSystemAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemAgreementId() {
        return sourceSystemAgreementId;
    }

    /**
     * Sets the value of the sourceSystemAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemAgreementId(String value) {
        this.sourceSystemAgreementId = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        if (clazz == null) {
            return "entity";
        } else {
            return clazz;
        }
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumAxdEntityAction }
     *     
     */
    public AxdEnumAxdEntityAction getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumAxdEntityAction }
     *     
     */
    public void setAction(AxdEnumAxdEntityAction value) {
        this.action = value;
    }

}
