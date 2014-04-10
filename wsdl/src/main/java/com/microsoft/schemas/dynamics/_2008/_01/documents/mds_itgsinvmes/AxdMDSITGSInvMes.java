
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * <p>Java class for AxdMDS_ITGSInvMes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdMDS_ITGSInvMes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocPurpose" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_XMLDocPurpose" minOccurs="0"/>
 *         &lt;element name="KeyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SenderId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DataAreaId" minOccurs="0"/>
 *         &lt;element name="MDS_SalesInvoiceMessage" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes}AxdEntity_MDS_SalesInvoiceMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdMDS_ITGSInvMes", propOrder = {
    "docPurpose",
    "keyId",
    "senderId",
    "mdsSalesInvoiceMessage"
})
public class AxdMDSITGSInvMes {

    @XmlElementRef(name = "DocPurpose", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", type = JAXBElement.class)
    protected JAXBElement<AxdEnumXMLDocPurpose> docPurpose;
    @XmlElementRef(name = "KeyId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", type = JAXBElement.class)
    protected JAXBElement<String> keyId;
    @XmlElementRef(name = "SenderId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", type = JAXBElement.class)
    protected JAXBElement<String> senderId;
    @XmlElement(name = "MDS_SalesInvoiceMessage")
    protected List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage;

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
     * Gets the value of the keyId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKeyId() {
        return keyId;
    }

    /**
     * Sets the value of the keyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKeyId(JAXBElement<String> value) {
        this.keyId = ((JAXBElement<String> ) value);
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
     * Gets the value of the mdsSalesInvoiceMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mdsSalesInvoiceMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMDSSalesInvoiceMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityMDSSalesInvoiceMessage }
     * 
     * 
     */
    public List<AxdEntityMDSSalesInvoiceMessage> getMDSSalesInvoiceMessage() {
        if (mdsSalesInvoiceMessage == null) {
            mdsSalesInvoiceMessage = new ArrayList<AxdEntityMDSSalesInvoiceMessage>();
        }
        return this.mdsSalesInvoiceMessage;
    }

}
