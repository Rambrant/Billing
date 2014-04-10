
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumBankAccountType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumBankCodeType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank package. 
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

    private final static QName _MDSITGCustBank_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "MDS_ITGCustBank");
    private final static QName _AxdEntityCustBankAccountAccountNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "AccountNum");
    private final static QName _AxdEntityCustBankAccountPhone_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "Phone");
    private final static QName _AxdEntityCustBankAccountBankIBAN_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankIBAN");
    private final static QName _AxdEntityCustBankAccountCellularPhone_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "CellularPhone");
    private final static QName _AxdEntityCustBankAccountRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "RecVersion");
    private final static QName _AxdEntityCustBankAccountRegistrationNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "RegistrationNum");
    private final static QName _AxdEntityCustBankAccountBankAccountType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankAccountType");
    private final static QName _AxdEntityCustBankAccountURL_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "URL");
    private final static QName _AxdEntityCustBankAccountBankGroupId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankGroupId");
    private final static QName _AxdEntityCustBankAccountTelex_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "Telex");
    private final static QName _AxdEntityCustBankAccountBankCIN_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankCIN");
    private final static QName _AxdEntityCustBankAccountSWIFTNo_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "SWIFTNo");
    private final static QName _AxdEntityCustBankAccountContactPerson_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "ContactPerson");
    private final static QName _AxdEntityCustBankAccountPager_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "Pager");
    private final static QName _AxdEntityCustBankAccountBankCodeType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankCodeType");
    private final static QName _AxdEntityCustBankAccountRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "RecId");
    private final static QName _AxdEntityCustBankAccountCurrencyCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "CurrencyCode");
    private final static QName _AxdEntityCustBankAccountExchRateRef_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "ExchRateRef");
    private final static QName _AxdEntityCustBankAccountPhoneLocal_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "PhoneLocal");
    private final static QName _AxdEntityCustBankAccountMsgToBank_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "MsgToBank");
    private final static QName _AxdEntityCustBankAccountTeleFax_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "TeleFax");
    private final static QName _AxdEntityCustBankAccountCustPaymentTextCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "CustPaymentTextCode");
    private final static QName _AxdEntityCustBankAccountEmail_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "Email");
    private final static QName _AxdEntityCustBankAccountCustDomNumberBE_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "CustDomNumber_BE");
    private final static QName _AxdEntityCustBankAccountBankContractAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "BankContractAccount");
    private final static QName _AxdEntityCustBankAccountExchRate_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "ExchRate");
    private final static QName _AxdEntityCustBankAccountName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "Name");
    private final static QName _AxdEntityCustBankAccountDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "_DocumentHash");
    private final static QName _AxdEntityCustBankAccountSMS_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "SMS");
    private final static QName _AxdMDSITGCustBankDocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "DocPurpose");
    private final static QName _AxdMDSITGCustBankSenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "SenderId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AxdEntityCustBankAccount }
     * 
     */
    public AxdEntityCustBankAccount createAxdEntityCustBankAccount() {
        return new AxdEntityCustBankAccount();
    }

    /**
     * Create an instance of {@link AxdMDSITGCustBank }
     * 
     */
    public AxdMDSITGCustBank createAxdMDSITGCustBank() {
        return new AxdMDSITGCustBank();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGCustBank }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "MDS_ITGCustBank")
    public JAXBElement<AxdMDSITGCustBank> createMDSITGCustBank(AxdMDSITGCustBank value) {
        return new JAXBElement<AxdMDSITGCustBank>(_MDSITGCustBank_QNAME, AxdMDSITGCustBank.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "AccountNum", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountAccountNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountAccountNum_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "Phone", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountPhone(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountPhone_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankIBAN", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountBankIBAN(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountBankIBAN_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "CellularPhone", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountCellularPhone(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountCellularPhone_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "RecVersion", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<Integer> createAxdEntityCustBankAccountRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityCustBankAccountRecVersion_QNAME, Integer.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "RegistrationNum", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountRegistrationNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountRegistrationNum_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumBankAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankAccountType", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<AxdEnumBankAccountType> createAxdEntityCustBankAccountBankAccountType(AxdEnumBankAccountType value) {
        return new JAXBElement<AxdEnumBankAccountType>(_AxdEntityCustBankAccountBankAccountType_QNAME, AxdEnumBankAccountType.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "URL", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountURL(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountURL_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankGroupId", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountBankGroupId(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountBankGroupId_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "Telex", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountTelex(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountTelex_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankCIN", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountBankCIN(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountBankCIN_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "SWIFTNo", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountSWIFTNo(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountSWIFTNo_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "ContactPerson", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountContactPerson(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountContactPerson_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "Pager", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountPager(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountPager_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumBankCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankCodeType", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<AxdEnumBankCodeType> createAxdEntityCustBankAccountBankCodeType(AxdEnumBankCodeType value) {
        return new JAXBElement<AxdEnumBankCodeType>(_AxdEntityCustBankAccountBankCodeType_QNAME, AxdEnumBankCodeType.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "RecId", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<Long> createAxdEntityCustBankAccountRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityCustBankAccountRecId_QNAME, Long.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "CurrencyCode", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountCurrencyCode(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountCurrencyCode_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "ExchRateRef", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountExchRateRef(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountExchRateRef_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "PhoneLocal", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountPhoneLocal(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountPhoneLocal_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "MsgToBank", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountMsgToBank(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountMsgToBank_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "TeleFax", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountTeleFax(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountTeleFax_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "CustPaymentTextCode", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountCustPaymentTextCode(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountCustPaymentTextCode_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "Email", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountEmail(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountEmail_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "CustDomNumber_BE", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountCustDomNumberBE(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountCustDomNumberBE_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "BankContractAccount", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountBankContractAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountBankContractAccount_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "ExchRate", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<BigDecimal> createAxdEntityCustBankAccountExchRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityCustBankAccountExchRate_QNAME, BigDecimal.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "Name", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountName(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountName_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "_DocumentHash", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountDocumentHash_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "SMS", scope = AxdEntityCustBankAccount.class)
    public JAXBElement<String> createAxdEntityCustBankAccountSMS(String value) {
        return new JAXBElement<String>(_AxdEntityCustBankAccountSMS_QNAME, String.class, AxdEntityCustBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "DocPurpose", scope = AxdMDSITGCustBank.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdMDSITGCustBankDocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdMDSITGCustBankDocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdMDSITGCustBank.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", name = "SenderId", scope = AxdMDSITGCustBank.class)
    public JAXBElement<String> createAxdMDSITGCustBankSenderId(String value) {
        return new JAXBElement<String>(_AxdMDSITGCustBankSenderId_QNAME, String.class, AxdMDSITGCustBank.class, value);
    }

}
