
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCompanyTypeMX;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumLegalNatureIT;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTax1099ForeignEntityIndicator;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTax1099LastFilingIndicator;


/**
 * <p>Java class for AxdEntity_DirParty_CompanyInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_CompanyInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_OMInternalOrganization">
 *       &lt;sequence>
 *         &lt;element name="ActivityCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyActivityCode" minOccurs="0"/>
 *         &lt;element name="AddrFormat" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressFormatId" minOccurs="0"/>
 *         &lt;element name="Bank" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBankAccountId" minOccurs="0"/>
 *         &lt;element name="BankAcctUsedFor1099" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBankAccountId" minOccurs="0"/>
 *         &lt;element name="BankCentralBankPurposeCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCentralBankPurposeCode" minOccurs="0"/>
 *         &lt;element name="BankCentralBankPurposeText" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCentralBankPurposeText" minOccurs="0"/>
 *         &lt;element name="BranchId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBranchId" minOccurs="0"/>
 *         &lt;element name="branchNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxBranchNumber" minOccurs="0"/>
 *         &lt;element name="BusinessActivity_SA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBusinessActivityZakat_SA" minOccurs="0"/>
 *         &lt;element name="BusinessActivityDesc_SA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBusinessActivityDescZakat_SA" minOccurs="0"/>
 *         &lt;element name="BusinessNumber_CA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BusinessNumber_CA" minOccurs="0"/>
 *         &lt;element name="CombinedFedStateFiler" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="CompanyNAFCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyIdNAF" minOccurs="0"/>
 *         &lt;element name="CompanyRegComFR" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyRegComFR" minOccurs="0"/>
 *         &lt;element name="CompanyType_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CompanyType_MX" minOccurs="0"/>
 *         &lt;element name="ConversionDate" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TransDate" minOccurs="0"/>
 *         &lt;element name="CoRegNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyCoRegNum" minOccurs="0"/>
 *         &lt;element name="Curp_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Curp_MX" minOccurs="0"/>
 *         &lt;element name="CustomsCustomerNumber_FI" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustomsCustomerNumber_FI" minOccurs="0"/>
 *         &lt;element name="CustomsLicenseNumber_FI" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustomsLicenseNumber_FI" minOccurs="0"/>
 *         &lt;element name="DataArea" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DataAreaId"/>
 *         &lt;element name="DBA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DBA" minOccurs="0"/>
 *         &lt;element name="DVRid" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyDVRid" minOccurs="0"/>
 *         &lt;element name="EnterpriseNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxEnterpriseNumber" minOccurs="0"/>
 *         &lt;element name="FICreditorID_DK" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_FICreditorID_DK" minOccurs="0"/>
 *         &lt;element name="FileNumber_SA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyFileNumZakat_SA" minOccurs="0"/>
 *         &lt;element name="FiscalCode_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_IVACode" minOccurs="0"/>
 *         &lt;element name="ForeignEntityIndicator" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Tax1099ForeignEntityIndicator" minOccurs="0"/>
 *         &lt;element name="Giro" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_GiroNum" minOccurs="0"/>
 *         &lt;element name="GiroContract" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_GiroContractNum" minOccurs="0"/>
 *         &lt;element name="GiroContractAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_GiroContractAccount" minOccurs="0"/>
 *         &lt;element name="ImportVATNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_VATNum" minOccurs="0"/>
 *         &lt;element name="ImportVATNumBranchId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBranchId" minOccurs="0"/>
 *         &lt;element name="IntrastatCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_IntrastatExternalCode" minOccurs="0"/>
 *         &lt;element name="IsConsolidationCompany" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="IsEliminationCompany" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="IssuingSignature" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_IssuingSignature_IT" minOccurs="0"/>
 *         &lt;element name="Key" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ParametersKey" minOccurs="0"/>
 *         &lt;element name="LastFilingIndicator" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Tax1099LastFilingIndicator" minOccurs="0"/>
 *         &lt;element name="LegalFormFR" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyLegalFormFR" minOccurs="0"/>
 *         &lt;element name="LegalNature_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_LegalNature_IT" minOccurs="0"/>
 *         &lt;element name="LegalRepresentativeCurp_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Curp_MX" minOccurs="0"/>
 *         &lt;element name="LegalRepresentativeName_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LegalRepresentativeName_MX" minOccurs="0"/>
 *         &lt;element name="LegalRepresentativeRfc_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Rfc_MX" minOccurs="0"/>
 *         &lt;element name="NameControl" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NameControl" minOccurs="0"/>
 *         &lt;element name="OrgId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_OrgId" minOccurs="0"/>
 *         &lt;element name="PackMaterialFeeLicenseNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InventPackingMaterialFeeLicenseNum" minOccurs="0"/>
 *         &lt;element name="PaymInstruction1" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymInstructionId" minOccurs="0"/>
 *         &lt;element name="PaymInstruction2" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymInstructionId" minOccurs="0"/>
 *         &lt;element name="PaymInstruction3" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymInstructionId" minOccurs="0"/>
 *         &lt;element name="PaymInstruction4" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymInstructionId" minOccurs="0"/>
 *         &lt;element name="PaymRoutingDNB" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymRoutingDNB" minOccurs="0"/>
 *         &lt;element name="PaymTraderNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymTraderNumber" minOccurs="0"/>
 *         &lt;element name="PlanningCompany" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="RegNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyRegNum" minOccurs="0"/>
 *         &lt;element name="Rfc_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Rfc_MX" minOccurs="0"/>
 *         &lt;element name="ShippingCalendarId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyShippingCalendarId" minOccurs="0"/>
 *         &lt;element name="SiaCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanySIACode" minOccurs="0"/>
 *         &lt;element name="SoftwareIdentificationCode_CA" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SoftwareIdentificationCode_CA" minOccurs="0"/>
 *         &lt;element name="StateInscription_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_StateInscription_MX" minOccurs="0"/>
 *         &lt;element name="Tax1099RegNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Tax1099RegNum" minOccurs="0"/>
 *         &lt;element name="TaxRepresentative" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxRepresentative" minOccurs="0"/>
 *         &lt;element name="TCC" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TCC" minOccurs="0"/>
 *         &lt;element name="UPSNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_UPSNum" minOccurs="0"/>
 *         &lt;element name="validate1099OnEntry" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="VATNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_VATNum" minOccurs="0"/>
 *         &lt;element name="VATNumBranchId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyBranchId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_CompanyInfo", propOrder = {
    "activityCode",
    "addrFormat",
    "bank",
    "bankAcctUsedFor1099",
    "bankCentralBankPurposeCode",
    "bankCentralBankPurposeText",
    "branchId",
    "branchNumber",
    "businessActivitySA",
    "businessActivityDescSA",
    "businessNumberCA",
    "combinedFedStateFiler",
    "companyNAFCode",
    "companyRegComFR",
    "companyTypeMX",
    "conversionDate",
    "coRegNum",
    "curpMX",
    "customsCustomerNumberFI",
    "customsLicenseNumberFI",
    "dataArea",
    "dba",
    "dvRid",
    "enterpriseNumber",
    "fiCreditorIDDK",
    "fileNumberSA",
    "fiscalCodeIT",
    "foreignEntityIndicator",
    "giro",
    "giroContract",
    "giroContractAccount",
    "importVATNum",
    "importVATNumBranchId",
    "intrastatCode",
    "isConsolidationCompany",
    "isEliminationCompany",
    "issuingSignature",
    "key",
    "lastFilingIndicator",
    "legalFormFR",
    "legalNatureIT",
    "legalRepresentativeCurpMX",
    "legalRepresentativeNameMX",
    "legalRepresentativeRfcMX",
    "nameControl",
    "orgId",
    "packMaterialFeeLicenseNum",
    "paymInstruction1",
    "paymInstruction2",
    "paymInstruction3",
    "paymInstruction4",
    "paymRoutingDNB",
    "paymTraderNumber",
    "planningCompany",
    "regNum",
    "rfcMX",
    "shippingCalendarId",
    "siaCode",
    "softwareIdentificationCodeCA",
    "stateInscriptionMX",
    "tax1099RegNum",
    "taxRepresentative",
    "tcc",
    "upsNum",
    "validate1099OnEntry",
    "vatNum",
    "vatNumBranchId"
})
public class AxdEntityDirPartyCompanyInfo
    extends AxdEntityDirPartyOMInternalOrganization
{

    @XmlElementRef(name = "ActivityCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> activityCode;
    @XmlElementRef(name = "AddrFormat", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> addrFormat;
    @XmlElementRef(name = "Bank", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bank;
    @XmlElementRef(name = "BankAcctUsedFor1099", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankAcctUsedFor1099;
    @XmlElementRef(name = "BankCentralBankPurposeCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankCentralBankPurposeCode;
    @XmlElementRef(name = "BankCentralBankPurposeText", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankCentralBankPurposeText;
    @XmlElementRef(name = "BranchId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> branchId;
    @XmlElementRef(name = "branchNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> branchNumber;
    @XmlElementRef(name = "BusinessActivity_SA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> businessActivitySA;
    @XmlElementRef(name = "BusinessActivityDesc_SA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> businessActivityDescSA;
    @XmlElementRef(name = "BusinessNumber_CA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> businessNumberCA;
    @XmlElementRef(name = "CombinedFedStateFiler", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> combinedFedStateFiler;
    @XmlElementRef(name = "CompanyNAFCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> companyNAFCode;
    @XmlElementRef(name = "CompanyRegComFR", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> companyRegComFR;
    @XmlElementRef(name = "CompanyType_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCompanyTypeMX> companyTypeMX;
    @XmlElementRef(name = "ConversionDate", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> conversionDate;
    @XmlElementRef(name = "CoRegNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> coRegNum;
    @XmlElementRef(name = "Curp_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> curpMX;
    @XmlElementRef(name = "CustomsCustomerNumber_FI", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> customsCustomerNumberFI;
    @XmlElementRef(name = "CustomsLicenseNumber_FI", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> customsLicenseNumberFI;
    @XmlElement(name = "DataArea", required = true)
    protected String dataArea;
    @XmlElementRef(name = "DBA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dba;
    @XmlElementRef(name = "DVRid", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dvRid;
    @XmlElementRef(name = "EnterpriseNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> enterpriseNumber;
    @XmlElementRef(name = "FICreditorID_DK", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> fiCreditorIDDK;
    @XmlElementRef(name = "FileNumber_SA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> fileNumberSA;
    @XmlElementRef(name = "FiscalCode_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> fiscalCodeIT;
    @XmlElementRef(name = "ForeignEntityIndicator", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator> foreignEntityIndicator;
    @XmlElementRef(name = "Giro", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> giro;
    @XmlElementRef(name = "GiroContract", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> giroContract;
    @XmlElementRef(name = "GiroContractAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> giroContractAccount;
    @XmlElementRef(name = "ImportVATNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> importVATNum;
    @XmlElementRef(name = "ImportVATNumBranchId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> importVATNumBranchId;
    @XmlElementRef(name = "IntrastatCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> intrastatCode;
    @XmlElementRef(name = "IsConsolidationCompany", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isConsolidationCompany;
    @XmlElementRef(name = "IsEliminationCompany", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isEliminationCompany;
    @XmlElementRef(name = "IssuingSignature", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> issuingSignature;
    @XmlElementRef(name = "Key", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> key;
    @XmlElementRef(name = "LastFilingIndicator", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeTax1099LastFilingIndicator> lastFilingIndicator;
    @XmlElementRef(name = "LegalFormFR", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> legalFormFR;
    @XmlElementRef(name = "LegalNature_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumLegalNatureIT> legalNatureIT;
    @XmlElementRef(name = "LegalRepresentativeCurp_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> legalRepresentativeCurpMX;
    @XmlElementRef(name = "LegalRepresentativeName_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> legalRepresentativeNameMX;
    @XmlElementRef(name = "LegalRepresentativeRfc_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> legalRepresentativeRfcMX;
    @XmlElementRef(name = "NameControl", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> nameControl;
    @XmlElementRef(name = "OrgId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> orgId;
    @XmlElementRef(name = "PackMaterialFeeLicenseNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> packMaterialFeeLicenseNum;
    @XmlElementRef(name = "PaymInstruction1", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymInstruction1;
    @XmlElementRef(name = "PaymInstruction2", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymInstruction2;
    @XmlElementRef(name = "PaymInstruction3", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymInstruction3;
    @XmlElementRef(name = "PaymInstruction4", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymInstruction4;
    @XmlElementRef(name = "PaymRoutingDNB", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymRoutingDNB;
    @XmlElementRef(name = "PaymTraderNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymTraderNumber;
    @XmlElementRef(name = "PlanningCompany", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> planningCompany;
    @XmlElementRef(name = "RegNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> regNum;
    @XmlElementRef(name = "Rfc_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> rfcMX;
    @XmlElementRef(name = "ShippingCalendarId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> shippingCalendarId;
    @XmlElementRef(name = "SiaCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> siaCode;
    @XmlElementRef(name = "SoftwareIdentificationCode_CA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> softwareIdentificationCodeCA;
    @XmlElementRef(name = "StateInscription_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> stateInscriptionMX;
    @XmlElementRef(name = "Tax1099RegNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> tax1099RegNum;
    @XmlElementRef(name = "TaxRepresentative", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> taxRepresentative;
    @XmlElementRef(name = "TCC", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> tcc;
    @XmlElementRef(name = "UPSNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> upsNum;
    @XmlElementRef(name = "validate1099OnEntry", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> validate1099OnEntry;
    @XmlElementRef(name = "VATNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> vatNum;
    @XmlElementRef(name = "VATNumBranchId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> vatNumBranchId;

    /**
     * Gets the value of the activityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActivityCode() {
        return activityCode;
    }

    /**
     * Sets the value of the activityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActivityCode(JAXBElement<String> value) {
        this.activityCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the addrFormat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrFormat() {
        return addrFormat;
    }

    /**
     * Sets the value of the addrFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrFormat(JAXBElement<String> value) {
        this.addrFormat = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBank(JAXBElement<String> value) {
        this.bank = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankAcctUsedFor1099 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAcctUsedFor1099() {
        return bankAcctUsedFor1099;
    }

    /**
     * Sets the value of the bankAcctUsedFor1099 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAcctUsedFor1099(JAXBElement<String> value) {
        this.bankAcctUsedFor1099 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankCentralBankPurposeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankCentralBankPurposeCode() {
        return bankCentralBankPurposeCode;
    }

    /**
     * Sets the value of the bankCentralBankPurposeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankCentralBankPurposeCode(JAXBElement<String> value) {
        this.bankCentralBankPurposeCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankCentralBankPurposeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankCentralBankPurposeText() {
        return bankCentralBankPurposeText;
    }

    /**
     * Sets the value of the bankCentralBankPurposeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankCentralBankPurposeText(JAXBElement<String> value) {
        this.bankCentralBankPurposeText = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the branchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchId() {
        return branchId;
    }

    /**
     * Sets the value of the branchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchId(JAXBElement<String> value) {
        this.branchId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the branchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchNumber() {
        return branchNumber;
    }

    /**
     * Sets the value of the branchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchNumber(JAXBElement<String> value) {
        this.branchNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the businessActivitySA property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessActivitySA() {
        return businessActivitySA;
    }

    /**
     * Sets the value of the businessActivitySA property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessActivitySA(JAXBElement<String> value) {
        this.businessActivitySA = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the businessActivityDescSA property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessActivityDescSA() {
        return businessActivityDescSA;
    }

    /**
     * Sets the value of the businessActivityDescSA property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessActivityDescSA(JAXBElement<String> value) {
        this.businessActivityDescSA = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the businessNumberCA property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessNumberCA() {
        return businessNumberCA;
    }

    /**
     * Sets the value of the businessNumberCA property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessNumberCA(JAXBElement<String> value) {
        this.businessNumberCA = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the combinedFedStateFiler property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getCombinedFedStateFiler() {
        return combinedFedStateFiler;
    }

    /**
     * Sets the value of the combinedFedStateFiler property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setCombinedFedStateFiler(JAXBElement<AxdEnumNoYes> value) {
        this.combinedFedStateFiler = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the companyNAFCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyNAFCode() {
        return companyNAFCode;
    }

    /**
     * Sets the value of the companyNAFCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyNAFCode(JAXBElement<String> value) {
        this.companyNAFCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the companyRegComFR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyRegComFR() {
        return companyRegComFR;
    }

    /**
     * Sets the value of the companyRegComFR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyRegComFR(JAXBElement<String> value) {
        this.companyRegComFR = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the companyTypeMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCompanyTypeMX }{@code >}
     *     
     */
    public JAXBElement<AxdEnumCompanyTypeMX> getCompanyTypeMX() {
        return companyTypeMX;
    }

    /**
     * Sets the value of the companyTypeMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCompanyTypeMX }{@code >}
     *     
     */
    public void setCompanyTypeMX(JAXBElement<AxdEnumCompanyTypeMX> value) {
        this.companyTypeMX = ((JAXBElement<AxdEnumCompanyTypeMX> ) value);
    }

    /**
     * Gets the value of the conversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getConversionDate() {
        return conversionDate;
    }

    /**
     * Sets the value of the conversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setConversionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.conversionDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the coRegNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCoRegNum() {
        return coRegNum;
    }

    /**
     * Sets the value of the coRegNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCoRegNum(JAXBElement<String> value) {
        this.coRegNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the curpMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurpMX() {
        return curpMX;
    }

    /**
     * Sets the value of the curpMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurpMX(JAXBElement<String> value) {
        this.curpMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the customsCustomerNumberFI property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomsCustomerNumberFI() {
        return customsCustomerNumberFI;
    }

    /**
     * Sets the value of the customsCustomerNumberFI property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomsCustomerNumberFI(JAXBElement<String> value) {
        this.customsCustomerNumberFI = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the customsLicenseNumberFI property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomsLicenseNumberFI() {
        return customsLicenseNumberFI;
    }

    /**
     * Sets the value of the customsLicenseNumberFI property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomsLicenseNumberFI(JAXBElement<String> value) {
        this.customsLicenseNumberFI = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dataArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataArea() {
        return dataArea;
    }

    /**
     * Sets the value of the dataArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataArea(String value) {
        this.dataArea = value;
    }

    /**
     * Gets the value of the dba property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDBA() {
        return dba;
    }

    /**
     * Sets the value of the dba property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDBA(JAXBElement<String> value) {
        this.dba = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dvRid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDVRid() {
        return dvRid;
    }

    /**
     * Sets the value of the dvRid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDVRid(JAXBElement<String> value) {
        this.dvRid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the enterpriseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEnterpriseNumber() {
        return enterpriseNumber;
    }

    /**
     * Sets the value of the enterpriseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEnterpriseNumber(JAXBElement<String> value) {
        this.enterpriseNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fiCreditorIDDK property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFICreditorIDDK() {
        return fiCreditorIDDK;
    }

    /**
     * Sets the value of the fiCreditorIDDK property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFICreditorIDDK(JAXBElement<String> value) {
        this.fiCreditorIDDK = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fileNumberSA property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileNumberSA() {
        return fileNumberSA;
    }

    /**
     * Sets the value of the fileNumberSA property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileNumberSA(JAXBElement<String> value) {
        this.fileNumberSA = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fiscalCodeIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiscalCodeIT() {
        return fiscalCodeIT;
    }

    /**
     * Sets the value of the fiscalCodeIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiscalCodeIT(JAXBElement<String> value) {
        this.fiscalCodeIT = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the foreignEntityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099ForeignEntityIndicator }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator> getForeignEntityIndicator() {
        return foreignEntityIndicator;
    }

    /**
     * Sets the value of the foreignEntityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099ForeignEntityIndicator }{@code >}
     *     
     */
    public void setForeignEntityIndicator(JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator> value) {
        this.foreignEntityIndicator = ((JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator> ) value);
    }

    /**
     * Gets the value of the giro property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGiro() {
        return giro;
    }

    /**
     * Sets the value of the giro property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGiro(JAXBElement<String> value) {
        this.giro = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the giroContract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGiroContract() {
        return giroContract;
    }

    /**
     * Sets the value of the giroContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGiroContract(JAXBElement<String> value) {
        this.giroContract = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the giroContractAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGiroContractAccount() {
        return giroContractAccount;
    }

    /**
     * Sets the value of the giroContractAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGiroContractAccount(JAXBElement<String> value) {
        this.giroContractAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the importVATNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImportVATNum() {
        return importVATNum;
    }

    /**
     * Sets the value of the importVATNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImportVATNum(JAXBElement<String> value) {
        this.importVATNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the importVATNumBranchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImportVATNumBranchId() {
        return importVATNumBranchId;
    }

    /**
     * Sets the value of the importVATNumBranchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImportVATNumBranchId(JAXBElement<String> value) {
        this.importVATNumBranchId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the intrastatCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntrastatCode() {
        return intrastatCode;
    }

    /**
     * Sets the value of the intrastatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntrastatCode(JAXBElement<String> value) {
        this.intrastatCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the isConsolidationCompany property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsConsolidationCompany() {
        return isConsolidationCompany;
    }

    /**
     * Sets the value of the isConsolidationCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsConsolidationCompany(JAXBElement<AxdEnumNoYes> value) {
        this.isConsolidationCompany = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the isEliminationCompany property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsEliminationCompany() {
        return isEliminationCompany;
    }

    /**
     * Sets the value of the isEliminationCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsEliminationCompany(JAXBElement<AxdEnumNoYes> value) {
        this.isEliminationCompany = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the issuingSignature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuingSignature() {
        return issuingSignature;
    }

    /**
     * Sets the value of the issuingSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuingSignature(JAXBElement<String> value) {
        this.issuingSignature = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setKey(JAXBElement<Integer> value) {
        this.key = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the lastFilingIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099LastFilingIndicator }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeTax1099LastFilingIndicator> getLastFilingIndicator() {
        return lastFilingIndicator;
    }

    /**
     * Sets the value of the lastFilingIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099LastFilingIndicator }{@code >}
     *     
     */
    public void setLastFilingIndicator(JAXBElement<AxdExtTypeTax1099LastFilingIndicator> value) {
        this.lastFilingIndicator = ((JAXBElement<AxdExtTypeTax1099LastFilingIndicator> ) value);
    }

    /**
     * Gets the value of the legalFormFR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegalFormFR() {
        return legalFormFR;
    }

    /**
     * Sets the value of the legalFormFR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegalFormFR(JAXBElement<String> value) {
        this.legalFormFR = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legalNatureIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumLegalNatureIT }{@code >}
     *     
     */
    public JAXBElement<AxdEnumLegalNatureIT> getLegalNatureIT() {
        return legalNatureIT;
    }

    /**
     * Sets the value of the legalNatureIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumLegalNatureIT }{@code >}
     *     
     */
    public void setLegalNatureIT(JAXBElement<AxdEnumLegalNatureIT> value) {
        this.legalNatureIT = ((JAXBElement<AxdEnumLegalNatureIT> ) value);
    }

    /**
     * Gets the value of the legalRepresentativeCurpMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegalRepresentativeCurpMX() {
        return legalRepresentativeCurpMX;
    }

    /**
     * Sets the value of the legalRepresentativeCurpMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegalRepresentativeCurpMX(JAXBElement<String> value) {
        this.legalRepresentativeCurpMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legalRepresentativeNameMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegalRepresentativeNameMX() {
        return legalRepresentativeNameMX;
    }

    /**
     * Sets the value of the legalRepresentativeNameMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegalRepresentativeNameMX(JAXBElement<String> value) {
        this.legalRepresentativeNameMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legalRepresentativeRfcMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegalRepresentativeRfcMX() {
        return legalRepresentativeRfcMX;
    }

    /**
     * Sets the value of the legalRepresentativeRfcMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegalRepresentativeRfcMX(JAXBElement<String> value) {
        this.legalRepresentativeRfcMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nameControl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameControl() {
        return nameControl;
    }

    /**
     * Sets the value of the nameControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameControl(JAXBElement<String> value) {
        this.nameControl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgId(JAXBElement<String> value) {
        this.orgId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the packMaterialFeeLicenseNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackMaterialFeeLicenseNum() {
        return packMaterialFeeLicenseNum;
    }

    /**
     * Sets the value of the packMaterialFeeLicenseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackMaterialFeeLicenseNum(JAXBElement<String> value) {
        this.packMaterialFeeLicenseNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymInstruction1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymInstruction1() {
        return paymInstruction1;
    }

    /**
     * Sets the value of the paymInstruction1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymInstruction1(JAXBElement<String> value) {
        this.paymInstruction1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymInstruction2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymInstruction2() {
        return paymInstruction2;
    }

    /**
     * Sets the value of the paymInstruction2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymInstruction2(JAXBElement<String> value) {
        this.paymInstruction2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymInstruction3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymInstruction3() {
        return paymInstruction3;
    }

    /**
     * Sets the value of the paymInstruction3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymInstruction3(JAXBElement<String> value) {
        this.paymInstruction3 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymInstruction4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymInstruction4() {
        return paymInstruction4;
    }

    /**
     * Sets the value of the paymInstruction4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymInstruction4(JAXBElement<String> value) {
        this.paymInstruction4 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymRoutingDNB property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymRoutingDNB() {
        return paymRoutingDNB;
    }

    /**
     * Sets the value of the paymRoutingDNB property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymRoutingDNB(JAXBElement<String> value) {
        this.paymRoutingDNB = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymTraderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymTraderNumber() {
        return paymTraderNumber;
    }

    /**
     * Sets the value of the paymTraderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymTraderNumber(JAXBElement<String> value) {
        this.paymTraderNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the planningCompany property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getPlanningCompany() {
        return planningCompany;
    }

    /**
     * Sets the value of the planningCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setPlanningCompany(JAXBElement<AxdEnumNoYes> value) {
        this.planningCompany = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the regNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegNum() {
        return regNum;
    }

    /**
     * Sets the value of the regNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegNum(JAXBElement<String> value) {
        this.regNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the rfcMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRfcMX() {
        return rfcMX;
    }

    /**
     * Sets the value of the rfcMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRfcMX(JAXBElement<String> value) {
        this.rfcMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shippingCalendarId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingCalendarId() {
        return shippingCalendarId;
    }

    /**
     * Sets the value of the shippingCalendarId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingCalendarId(JAXBElement<String> value) {
        this.shippingCalendarId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the siaCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSiaCode() {
        return siaCode;
    }

    /**
     * Sets the value of the siaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSiaCode(JAXBElement<String> value) {
        this.siaCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the softwareIdentificationCodeCA property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSoftwareIdentificationCodeCA() {
        return softwareIdentificationCodeCA;
    }

    /**
     * Sets the value of the softwareIdentificationCodeCA property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSoftwareIdentificationCodeCA(JAXBElement<String> value) {
        this.softwareIdentificationCodeCA = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the stateInscriptionMX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStateInscriptionMX() {
        return stateInscriptionMX;
    }

    /**
     * Sets the value of the stateInscriptionMX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStateInscriptionMX(JAXBElement<String> value) {
        this.stateInscriptionMX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the tax1099RegNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTax1099RegNum() {
        return tax1099RegNum;
    }

    /**
     * Sets the value of the tax1099RegNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTax1099RegNum(JAXBElement<String> value) {
        this.tax1099RegNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taxRepresentative property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxRepresentative() {
        return taxRepresentative;
    }

    /**
     * Sets the value of the taxRepresentative property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxRepresentative(JAXBElement<String> value) {
        this.taxRepresentative = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the tcc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTCC() {
        return tcc;
    }

    /**
     * Sets the value of the tcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTCC(JAXBElement<String> value) {
        this.tcc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the upsNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUPSNum() {
        return upsNum;
    }

    /**
     * Sets the value of the upsNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUPSNum(JAXBElement<String> value) {
        this.upsNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the validate1099OnEntry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getValidate1099OnEntry() {
        return validate1099OnEntry;
    }

    /**
     * Sets the value of the validate1099OnEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setValidate1099OnEntry(JAXBElement<AxdEnumNoYes> value) {
        this.validate1099OnEntry = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the vatNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVATNum() {
        return vatNum;
    }

    /**
     * Sets the value of the vatNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVATNum(JAXBElement<String> value) {
        this.vatNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the vatNumBranchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVATNumBranchId() {
        return vatNumBranchId;
    }

    /**
     * Sets the value of the vatNumBranchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVATNumBranchId(JAXBElement<String> value) {
        this.vatNumBranchId = ((JAXBElement<String> ) value);
    }

}
