
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdValidTimeStateType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;


/**
 * <p>Java class for AxdCustomer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdCustomer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocPurpose" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_XMLDocPurpose" minOccurs="0"/>
 *         &lt;element name="SenderId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DataAreaId" minOccurs="0"/>
 *         &lt;element name="ValidAsOfDateTime" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DateTime" minOccurs="0"/>
 *         &lt;element name="ValidFromDateTime" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DateTime" minOccurs="0"/>
 *         &lt;element name="ValidTimeStateType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_AxdValidTimeStateType" minOccurs="0"/>
 *         &lt;element name="ValidToDateTime" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DateTime" minOccurs="0"/>
 *         &lt;element name="CustTable" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_CustTable" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdCustomer", propOrder = {
    "docPurpose",
    "senderId",
    "validAsOfDateTime",
    "validFromDateTime",
    "validTimeStateType",
    "validToDateTime",
    "custTable"
})
public class AxdCustomer {

    @XmlElementRef(name = "DocPurpose", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumXMLDocPurpose> docPurpose;
    @XmlElementRef(name = "SenderId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> senderId;
    @XmlElementRef(name = "ValidAsOfDateTime", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdTypeDateTime> validAsOfDateTime;
    @XmlElementRef(name = "ValidFromDateTime", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdTypeDateTime> validFromDateTime;
    @XmlElementRef(name = "ValidTimeStateType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumAxdValidTimeStateType> validTimeStateType;
    @XmlElementRef(name = "ValidToDateTime", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdTypeDateTime> validToDateTime;
    @XmlElement(name = "CustTable")
    protected List<AxdEntityCustTable> custTable;

    /**
     * Gets the value of the docPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}
     *     
     */
    public JAXBElement<AxdEnumXMLDocPurpose> getDocPurpose() {
        return docPurpose;
    }

    /**
     * Sets the value of the docPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}
     *     
     */
    public void setDocPurpose(JAXBElement<AxdEnumXMLDocPurpose> value) {
        this.docPurpose = ((JAXBElement<AxdEnumXMLDocPurpose> ) value);
    }

    /**
     * Gets the value of the senderId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSenderId(JAXBElement<String> value) {
        this.senderId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the validAsOfDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdTypeDateTime> getValidAsOfDateTime() {
        return validAsOfDateTime;
    }

    /**
     * Sets the value of the validAsOfDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public void setValidAsOfDateTime(JAXBElement<AxdTypeDateTime> value) {
        this.validAsOfDateTime = ((JAXBElement<AxdTypeDateTime> ) value);
    }

    /**
     * Gets the value of the validFromDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdTypeDateTime> getValidFromDateTime() {
        return validFromDateTime;
    }

    /**
     * Sets the value of the validFromDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public void setValidFromDateTime(JAXBElement<AxdTypeDateTime> value) {
        this.validFromDateTime = ((JAXBElement<AxdTypeDateTime> ) value);
    }

    /**
     * Gets the value of the validTimeStateType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumAxdValidTimeStateType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumAxdValidTimeStateType> getValidTimeStateType() {
        return validTimeStateType;
    }

    /**
     * Sets the value of the validTimeStateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumAxdValidTimeStateType }{@code >}
     *     
     */
    public void setValidTimeStateType(JAXBElement<AxdEnumAxdValidTimeStateType> value) {
        this.validTimeStateType = ((JAXBElement<AxdEnumAxdValidTimeStateType> ) value);
    }

    /**
     * Gets the value of the validToDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdTypeDateTime> getValidToDateTime() {
        return validToDateTime;
    }

    /**
     * Sets the value of the validToDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}
     *     
     */
    public void setValidToDateTime(JAXBElement<AxdTypeDateTime> value) {
        this.validToDateTime = ((JAXBElement<AxdTypeDateTime> ) value);
    }

    /**
     * Gets the value of the custTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the custTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityCustTable }
     * 
     * 
     */
    public List<AxdEntityCustTable> getCustTable() {
        if (custTable == null) {
            custTable = new ArrayList<AxdEntityCustTable>();
        }
        return this.custTable;
    }

}
