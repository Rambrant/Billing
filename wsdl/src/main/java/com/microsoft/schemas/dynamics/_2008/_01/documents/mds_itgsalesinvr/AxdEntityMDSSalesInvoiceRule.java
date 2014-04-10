
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr;

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
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesInvoiceRuleDistributionMode;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission;


/**
 * <p>Java class for AxdEntity_MDS_SalesInvoiceRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_MDS_SalesInvoiceRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_DocumentHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BelongsToDataAreaId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesBelongsToDataAreaId" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CurrencyCode_AxdType_ExtCodeValue"/>
 *         &lt;element name="CustomerReference" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleCustRef" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleDescription" minOccurs="0"/>
 *         &lt;element name="DeviatingExchRate" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleDeviatingExchRate"/>
 *         &lt;element name="DisplayTDComission" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleDisplayTDComission"/>
 *         &lt;element name="DistributionMode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_MDS_SalesInvoiceRuleDistributionMode"/>
 *         &lt;element name="InvoiceRuleId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleId"/>
 *         &lt;element name="IssuerReference" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleIssuerReference" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesInvoiceRuleName"/>
 *         &lt;element name="PaymModeId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPaymMode" minOccurs="0"/>
 *         &lt;element name="PaymTermId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymTermId"/>
 *         &lt;element name="PostingProfile" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PostingProfile"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="RevenueTypeId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MDS_SalesRevenueTypeId"/>
 *         &lt;element name="MDS_SalesInvoiceMessage" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR}AxdEntity_MDS_SalesInvoiceMessage" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_MDS_SalesInvoiceRule", propOrder = {
    "documentHash",
    "belongsToDataAreaId",
    "currencyCode",
    "customerReference",
    "description",
    "deviatingExchRate",
    "displayTDComission",
    "distributionMode",
    "invoiceRuleId",
    "issuerReference",
    "name",
    "paymModeId",
    "paymTermId",
    "postingProfile",
    "recId",
    "recVersion",
    "revenueTypeId",
    "mdsSalesInvoiceMessage"
})
public class AxdEntityMDSSalesInvoiceRule {

    @XmlElementRef(name = "_DocumentHash", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> documentHash;
    @XmlElementRef(name = "BelongsToDataAreaId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> belongsToDataAreaId;
    @XmlElement(name = "CurrencyCode", required = true)
    protected String currencyCode;
    @XmlElementRef(name = "CustomerReference", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> customerReference;
    @XmlElementRef(name = "Description", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> description;
    @XmlElement(name = "DeviatingExchRate", required = true)
    protected AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate deviatingExchRate;
    @XmlElement(name = "DisplayTDComission", required = true)
    protected AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission displayTDComission;
    @XmlElement(name = "DistributionMode", required = true)
    protected AxdEnumMDSSalesInvoiceRuleDistributionMode distributionMode;
    @XmlElement(name = "InvoiceRuleId", required = true)
    protected String invoiceRuleId;
    @XmlElementRef(name = "IssuerReference", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> issuerReference;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElementRef(name = "PaymModeId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> paymModeId;
    @XmlElement(name = "PaymTermId", required = true)
    protected String paymTermId;
    @XmlElement(name = "PostingProfile", required = true)
    protected String postingProfile;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElement(name = "RevenueTypeId", required = true)
    protected String revenueTypeId;
    @XmlElement(name = "MDS_SalesInvoiceMessage")
    protected List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage;
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBelongsToDataAreaId() {
        return belongsToDataAreaId;
    }

    /**
     * Sets the value of the belongsToDataAreaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBelongsToDataAreaId(JAXBElement<String> value) {
        this.belongsToDataAreaId = ((JAXBElement<String> ) value);
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
     * Gets the value of the customerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerReference() {
        return customerReference;
    }

    /**
     * Sets the value of the customerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerReference(JAXBElement<String> value) {
        this.customerReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the deviatingExchRate property.
     * 
     * @return
     *     possible object is
     *     {@link AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate }
     *     
     */
    public AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate getDeviatingExchRate() {
        return deviatingExchRate;
    }

    /**
     * Sets the value of the deviatingExchRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate }
     *     
     */
    public void setDeviatingExchRate(AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate value) {
        this.deviatingExchRate = value;
    }

    /**
     * Gets the value of the displayTDComission property.
     * 
     * @return
     *     possible object is
     *     {@link AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission }
     *     
     */
    public AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission getDisplayTDComission() {
        return displayTDComission;
    }

    /**
     * Sets the value of the displayTDComission property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission }
     *     
     */
    public void setDisplayTDComission(AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission value) {
        this.displayTDComission = value;
    }

    /**
     * Gets the value of the distributionMode property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumMDSSalesInvoiceRuleDistributionMode }
     *     
     */
    public AxdEnumMDSSalesInvoiceRuleDistributionMode getDistributionMode() {
        return distributionMode;
    }

    /**
     * Sets the value of the distributionMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumMDSSalesInvoiceRuleDistributionMode }
     *     
     */
    public void setDistributionMode(AxdEnumMDSSalesInvoiceRuleDistributionMode value) {
        this.distributionMode = value;
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
     * Gets the value of the issuerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuerReference() {
        return issuerReference;
    }

    /**
     * Sets the value of the issuerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuerReference(JAXBElement<String> value) {
        this.issuerReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the paymModeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymModeId() {
        return paymModeId;
    }

    /**
     * Sets the value of the paymModeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymModeId(JAXBElement<String> value) {
        this.paymModeId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymTermId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymTermId() {
        return paymTermId;
    }

    /**
     * Sets the value of the paymTermId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymTermId(String value) {
        this.paymTermId = value;
    }

    /**
     * Gets the value of the postingProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingProfile() {
        return postingProfile;
    }

    /**
     * Sets the value of the postingProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingProfile(String value) {
        this.postingProfile = value;
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
     * Gets the value of the revenueTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueTypeId() {
        return revenueTypeId;
    }

    /**
     * Sets the value of the revenueTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueTypeId(String value) {
        this.revenueTypeId = value;
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
