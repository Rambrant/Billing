
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr;

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
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;


/**
 * <p>Java class for AxdEntity_MDS_SalesInvoiceMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_MDS_SalesInvoiceMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceMessageId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceMessageId"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="RefRecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RefRecId" minOccurs="0"/>
 *         &lt;element name="RefTableId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RefTableId" minOccurs="0"/>
 *         &lt;element name="SourceType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_MDS_SalesMessageSourceType"/>
 *         &lt;element name="Text" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceMessageText"/>
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
@XmlType(name = "AxdEntity_MDS_SalesInvoiceMessage", propOrder = {
    "invoiceMessageId",
    "recId",
    "recVersion",
    "refRecId",
    "refTableId",
    "sourceType",
    "text",
    "validFrom",
    "validTo"
})
public class AxdEntityMDSSalesInvoiceMessage {

    @XmlElement(name = "InvoiceMessageId", required = true)
    protected String invoiceMessageId;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "RefRecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Long> refRecId;
    @XmlElementRef(name = "RefTableId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Integer> refTableId;
    @XmlElement(name = "SourceType", required = true)
    protected AxdEnumMDSSalesMessageSourceType sourceType;
    @XmlElement(name = "Text", required = true)
    protected String text;
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
     * Gets the value of the invoiceMessageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceMessageId() {
        return invoiceMessageId;
    }

    /**
     * Sets the value of the invoiceMessageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceMessageId(String value) {
        this.invoiceMessageId = value;
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
     * Gets the value of the refRecId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRefRecId() {
        return refRecId;
    }

    /**
     * Sets the value of the refRecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRefRecId(JAXBElement<Long> value) {
        this.refRecId = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the refTableId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getRefTableId() {
        return refTableId;
    }

    /**
     * Sets the value of the refTableId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setRefTableId(JAXBElement<Integer> value) {
        this.refTableId = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumMDSSalesMessageSourceType }
     *     
     */
    public AxdEnumMDSSalesMessageSourceType getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumMDSSalesMessageSourceType }
     *     
     */
    public void setSourceType(AxdEnumMDSSalesMessageSourceType value) {
        this.sourceType = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
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
