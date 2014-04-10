
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYesCombo;


/**
 * <p>Java class for AxdEntity_MDS_SalesInvoiceRecipient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_MDS_SalesInvoiceRecipient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_DocumentHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttentionRow1" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRecipientAttentionRow" minOccurs="0"/>
 *         &lt;element name="AttentionRow2" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRecipientAttentionRow" minOccurs="0"/>
 *         &lt;element name="DefaultRecipient" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYesCombo"/>
 *         &lt;element name="Email" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Email" minOccurs="0"/>
 *         &lt;element name="InvoiceRecipientId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRecipientId"/>
 *         &lt;element name="InvoiceRuleId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleId" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationRecId" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="LogisticsLocation" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec}AxdEntity_LogisticsLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MDS_SalesSplitter" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec}AxdEntity_MDS_SalesSplitter" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_MDS_SalesInvoiceRecipient", propOrder = {
    "documentHash",
    "attentionRow1",
    "attentionRow2",
    "defaultRecipient",
    "email",
    "invoiceRecipientId",
    "invoiceRuleId",
    "location",
    "recId",
    "recVersion",
    "logisticsLocation",
    "mdsSalesSplitter"
})
public class AxdEntityMDSSalesInvoiceRecipient {

    @XmlElementRef(name = "_DocumentHash", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> documentHash;
    @XmlElementRef(name = "AttentionRow1", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> attentionRow1;
    @XmlElementRef(name = "AttentionRow2", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> attentionRow2;
    @XmlElement(name = "DefaultRecipient", required = true)
    protected AxdEnumNoYesCombo defaultRecipient;
    @XmlElementRef(name = "Email", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> email;
    @XmlElement(name = "InvoiceRecipientId", required = true)
    protected String invoiceRecipientId;
    @XmlElementRef(name = "InvoiceRuleId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> invoiceRuleId;
    @XmlElementRef(name = "Location", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> location;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElement(name = "LogisticsLocation")
    protected List<AxdEntityLogisticsLocation> logisticsLocation;
    @XmlElement(name = "MDS_SalesSplitter")
    protected List<AxdEntityMDSSalesSplitter> mdsSalesSplitter;
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
     * Gets the value of the attentionRow1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAttentionRow1() {
        return attentionRow1;
    }

    /**
     * Sets the value of the attentionRow1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttentionRow1(JAXBElement<String> value) {
        this.attentionRow1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the attentionRow2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAttentionRow2() {
        return attentionRow2;
    }

    /**
     * Sets the value of the attentionRow2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttentionRow2(JAXBElement<String> value) {
        this.attentionRow2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the defaultRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumNoYesCombo }
     *     
     */
    public AxdEnumNoYesCombo getDefaultRecipient() {
        return defaultRecipient;
    }

    /**
     * Sets the value of the defaultRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumNoYesCombo }
     *     
     */
    public void setDefaultRecipient(AxdEnumNoYesCombo value) {
        this.defaultRecipient = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmail(JAXBElement<String> value) {
        this.email = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoiceRecipientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    /**
     * Sets the value of the invoiceRecipientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRecipientId(String value) {
        this.invoiceRecipientId = value;
    }

    /**
     * Gets the value of the invoiceRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceRuleId() {
        return invoiceRuleId;
    }

    /**
     * Sets the value of the invoiceRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceRuleId(JAXBElement<String> value) {
        this.invoiceRuleId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setLocation(JAXBElement<Long> value) {
        this.location = ((JAXBElement<Long> ) value);
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
     * Gets the value of the logisticsLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logisticsLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogisticsLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityLogisticsLocation }
     * 
     * 
     */
    public List<AxdEntityLogisticsLocation> getLogisticsLocation() {
        if (logisticsLocation == null) {
            logisticsLocation = new ArrayList<AxdEntityLogisticsLocation>();
        }
        return this.logisticsLocation;
    }

    /**
     * Gets the value of the mdsSalesSplitter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mdsSalesSplitter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMDSSalesSplitter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityMDSSalesSplitter }
     * 
     * 
     */
    public List<AxdEntityMDSSalesSplitter> getMDSSalesSplitter() {
        if (mdsSalesSplitter == null) {
            mdsSalesSplitter = new ArrayList<AxdEntityMDSSalesSplitter>();
        }
        return this.mdsSalesSplitter;
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
