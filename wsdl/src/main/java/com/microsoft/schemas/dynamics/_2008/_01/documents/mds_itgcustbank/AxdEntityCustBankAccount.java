
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumBankAccountType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumBankCodeType;


/**
 * <p>Java class for AxdEntity_CustBankAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_CustBankAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_DocumentHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountID" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustBankAccountId"/>
 *         &lt;element name="AccountNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankAccount" minOccurs="0"/>
 *         &lt;element name="BankAccountType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_BankAccountType" minOccurs="0"/>
 *         &lt;element name="BankCIN" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCIN" minOccurs="0"/>
 *         &lt;element name="BankCodeType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_BankCodeType" minOccurs="0"/>
 *         &lt;element name="BankContractAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_GiroContractAccount" minOccurs="0"/>
 *         &lt;element name="BankGroupId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankGroupId" minOccurs="0"/>
 *         &lt;element name="BankIBAN" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankIBAN" minOccurs="0"/>
 *         &lt;element name="CellularPhone" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PhoneMobile" minOccurs="0"/>
 *         &lt;element name="ContactPerson" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PersonName" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CurrencyCode" minOccurs="0"/>
 *         &lt;element name="CustAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustAccount_AxdType_ExtCodeValue"/>
 *         &lt;element name="CustDomNumber_BE" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustDomNumber_BE" minOccurs="0"/>
 *         &lt;element name="CustPaymentTextCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPaymTextCode" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Email" minOccurs="0"/>
 *         &lt;element name="ExchRate" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CrossExchRate" minOccurs="0"/>
 *         &lt;element name="ExchRateRef" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ExchRateRef" minOccurs="0"/>
 *         &lt;element name="MsgToBank" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankMsgToBank" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Name" minOccurs="0"/>
 *         &lt;element name="Pager" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Pager" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Phone" minOccurs="0"/>
 *         &lt;element name="PhoneLocal" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PhoneLocal" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="RegistrationNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankRegNum" minOccurs="0"/>
 *         &lt;element name="SMS" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SMS" minOccurs="0"/>
 *         &lt;element name="SWIFTNo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SWIFTNo" minOccurs="0"/>
 *         &lt;element name="TeleFax" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TeleFax" minOccurs="0"/>
 *         &lt;element name="Telex" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Telex" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_URL" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_CustBankAccount", propOrder = {
    "documentHash",
    "accountID",
    "accountNum",
    "bankAccountType",
    "bankCIN",
    "bankCodeType",
    "bankContractAccount",
    "bankGroupId",
    "bankIBAN",
    "cellularPhone",
    "contactPerson",
    "currencyCode",
    "custAccount",
    "custDomNumberBE",
    "custPaymentTextCode",
    "email",
    "exchRate",
    "exchRateRef",
    "msgToBank",
    "name",
    "pager",
    "phone",
    "phoneLocal",
    "recId",
    "recVersion",
    "registrationNum",
    "sms",
    "swiftNo",
    "teleFax",
    "telex",
    "url"
})
public class AxdEntityCustBankAccount {

    @XmlElementRef(name = "_DocumentHash", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> documentHash;
    @XmlElement(name = "AccountID", required = true)
    protected String accountID;
    @XmlElementRef(name = "AccountNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> accountNum;
    @XmlElementRef(name = "BankAccountType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<AxdEnumBankAccountType> bankAccountType;
    @XmlElementRef(name = "BankCIN", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> bankCIN;
    @XmlElementRef(name = "BankCodeType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<AxdEnumBankCodeType> bankCodeType;
    @XmlElementRef(name = "BankContractAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> bankContractAccount;
    @XmlElementRef(name = "BankGroupId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> bankGroupId;
    @XmlElementRef(name = "BankIBAN", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> bankIBAN;
    @XmlElementRef(name = "CellularPhone", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> cellularPhone;
    @XmlElementRef(name = "ContactPerson", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> contactPerson;
    @XmlElementRef(name = "CurrencyCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> currencyCode;
    @XmlElement(name = "CustAccount", required = true)
    protected String custAccount;
    @XmlElementRef(name = "CustDomNumber_BE", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> custDomNumberBE;
    @XmlElementRef(name = "CustPaymentTextCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> custPaymentTextCode;
    @XmlElementRef(name = "Email", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> email;
    @XmlElementRef(name = "ExchRate", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> exchRate;
    @XmlElementRef(name = "ExchRateRef", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> exchRateRef;
    @XmlElementRef(name = "MsgToBank", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> msgToBank;
    @XmlElementRef(name = "Name", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Pager", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> pager;
    @XmlElementRef(name = "Phone", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> phone;
    @XmlElementRef(name = "PhoneLocal", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> phoneLocal;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "RegistrationNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> registrationNum;
    @XmlElementRef(name = "SMS", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> sms;
    @XmlElementRef(name = "SWIFTNo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> swiftNo;
    @XmlElementRef(name = "TeleFax", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> teleFax;
    @XmlElementRef(name = "Telex", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> telex;
    @XmlElementRef(name = "URL", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", type = JAXBElement.class)
    protected JAXBElement<String> url;
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
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountID(String value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the accountNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountNum() {
        return accountNum;
    }

    /**
     * Sets the value of the accountNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountNum(JAXBElement<String> value) {
        this.accountNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumBankAccountType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumBankAccountType> getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumBankAccountType }{@code >}
     *     
     */
    public void setBankAccountType(JAXBElement<AxdEnumBankAccountType> value) {
        this.bankAccountType = ((JAXBElement<AxdEnumBankAccountType> ) value);
    }

    /**
     * Gets the value of the bankCIN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankCIN() {
        return bankCIN;
    }

    /**
     * Sets the value of the bankCIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankCIN(JAXBElement<String> value) {
        this.bankCIN = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankCodeType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumBankCodeType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumBankCodeType> getBankCodeType() {
        return bankCodeType;
    }

    /**
     * Sets the value of the bankCodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumBankCodeType }{@code >}
     *     
     */
    public void setBankCodeType(JAXBElement<AxdEnumBankCodeType> value) {
        this.bankCodeType = ((JAXBElement<AxdEnumBankCodeType> ) value);
    }

    /**
     * Gets the value of the bankContractAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankContractAccount() {
        return bankContractAccount;
    }

    /**
     * Sets the value of the bankContractAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankContractAccount(JAXBElement<String> value) {
        this.bankContractAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankGroupId() {
        return bankGroupId;
    }

    /**
     * Sets the value of the bankGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankGroupId(JAXBElement<String> value) {
        this.bankGroupId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankIBAN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankIBAN() {
        return bankIBAN;
    }

    /**
     * Sets the value of the bankIBAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankIBAN(JAXBElement<String> value) {
        this.bankIBAN = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cellularPhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCellularPhone() {
        return cellularPhone;
    }

    /**
     * Sets the value of the cellularPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCellularPhone(JAXBElement<String> value) {
        this.cellularPhone = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContactPerson(JAXBElement<String> value) {
        this.contactPerson = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrencyCode(JAXBElement<String> value) {
        this.currencyCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the custAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAccount() {
        return custAccount;
    }

    /**
     * Sets the value of the custAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAccount(String value) {
        this.custAccount = value;
    }

    /**
     * Gets the value of the custDomNumberBE property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustDomNumberBE() {
        return custDomNumberBE;
    }

    /**
     * Sets the value of the custDomNumberBE property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustDomNumberBE(JAXBElement<String> value) {
        this.custDomNumberBE = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the custPaymentTextCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustPaymentTextCode() {
        return custPaymentTextCode;
    }

    /**
     * Sets the value of the custPaymentTextCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustPaymentTextCode(JAXBElement<String> value) {
        this.custPaymentTextCode = ((JAXBElement<String> ) value);
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
     * Gets the value of the exchRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExchRate() {
        return exchRate;
    }

    /**
     * Sets the value of the exchRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExchRate(JAXBElement<BigDecimal> value) {
        this.exchRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the exchRateRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchRateRef() {
        return exchRateRef;
    }

    /**
     * Sets the value of the exchRateRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchRateRef(JAXBElement<String> value) {
        this.exchRateRef = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the msgToBank property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMsgToBank() {
        return msgToBank;
    }

    /**
     * Sets the value of the msgToBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMsgToBank(JAXBElement<String> value) {
        this.msgToBank = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pager property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPager() {
        return pager;
    }

    /**
     * Sets the value of the pager property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPager(JAXBElement<String> value) {
        this.pager = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhone(JAXBElement<String> value) {
        this.phone = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phoneLocal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneLocal() {
        return phoneLocal;
    }

    /**
     * Sets the value of the phoneLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneLocal(JAXBElement<String> value) {
        this.phoneLocal = ((JAXBElement<String> ) value);
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
     * Gets the value of the registrationNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegistrationNum() {
        return registrationNum;
    }

    /**
     * Sets the value of the registrationNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegistrationNum(JAXBElement<String> value) {
        this.registrationNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the sms property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSMS() {
        return sms;
    }

    /**
     * Sets the value of the sms property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSMS(JAXBElement<String> value) {
        this.sms = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the swiftNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSWIFTNo() {
        return swiftNo;
    }

    /**
     * Sets the value of the swiftNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSWIFTNo(JAXBElement<String> value) {
        this.swiftNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the teleFax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTeleFax() {
        return teleFax;
    }

    /**
     * Sets the value of the teleFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTeleFax(JAXBElement<String> value) {
        this.teleFax = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the telex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelex() {
        return telex;
    }

    /**
     * Sets the value of the telex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelex(JAXBElement<String> value) {
        this.telex = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setURL(JAXBElement<String> value) {
        this.url = ((JAXBElement<String> ) value);
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
