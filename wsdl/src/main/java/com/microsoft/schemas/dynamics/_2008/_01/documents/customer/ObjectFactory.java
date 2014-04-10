
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEntityKeyDirNameAffix;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEntityKeyDirPartyLocation;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumABC;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdValidTimeStateType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCompanyTypeMX;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardAddressVerification;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardAddressVerificationLevel;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardCVC;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCustAccountStatement;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumDirPersonMaritalStatus;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumECPsalesOrdersViewType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumGender;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumLegalNatureIT;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumLogisticsElectronicAddressMethodType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMonthsOfYear;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumOMInternalOrganizationType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumTimezone;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumUseCashDisc;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCreditCardAddressVerificationVoid;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustBlocked;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustExcludeCollectionFee;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustExcludeInterestCharges;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustInvoiceAddress;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeDirPartyIsLocationOwner;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeEffectiveDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeExpirationDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeForecastDMPInclude;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInclTax;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyAllowIndirectCreation;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyAutoCreateOrders;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyDirectDelivery;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeLogisticsIsPrimaryAddress;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeLogisticsIsPrivate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeMandatoryCreditLimit;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeNoYesId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeOneTimeCustomer;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypePaymentStubAccountStatementId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypePaymentStubCollectionId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypePaymentStubInterestId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypePaymentStubInvoiceId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypePaymentStubProjId;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeShipCarrierBlindShipment;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeShipCarrierFuelSurcharge;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTax1099ForeignEntityIndicator;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTax1099LastFilingIndicator;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTaxWithholdCalculateTH;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDimensionAttributeValueSet;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.customer package. 
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

    private final static QName _Customer_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Customer");
    private final static QName _AxdEntityDirPartyDirOrganizationBasePhoneticName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PhoneticName");
    private final static QName _AxdEntityDirPartyDirOrganizationBaseDunsNumberRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DunsNumberRecId");
    private final static QName _AxdEntityDirPartyCompanyInfoRfcMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Rfc_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoLegalRepresentativeNameMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LegalRepresentativeName_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoImportVATNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ImportVATNum");
    private final static QName _AxdEntityDirPartyCompanyInfoCompanyTypeMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CompanyType_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoVATNumBranchId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "VATNumBranchId");
    private final static QName _AxdEntityDirPartyCompanyInfoBusinessNumberCA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BusinessNumber_CA");
    private final static QName _AxdEntityDirPartyCompanyInfoBankCentralBankPurposeCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BankCentralBankPurposeCode");
    private final static QName _AxdEntityDirPartyCompanyInfoGiroContract_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroContract");
    private final static QName _AxdEntityDirPartyCompanyInfoDBA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DBA");
    private final static QName _AxdEntityDirPartyCompanyInfoBank_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Bank");
    private final static QName _AxdEntityDirPartyCompanyInfoVATNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "VATNum");
    private final static QName _AxdEntityDirPartyCompanyInfoActivityCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ActivityCode");
    private final static QName _AxdEntityDirPartyCompanyInfoStateInscriptionMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "StateInscription_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoSoftwareIdentificationCodeCA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SoftwareIdentificationCode_CA");
    private final static QName _AxdEntityDirPartyCompanyInfoCustomsLicenseNumberFI_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustomsLicenseNumber_FI");
    private final static QName _AxdEntityDirPartyCompanyInfoFICreditorIDDK_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FICreditorID_DK");
    private final static QName _AxdEntityDirPartyCompanyInfoLastFilingIndicator_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LastFilingIndicator");
    private final static QName _AxdEntityDirPartyCompanyInfoBranchId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BranchId");
    private final static QName _AxdEntityDirPartyCompanyInfoGiro_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Giro");
    private final static QName _AxdEntityDirPartyCompanyInfoIsConsolidationCompany_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsConsolidationCompany");
    private final static QName _AxdEntityDirPartyCompanyInfoBankAcctUsedFor1099_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BankAcctUsedFor1099");
    private final static QName _AxdEntityDirPartyCompanyInfoLegalNatureIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LegalNature_IT");
    private final static QName _AxdEntityDirPartyCompanyInfoFiscalCodeIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FiscalCode_IT");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymRoutingDNB_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymRoutingDNB");
    private final static QName _AxdEntityDirPartyCompanyInfoBankCentralBankPurposeText_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BankCentralBankPurposeText");
    private final static QName _AxdEntityDirPartyCompanyInfoCustomsCustomerNumberFI_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustomsCustomerNumber_FI");
    private final static QName _AxdEntityDirPartyCompanyInfoIntrastatCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IntrastatCode");
    private final static QName _AxdEntityDirPartyCompanyInfoUPSNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "UPSNum");
    private final static QName _AxdEntityDirPartyCompanyInfoLegalRepresentativeRfcMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LegalRepresentativeRfc_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoBusinessActivityDescSA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BusinessActivityDesc_SA");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymInstruction1_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymInstruction1");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymInstruction2_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymInstruction2");
    private final static QName _AxdEntityDirPartyCompanyInfoTaxRepresentative_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxRepresentative");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymInstruction3_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymInstruction3");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymInstruction4_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymInstruction4");
    private final static QName _AxdEntityDirPartyCompanyInfoLegalFormFR_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LegalFormFR");
    private final static QName _AxdEntityDirPartyCompanyInfoValidate1099OnEntry_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "validate1099OnEntry");
    private final static QName _AxdEntityDirPartyCompanyInfoCompanyNAFCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CompanyNAFCode");
    private final static QName _AxdEntityDirPartyCompanyInfoIssuingSignature_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IssuingSignature");
    private final static QName _AxdEntityDirPartyCompanyInfoTax1099RegNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Tax1099RegNum");
    private final static QName _AxdEntityDirPartyCompanyInfoPackMaterialFeeLicenseNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PackMaterialFeeLicenseNum");
    private final static QName _AxdEntityDirPartyCompanyInfoConversionDate_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ConversionDate");
    private final static QName _AxdEntityDirPartyCompanyInfoBranchNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "branchNumber");
    private final static QName _AxdEntityDirPartyCompanyInfoBusinessActivitySA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BusinessActivity_SA");
    private final static QName _AxdEntityDirPartyCompanyInfoForeignEntityIndicator_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ForeignEntityIndicator");
    private final static QName _AxdEntityDirPartyCompanyInfoNameControl_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "NameControl");
    private final static QName _AxdEntityDirPartyCompanyInfoGiroContractAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroContractAccount");
    private final static QName _AxdEntityDirPartyCompanyInfoFileNumberSA_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FileNumber_SA");
    private final static QName _AxdEntityDirPartyCompanyInfoOrgId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OrgId");
    private final static QName _AxdEntityDirPartyCompanyInfoSiaCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SiaCode");
    private final static QName _AxdEntityDirPartyCompanyInfoCoRegNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CoRegNum");
    private final static QName _AxdEntityDirPartyCompanyInfoTCC_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TCC");
    private final static QName _AxdEntityDirPartyCompanyInfoPlanningCompany_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PlanningCompany");
    private final static QName _AxdEntityDirPartyCompanyInfoCompanyRegComFR_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CompanyRegComFR");
    private final static QName _AxdEntityDirPartyCompanyInfoShippingCalendarId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShippingCalendarId");
    private final static QName _AxdEntityDirPartyCompanyInfoRegNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "RegNum");
    private final static QName _AxdEntityDirPartyCompanyInfoKey_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Key");
    private final static QName _AxdEntityDirPartyCompanyInfoLegalRepresentativeCurpMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LegalRepresentativeCurp_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoCurpMX_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Curp_MX");
    private final static QName _AxdEntityDirPartyCompanyInfoEnterpriseNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "EnterpriseNumber");
    private final static QName _AxdEntityDirPartyCompanyInfoImportVATNumBranchId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ImportVATNumBranchId");
    private final static QName _AxdEntityDirPartyCompanyInfoDVRid_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DVRid");
    private final static QName _AxdEntityDirPartyCompanyInfoAddrFormat_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AddrFormat");
    private final static QName _AxdEntityDirPartyCompanyInfoIsEliminationCompany_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsEliminationCompany");
    private final static QName _AxdEntityDirPartyCompanyInfoPaymTraderNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymTraderNumber");
    private final static QName _AxdEntityDirPartyCompanyInfoCombinedFedStateFiler_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CombinedFedStateFiler");
    private final static QName _AxdCustomerValidFromDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidFromDateTime");
    private final static QName _AxdCustomerDocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DocPurpose");
    private final static QName _AxdCustomerValidTimeStateType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidTimeStateType");
    private final static QName _AxdCustomerValidAsOfDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidAsOfDateTime");
    private final static QName _AxdCustomerSenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SenderId");
    private final static QName _AxdCustomerValidToDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidToDateTime");
    private final static QName _AxdEntityDirPartyDirOrganizationABC_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ABC");
    private final static QName _AxdEntityDirPartyDirOrganizationNumberOfEmployees_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "NumberOfEmployees");
    private final static QName _AxdEntityDirPartyDirOrganizationOrgNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OrgNumber");
    private final static QName _AxdEntityDirPartyDirPersonPersonalTitle_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PersonalTitle");
    private final static QName _AxdEntityDirPartyDirPersonBirthYear_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthYear");
    private final static QName _AxdEntityDirPartyDirPersonProfessionalSuffix_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ProfessionalSuffix");
    private final static QName _AxdEntityDirPartyDirPersonPersonalSuffix_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PersonalSuffix");
    private final static QName _AxdEntityDirPartyDirPersonPersonSuffix_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PersonSuffix");
    private final static QName _AxdEntityDirPartyDirPersonGender_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Gender");
    private final static QName _AxdEntityDirPartyDirPersonInitials_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Initials");
    private final static QName _AxdEntityDirPartyDirPersonNameSequence_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "NameSequence");
    private final static QName _AxdEntityDirPartyDirPersonMaritalStatus_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MaritalStatus");
    private final static QName _AxdEntityDirPartyDirPersonPersonTitle_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PersonTitle");
    private final static QName _AxdEntityDirPartyDirPersonPhoneticMiddleName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PhoneticMiddleName");
    private final static QName _AxdEntityDirPartyDirPersonChildrenNames_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ChildrenNames");
    private final static QName _AxdEntityDirPartyDirPersonAnniversaryMonth_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AnniversaryMonth");
    private final static QName _AxdEntityDirPartyDirPersonHobbies_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Hobbies");
    private final static QName _AxdEntityDirPartyDirPersonBirthDay_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthDay");
    private final static QName _AxdEntityDirPartyDirPersonPhoneticLastName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PhoneticLastName");
    private final static QName _AxdEntityDirPartyDirPersonPhoneticFirstName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PhoneticFirstName");
    private final static QName _AxdEntityDirPartyDirPersonCommunicatorSignIn_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CommunicatorSignIn");
    private final static QName _AxdEntityDirPartyDirPersonAnniversaryDay_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AnniversaryDay");
    private final static QName _AxdEntityDirPartyDirPersonProfessionalTitle_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ProfessionalTitle");
    private final static QName _AxdEntityDirPartyDirPersonBirthMonth_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthMonth");
    private final static QName _AxdEntityDirPartyDirPersonAnniversaryYear_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AnniversaryYear");
    private final static QName _AxdEntityDirPartyOMOperatingUnitHcmWorker_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "HcmWorker");
    private final static QName _AxdEntityDirPartyPostalAddressViewCounty_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "County");
    private final static QName _AxdEntityDirPartyPostalAddressViewDistrict_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "District");
    private final static QName _AxdEntityDirPartyPostalAddressViewState_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "State");
    private final static QName _AxdEntityDirPartyPostalAddressViewAddress_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Address");
    private final static QName _AxdEntityDirPartyPostalAddressViewPartyLocation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PartyLocation");
    private final static QName _AxdEntityDirPartyPostalAddressViewDistrictName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DistrictName");
    private final static QName _AxdEntityDirPartyPostalAddressViewLongitude_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Longitude");
    private final static QName _AxdEntityDirPartyPostalAddressViewBuildingCompliment_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BuildingCompliment");
    private final static QName _AxdEntityDirPartyPostalAddressViewParty_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Party");
    private final static QName _AxdEntityDirPartyPostalAddressViewLocation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Location");
    private final static QName _AxdEntityDirPartyPostalAddressViewStreetNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "StreetNumber");
    private final static QName _AxdEntityDirPartyPostalAddressViewZipCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ZipCode");
    private final static QName _AxdEntityDirPartyPostalAddressViewIsPrimary_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsPrimary");
    private final static QName _AxdEntityDirPartyPostalAddressViewRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "RecId");
    private final static QName _AxdEntityDirPartyPostalAddressViewCity_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "City");
    private final static QName _AxdEntityDirPartyPostalAddressViewPostBox_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PostBox");
    private final static QName _AxdEntityDirPartyPostalAddressViewRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "RecVersion");
    private final static QName _AxdEntityDirPartyPostalAddressViewLocationName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LocationName");
    private final static QName _AxdEntityDirPartyPostalAddressViewLatitude_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Latitude");
    private final static QName _AxdEntityDirPartyPostalAddressViewTimeZone_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TimeZone");
    private final static QName _AxdEntityDirPartyPostalAddressViewValidTo_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidTo");
    private final static QName _AxdEntityDirPartyPostalAddressViewRoles_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Roles");
    private final static QName _AxdEntityDirPartyPostalAddressViewValidFrom_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ValidFrom");
    private final static QName _AxdEntityDirPartyPostalAddressViewStreet_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Street");
    private final static QName _AxdEntityDirPartyPostalAddressViewISOcode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ISOcode");
    private final static QName _AxdEntityDirPartyPostalAddressViewIsPrivate_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsPrivate");
    private final static QName _AxdEntityDirPartyPostalAddressViewIsLocationOwner_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsLocationOwner");
    private final static QName _AxdEntityDirPartyPostalAddressViewCountryRegionId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CountryRegionId");
    private final static QName _AxdEntityDirPartyPostalAddressViewCountryCurrencyCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CountryCurrencyCode");
    private final static QName _AxdEntityDirPartyDirPartyTableNameAlias_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "NameAlias");
    private final static QName _AxdEntityDirPartyDirPartyTableName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Name");
    private final static QName _AxdEntityDirPartyDirPartyTableInstanceRelationType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InstanceRelationType");
    private final static QName _AxdEntityDirPartyDirPartyTablePartyNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PartyNumber");
    private final static QName _AxdEntityDirPartyDirPartyTableMemo_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Memo");
    private final static QName _AxdEntityDirPartyDirPartyTableKnownAs_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "KnownAs");
    private final static QName _AxdEntityDirPartyDirPartyTableLanguageId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LanguageId");
    private final static QName _AxdEntityDirPartyContactInfoViewElectronicAddress_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ElectronicAddress");
    private final static QName _AxdEntityDirPartyContactInfoViewLocationId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LocationId");
    private final static QName _AxdEntityDirPartyContactInfoViewLocator_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Locator");
    private final static QName _AxdEntityDirPartyContactInfoViewCountryRegionCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CountryRegionCode");
    private final static QName _AxdEntityDirPartyContactInfoViewLocatorExtension_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LocatorExtension");
    private final static QName _AxdEntityDirPartyContactInfoViewType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Type");
    private final static QName _AxdEntityDirPartyContactInfoViewTypeIcon_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TypeIcon");
    private final static QName _AxdEntityCustTablePaymSpec_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymSpec");
    private final static QName _AxdEntityCustTableBankAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BankAccount");
    private final static QName _AxdEntityCustTableCreditCardAddressVerification_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditCardAddressVerification");
    private final static QName _AxdEntityCustTableIdentificationNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IdentificationNumber");
    private final static QName _AxdEntityCustTableOneTimeCustomer_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OneTimeCustomer");
    private final static QName _AxdEntityCustTableDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "_DocumentHash");
    private final static QName _AxdEntityCustTableDlvReason_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DlvReason");
    private final static QName _AxdEntityCustTableCreditCardAddressVerificationVoid_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditCardAddressVerificationVoid");
    private final static QName _AxdEntityCustTableCustExcludeCollectionFee_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustExcludeCollectionFee");
    private final static QName _AxdEntityCustTablePriceGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PriceGroup");
    private final static QName _AxdEntityCustTableEinvoiceEANNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "EinvoiceEANNum");
    private final static QName _AxdEntityCustTableAccountStatement_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AccountStatement");
    private final static QName _AxdEntityCustTablePartyState_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PartyState");
    private final static QName _AxdEntityCustTableInterCompanyDirectDelivery_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InterCompanyDirectDelivery");
    private final static QName _AxdEntityCustTableCreditCardCVC_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditCardCVC");
    private final static QName _AxdEntityCustTableLineDisc_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LineDisc");
    private final static QName _AxdEntityCustTableSyncVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SyncVersion");
    private final static QName _AxdEntityCustTableCompanyIdSiret_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CompanyIdSiret");
    private final static QName _AxdEntityCustTableBirthDateIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthDate_IT");
    private final static QName _AxdEntityCustTableSuppItemGroupId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SuppItemGroupId");
    private final static QName _AxdEntityCustTableCompanyChainId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CompanyChainId");
    private final static QName _AxdEntityCustTableFreightZone_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FreightZone");
    private final static QName _AxdEntityCustTableGiroTypeInterestNote_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroTypeInterestNote");
    private final static QName _AxdEntityCustTableBankCustPaymIdTable_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BankCustPaymIdTable");
    private final static QName _AxdEntityCustTableShipCarrierId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShipCarrierId");
    private final static QName _AxdEntityCustTableSyncEntityId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SyncEntityId");
    private final static QName _AxdEntityCustTableBirthPlaceIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthPlace_IT");
    private final static QName _AxdEntityCustTableInvoiceAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InvoiceAccount");
    private final static QName _AxdEntityCustTableEndDisc_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "EndDisc");
    private final static QName _AxdEntityCustTableMarkupGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MarkupGroup");
    private final static QName _AxdEntityCustTableCreditRating_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditRating");
    private final static QName _AxdEntityCustTableBirthCountyCodeIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "BirthCountyCode_IT");
    private final static QName _AxdEntityCustTableSalesDistrictId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SalesDistrictId");
    private final static QName _AxdEntityCustTableCustExcludeInterestCharges_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustExcludeInterestCharges");
    private final static QName _AxdEntityCustTableForecastDMPInclude_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ForecastDMPInclude");
    private final static QName _AxdEntityCustTableTaxWithholdGroupTH_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxWithholdGroup_TH");
    private final static QName _AxdEntityCustTableContactPersonId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ContactPersonId");
    private final static QName _AxdEntityCustTableGiroType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroType");
    private final static QName _AxdEntityCustTableSegmentId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SegmentId");
    private final static QName _AxdEntityCustTableInventSiteId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InventSiteId");
    private final static QName _AxdEntityCustTableCurrency_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Currency");
    private final static QName _AxdEntityCustTableLineOfBusinessId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LineOfBusinessId");
    private final static QName _AxdEntityCustTableGiroTypeFreeTextInvoice_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroTypeFreeTextInvoice");
    private final static QName _AxdEntityCustTableCommissionGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CommissionGroup");
    private final static QName _AxdEntityCustTableDlvMode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DlvMode");
    private final static QName _AxdEntityCustTableSalesGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SalesGroup");
    private final static QName _AxdEntityCustTableAccountNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "AccountNum");
    private final static QName _AxdEntityCustTableBlocked_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "Blocked");
    private final static QName _AxdEntityCustTableGiroTypeProjInvoice_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroTypeProjInvoice");
    private final static QName _AxdEntityCustTableInclTax_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InclTax");
    private final static QName _AxdEntityCustTableInvoiceAddress_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InvoiceAddress");
    private final static QName _AxdEntityCustTableDlvTerm_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DlvTerm");
    private final static QName _AxdEntityCustTableVendAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "VendAccount");
    private final static QName _AxdEntityCustTableUseCashDisc_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "UseCashDisc");
    private final static QName _AxdEntityCustTableEInvoice_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "EInvoice");
    private final static QName _AxdEntityCustTableSalesPoolId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SalesPoolId");
    private final static QName _AxdEntityCustTableCashDisc_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CashDisc");
    private final static QName _AxdEntityCustTableInterCompanyAllowIndirectCreation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InterCompanyAllowIndirectCreation");
    private final static QName _AxdEntityCustTableOurAccountNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OurAccountNum");
    private final static QName _AxdEntityCustTableShipCarrierAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShipCarrierAccount");
    private final static QName _AxdEntityCustTableFiscalCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FiscalCode");
    private final static QName _AxdEntityCustTablePaymSched_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymSched");
    private final static QName _AxdEntityCustTableResidenceForeignCountryRegionIdIT_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ResidenceForeignCountryRegionId_IT");
    private final static QName _AxdEntityCustTableGiroTypeAccountStatement_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroTypeAccountStatement");
    private final static QName _AxdEntityCustTableCreditMax_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditMax");
    private final static QName _AxdEntityCustTableTaxWithholdCalculateTH_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxWithholdCalculate_TH");
    private final static QName _AxdEntityCustTablePaymDayId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymDayId");
    private final static QName _AxdEntityCustTableNumberSequenceGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "numberSequenceGroup");
    private final static QName _AxdEntityCustTablePartyCountry_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PartyCountry");
    private final static QName _AxdEntityCustTableCreditCardAddressVerificationLevel_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CreditCardAddressVerificationLevel");
    private final static QName _AxdEntityCustTableTaxGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxGroup");
    private final static QName _AxdEntityCustTableMandatoryCreditLimit_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MandatoryCreditLimit");
    private final static QName _AxdEntityCustTableFactoringAccount_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FactoringAccount");
    private final static QName _AxdEntityCustTableShipCarrierFuelSurcharge_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShipCarrierFuelSurcharge");
    private final static QName _AxdEntityCustTableDefaultDimension_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DefaultDimension");
    private final static QName _AxdEntityCustTableGiroTypeCollectionletter_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "GiroTypeCollectionletter");
    private final static QName _AxdEntityCustTableInterCompanyAutoCreateOrders_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InterCompanyAutoCreateOrders");
    private final static QName _AxdEntityCustTableMainContactPersonnelNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MainContactPersonnelNumber");
    private final static QName _AxdEntityCustTableSubsegmentId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SubsegmentId");
    private final static QName _AxdEntityCustTableSalesCalendarId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "SalesCalendarId");
    private final static QName _AxdEntityCustTablePaymMode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymMode");
    private final static QName _AxdEntityCustTableMultiLineDisc_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MultiLineDisc");
    private final static QName _AxdEntityCustTableCustItemGroupId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustItemGroupId");
    private final static QName _AxdEntityCustTableCustClassificationId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CustClassificationId");
    private final static QName _AxdEntityCustTablePaymTermId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PaymTermId");
    private final static QName _AxdEntityCustTablePBACustGroupId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "PBACustGroupId");
    private final static QName _AxdEntityCustTableClearingPeriod_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ClearingPeriod");
    private final static QName _AxdEntityCustTableCashDiscBaseDays_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "CashDiscBaseDays");
    private final static QName _AxdEntityCustTableShipCarrierAccountCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShipCarrierAccountCode");
    private final static QName _AxdEntityCustTableShipCarrierBlindShipment_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "ShipCarrierBlindShipment");
    private final static QName _AxdEntityCustTableTaxLicenseNum_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxLicenseNum");
    private final static QName _AxdEntityCustTableWebSalesOrderDisplay_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "WebSalesOrderDisplay");
    private final static QName _AxdEntityCustTableStatisticsGroup_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "StatisticsGroup");
    private final static QName _AxdEntityCustTableInventLocation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "InventLocation");
    private final static QName _AxdEntityCustTableTaxBorderNumberFI_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TaxBorderNumber_FI");
    private final static QName _AxdEntityCustTableOrderEntryDeadlineGroupId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OrderEntryDeadlineGroupId");
    private final static QName _AxdEntityCustTableMainContactWorker_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MainContactWorker");
    private final static QName _AxdEntityCustTableDestinationCodeId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "DestinationCodeId");
    private final static QName _AxdEntityDirPartyOMInternalOrganizationOrganizationType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "OrganizationType");
    private final static QName _AxdEntityPersonNameMiddleName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "MiddleName");
    private final static QName _AxdEntityPersonNameFirstName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "FirstName");
    private final static QName _AxdEntityPersonNameLastName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "LastName");
    private final static QName _AxdEntityDirPartyOMTeamIsActive_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "IsActive");
    private final static QName _AxdEntityDirPartyOMTeamTeamAdministrator_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "TeamAdministrator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.customer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyDirOrganization }
     * 
     */
    public AxdEntityDirPartyDirOrganization createAxdEntityDirPartyDirOrganization() {
        return new AxdEntityDirPartyDirOrganization();
    }

    /**
     * Create an instance of {@link AxdEntityOrganizationName }
     * 
     */
    public AxdEntityOrganizationName createAxdEntityOrganizationName() {
        return new AxdEntityOrganizationName();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyDirPartyTable }
     * 
     */
    public AxdEntityDirPartyDirPartyTable createAxdEntityDirPartyDirPartyTable() {
        return new AxdEntityDirPartyDirPartyTable();
    }

    /**
     * Create an instance of {@link AxdEntityPersonName }
     * 
     */
    public AxdEntityPersonName createAxdEntityPersonName() {
        return new AxdEntityPersonName();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyOMTeam }
     * 
     */
    public AxdEntityDirPartyOMTeam createAxdEntityDirPartyOMTeam() {
        return new AxdEntityDirPartyOMTeam();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyCompanyInfo }
     * 
     */
    public AxdEntityDirPartyCompanyInfo createAxdEntityDirPartyCompanyInfo() {
        return new AxdEntityDirPartyCompanyInfo();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyDirOrganizationBase }
     * 
     */
    public AxdEntityDirPartyDirOrganizationBase createAxdEntityDirPartyDirOrganizationBase() {
        return new AxdEntityDirPartyDirOrganizationBase();
    }

    /**
     * Create an instance of {@link AxdCustomer }
     * 
     */
    public AxdCustomer createAxdCustomer() {
        return new AxdCustomer();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyOMOperatingUnit }
     * 
     */
    public AxdEntityDirPartyOMOperatingUnit createAxdEntityDirPartyOMOperatingUnit() {
        return new AxdEntityDirPartyOMOperatingUnit();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyDirPerson }
     * 
     */
    public AxdEntityDirPartyDirPerson createAxdEntityDirPartyDirPerson() {
        return new AxdEntityDirPartyDirPerson();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyPostalAddressView }
     * 
     */
    public AxdEntityDirPartyPostalAddressView createAxdEntityDirPartyPostalAddressView() {
        return new AxdEntityDirPartyPostalAddressView();
    }

    /**
     * Create an instance of {@link AxdEntityCustTable }
     * 
     */
    public AxdEntityCustTable createAxdEntityCustTable() {
        return new AxdEntityCustTable();
    }

    /**
     * Create an instance of {@link AxdEntityDirPartyContactInfoView }
     * 
     */
    public AxdEntityDirPartyContactInfoView createAxdEntityDirPartyContactInfoView() {
        return new AxdEntityDirPartyContactInfoView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Customer")
    public JAXBElement<AxdCustomer> createCustomer(AxdCustomer value) {
        return new JAXBElement<AxdCustomer>(_Customer_QNAME, AxdCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PhoneticName", scope = AxdEntityDirPartyDirOrganizationBase.class)
    public JAXBElement<String> createAxdEntityDirPartyDirOrganizationBasePhoneticName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirOrganizationBasePhoneticName_QNAME, String.class, AxdEntityDirPartyDirOrganizationBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DunsNumberRecId", scope = AxdEntityDirPartyDirOrganizationBase.class)
    public JAXBElement<String> createAxdEntityDirPartyDirOrganizationBaseDunsNumberRecId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirOrganizationBaseDunsNumberRecId_QNAME, String.class, AxdEntityDirPartyDirOrganizationBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Rfc_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoRfcMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoRfcMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LegalRepresentativeName_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoLegalRepresentativeNameMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoLegalRepresentativeNameMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ImportVATNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoImportVATNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoImportVATNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCompanyTypeMX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyType_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumCompanyTypeMX> createAxdEntityDirPartyCompanyInfoCompanyTypeMX(AxdEnumCompanyTypeMX value) {
        return new JAXBElement<AxdEnumCompanyTypeMX>(_AxdEntityDirPartyCompanyInfoCompanyTypeMX_QNAME, AxdEnumCompanyTypeMX.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "VATNumBranchId", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoVATNumBranchId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoVATNumBranchId_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BusinessNumber_CA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBusinessNumberCA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBusinessNumberCA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankCentralBankPurposeCode", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBankCentralBankPurposeCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBankCentralBankPurposeCode_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroContract", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoGiroContract(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoGiroContract_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DBA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoDBA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoDBA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Bank", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBank(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBank_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "VATNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoVATNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoVATNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ActivityCode", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoActivityCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoActivityCode_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "StateInscription_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoStateInscriptionMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoStateInscriptionMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SoftwareIdentificationCode_CA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoSoftwareIdentificationCodeCA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoSoftwareIdentificationCodeCA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustomsLicenseNumber_FI", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCustomsLicenseNumberFI(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCustomsLicenseNumberFI_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FICreditorID_DK", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoFICreditorIDDK(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoFICreditorIDDK_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099LastFilingIndicator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LastFilingIndicator", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdExtTypeTax1099LastFilingIndicator> createAxdEntityDirPartyCompanyInfoLastFilingIndicator(AxdExtTypeTax1099LastFilingIndicator value) {
        return new JAXBElement<AxdExtTypeTax1099LastFilingIndicator>(_AxdEntityDirPartyCompanyInfoLastFilingIndicator_QNAME, AxdExtTypeTax1099LastFilingIndicator.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BranchId", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBranchId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBranchId_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Giro", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoGiro(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoGiro_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsConsolidationCompany", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyCompanyInfoIsConsolidationCompany(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyCompanyInfoIsConsolidationCompany_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankAcctUsedFor1099", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBankAcctUsedFor1099(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBankAcctUsedFor1099_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumLegalNatureIT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LegalNature_IT", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumLegalNatureIT> createAxdEntityDirPartyCompanyInfoLegalNatureIT(AxdEnumLegalNatureIT value) {
        return new JAXBElement<AxdEnumLegalNatureIT>(_AxdEntityDirPartyCompanyInfoLegalNatureIT_QNAME, AxdEnumLegalNatureIT.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FiscalCode_IT", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoFiscalCodeIT(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoFiscalCodeIT_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymRoutingDNB", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymRoutingDNB(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymRoutingDNB_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankCentralBankPurposeText", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBankCentralBankPurposeText(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBankCentralBankPurposeText_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustomsCustomerNumber_FI", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCustomsCustomerNumberFI(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCustomsCustomerNumberFI_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IntrastatCode", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoIntrastatCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoIntrastatCode_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "UPSNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoUPSNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoUPSNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LegalRepresentativeRfc_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoLegalRepresentativeRfcMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoLegalRepresentativeRfcMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BusinessActivityDesc_SA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBusinessActivityDescSA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBusinessActivityDescSA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymInstruction1", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymInstruction1(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymInstruction1_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymInstruction2", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymInstruction2(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymInstruction2_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxRepresentative", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoTaxRepresentative(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoTaxRepresentative_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymInstruction3", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymInstruction3(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymInstruction3_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymInstruction4", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymInstruction4(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymInstruction4_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LegalFormFR", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoLegalFormFR(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoLegalFormFR_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "validate1099OnEntry", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyCompanyInfoValidate1099OnEntry(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyCompanyInfoValidate1099OnEntry_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyNAFCode", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCompanyNAFCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCompanyNAFCode_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IssuingSignature", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoIssuingSignature(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoIssuingSignature_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Tax1099RegNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoTax1099RegNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoTax1099RegNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PackMaterialFeeLicenseNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPackMaterialFeeLicenseNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPackMaterialFeeLicenseNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ConversionDate", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<XMLGregorianCalendar> createAxdEntityDirPartyCompanyInfoConversionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_AxdEntityDirPartyCompanyInfoConversionDate_QNAME, XMLGregorianCalendar.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "branchNumber", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBranchNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBranchNumber_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BusinessActivity_SA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoBusinessActivitySA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBusinessActivitySA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeTax1099ForeignEntityIndicator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ForeignEntityIndicator", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator> createAxdEntityDirPartyCompanyInfoForeignEntityIndicator(AxdExtTypeTax1099ForeignEntityIndicator value) {
        return new JAXBElement<AxdExtTypeTax1099ForeignEntityIndicator>(_AxdEntityDirPartyCompanyInfoForeignEntityIndicator_QNAME, AxdExtTypeTax1099ForeignEntityIndicator.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "NameControl", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoNameControl(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoNameControl_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroContractAccount", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoGiroContractAccount(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoGiroContractAccount_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FileNumber_SA", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoFileNumberSA(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoFileNumberSA_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OrgId", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoOrgId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoOrgId_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SiaCode", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoSiaCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoSiaCode_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CoRegNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCoRegNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCoRegNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TCC", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoTCC(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoTCC_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PlanningCompany", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyCompanyInfoPlanningCompany(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyCompanyInfoPlanningCompany_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyRegComFR", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCompanyRegComFR(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCompanyRegComFR_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShippingCalendarId", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoShippingCalendarId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoShippingCalendarId_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RegNum", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoRegNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoRegNum_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Key", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<Integer> createAxdEntityDirPartyCompanyInfoKey(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyCompanyInfoKey_QNAME, Integer.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LegalRepresentativeCurp_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoLegalRepresentativeCurpMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoLegalRepresentativeCurpMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Curp_MX", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoCurpMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCurpMX_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "EnterpriseNumber", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoEnterpriseNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoEnterpriseNumber_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ImportVATNumBranchId", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoImportVATNumBranchId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoImportVATNumBranchId_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DVRid", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoDVRid(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoDVRid_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AddrFormat", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoAddrFormat(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoAddrFormat_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsEliminationCompany", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyCompanyInfoIsEliminationCompany(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyCompanyInfoIsEliminationCompany_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymTraderNumber", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<String> createAxdEntityDirPartyCompanyInfoPaymTraderNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPaymTraderNumber_QNAME, String.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CombinedFedStateFiler", scope = AxdEntityDirPartyCompanyInfo.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyCompanyInfoCombinedFedStateFiler(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyCompanyInfoCombinedFedStateFiler_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyCompanyInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidFromDateTime", scope = AxdCustomer.class)
    public JAXBElement<AxdTypeDateTime> createAxdCustomerValidFromDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdCustomerValidFromDateTime_QNAME, AxdTypeDateTime.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DocPurpose", scope = AxdCustomer.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdCustomerDocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdCustomerDocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumAxdValidTimeStateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidTimeStateType", scope = AxdCustomer.class)
    public JAXBElement<AxdEnumAxdValidTimeStateType> createAxdCustomerValidTimeStateType(AxdEnumAxdValidTimeStateType value) {
        return new JAXBElement<AxdEnumAxdValidTimeStateType>(_AxdCustomerValidTimeStateType_QNAME, AxdEnumAxdValidTimeStateType.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidAsOfDateTime", scope = AxdCustomer.class)
    public JAXBElement<AxdTypeDateTime> createAxdCustomerValidAsOfDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdCustomerValidAsOfDateTime_QNAME, AxdTypeDateTime.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SenderId", scope = AxdCustomer.class)
    public JAXBElement<String> createAxdCustomerSenderId(String value) {
        return new JAXBElement<String>(_AxdCustomerSenderId_QNAME, String.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidToDateTime", scope = AxdCustomer.class)
    public JAXBElement<AxdTypeDateTime> createAxdCustomerValidToDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdCustomerValidToDateTime_QNAME, AxdTypeDateTime.class, AxdCustomer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumABC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ABC", scope = AxdEntityDirPartyDirOrganization.class)
    public JAXBElement<AxdEnumABC> createAxdEntityDirPartyDirOrganizationABC(AxdEnumABC value) {
        return new JAXBElement<AxdEnumABC>(_AxdEntityDirPartyDirOrganizationABC_QNAME, AxdEnumABC.class, AxdEntityDirPartyDirOrganization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "NumberOfEmployees", scope = AxdEntityDirPartyDirOrganization.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirOrganizationNumberOfEmployees(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyDirOrganizationNumberOfEmployees_QNAME, Integer.class, AxdEntityDirPartyDirOrganization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OrgNumber", scope = AxdEntityDirPartyDirOrganization.class)
    public JAXBElement<String> createAxdEntityDirPartyDirOrganizationOrgNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirOrganizationOrgNumber_QNAME, String.class, AxdEntityDirPartyDirOrganization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PersonalTitle", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEntityKeyDirNameAffix> createAxdEntityDirPartyDirPersonPersonalTitle(AxdEntityKeyDirNameAffix value) {
        return new JAXBElement<AxdEntityKeyDirNameAffix>(_AxdEntityDirPartyDirPersonPersonalTitle_QNAME, AxdEntityKeyDirNameAffix.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthYear", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirPersonBirthYear(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyDirPersonBirthYear_QNAME, Integer.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ProfessionalSuffix", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonProfessionalSuffix(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonProfessionalSuffix_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PersonalSuffix", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEntityKeyDirNameAffix> createAxdEntityDirPartyDirPersonPersonalSuffix(AxdEntityKeyDirNameAffix value) {
        return new JAXBElement<AxdEntityKeyDirNameAffix>(_AxdEntityDirPartyDirPersonPersonalSuffix_QNAME, AxdEntityKeyDirNameAffix.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PersonSuffix", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonPersonSuffix(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonPersonSuffix_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Gender", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEnumGender> createAxdEntityDirPartyDirPersonGender(AxdEnumGender value) {
        return new JAXBElement<AxdEnumGender>(_AxdEntityDirPartyDirPersonGender_QNAME, AxdEnumGender.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Initials", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonInitials(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonInitials_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "NameSequence", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonNameSequence(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonNameSequence_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumDirPersonMaritalStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MaritalStatus", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEnumDirPersonMaritalStatus> createAxdEntityDirPartyDirPersonMaritalStatus(AxdEnumDirPersonMaritalStatus value) {
        return new JAXBElement<AxdEnumDirPersonMaritalStatus>(_AxdEntityDirPartyDirPersonMaritalStatus_QNAME, AxdEnumDirPersonMaritalStatus.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PersonTitle", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonPersonTitle(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonPersonTitle_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PhoneticMiddleName", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonPhoneticMiddleName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonPhoneticMiddleName_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ChildrenNames", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonChildrenNames(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonChildrenNames_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AnniversaryMonth", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEnumMonthsOfYear> createAxdEntityDirPartyDirPersonAnniversaryMonth(AxdEnumMonthsOfYear value) {
        return new JAXBElement<AxdEnumMonthsOfYear>(_AxdEntityDirPartyDirPersonAnniversaryMonth_QNAME, AxdEnumMonthsOfYear.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Hobbies", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonHobbies(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonHobbies_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthDay", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirPersonBirthDay(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyDirPersonBirthDay_QNAME, Integer.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PhoneticLastName", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonPhoneticLastName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonPhoneticLastName_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PhoneticFirstName", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonPhoneticFirstName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonPhoneticFirstName_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEntityKeyDirPartyLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CommunicatorSignIn", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEntityKeyDirPartyLocation> createAxdEntityDirPartyDirPersonCommunicatorSignIn(AxdEntityKeyDirPartyLocation value) {
        return new JAXBElement<AxdEntityKeyDirPartyLocation>(_AxdEntityDirPartyDirPersonCommunicatorSignIn_QNAME, AxdEntityKeyDirPartyLocation.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AnniversaryDay", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirPersonAnniversaryDay(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyDirPersonAnniversaryDay_QNAME, Integer.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ProfessionalTitle", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPersonProfessionalTitle(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPersonProfessionalTitle_QNAME, String.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthMonth", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<AxdEnumMonthsOfYear> createAxdEntityDirPartyDirPersonBirthMonth(AxdEnumMonthsOfYear value) {
        return new JAXBElement<AxdEnumMonthsOfYear>(_AxdEntityDirPartyDirPersonBirthMonth_QNAME, AxdEnumMonthsOfYear.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AnniversaryYear", scope = AxdEntityDirPartyDirPerson.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirPersonAnniversaryYear(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyDirPersonAnniversaryYear_QNAME, Integer.class, AxdEntityDirPartyDirPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "HcmWorker", scope = AxdEntityDirPartyOMOperatingUnit.class)
    public JAXBElement<String> createAxdEntityDirPartyOMOperatingUnitHcmWorker(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyOMOperatingUnitHcmWorker_QNAME, String.class, AxdEntityDirPartyOMOperatingUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "County", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewCounty(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewCounty_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "District", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<Long> createAxdEntityDirPartyPostalAddressViewDistrict(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewDistrict_QNAME, Long.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "State", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewState(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewState_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Address", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewAddress(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewAddress_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PartyLocation", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<Long> createAxdEntityDirPartyPostalAddressViewPartyLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewPartyLocation_QNAME, Long.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DistrictName", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewDistrictName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewDistrictName_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Longitude", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<BigDecimal> createAxdEntityDirPartyPostalAddressViewLongitude(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityDirPartyPostalAddressViewLongitude_QNAME, BigDecimal.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BuildingCompliment", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewBuildingCompliment(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewBuildingCompliment_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Party", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewParty(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewParty_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Location", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<Long> createAxdEntityDirPartyPostalAddressViewLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewLocation_QNAME, Long.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "StreetNumber", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewStreetNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewStreetNumber_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ZipCode", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewZipCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewZipCode_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeLogisticsIsPrimaryAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsPrimary", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdExtTypeLogisticsIsPrimaryAddress> createAxdEntityDirPartyPostalAddressViewIsPrimary(AxdExtTypeLogisticsIsPrimaryAddress value) {
        return new JAXBElement<AxdExtTypeLogisticsIsPrimaryAddress>(_AxdEntityDirPartyPostalAddressViewIsPrimary_QNAME, AxdExtTypeLogisticsIsPrimaryAddress.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<Long> createAxdEntityDirPartyPostalAddressViewRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "City", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewCity(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewCity_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PostBox", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewPostBox(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewPostBox_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<Integer> createAxdEntityDirPartyPostalAddressViewRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LocationName", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewLocationName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewLocationName_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Latitude", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<BigDecimal> createAxdEntityDirPartyPostalAddressViewLatitude(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityDirPartyPostalAddressViewLatitude_QNAME, BigDecimal.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumTimezone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TimeZone", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdEnumTimezone> createAxdEntityDirPartyPostalAddressViewTimeZone(AxdEnumTimezone value) {
        return new JAXBElement<AxdEnumTimezone>(_AxdEntityDirPartyPostalAddressViewTimeZone_QNAME, AxdEnumTimezone.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidTo", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdExtTypeExpirationDateTime> createAxdEntityDirPartyPostalAddressViewValidTo(AxdExtTypeExpirationDateTime value) {
        return new JAXBElement<AxdExtTypeExpirationDateTime>(_AxdEntityDirPartyPostalAddressViewValidTo_QNAME, AxdExtTypeExpirationDateTime.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Roles", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewRoles(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewRoles_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidFrom", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdExtTypeEffectiveDateTime> createAxdEntityDirPartyPostalAddressViewValidFrom(AxdExtTypeEffectiveDateTime value) {
        return new JAXBElement<AxdExtTypeEffectiveDateTime>(_AxdEntityDirPartyPostalAddressViewValidFrom_QNAME, AxdExtTypeEffectiveDateTime.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Street", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewStreet(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewStreet_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ISOcode", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewISOcode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewISOcode_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeLogisticsIsPrivate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsPrivate", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdExtTypeLogisticsIsPrivate> createAxdEntityDirPartyPostalAddressViewIsPrivate(AxdExtTypeLogisticsIsPrivate value) {
        return new JAXBElement<AxdExtTypeLogisticsIsPrivate>(_AxdEntityDirPartyPostalAddressViewIsPrivate_QNAME, AxdExtTypeLogisticsIsPrivate.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeDirPartyIsLocationOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsLocationOwner", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<AxdExtTypeDirPartyIsLocationOwner> createAxdEntityDirPartyPostalAddressViewIsLocationOwner(AxdExtTypeDirPartyIsLocationOwner value) {
        return new JAXBElement<AxdExtTypeDirPartyIsLocationOwner>(_AxdEntityDirPartyPostalAddressViewIsLocationOwner_QNAME, AxdExtTypeDirPartyIsLocationOwner.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CountryRegionId", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewCountryRegionId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewCountryRegionId_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CountryCurrencyCode", scope = AxdEntityDirPartyPostalAddressView.class)
    public JAXBElement<String> createAxdEntityDirPartyPostalAddressViewCountryCurrencyCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewCountryCurrencyCode_QNAME, String.class, AxdEntityDirPartyPostalAddressView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidFrom", scope = AxdEntityOrganizationName.class)
    public JAXBElement<AxdExtTypeEffectiveDateTime> createAxdEntityOrganizationNameValidFrom(AxdExtTypeEffectiveDateTime value) {
        return new JAXBElement<AxdExtTypeEffectiveDateTime>(_AxdEntityDirPartyPostalAddressViewValidFrom_QNAME, AxdExtTypeEffectiveDateTime.class, AxdEntityOrganizationName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityOrganizationName.class)
    public JAXBElement<Integer> createAxdEntityOrganizationNameRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityOrganizationName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidTo", scope = AxdEntityOrganizationName.class)
    public JAXBElement<AxdExtTypeExpirationDateTime> createAxdEntityOrganizationNameValidTo(AxdExtTypeExpirationDateTime value) {
        return new JAXBElement<AxdExtTypeExpirationDateTime>(_AxdEntityDirPartyPostalAddressViewValidTo_QNAME, AxdExtTypeExpirationDateTime.class, AxdEntityOrganizationName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityOrganizationName.class)
    public JAXBElement<Long> createAxdEntityOrganizationNameRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityOrganizationName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "NameAlias", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTableNameAlias(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableNameAlias_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Name", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTableName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableName_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InstanceRelationType", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<Long> createAxdEntityDirPartyDirPartyTableInstanceRelationType(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyDirPartyTableInstanceRelationType_QNAME, Long.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<Integer> createAxdEntityDirPartyDirPartyTableRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PartyNumber", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTablePartyNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTablePartyNumber_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Memo", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTableMemo(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableMemo_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "KnownAs", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTableKnownAs(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableKnownAs_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LanguageId", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<String> createAxdEntityDirPartyDirPartyTableLanguageId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableLanguageId_QNAME, String.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityDirPartyDirPartyTable.class)
    public JAXBElement<Long> createAxdEntityDirPartyDirPartyTableRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityDirPartyDirPartyTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ElectronicAddress", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Long> createAxdEntityDirPartyContactInfoViewElectronicAddress(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyContactInfoViewElectronicAddress_QNAME, Long.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LocationId", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewLocationId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyContactInfoViewLocationId_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Integer> createAxdEntityDirPartyContactInfoViewRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LocationName", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewLocationName(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewLocationName_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PartyLocation", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Long> createAxdEntityDirPartyContactInfoViewPartyLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewPartyLocation_QNAME, Long.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Locator", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewLocator(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyContactInfoViewLocator_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidTo", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdExtTypeExpirationDateTime> createAxdEntityDirPartyContactInfoViewValidTo(AxdExtTypeExpirationDateTime value) {
        return new JAXBElement<AxdExtTypeExpirationDateTime>(_AxdEntityDirPartyPostalAddressViewValidTo_QNAME, AxdExtTypeExpirationDateTime.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CountryRegionCode", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewCountryRegionCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyContactInfoViewCountryRegionCode_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Roles", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewRoles(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewRoles_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidFrom", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdExtTypeEffectiveDateTime> createAxdEntityDirPartyContactInfoViewValidFrom(AxdExtTypeEffectiveDateTime value) {
        return new JAXBElement<AxdExtTypeEffectiveDateTime>(_AxdEntityDirPartyPostalAddressViewValidFrom_QNAME, AxdExtTypeEffectiveDateTime.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LocatorExtension", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewLocatorExtension(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyContactInfoViewLocatorExtension_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Party", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<String> createAxdEntityDirPartyContactInfoViewParty(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewParty_QNAME, String.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumLogisticsElectronicAddressMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Type", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdEnumLogisticsElectronicAddressMethodType> createAxdEntityDirPartyContactInfoViewType(AxdEnumLogisticsElectronicAddressMethodType value) {
        return new JAXBElement<AxdEnumLogisticsElectronicAddressMethodType>(_AxdEntityDirPartyContactInfoViewType_QNAME, AxdEnumLogisticsElectronicAddressMethodType.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Location", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Long> createAxdEntityDirPartyContactInfoViewLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewLocation_QNAME, Long.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TypeIcon", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Integer> createAxdEntityDirPartyContactInfoViewTypeIcon(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyContactInfoViewTypeIcon_QNAME, Integer.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsPrivate", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyContactInfoViewIsPrivate(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyPostalAddressViewIsPrivate_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeDirPartyIsLocationOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsLocationOwner", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdExtTypeDirPartyIsLocationOwner> createAxdEntityDirPartyContactInfoViewIsLocationOwner(AxdExtTypeDirPartyIsLocationOwner value) {
        return new JAXBElement<AxdExtTypeDirPartyIsLocationOwner>(_AxdEntityDirPartyPostalAddressViewIsLocationOwner_QNAME, AxdExtTypeDirPartyIsLocationOwner.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsPrimary", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyContactInfoViewIsPrimary(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyPostalAddressViewIsPrimary_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityDirPartyContactInfoView.class)
    public JAXBElement<Long> createAxdEntityDirPartyContactInfoViewRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityDirPartyContactInfoView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymSpec", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePaymSpec(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePaymSpec_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Rfc_MX", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableRfcMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoRfcMX_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankAccount", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBankAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableBankAccount_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditCardAddressVerification", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumCreditCardAddressVerification> createAxdEntityCustTableCreditCardAddressVerification(AxdEnumCreditCardAddressVerification value) {
        return new JAXBElement<AxdEnumCreditCardAddressVerification>(_AxdEntityCustTableCreditCardAddressVerification_QNAME, AxdEnumCreditCardAddressVerification.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IdentificationNumber", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableIdentificationNumber(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableIdentificationNumber_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeOneTimeCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OneTimeCustomer", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeOneTimeCustomer> createAxdEntityCustTableOneTimeCustomer(AxdExtTypeOneTimeCustomer value) {
        return new JAXBElement<AxdExtTypeOneTimeCustomer>(_AxdEntityCustTableOneTimeCustomer_QNAME, AxdExtTypeOneTimeCustomer.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "_DocumentHash", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableDocumentHash_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DlvReason", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableDlvReason(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableDlvReason_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeCreditCardAddressVerificationVoid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditCardAddressVerificationVoid", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid> createAxdEntityCustTableCreditCardAddressVerificationVoid(AxdExtTypeCreditCardAddressVerificationVoid value) {
        return new JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid>(_AxdEntityCustTableCreditCardAddressVerificationVoid_QNAME, AxdExtTypeCreditCardAddressVerificationVoid.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeCollectionFee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustExcludeCollectionFee", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeCustExcludeCollectionFee> createAxdEntityCustTableCustExcludeCollectionFee(AxdExtTypeCustExcludeCollectionFee value) {
        return new JAXBElement<AxdExtTypeCustExcludeCollectionFee>(_AxdEntityCustTableCustExcludeCollectionFee_QNAME, AxdExtTypeCustExcludeCollectionFee.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PriceGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePriceGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePriceGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "StateInscription_MX", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableStateInscriptionMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoStateInscriptionMX_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "EinvoiceEANNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableEinvoiceEANNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableEinvoiceEANNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCustAccountStatement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AccountStatement", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumCustAccountStatement> createAxdEntityCustTableAccountStatement(AxdEnumCustAccountStatement value) {
        return new JAXBElement<AxdEnumCustAccountStatement>(_AxdEntityCustTableAccountStatement_QNAME, AxdEnumCustAccountStatement.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PartyState", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePartyState(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePartyState_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyDirectDelivery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InterCompanyDirectDelivery", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeInterCompanyDirectDelivery> createAxdEntityCustTableInterCompanyDirectDelivery(AxdExtTypeInterCompanyDirectDelivery value) {
        return new JAXBElement<AxdExtTypeInterCompanyDirectDelivery>(_AxdEntityCustTableInterCompanyDirectDelivery_QNAME, AxdExtTypeInterCompanyDirectDelivery.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityCustTable.class)
    public JAXBElement<Integer> createAxdEntityCustTableRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCreditCardCVC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditCardCVC", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumCreditCardCVC> createAxdEntityCustTableCreditCardCVC(AxdEnumCreditCardCVC value) {
        return new JAXBElement<AxdEnumCreditCardCVC>(_AxdEntityCustTableCreditCardCVC_QNAME, AxdEnumCreditCardCVC.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LineDisc", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableLineDisc(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableLineDisc_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SyncVersion", scope = AxdEntityCustTable.class)
    public JAXBElement<Long> createAxdEntityCustTableSyncVersion(Long value) {
        return new JAXBElement<Long>(_AxdEntityCustTableSyncVersion_QNAME, Long.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyIdSiret", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCompanyIdSiret(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCompanyIdSiret_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthDate_IT", scope = AxdEntityCustTable.class)
    public JAXBElement<XMLGregorianCalendar> createAxdEntityCustTableBirthDateIT(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_AxdEntityCustTableBirthDateIT_QNAME, XMLGregorianCalendar.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SuppItemGroupId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSuppItemGroupId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSuppItemGroupId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyChainId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCompanyChainId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCompanyChainId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FreightZone", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableFreightZone(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableFreightZone_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInterestId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroTypeInterestNote", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubInterestId> createAxdEntityCustTableGiroTypeInterestNote(AxdExtTypePaymentStubInterestId value) {
        return new JAXBElement<AxdExtTypePaymentStubInterestId>(_AxdEntityCustTableGiroTypeInterestNote_QNAME, AxdExtTypePaymentStubInterestId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankCustPaymIdTable", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBankCustPaymIdTable(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableBankCustPaymIdTable_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShipCarrierId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableShipCarrierId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableShipCarrierId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SyncEntityId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSyncEntityId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSyncEntityId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthPlace_IT", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBirthPlaceIT(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableBirthPlaceIT_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InvoiceAccount", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableInvoiceAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableInvoiceAccount_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "EndDisc", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableEndDisc(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableEndDisc_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MarkupGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableMarkupGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableMarkupGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditRating", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCreditRating(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCreditRating_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BirthCountyCode_IT", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBirthCountyCodeIT(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableBirthCountyCodeIT_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyNAFCode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCompanyNAFCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCompanyNAFCode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SalesDistrictId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSalesDistrictId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSalesDistrictId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PackMaterialFeeLicenseNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePackMaterialFeeLicenseNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoPackMaterialFeeLicenseNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeInterestCharges }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustExcludeInterestCharges", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeCustExcludeInterestCharges> createAxdEntityCustTableCustExcludeInterestCharges(AxdExtTypeCustExcludeInterestCharges value) {
        return new JAXBElement<AxdExtTypeCustExcludeInterestCharges>(_AxdEntityCustTableCustExcludeInterestCharges_QNAME, AxdExtTypeCustExcludeInterestCharges.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeForecastDMPInclude }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ForecastDMPInclude", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeForecastDMPInclude> createAxdEntityCustTableForecastDMPInclude(AxdExtTypeForecastDMPInclude value) {
        return new JAXBElement<AxdExtTypeForecastDMPInclude>(_AxdEntityCustTableForecastDMPInclude_QNAME, AxdExtTypeForecastDMPInclude.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Party", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableParty(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyPostalAddressViewParty_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxWithholdGroup_TH", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableTaxWithholdGroupTH(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableTaxWithholdGroupTH_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ContactPersonId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableContactPersonId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableContactPersonId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroType", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubInvoiceId> createAxdEntityCustTableGiroType(AxdExtTypePaymentStubInvoiceId value) {
        return new JAXBElement<AxdExtTypePaymentStubInvoiceId>(_AxdEntityCustTableGiroType_QNAME, AxdExtTypePaymentStubInvoiceId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SegmentId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSegmentId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSegmentId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InventSiteId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableInventSiteId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableInventSiteId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Currency", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCurrency(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCurrency_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LineOfBusinessId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableLineOfBusinessId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableLineOfBusinessId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroTypeFreeTextInvoice", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubInvoiceId> createAxdEntityCustTableGiroTypeFreeTextInvoice(AxdExtTypePaymentStubInvoiceId value) {
        return new JAXBElement<AxdExtTypePaymentStubInvoiceId>(_AxdEntityCustTableGiroTypeFreeTextInvoice_QNAME, AxdExtTypePaymentStubInvoiceId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CommissionGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCommissionGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCommissionGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DlvMode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableDlvMode(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableDlvMode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SalesGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSalesGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSalesGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "AccountNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableAccountNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableAccountNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeCustBlocked }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Blocked", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeCustBlocked> createAxdEntityCustTableBlocked(AxdExtTypeCustBlocked value) {
        return new JAXBElement<AxdExtTypeCustBlocked>(_AxdEntityCustTableBlocked_QNAME, AxdExtTypeCustBlocked.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Curp_MX", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCurpMX(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoCurpMX_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "EnterpriseNumber", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableEnterpriseNumber(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoEnterpriseNumber_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubProjId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroTypeProjInvoice", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubProjId> createAxdEntityCustTableGiroTypeProjInvoice(AxdExtTypePaymentStubProjId value) {
        return new JAXBElement<AxdExtTypePaymentStubProjId>(_AxdEntityCustTableGiroTypeProjInvoice_QNAME, AxdExtTypePaymentStubProjId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeInclTax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InclTax", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeInclTax> createAxdEntityCustTableInclTax(AxdExtTypeInclTax value) {
        return new JAXBElement<AxdExtTypeInclTax>(_AxdEntityCustTableInclTax_QNAME, AxdExtTypeInclTax.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeCustInvoiceAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InvoiceAddress", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeCustInvoiceAddress> createAxdEntityCustTableInvoiceAddress(AxdExtTypeCustInvoiceAddress value) {
        return new JAXBElement<AxdExtTypeCustInvoiceAddress>(_AxdEntityCustTableInvoiceAddress_QNAME, AxdExtTypeCustInvoiceAddress.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DlvTerm", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableDlvTerm(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableDlvTerm_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "VendAccount", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableVendAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableVendAccount_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCompanyTypeMX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CompanyType_MX", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumCompanyTypeMX> createAxdEntityCustTableCompanyTypeMX(AxdEnumCompanyTypeMX value) {
        return new JAXBElement<AxdEnumCompanyTypeMX>(_AxdEntityDirPartyCompanyInfoCompanyTypeMX_QNAME, AxdEnumCompanyTypeMX.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumUseCashDisc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "UseCashDisc", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumUseCashDisc> createAxdEntityCustTableUseCashDisc(AxdEnumUseCashDisc value) {
        return new JAXBElement<AxdEnumUseCashDisc>(_AxdEntityCustTableUseCashDisc_QNAME, AxdEnumUseCashDisc.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeNoYesId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "EInvoice", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeNoYesId> createAxdEntityCustTableEInvoice(AxdExtTypeNoYesId value) {
        return new JAXBElement<AxdExtTypeNoYesId>(_AxdEntityCustTableEInvoice_QNAME, AxdExtTypeNoYesId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SalesPoolId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSalesPoolId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSalesPoolId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CashDisc", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCashDisc(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCashDisc_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankCentralBankPurposeCode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBankCentralBankPurposeCode(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBankCentralBankPurposeCode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAllowIndirectCreation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InterCompanyAllowIndirectCreation", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation> createAxdEntityCustTableInterCompanyAllowIndirectCreation(AxdExtTypeInterCompanyAllowIndirectCreation value) {
        return new JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation>(_AxdEntityCustTableInterCompanyAllowIndirectCreation_QNAME, AxdExtTypeInterCompanyAllowIndirectCreation.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OurAccountNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableOurAccountNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableOurAccountNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShipCarrierAccount", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableShipCarrierAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableShipCarrierAccount_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FiscalCode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableFiscalCode(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableFiscalCode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "VATNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableVATNum(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoVATNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymSched", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePaymSched(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePaymSched_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ResidenceForeignCountryRegionId_IT", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableResidenceForeignCountryRegionIdIT(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableResidenceForeignCountryRegionIdIT_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityCustTable.class)
    public JAXBElement<Long> createAxdEntityCustTableRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubAccountStatementId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroTypeAccountStatement", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubAccountStatementId> createAxdEntityCustTableGiroTypeAccountStatement(AxdExtTypePaymentStubAccountStatementId value) {
        return new JAXBElement<AxdExtTypePaymentStubAccountStatementId>(_AxdEntityCustTableGiroTypeAccountStatement_QNAME, AxdExtTypePaymentStubAccountStatementId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditMax", scope = AxdEntityCustTable.class)
    public JAXBElement<BigDecimal> createAxdEntityCustTableCreditMax(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityCustTableCreditMax_QNAME, BigDecimal.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeTaxWithholdCalculateTH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxWithholdCalculate_TH", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeTaxWithholdCalculateTH> createAxdEntityCustTableTaxWithholdCalculateTH(AxdExtTypeTaxWithholdCalculateTH value) {
        return new JAXBElement<AxdExtTypeTaxWithholdCalculateTH>(_AxdEntityCustTableTaxWithholdCalculateTH_QNAME, AxdExtTypeTaxWithholdCalculateTH.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "BankCentralBankPurposeText", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableBankCentralBankPurposeText(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoBankCentralBankPurposeText_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymDayId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePaymDayId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePaymDayId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "numberSequenceGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableNumberSequenceGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableNumberSequenceGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PartyCountry", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePartyCountry(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePartyCountry_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerificationLevel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CreditCardAddressVerificationLevel", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumCreditCardAddressVerificationLevel> createAxdEntityCustTableCreditCardAddressVerificationLevel(AxdEnumCreditCardAddressVerificationLevel value) {
        return new JAXBElement<AxdEnumCreditCardAddressVerificationLevel>(_AxdEntityCustTableCreditCardAddressVerificationLevel_QNAME, AxdEnumCreditCardAddressVerificationLevel.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableTaxGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableTaxGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeMandatoryCreditLimit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MandatoryCreditLimit", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeMandatoryCreditLimit> createAxdEntityCustTableMandatoryCreditLimit(AxdExtTypeMandatoryCreditLimit value) {
        return new JAXBElement<AxdExtTypeMandatoryCreditLimit>(_AxdEntityCustTableMandatoryCreditLimit_QNAME, AxdExtTypeMandatoryCreditLimit.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FactoringAccount", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableFactoringAccount(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableFactoringAccount_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierFuelSurcharge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShipCarrierFuelSurcharge", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeShipCarrierFuelSurcharge> createAxdEntityCustTableShipCarrierFuelSurcharge(AxdExtTypeShipCarrierFuelSurcharge value) {
        return new JAXBElement<AxdExtTypeShipCarrierFuelSurcharge>(_AxdEntityCustTableShipCarrierFuelSurcharge_QNAME, AxdExtTypeShipCarrierFuelSurcharge.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDimensionAttributeValueSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DefaultDimension", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdTypeDimensionAttributeValueSet> createAxdEntityCustTableDefaultDimension(AxdTypeDimensionAttributeValueSet value) {
        return new JAXBElement<AxdTypeDimensionAttributeValueSet>(_AxdEntityCustTableDefaultDimension_QNAME, AxdTypeDimensionAttributeValueSet.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubCollectionId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "GiroTypeCollectionletter", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypePaymentStubCollectionId> createAxdEntityCustTableGiroTypeCollectionletter(AxdExtTypePaymentStubCollectionId value) {
        return new JAXBElement<AxdExtTypePaymentStubCollectionId>(_AxdEntityCustTableGiroTypeCollectionletter_QNAME, AxdExtTypePaymentStubCollectionId.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "Memo", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableMemo(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyDirPartyTableMemo_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAutoCreateOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InterCompanyAutoCreateOrders", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders> createAxdEntityCustTableInterCompanyAutoCreateOrders(AxdExtTypeInterCompanyAutoCreateOrders value) {
        return new JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders>(_AxdEntityCustTableInterCompanyAutoCreateOrders_QNAME, AxdExtTypeInterCompanyAutoCreateOrders.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MainContactPersonnelNumber", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableMainContactPersonnelNumber(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableMainContactPersonnelNumber_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SubsegmentId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSubsegmentId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSubsegmentId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "SalesCalendarId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableSalesCalendarId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableSalesCalendarId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymMode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePaymMode(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePaymMode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MultiLineDisc", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableMultiLineDisc(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableMultiLineDisc_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustItemGroupId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCustItemGroupId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCustItemGroupId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CustClassificationId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableCustClassificationId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableCustClassificationId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PaymTermId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePaymTermId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePaymTermId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "PBACustGroupId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTablePBACustGroupId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTablePBACustGroupId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OrgId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableOrgId(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyCompanyInfoOrgId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ClearingPeriod", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableClearingPeriod(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableClearingPeriod_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "CashDiscBaseDays", scope = AxdEntityCustTable.class)
    public JAXBElement<Integer> createAxdEntityCustTableCashDiscBaseDays(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityCustTableCashDiscBaseDays_QNAME, Integer.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShipCarrierAccountCode", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableShipCarrierAccountCode(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableShipCarrierAccountCode_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierBlindShipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ShipCarrierBlindShipment", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdExtTypeShipCarrierBlindShipment> createAxdEntityCustTableShipCarrierBlindShipment(AxdExtTypeShipCarrierBlindShipment value) {
        return new JAXBElement<AxdExtTypeShipCarrierBlindShipment>(_AxdEntityCustTableShipCarrierBlindShipment_QNAME, AxdExtTypeShipCarrierBlindShipment.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxLicenseNum", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableTaxLicenseNum(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableTaxLicenseNum_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumECPsalesOrdersViewType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "WebSalesOrderDisplay", scope = AxdEntityCustTable.class)
    public JAXBElement<AxdEnumECPsalesOrdersViewType> createAxdEntityCustTableWebSalesOrderDisplay(AxdEnumECPsalesOrdersViewType value) {
        return new JAXBElement<AxdEnumECPsalesOrdersViewType>(_AxdEntityCustTableWebSalesOrderDisplay_QNAME, AxdEnumECPsalesOrdersViewType.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "StatisticsGroup", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableStatisticsGroup(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableStatisticsGroup_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "InventLocation", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableInventLocation(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableInventLocation_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TaxBorderNumber_FI", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableTaxBorderNumberFI(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableTaxBorderNumberFI_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OrderEntryDeadlineGroupId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableOrderEntryDeadlineGroupId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableOrderEntryDeadlineGroupId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MainContactWorker", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableMainContactWorker(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableMainContactWorker_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "DestinationCodeId", scope = AxdEntityCustTable.class)
    public JAXBElement<String> createAxdEntityCustTableDestinationCodeId(String value) {
        return new JAXBElement<String>(_AxdEntityCustTableDestinationCodeId_QNAME, String.class, AxdEntityCustTable.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumOMInternalOrganizationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "OrganizationType", scope = AxdEntityDirPartyOMInternalOrganization.class)
    public JAXBElement<AxdEnumOMInternalOrganizationType> createAxdEntityDirPartyOMInternalOrganizationOrganizationType(AxdEnumOMInternalOrganizationType value) {
        return new JAXBElement<AxdEnumOMInternalOrganizationType>(_AxdEntityDirPartyOMInternalOrganizationOrganizationType_QNAME, AxdEnumOMInternalOrganizationType.class, AxdEntityDirPartyOMInternalOrganization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "MiddleName", scope = AxdEntityPersonName.class)
    public JAXBElement<String> createAxdEntityPersonNameMiddleName(String value) {
        return new JAXBElement<String>(_AxdEntityPersonNameMiddleName_QNAME, String.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidFrom", scope = AxdEntityPersonName.class)
    public JAXBElement<AxdExtTypeEffectiveDateTime> createAxdEntityPersonNameValidFrom(AxdExtTypeEffectiveDateTime value) {
        return new JAXBElement<AxdExtTypeEffectiveDateTime>(_AxdEntityDirPartyPostalAddressViewValidFrom_QNAME, AxdExtTypeEffectiveDateTime.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecVersion", scope = AxdEntityPersonName.class)
    public JAXBElement<Integer> createAxdEntityPersonNameRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityDirPartyPostalAddressViewRecVersion_QNAME, Integer.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "FirstName", scope = AxdEntityPersonName.class)
    public JAXBElement<String> createAxdEntityPersonNameFirstName(String value) {
        return new JAXBElement<String>(_AxdEntityPersonNameFirstName_QNAME, String.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "ValidTo", scope = AxdEntityPersonName.class)
    public JAXBElement<AxdExtTypeExpirationDateTime> createAxdEntityPersonNameValidTo(AxdExtTypeExpirationDateTime value) {
        return new JAXBElement<AxdExtTypeExpirationDateTime>(_AxdEntityDirPartyPostalAddressViewValidTo_QNAME, AxdExtTypeExpirationDateTime.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "LastName", scope = AxdEntityPersonName.class)
    public JAXBElement<String> createAxdEntityPersonNameLastName(String value) {
        return new JAXBElement<String>(_AxdEntityPersonNameLastName_QNAME, String.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "RecId", scope = AxdEntityPersonName.class)
    public JAXBElement<Long> createAxdEntityPersonNameRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityDirPartyPostalAddressViewRecId_QNAME, Long.class, AxdEntityPersonName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "IsActive", scope = AxdEntityDirPartyOMTeam.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityDirPartyOMTeamIsActive(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityDirPartyOMTeamIsActive_QNAME, AxdEnumNoYes.class, AxdEntityDirPartyOMTeam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", name = "TeamAdministrator", scope = AxdEntityDirPartyOMTeam.class)
    public JAXBElement<String> createAxdEntityDirPartyOMTeamTeamAdministrator(String value) {
        return new JAXBElement<String>(_AxdEntityDirPartyOMTeamTeamAdministrator_QNAME, String.class, AxdEntityDirPartyOMTeam.class, value);
    }

}
