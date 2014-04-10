
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.math.BigDecimal;
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
import javax.xml.datatype.XMLGregorianCalendar;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCompanyTypeMX;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardAddressVerification;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardAddressVerificationLevel;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCreditCardCVC;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumCustAccountStatement;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumECPsalesOrdersViewType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumUseCashDisc;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCreditCardAddressVerificationVoid;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustBlocked;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustExcludeCollectionFee;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustExcludeInterestCharges;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeCustInvoiceAddress;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeForecastDMPInclude;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInclTax;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyAllowIndirectCreation;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyAutoCreateOrders;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeInterCompanyDirectDelivery;
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
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeTaxWithholdCalculateTH;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDimensionAttributeValueSet;


/**
 * <p>Java class for AxdEntity_CustTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_CustTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_DocumentHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustAccount_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="AccountStatement" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CustAccountStatement" minOccurs="0"/>
 *         &lt;element name="BankAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustBankAccountId" minOccurs="0"/>
 *         &lt;element name="BankCentralBankPurposeCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCentralBankPurposeCode" minOccurs="0"/>
 *         &lt;element name="BankCentralBankPurposeText" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCentralBankPurposeText" minOccurs="0"/>
 *         &lt;element name="BankCustPaymIdTable" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCustPaymIdType" minOccurs="0"/>
 *         &lt;element name="BirthCountyCode_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressCountyCode_IT" minOccurs="0"/>
 *         &lt;element name="BirthDate_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BirthDate" minOccurs="0"/>
 *         &lt;element name="BirthPlace_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressCity" minOccurs="0"/>
 *         &lt;element name="Blocked" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustBlocked" minOccurs="0"/>
 *         &lt;element name="CashDisc" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustCashDiscCode" minOccurs="0"/>
 *         &lt;element name="CashDiscBaseDays" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CashDiscBaseDays" minOccurs="0"/>
 *         &lt;element name="ClearingPeriod" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustClearingPeriod" minOccurs="0"/>
 *         &lt;element name="CommissionGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CommissCustomerGroup" minOccurs="0"/>
 *         &lt;element name="CompanyChainId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_smmChainId" minOccurs="0"/>
 *         &lt;element name="CompanyIdSiret" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyIdSiret" minOccurs="0"/>
 *         &lt;element name="CompanyNAFCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CompanyIdNAF" minOccurs="0"/>
 *         &lt;element name="CompanyType_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CompanyType_MX" minOccurs="0"/>
 *         &lt;element name="ContactPersonId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ContactPersonId" minOccurs="0"/>
 *         &lt;element name="CreditCardAddressVerification" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CreditCardAddressVerification" minOccurs="0"/>
 *         &lt;element name="CreditCardAddressVerificationLevel" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CreditCardAddressVerificationLevel" minOccurs="0"/>
 *         &lt;element name="CreditCardAddressVerificationVoid" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CreditCardAddressVerificationVoid" minOccurs="0"/>
 *         &lt;element name="CreditCardCVC" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CreditCardCVC" minOccurs="0"/>
 *         &lt;element name="CreditMax" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustCreditMaxMST" minOccurs="0"/>
 *         &lt;element name="CreditRating" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustCreditRating" minOccurs="0"/>
 *         &lt;element name="Curp_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Curp_MX" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustCurrencyCode_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="CustClassificationId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustClassificationId" minOccurs="0"/>
 *         &lt;element name="CustExcludeCollectionFee" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustExcludeCollectionFee" minOccurs="0"/>
 *         &lt;element name="CustExcludeInterestCharges" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustExcludeInterestCharges" minOccurs="0"/>
 *         &lt;element name="CustGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustGroupId"/>
 *         &lt;element name="CustItemGroupId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustItemGroupId" minOccurs="0"/>
 *         &lt;element name="DefaultDimension" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DimensionAttributeValueSet" minOccurs="0"/>
 *         &lt;element name="DestinationCodeId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustDestinationCodeId" minOccurs="0"/>
 *         &lt;element name="DlvMode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustDlvModeId_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="DlvReason" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DlvReasonId" minOccurs="0"/>
 *         &lt;element name="DlvTerm" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustDlvTermId_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="EInvoice" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NoYesId" minOccurs="0"/>
 *         &lt;element name="EinvoiceEANNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EinvoiceEANNum" minOccurs="0"/>
 *         &lt;element name="EndDisc" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustEndDiscCode" minOccurs="0"/>
 *         &lt;element name="EnterpriseNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxEnterpriseNumber" minOccurs="0"/>
 *         &lt;element name="FactoringAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankCustFactoringAccount" minOccurs="0"/>
 *         &lt;element name="FiscalCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_FiscalCode" minOccurs="0"/>
 *         &lt;element name="ForecastDMPInclude" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ForecastDMPInclude" minOccurs="0"/>
 *         &lt;element name="FreightZone" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustFreightZoneId" minOccurs="0"/>
 *         &lt;element name="GiroType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubInvoiceId" minOccurs="0"/>
 *         &lt;element name="GiroTypeAccountStatement" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubAccountStatementId" minOccurs="0"/>
 *         &lt;element name="GiroTypeCollectionletter" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubCollectionId" minOccurs="0"/>
 *         &lt;element name="GiroTypeFreeTextInvoice" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubInvoiceId" minOccurs="0"/>
 *         &lt;element name="GiroTypeInterestNote" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubInterestId" minOccurs="0"/>
 *         &lt;element name="GiroTypeProjInvoice" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymentStubProjId" minOccurs="0"/>
 *         &lt;element name="IdentificationNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustIdentificationNumber" minOccurs="0"/>
 *         &lt;element name="InclTax" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InclTax" minOccurs="0"/>
 *         &lt;element name="InterCompanyAllowIndirectCreation" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InterCompanyAllowIndirectCreation" minOccurs="0"/>
 *         &lt;element name="InterCompanyAutoCreateOrders" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InterCompanyAutoCreateOrders" minOccurs="0"/>
 *         &lt;element name="InterCompanyDirectDelivery" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InterCompanyDirectDelivery" minOccurs="0"/>
 *         &lt;element name="InventLocation" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InventLocationId" minOccurs="0"/>
 *         &lt;element name="InventSiteId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InventSiteId" minOccurs="0"/>
 *         &lt;element name="InvoiceAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_CustInvoiceAccount_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="InvoiceAddress" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustInvoiceAddress" minOccurs="0"/>
 *         &lt;element name="LineDisc" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustLineDiscCode" minOccurs="0"/>
 *         &lt;element name="LineOfBusinessId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustLineOfBusinessId" minOccurs="0"/>
 *         &lt;element name="MainContactPersonnelNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_HcmPersonnelNumberId" minOccurs="0"/>
 *         &lt;element name="MainContactWorker" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber" minOccurs="0"/>
 *         &lt;element name="MandatoryCreditLimit" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_MandatoryCreditLimit" minOccurs="0"/>
 *         &lt;element name="MarkupGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustMarkupGroupId" minOccurs="0"/>
 *         &lt;element name="Memo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_smmBusRelMemo" minOccurs="0"/>
 *         &lt;element name="MultiLineDisc" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustMultiLineDiscCode" minOccurs="0"/>
 *         &lt;element name="numberSequenceGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NumberSequenceGroupId" minOccurs="0"/>
 *         &lt;element name="OneTimeCustomer" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_OneTimeCustomer" minOccurs="0"/>
 *         &lt;element name="OrderEntryDeadlineGroupId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InventOrderEntryDeadlineGroupId" minOccurs="0"/>
 *         &lt;element name="OrgId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_OrgId" minOccurs="0"/>
 *         &lt;element name="OurAccountNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustAccountExt" minOccurs="0"/>
 *         &lt;element name="PackMaterialFeeLicenseNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_InventPackingMaterialFeeLicenseNum" minOccurs="0"/>
 *         &lt;element name="Party" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber" minOccurs="0"/>
 *         &lt;element name="PartyCountry" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressCountryRegionId" minOccurs="0"/>
 *         &lt;element name="PartyState" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressStateId" minOccurs="0"/>
 *         &lt;element name="PaymDayId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPaymDayId" minOccurs="0"/>
 *         &lt;element name="PaymMode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPaymMode" minOccurs="0"/>
 *         &lt;element name="PaymSched" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymSchedId" minOccurs="0"/>
 *         &lt;element name="PaymSpec" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PaymSpec" minOccurs="0"/>
 *         &lt;element name="PaymTermId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPaymTermId" minOccurs="0"/>
 *         &lt;element name="PBACustGroupId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PBACustGroupId" minOccurs="0"/>
 *         &lt;element name="PriceGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustPriceGroup" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="ResidenceForeignCountryRegionId_IT" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressCountryRegionId" minOccurs="0"/>
 *         &lt;element name="Rfc_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Rfc_MX" minOccurs="0"/>
 *         &lt;element name="SalesCalendarId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SalesCalendarId" minOccurs="0"/>
 *         &lt;element name="SalesDistrictId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_smmSalesDistrictId" minOccurs="0"/>
 *         &lt;element name="SalesGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CommissSalesGroup" minOccurs="0"/>
 *         &lt;element name="SalesPoolId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustSalesPoolId" minOccurs="0"/>
 *         &lt;element name="SegmentId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_smmSegmentId" minOccurs="0"/>
 *         &lt;element name="ShipCarrierAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ShipCarrierAccount" minOccurs="0"/>
 *         &lt;element name="ShipCarrierAccountCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ShipCarrierAccountCode" minOccurs="0"/>
 *         &lt;element name="ShipCarrierBlindShipment" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ShipCarrierBlindShipment" minOccurs="0"/>
 *         &lt;element name="ShipCarrierFuelSurcharge" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ShipCarrierFuelSurcharge" minOccurs="0"/>
 *         &lt;element name="ShipCarrierId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ShipCarrierId" minOccurs="0"/>
 *         &lt;element name="StateInscription_MX" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_StateInscription_MX" minOccurs="0"/>
 *         &lt;element name="StatisticsGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustStatGroupId" minOccurs="0"/>
 *         &lt;element name="SubsegmentId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_smmSubsegmentId" minOccurs="0"/>
 *         &lt;element name="SuppItemGroupId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CustSuppItemGroupId" minOccurs="0"/>
 *         &lt;element name="SyncEntityId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SyncEntityId" minOccurs="0"/>
 *         &lt;element name="SyncVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SyncVersion" minOccurs="0"/>
 *         &lt;element name="TaxBorderNumber_FI" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxBorderNumber_FI" minOccurs="0"/>
 *         &lt;element name="TaxGroup" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxGroup" minOccurs="0"/>
 *         &lt;element name="TaxLicenseNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxPackagingLicenseNum" minOccurs="0"/>
 *         &lt;element name="TaxWithholdCalculate_TH" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxWithholdCalculate_TH" minOccurs="0"/>
 *         &lt;element name="TaxWithholdGroup_TH" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TaxWithholdGroup" minOccurs="0"/>
 *         &lt;element name="UseCashDisc" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_UseCashDisc" minOccurs="0"/>
 *         &lt;element name="VATNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_VATNum" minOccurs="0"/>
 *         &lt;element name="VendAccount" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_VendAccount_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="WebSalesOrderDisplay" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_ECPsalesOrdersViewType" minOccurs="0"/>
 *         &lt;element name="DirParty" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_DirPartyTable" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_CustTable", propOrder = {
    "documentHash",
    "accountNum",
    "accountStatement",
    "bankAccount",
    "bankCentralBankPurposeCode",
    "bankCentralBankPurposeText",
    "bankCustPaymIdTable",
    "birthCountyCodeIT",
    "birthDateIT",
    "birthPlaceIT",
    "blocked",
    "cashDisc",
    "cashDiscBaseDays",
    "clearingPeriod",
    "commissionGroup",
    "companyChainId",
    "companyIdSiret",
    "companyNAFCode",
    "companyTypeMX",
    "contactPersonId",
    "creditCardAddressVerification",
    "creditCardAddressVerificationLevel",
    "creditCardAddressVerificationVoid",
    "creditCardCVC",
    "creditMax",
    "creditRating",
    "curpMX",
    "currency",
    "custClassificationId",
    "custExcludeCollectionFee",
    "custExcludeInterestCharges",
    "custGroup",
    "custItemGroupId",
    "defaultDimension",
    "destinationCodeId",
    "dlvMode",
    "dlvReason",
    "dlvTerm",
    "eInvoice",
    "einvoiceEANNum",
    "endDisc",
    "enterpriseNumber",
    "factoringAccount",
    "fiscalCode",
    "forecastDMPInclude",
    "freightZone",
    "giroType",
    "giroTypeAccountStatement",
    "giroTypeCollectionletter",
    "giroTypeFreeTextInvoice",
    "giroTypeInterestNote",
    "giroTypeProjInvoice",
    "identificationNumber",
    "inclTax",
    "interCompanyAllowIndirectCreation",
    "interCompanyAutoCreateOrders",
    "interCompanyDirectDelivery",
    "inventLocation",
    "inventSiteId",
    "invoiceAccount",
    "invoiceAddress",
    "lineDisc",
    "lineOfBusinessId",
    "mainContactPersonnelNumber",
    "mainContactWorker",
    "mandatoryCreditLimit",
    "markupGroup",
    "memo",
    "multiLineDisc",
    "numberSequenceGroup",
    "oneTimeCustomer",
    "orderEntryDeadlineGroupId",
    "orgId",
    "ourAccountNum",
    "packMaterialFeeLicenseNum",
    "party",
    "partyCountry",
    "partyState",
    "paymDayId",
    "paymMode",
    "paymSched",
    "paymSpec",
    "paymTermId",
    "pbaCustGroupId",
    "priceGroup",
    "recId",
    "recVersion",
    "residenceForeignCountryRegionIdIT",
    "rfcMX",
    "salesCalendarId",
    "salesDistrictId",
    "salesGroup",
    "salesPoolId",
    "segmentId",
    "shipCarrierAccount",
    "shipCarrierAccountCode",
    "shipCarrierBlindShipment",
    "shipCarrierFuelSurcharge",
    "shipCarrierId",
    "stateInscriptionMX",
    "statisticsGroup",
    "subsegmentId",
    "suppItemGroupId",
    "syncEntityId",
    "syncVersion",
    "taxBorderNumberFI",
    "taxGroup",
    "taxLicenseNum",
    "taxWithholdCalculateTH",
    "taxWithholdGroupTH",
    "useCashDisc",
    "vatNum",
    "vendAccount",
    "webSalesOrderDisplay",
    "dirParty"
})
public class AxdEntityCustTable {

    @XmlElementRef(name = "_DocumentHash", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> documentHash;
    @XmlElementRef(name = "AccountNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> accountNum;
    @XmlElementRef(name = "AccountStatement", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCustAccountStatement> accountStatement;
    @XmlElementRef(name = "BankAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankAccount;
    @XmlElementRef(name = "BankCentralBankPurposeCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankCentralBankPurposeCode;
    @XmlElementRef(name = "BankCentralBankPurposeText", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankCentralBankPurposeText;
    @XmlElementRef(name = "BankCustPaymIdTable", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> bankCustPaymIdTable;
    @XmlElementRef(name = "BirthCountyCode_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> birthCountyCodeIT;
    @XmlElementRef(name = "BirthDate_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> birthDateIT;
    @XmlElementRef(name = "BirthPlace_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> birthPlaceIT;
    @XmlElementRef(name = "Blocked", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeCustBlocked> blocked;
    @XmlElementRef(name = "CashDisc", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> cashDisc;
    @XmlElementRef(name = "CashDiscBaseDays", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> cashDiscBaseDays;
    @XmlElementRef(name = "ClearingPeriod", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> clearingPeriod;
    @XmlElementRef(name = "CommissionGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> commissionGroup;
    @XmlElementRef(name = "CompanyChainId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> companyChainId;
    @XmlElementRef(name = "CompanyIdSiret", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> companyIdSiret;
    @XmlElementRef(name = "CompanyNAFCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> companyNAFCode;
    @XmlElementRef(name = "CompanyType_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCompanyTypeMX> companyTypeMX;
    @XmlElementRef(name = "ContactPersonId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> contactPersonId;
    @XmlElementRef(name = "CreditCardAddressVerification", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCreditCardAddressVerification> creditCardAddressVerification;
    @XmlElementRef(name = "CreditCardAddressVerificationLevel", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCreditCardAddressVerificationLevel> creditCardAddressVerificationLevel;
    @XmlElementRef(name = "CreditCardAddressVerificationVoid", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid> creditCardAddressVerificationVoid;
    @XmlElementRef(name = "CreditCardCVC", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumCreditCardCVC> creditCardCVC;
    @XmlElementRef(name = "CreditMax", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> creditMax;
    @XmlElementRef(name = "CreditRating", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> creditRating;
    @XmlElementRef(name = "Curp_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> curpMX;
    @XmlElementRef(name = "Currency", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> currency;
    @XmlElementRef(name = "CustClassificationId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> custClassificationId;
    @XmlElementRef(name = "CustExcludeCollectionFee", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeCustExcludeCollectionFee> custExcludeCollectionFee;
    @XmlElementRef(name = "CustExcludeInterestCharges", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeCustExcludeInterestCharges> custExcludeInterestCharges;
    @XmlElement(name = "CustGroup", required = true)
    protected String custGroup;
    @XmlElementRef(name = "CustItemGroupId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> custItemGroupId;
    @XmlElementRef(name = "DefaultDimension", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdTypeDimensionAttributeValueSet> defaultDimension;
    @XmlElementRef(name = "DestinationCodeId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> destinationCodeId;
    @XmlElementRef(name = "DlvMode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dlvMode;
    @XmlElementRef(name = "DlvReason", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dlvReason;
    @XmlElementRef(name = "DlvTerm", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dlvTerm;
    @XmlElementRef(name = "EInvoice", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeNoYesId> eInvoice;
    @XmlElementRef(name = "EinvoiceEANNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> einvoiceEANNum;
    @XmlElementRef(name = "EndDisc", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> endDisc;
    @XmlElementRef(name = "EnterpriseNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> enterpriseNumber;
    @XmlElementRef(name = "FactoringAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> factoringAccount;
    @XmlElementRef(name = "FiscalCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> fiscalCode;
    @XmlElementRef(name = "ForecastDMPInclude", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeForecastDMPInclude> forecastDMPInclude;
    @XmlElementRef(name = "FreightZone", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> freightZone;
    @XmlElementRef(name = "GiroType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubInvoiceId> giroType;
    @XmlElementRef(name = "GiroTypeAccountStatement", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubAccountStatementId> giroTypeAccountStatement;
    @XmlElementRef(name = "GiroTypeCollectionletter", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubCollectionId> giroTypeCollectionletter;
    @XmlElementRef(name = "GiroTypeFreeTextInvoice", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubInvoiceId> giroTypeFreeTextInvoice;
    @XmlElementRef(name = "GiroTypeInterestNote", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubInterestId> giroTypeInterestNote;
    @XmlElementRef(name = "GiroTypeProjInvoice", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypePaymentStubProjId> giroTypeProjInvoice;
    @XmlElementRef(name = "IdentificationNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> identificationNumber;
    @XmlElementRef(name = "InclTax", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeInclTax> inclTax;
    @XmlElementRef(name = "InterCompanyAllowIndirectCreation", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation> interCompanyAllowIndirectCreation;
    @XmlElementRef(name = "InterCompanyAutoCreateOrders", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders> interCompanyAutoCreateOrders;
    @XmlElementRef(name = "InterCompanyDirectDelivery", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeInterCompanyDirectDelivery> interCompanyDirectDelivery;
    @XmlElementRef(name = "InventLocation", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> inventLocation;
    @XmlElementRef(name = "InventSiteId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> inventSiteId;
    @XmlElementRef(name = "InvoiceAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> invoiceAccount;
    @XmlElementRef(name = "InvoiceAddress", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeCustInvoiceAddress> invoiceAddress;
    @XmlElementRef(name = "LineDisc", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> lineDisc;
    @XmlElementRef(name = "LineOfBusinessId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> lineOfBusinessId;
    @XmlElementRef(name = "MainContactPersonnelNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> mainContactPersonnelNumber;
    @XmlElementRef(name = "MainContactWorker", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> mainContactWorker;
    @XmlElementRef(name = "MandatoryCreditLimit", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeMandatoryCreditLimit> mandatoryCreditLimit;
    @XmlElementRef(name = "MarkupGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> markupGroup;
    @XmlElementRef(name = "Memo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> memo;
    @XmlElementRef(name = "MultiLineDisc", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> multiLineDisc;
    @XmlElementRef(name = "numberSequenceGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> numberSequenceGroup;
    @XmlElementRef(name = "OneTimeCustomer", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeOneTimeCustomer> oneTimeCustomer;
    @XmlElementRef(name = "OrderEntryDeadlineGroupId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> orderEntryDeadlineGroupId;
    @XmlElementRef(name = "OrgId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> orgId;
    @XmlElementRef(name = "OurAccountNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> ourAccountNum;
    @XmlElementRef(name = "PackMaterialFeeLicenseNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> packMaterialFeeLicenseNum;
    @XmlElementRef(name = "Party", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> party;
    @XmlElementRef(name = "PartyCountry", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> partyCountry;
    @XmlElementRef(name = "PartyState", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> partyState;
    @XmlElementRef(name = "PaymDayId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymDayId;
    @XmlElementRef(name = "PaymMode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymMode;
    @XmlElementRef(name = "PaymSched", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymSched;
    @XmlElementRef(name = "PaymSpec", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymSpec;
    @XmlElementRef(name = "PaymTermId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> paymTermId;
    @XmlElementRef(name = "PBACustGroupId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> pbaCustGroupId;
    @XmlElementRef(name = "PriceGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> priceGroup;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "ResidenceForeignCountryRegionId_IT", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> residenceForeignCountryRegionIdIT;
    @XmlElementRef(name = "Rfc_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> rfcMX;
    @XmlElementRef(name = "SalesCalendarId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> salesCalendarId;
    @XmlElementRef(name = "SalesDistrictId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> salesDistrictId;
    @XmlElementRef(name = "SalesGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> salesGroup;
    @XmlElementRef(name = "SalesPoolId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> salesPoolId;
    @XmlElementRef(name = "SegmentId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> segmentId;
    @XmlElementRef(name = "ShipCarrierAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> shipCarrierAccount;
    @XmlElementRef(name = "ShipCarrierAccountCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> shipCarrierAccountCode;
    @XmlElementRef(name = "ShipCarrierBlindShipment", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeShipCarrierBlindShipment> shipCarrierBlindShipment;
    @XmlElementRef(name = "ShipCarrierFuelSurcharge", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeShipCarrierFuelSurcharge> shipCarrierFuelSurcharge;
    @XmlElementRef(name = "ShipCarrierId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> shipCarrierId;
    @XmlElementRef(name = "StateInscription_MX", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> stateInscriptionMX;
    @XmlElementRef(name = "StatisticsGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> statisticsGroup;
    @XmlElementRef(name = "SubsegmentId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> subsegmentId;
    @XmlElementRef(name = "SuppItemGroupId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> suppItemGroupId;
    @XmlElementRef(name = "SyncEntityId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> syncEntityId;
    @XmlElementRef(name = "SyncVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> syncVersion;
    @XmlElementRef(name = "TaxBorderNumber_FI", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> taxBorderNumberFI;
    @XmlElementRef(name = "TaxGroup", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> taxGroup;
    @XmlElementRef(name = "TaxLicenseNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> taxLicenseNum;
    @XmlElementRef(name = "TaxWithholdCalculate_TH", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeTaxWithholdCalculateTH> taxWithholdCalculateTH;
    @XmlElementRef(name = "TaxWithholdGroup_TH", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> taxWithholdGroupTH;
    @XmlElementRef(name = "UseCashDisc", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumUseCashDisc> useCashDisc;
    @XmlElementRef(name = "VATNum", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> vatNum;
    @XmlElementRef(name = "VendAccount", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> vendAccount;
    @XmlElementRef(name = "WebSalesOrderDisplay", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumECPsalesOrdersViewType> webSalesOrderDisplay;
    @XmlElement(name = "DirParty")
    protected List<AxdEntityDirPartyDirPartyTable> dirParty;
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
     * Gets the value of the accountStatement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCustAccountStatement }{@code >}
     *     
     */
    public JAXBElement<AxdEnumCustAccountStatement> getAccountStatement() {
        return accountStatement;
    }

    /**
     * Sets the value of the accountStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCustAccountStatement }{@code >}
     *     
     */
    public void setAccountStatement(JAXBElement<AxdEnumCustAccountStatement> value) {
        this.accountStatement = ((JAXBElement<AxdEnumCustAccountStatement> ) value);
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccount(JAXBElement<String> value) {
        this.bankAccount = ((JAXBElement<String> ) value);
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
     * Gets the value of the bankCustPaymIdTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankCustPaymIdTable() {
        return bankCustPaymIdTable;
    }

    /**
     * Sets the value of the bankCustPaymIdTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankCustPaymIdTable(JAXBElement<String> value) {
        this.bankCustPaymIdTable = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the birthCountyCodeIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthCountyCodeIT() {
        return birthCountyCodeIT;
    }

    /**
     * Sets the value of the birthCountyCodeIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthCountyCodeIT(JAXBElement<String> value) {
        this.birthCountyCodeIT = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the birthDateIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBirthDateIT() {
        return birthDateIT;
    }

    /**
     * Sets the value of the birthDateIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBirthDateIT(JAXBElement<XMLGregorianCalendar> value) {
        this.birthDateIT = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the birthPlaceIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthPlaceIT() {
        return birthPlaceIT;
    }

    /**
     * Sets the value of the birthPlaceIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthPlaceIT(JAXBElement<String> value) {
        this.birthPlaceIT = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the blocked property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustBlocked }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeCustBlocked> getBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustBlocked }{@code >}
     *     
     */
    public void setBlocked(JAXBElement<AxdExtTypeCustBlocked> value) {
        this.blocked = ((JAXBElement<AxdExtTypeCustBlocked> ) value);
    }

    /**
     * Gets the value of the cashDisc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCashDisc() {
        return cashDisc;
    }

    /**
     * Sets the value of the cashDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCashDisc(JAXBElement<String> value) {
        this.cashDisc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cashDiscBaseDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCashDiscBaseDays() {
        return cashDiscBaseDays;
    }

    /**
     * Sets the value of the cashDiscBaseDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCashDiscBaseDays(JAXBElement<Integer> value) {
        this.cashDiscBaseDays = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the clearingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClearingPeriod() {
        return clearingPeriod;
    }

    /**
     * Sets the value of the clearingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClearingPeriod(JAXBElement<String> value) {
        this.clearingPeriod = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the commissionGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCommissionGroup() {
        return commissionGroup;
    }

    /**
     * Sets the value of the commissionGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCommissionGroup(JAXBElement<String> value) {
        this.commissionGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the companyChainId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyChainId() {
        return companyChainId;
    }

    /**
     * Sets the value of the companyChainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyChainId(JAXBElement<String> value) {
        this.companyChainId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the companyIdSiret property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyIdSiret() {
        return companyIdSiret;
    }

    /**
     * Sets the value of the companyIdSiret property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyIdSiret(JAXBElement<String> value) {
        this.companyIdSiret = ((JAXBElement<String> ) value);
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
     * Gets the value of the contactPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContactPersonId() {
        return contactPersonId;
    }

    /**
     * Sets the value of the contactPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContactPersonId(JAXBElement<String> value) {
        this.contactPersonId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the creditCardAddressVerification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerification }{@code >}
     *     
     */
    public JAXBElement<AxdEnumCreditCardAddressVerification> getCreditCardAddressVerification() {
        return creditCardAddressVerification;
    }

    /**
     * Sets the value of the creditCardAddressVerification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerification }{@code >}
     *     
     */
    public void setCreditCardAddressVerification(JAXBElement<AxdEnumCreditCardAddressVerification> value) {
        this.creditCardAddressVerification = ((JAXBElement<AxdEnumCreditCardAddressVerification> ) value);
    }

    /**
     * Gets the value of the creditCardAddressVerificationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerificationLevel }{@code >}
     *     
     */
    public JAXBElement<AxdEnumCreditCardAddressVerificationLevel> getCreditCardAddressVerificationLevel() {
        return creditCardAddressVerificationLevel;
    }

    /**
     * Sets the value of the creditCardAddressVerificationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardAddressVerificationLevel }{@code >}
     *     
     */
    public void setCreditCardAddressVerificationLevel(JAXBElement<AxdEnumCreditCardAddressVerificationLevel> value) {
        this.creditCardAddressVerificationLevel = ((JAXBElement<AxdEnumCreditCardAddressVerificationLevel> ) value);
    }

    /**
     * Gets the value of the creditCardAddressVerificationVoid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCreditCardAddressVerificationVoid }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid> getCreditCardAddressVerificationVoid() {
        return creditCardAddressVerificationVoid;
    }

    /**
     * Sets the value of the creditCardAddressVerificationVoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCreditCardAddressVerificationVoid }{@code >}
     *     
     */
    public void setCreditCardAddressVerificationVoid(JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid> value) {
        this.creditCardAddressVerificationVoid = ((JAXBElement<AxdExtTypeCreditCardAddressVerificationVoid> ) value);
    }

    /**
     * Gets the value of the creditCardCVC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardCVC }{@code >}
     *     
     */
    public JAXBElement<AxdEnumCreditCardCVC> getCreditCardCVC() {
        return creditCardCVC;
    }

    /**
     * Sets the value of the creditCardCVC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumCreditCardCVC }{@code >}
     *     
     */
    public void setCreditCardCVC(JAXBElement<AxdEnumCreditCardCVC> value) {
        this.creditCardCVC = ((JAXBElement<AxdEnumCreditCardCVC> ) value);
    }

    /**
     * Gets the value of the creditMax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCreditMax() {
        return creditMax;
    }

    /**
     * Sets the value of the creditMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCreditMax(JAXBElement<BigDecimal> value) {
        this.creditMax = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the creditRating property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditRating() {
        return creditRating;
    }

    /**
     * Sets the value of the creditRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditRating(JAXBElement<String> value) {
        this.creditRating = ((JAXBElement<String> ) value);
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
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrency(JAXBElement<String> value) {
        this.currency = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the custClassificationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustClassificationId() {
        return custClassificationId;
    }

    /**
     * Sets the value of the custClassificationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustClassificationId(JAXBElement<String> value) {
        this.custClassificationId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the custExcludeCollectionFee property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeCollectionFee }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeCustExcludeCollectionFee> getCustExcludeCollectionFee() {
        return custExcludeCollectionFee;
    }

    /**
     * Sets the value of the custExcludeCollectionFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeCollectionFee }{@code >}
     *     
     */
    public void setCustExcludeCollectionFee(JAXBElement<AxdExtTypeCustExcludeCollectionFee> value) {
        this.custExcludeCollectionFee = ((JAXBElement<AxdExtTypeCustExcludeCollectionFee> ) value);
    }

    /**
     * Gets the value of the custExcludeInterestCharges property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeInterestCharges }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeCustExcludeInterestCharges> getCustExcludeInterestCharges() {
        return custExcludeInterestCharges;
    }

    /**
     * Sets the value of the custExcludeInterestCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustExcludeInterestCharges }{@code >}
     *     
     */
    public void setCustExcludeInterestCharges(JAXBElement<AxdExtTypeCustExcludeInterestCharges> value) {
        this.custExcludeInterestCharges = ((JAXBElement<AxdExtTypeCustExcludeInterestCharges> ) value);
    }

    /**
     * Gets the value of the custGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustGroup() {
        return custGroup;
    }

    /**
     * Sets the value of the custGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustGroup(String value) {
        this.custGroup = value;
    }

    /**
     * Gets the value of the custItemGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustItemGroupId() {
        return custItemGroupId;
    }

    /**
     * Sets the value of the custItemGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustItemGroupId(JAXBElement<String> value) {
        this.custItemGroupId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the defaultDimension property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDimensionAttributeValueSet }{@code >}
     *     
     */
    public JAXBElement<AxdTypeDimensionAttributeValueSet> getDefaultDimension() {
        return defaultDimension;
    }

    /**
     * Sets the value of the defaultDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDimensionAttributeValueSet }{@code >}
     *     
     */
    public void setDefaultDimension(JAXBElement<AxdTypeDimensionAttributeValueSet> value) {
        this.defaultDimension = ((JAXBElement<AxdTypeDimensionAttributeValueSet> ) value);
    }

    /**
     * Gets the value of the destinationCodeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestinationCodeId() {
        return destinationCodeId;
    }

    /**
     * Sets the value of the destinationCodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestinationCodeId(JAXBElement<String> value) {
        this.destinationCodeId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dlvMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDlvMode() {
        return dlvMode;
    }

    /**
     * Sets the value of the dlvMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDlvMode(JAXBElement<String> value) {
        this.dlvMode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dlvReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDlvReason() {
        return dlvReason;
    }

    /**
     * Sets the value of the dlvReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDlvReason(JAXBElement<String> value) {
        this.dlvReason = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dlvTerm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDlvTerm() {
        return dlvTerm;
    }

    /**
     * Sets the value of the dlvTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDlvTerm(JAXBElement<String> value) {
        this.dlvTerm = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the eInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeNoYesId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeNoYesId> getEInvoice() {
        return eInvoice;
    }

    /**
     * Sets the value of the eInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeNoYesId }{@code >}
     *     
     */
    public void setEInvoice(JAXBElement<AxdExtTypeNoYesId> value) {
        this.eInvoice = ((JAXBElement<AxdExtTypeNoYesId> ) value);
    }

    /**
     * Gets the value of the einvoiceEANNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEinvoiceEANNum() {
        return einvoiceEANNum;
    }

    /**
     * Sets the value of the einvoiceEANNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEinvoiceEANNum(JAXBElement<String> value) {
        this.einvoiceEANNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the endDisc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEndDisc() {
        return endDisc;
    }

    /**
     * Sets the value of the endDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEndDisc(JAXBElement<String> value) {
        this.endDisc = ((JAXBElement<String> ) value);
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
     * Gets the value of the factoringAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFactoringAccount() {
        return factoringAccount;
    }

    /**
     * Sets the value of the factoringAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFactoringAccount(JAXBElement<String> value) {
        this.factoringAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fiscalCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Sets the value of the fiscalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiscalCode(JAXBElement<String> value) {
        this.fiscalCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the forecastDMPInclude property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeForecastDMPInclude }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeForecastDMPInclude> getForecastDMPInclude() {
        return forecastDMPInclude;
    }

    /**
     * Sets the value of the forecastDMPInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeForecastDMPInclude }{@code >}
     *     
     */
    public void setForecastDMPInclude(JAXBElement<AxdExtTypeForecastDMPInclude> value) {
        this.forecastDMPInclude = ((JAXBElement<AxdExtTypeForecastDMPInclude> ) value);
    }

    /**
     * Gets the value of the freightZone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreightZone() {
        return freightZone;
    }

    /**
     * Sets the value of the freightZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreightZone(JAXBElement<String> value) {
        this.freightZone = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the giroType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubInvoiceId> getGiroType() {
        return giroType;
    }

    /**
     * Sets the value of the giroType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}
     *     
     */
    public void setGiroType(JAXBElement<AxdExtTypePaymentStubInvoiceId> value) {
        this.giroType = ((JAXBElement<AxdExtTypePaymentStubInvoiceId> ) value);
    }

    /**
     * Gets the value of the giroTypeAccountStatement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubAccountStatementId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubAccountStatementId> getGiroTypeAccountStatement() {
        return giroTypeAccountStatement;
    }

    /**
     * Sets the value of the giroTypeAccountStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubAccountStatementId }{@code >}
     *     
     */
    public void setGiroTypeAccountStatement(JAXBElement<AxdExtTypePaymentStubAccountStatementId> value) {
        this.giroTypeAccountStatement = ((JAXBElement<AxdExtTypePaymentStubAccountStatementId> ) value);
    }

    /**
     * Gets the value of the giroTypeCollectionletter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubCollectionId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubCollectionId> getGiroTypeCollectionletter() {
        return giroTypeCollectionletter;
    }

    /**
     * Sets the value of the giroTypeCollectionletter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubCollectionId }{@code >}
     *     
     */
    public void setGiroTypeCollectionletter(JAXBElement<AxdExtTypePaymentStubCollectionId> value) {
        this.giroTypeCollectionletter = ((JAXBElement<AxdExtTypePaymentStubCollectionId> ) value);
    }

    /**
     * Gets the value of the giroTypeFreeTextInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubInvoiceId> getGiroTypeFreeTextInvoice() {
        return giroTypeFreeTextInvoice;
    }

    /**
     * Sets the value of the giroTypeFreeTextInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInvoiceId }{@code >}
     *     
     */
    public void setGiroTypeFreeTextInvoice(JAXBElement<AxdExtTypePaymentStubInvoiceId> value) {
        this.giroTypeFreeTextInvoice = ((JAXBElement<AxdExtTypePaymentStubInvoiceId> ) value);
    }

    /**
     * Gets the value of the giroTypeInterestNote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInterestId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubInterestId> getGiroTypeInterestNote() {
        return giroTypeInterestNote;
    }

    /**
     * Sets the value of the giroTypeInterestNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubInterestId }{@code >}
     *     
     */
    public void setGiroTypeInterestNote(JAXBElement<AxdExtTypePaymentStubInterestId> value) {
        this.giroTypeInterestNote = ((JAXBElement<AxdExtTypePaymentStubInterestId> ) value);
    }

    /**
     * Gets the value of the giroTypeProjInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubProjId }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypePaymentStubProjId> getGiroTypeProjInvoice() {
        return giroTypeProjInvoice;
    }

    /**
     * Sets the value of the giroTypeProjInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypePaymentStubProjId }{@code >}
     *     
     */
    public void setGiroTypeProjInvoice(JAXBElement<AxdExtTypePaymentStubProjId> value) {
        this.giroTypeProjInvoice = ((JAXBElement<AxdExtTypePaymentStubProjId> ) value);
    }

    /**
     * Gets the value of the identificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the value of the identificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentificationNumber(JAXBElement<String> value) {
        this.identificationNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the inclTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInclTax }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeInclTax> getInclTax() {
        return inclTax;
    }

    /**
     * Sets the value of the inclTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInclTax }{@code >}
     *     
     */
    public void setInclTax(JAXBElement<AxdExtTypeInclTax> value) {
        this.inclTax = ((JAXBElement<AxdExtTypeInclTax> ) value);
    }

    /**
     * Gets the value of the interCompanyAllowIndirectCreation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAllowIndirectCreation }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation> getInterCompanyAllowIndirectCreation() {
        return interCompanyAllowIndirectCreation;
    }

    /**
     * Sets the value of the interCompanyAllowIndirectCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAllowIndirectCreation }{@code >}
     *     
     */
    public void setInterCompanyAllowIndirectCreation(JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation> value) {
        this.interCompanyAllowIndirectCreation = ((JAXBElement<AxdExtTypeInterCompanyAllowIndirectCreation> ) value);
    }

    /**
     * Gets the value of the interCompanyAutoCreateOrders property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAutoCreateOrders }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders> getInterCompanyAutoCreateOrders() {
        return interCompanyAutoCreateOrders;
    }

    /**
     * Sets the value of the interCompanyAutoCreateOrders property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyAutoCreateOrders }{@code >}
     *     
     */
    public void setInterCompanyAutoCreateOrders(JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders> value) {
        this.interCompanyAutoCreateOrders = ((JAXBElement<AxdExtTypeInterCompanyAutoCreateOrders> ) value);
    }

    /**
     * Gets the value of the interCompanyDirectDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyDirectDelivery }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeInterCompanyDirectDelivery> getInterCompanyDirectDelivery() {
        return interCompanyDirectDelivery;
    }

    /**
     * Sets the value of the interCompanyDirectDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeInterCompanyDirectDelivery }{@code >}
     *     
     */
    public void setInterCompanyDirectDelivery(JAXBElement<AxdExtTypeInterCompanyDirectDelivery> value) {
        this.interCompanyDirectDelivery = ((JAXBElement<AxdExtTypeInterCompanyDirectDelivery> ) value);
    }

    /**
     * Gets the value of the inventLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInventLocation() {
        return inventLocation;
    }

    /**
     * Sets the value of the inventLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInventLocation(JAXBElement<String> value) {
        this.inventLocation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the inventSiteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInventSiteId() {
        return inventSiteId;
    }

    /**
     * Sets the value of the inventSiteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInventSiteId(JAXBElement<String> value) {
        this.inventSiteId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoiceAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceAccount() {
        return invoiceAccount;
    }

    /**
     * Sets the value of the invoiceAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceAccount(JAXBElement<String> value) {
        this.invoiceAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoiceAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustInvoiceAddress }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeCustInvoiceAddress> getInvoiceAddress() {
        return invoiceAddress;
    }

    /**
     * Sets the value of the invoiceAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeCustInvoiceAddress }{@code >}
     *     
     */
    public void setInvoiceAddress(JAXBElement<AxdExtTypeCustInvoiceAddress> value) {
        this.invoiceAddress = ((JAXBElement<AxdExtTypeCustInvoiceAddress> ) value);
    }

    /**
     * Gets the value of the lineDisc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLineDisc() {
        return lineDisc;
    }

    /**
     * Sets the value of the lineDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineDisc(JAXBElement<String> value) {
        this.lineDisc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineOfBusinessId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLineOfBusinessId() {
        return lineOfBusinessId;
    }

    /**
     * Sets the value of the lineOfBusinessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineOfBusinessId(JAXBElement<String> value) {
        this.lineOfBusinessId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the mainContactPersonnelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMainContactPersonnelNumber() {
        return mainContactPersonnelNumber;
    }

    /**
     * Sets the value of the mainContactPersonnelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMainContactPersonnelNumber(JAXBElement<String> value) {
        this.mainContactPersonnelNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the mainContactWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMainContactWorker() {
        return mainContactWorker;
    }

    /**
     * Sets the value of the mainContactWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMainContactWorker(JAXBElement<String> value) {
        this.mainContactWorker = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the mandatoryCreditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeMandatoryCreditLimit }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeMandatoryCreditLimit> getMandatoryCreditLimit() {
        return mandatoryCreditLimit;
    }

    /**
     * Sets the value of the mandatoryCreditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeMandatoryCreditLimit }{@code >}
     *     
     */
    public void setMandatoryCreditLimit(JAXBElement<AxdExtTypeMandatoryCreditLimit> value) {
        this.mandatoryCreditLimit = ((JAXBElement<AxdExtTypeMandatoryCreditLimit> ) value);
    }

    /**
     * Gets the value of the markupGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMarkupGroup() {
        return markupGroup;
    }

    /**
     * Sets the value of the markupGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMarkupGroup(JAXBElement<String> value) {
        this.markupGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the memo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemo() {
        return memo;
    }

    /**
     * Sets the value of the memo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemo(JAXBElement<String> value) {
        this.memo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the multiLineDisc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMultiLineDisc() {
        return multiLineDisc;
    }

    /**
     * Sets the value of the multiLineDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMultiLineDisc(JAXBElement<String> value) {
        this.multiLineDisc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the numberSequenceGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumberSequenceGroup() {
        return numberSequenceGroup;
    }

    /**
     * Sets the value of the numberSequenceGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumberSequenceGroup(JAXBElement<String> value) {
        this.numberSequenceGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the oneTimeCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeOneTimeCustomer }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeOneTimeCustomer> getOneTimeCustomer() {
        return oneTimeCustomer;
    }

    /**
     * Sets the value of the oneTimeCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeOneTimeCustomer }{@code >}
     *     
     */
    public void setOneTimeCustomer(JAXBElement<AxdExtTypeOneTimeCustomer> value) {
        this.oneTimeCustomer = ((JAXBElement<AxdExtTypeOneTimeCustomer> ) value);
    }

    /**
     * Gets the value of the orderEntryDeadlineGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderEntryDeadlineGroupId() {
        return orderEntryDeadlineGroupId;
    }

    /**
     * Sets the value of the orderEntryDeadlineGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderEntryDeadlineGroupId(JAXBElement<String> value) {
        this.orderEntryDeadlineGroupId = ((JAXBElement<String> ) value);
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
     * Gets the value of the ourAccountNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOurAccountNum() {
        return ourAccountNum;
    }

    /**
     * Sets the value of the ourAccountNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOurAccountNum(JAXBElement<String> value) {
        this.ourAccountNum = ((JAXBElement<String> ) value);
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
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParty(JAXBElement<String> value) {
        this.party = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partyCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartyCountry() {
        return partyCountry;
    }

    /**
     * Sets the value of the partyCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartyCountry(JAXBElement<String> value) {
        this.partyCountry = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partyState property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartyState() {
        return partyState;
    }

    /**
     * Sets the value of the partyState property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartyState(JAXBElement<String> value) {
        this.partyState = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymDayId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymDayId() {
        return paymDayId;
    }

    /**
     * Sets the value of the paymDayId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymDayId(JAXBElement<String> value) {
        this.paymDayId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymMode() {
        return paymMode;
    }

    /**
     * Sets the value of the paymMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymMode(JAXBElement<String> value) {
        this.paymMode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymSched property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymSched() {
        return paymSched;
    }

    /**
     * Sets the value of the paymSched property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymSched(JAXBElement<String> value) {
        this.paymSched = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymSpec property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymSpec() {
        return paymSpec;
    }

    /**
     * Sets the value of the paymSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymSpec(JAXBElement<String> value) {
        this.paymSpec = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymTermId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymTermId() {
        return paymTermId;
    }

    /**
     * Sets the value of the paymTermId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymTermId(JAXBElement<String> value) {
        this.paymTermId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pbaCustGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPBACustGroupId() {
        return pbaCustGroupId;
    }

    /**
     * Sets the value of the pbaCustGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPBACustGroupId(JAXBElement<String> value) {
        this.pbaCustGroupId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the priceGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPriceGroup() {
        return priceGroup;
    }

    /**
     * Sets the value of the priceGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPriceGroup(JAXBElement<String> value) {
        this.priceGroup = ((JAXBElement<String> ) value);
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
     * Gets the value of the residenceForeignCountryRegionIdIT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResidenceForeignCountryRegionIdIT() {
        return residenceForeignCountryRegionIdIT;
    }

    /**
     * Sets the value of the residenceForeignCountryRegionIdIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResidenceForeignCountryRegionIdIT(JAXBElement<String> value) {
        this.residenceForeignCountryRegionIdIT = ((JAXBElement<String> ) value);
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
     * Gets the value of the salesCalendarId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesCalendarId() {
        return salesCalendarId;
    }

    /**
     * Sets the value of the salesCalendarId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesCalendarId(JAXBElement<String> value) {
        this.salesCalendarId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the salesDistrictId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesDistrictId() {
        return salesDistrictId;
    }

    /**
     * Sets the value of the salesDistrictId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesDistrictId(JAXBElement<String> value) {
        this.salesDistrictId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the salesGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesGroup() {
        return salesGroup;
    }

    /**
     * Sets the value of the salesGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesGroup(JAXBElement<String> value) {
        this.salesGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the salesPoolId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesPoolId() {
        return salesPoolId;
    }

    /**
     * Sets the value of the salesPoolId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesPoolId(JAXBElement<String> value) {
        this.salesPoolId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the segmentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSegmentId() {
        return segmentId;
    }

    /**
     * Sets the value of the segmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSegmentId(JAXBElement<String> value) {
        this.segmentId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shipCarrierAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipCarrierAccount() {
        return shipCarrierAccount;
    }

    /**
     * Sets the value of the shipCarrierAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipCarrierAccount(JAXBElement<String> value) {
        this.shipCarrierAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shipCarrierAccountCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipCarrierAccountCode() {
        return shipCarrierAccountCode;
    }

    /**
     * Sets the value of the shipCarrierAccountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipCarrierAccountCode(JAXBElement<String> value) {
        this.shipCarrierAccountCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shipCarrierBlindShipment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierBlindShipment }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeShipCarrierBlindShipment> getShipCarrierBlindShipment() {
        return shipCarrierBlindShipment;
    }

    /**
     * Sets the value of the shipCarrierBlindShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierBlindShipment }{@code >}
     *     
     */
    public void setShipCarrierBlindShipment(JAXBElement<AxdExtTypeShipCarrierBlindShipment> value) {
        this.shipCarrierBlindShipment = ((JAXBElement<AxdExtTypeShipCarrierBlindShipment> ) value);
    }

    /**
     * Gets the value of the shipCarrierFuelSurcharge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierFuelSurcharge }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeShipCarrierFuelSurcharge> getShipCarrierFuelSurcharge() {
        return shipCarrierFuelSurcharge;
    }

    /**
     * Sets the value of the shipCarrierFuelSurcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeShipCarrierFuelSurcharge }{@code >}
     *     
     */
    public void setShipCarrierFuelSurcharge(JAXBElement<AxdExtTypeShipCarrierFuelSurcharge> value) {
        this.shipCarrierFuelSurcharge = ((JAXBElement<AxdExtTypeShipCarrierFuelSurcharge> ) value);
    }

    /**
     * Gets the value of the shipCarrierId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipCarrierId() {
        return shipCarrierId;
    }

    /**
     * Sets the value of the shipCarrierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipCarrierId(JAXBElement<String> value) {
        this.shipCarrierId = ((JAXBElement<String> ) value);
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
     * Gets the value of the statisticsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatisticsGroup() {
        return statisticsGroup;
    }

    /**
     * Sets the value of the statisticsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatisticsGroup(JAXBElement<String> value) {
        this.statisticsGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the subsegmentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubsegmentId() {
        return subsegmentId;
    }

    /**
     * Sets the value of the subsegmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubsegmentId(JAXBElement<String> value) {
        this.subsegmentId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the suppItemGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSuppItemGroupId() {
        return suppItemGroupId;
    }

    /**
     * Sets the value of the suppItemGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSuppItemGroupId(JAXBElement<String> value) {
        this.suppItemGroupId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the syncEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSyncEntityId() {
        return syncEntityId;
    }

    /**
     * Sets the value of the syncEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSyncEntityId(JAXBElement<String> value) {
        this.syncEntityId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the syncVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSyncVersion() {
        return syncVersion;
    }

    /**
     * Sets the value of the syncVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSyncVersion(JAXBElement<Long> value) {
        this.syncVersion = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the taxBorderNumberFI property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxBorderNumberFI() {
        return taxBorderNumberFI;
    }

    /**
     * Sets the value of the taxBorderNumberFI property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxBorderNumberFI(JAXBElement<String> value) {
        this.taxBorderNumberFI = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taxGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxGroup() {
        return taxGroup;
    }

    /**
     * Sets the value of the taxGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxGroup(JAXBElement<String> value) {
        this.taxGroup = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taxLicenseNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxLicenseNum() {
        return taxLicenseNum;
    }

    /**
     * Sets the value of the taxLicenseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxLicenseNum(JAXBElement<String> value) {
        this.taxLicenseNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taxWithholdCalculateTH property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTaxWithholdCalculateTH }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeTaxWithholdCalculateTH> getTaxWithholdCalculateTH() {
        return taxWithholdCalculateTH;
    }

    /**
     * Sets the value of the taxWithholdCalculateTH property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeTaxWithholdCalculateTH }{@code >}
     *     
     */
    public void setTaxWithholdCalculateTH(JAXBElement<AxdExtTypeTaxWithholdCalculateTH> value) {
        this.taxWithholdCalculateTH = ((JAXBElement<AxdExtTypeTaxWithholdCalculateTH> ) value);
    }

    /**
     * Gets the value of the taxWithholdGroupTH property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxWithholdGroupTH() {
        return taxWithholdGroupTH;
    }

    /**
     * Sets the value of the taxWithholdGroupTH property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxWithholdGroupTH(JAXBElement<String> value) {
        this.taxWithholdGroupTH = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the useCashDisc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumUseCashDisc }{@code >}
     *     
     */
    public JAXBElement<AxdEnumUseCashDisc> getUseCashDisc() {
        return useCashDisc;
    }

    /**
     * Sets the value of the useCashDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumUseCashDisc }{@code >}
     *     
     */
    public void setUseCashDisc(JAXBElement<AxdEnumUseCashDisc> value) {
        this.useCashDisc = ((JAXBElement<AxdEnumUseCashDisc> ) value);
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
     * Gets the value of the vendAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVendAccount() {
        return vendAccount;
    }

    /**
     * Sets the value of the vendAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVendAccount(JAXBElement<String> value) {
        this.vendAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the webSalesOrderDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumECPsalesOrdersViewType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumECPsalesOrdersViewType> getWebSalesOrderDisplay() {
        return webSalesOrderDisplay;
    }

    /**
     * Sets the value of the webSalesOrderDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumECPsalesOrdersViewType }{@code >}
     *     
     */
    public void setWebSalesOrderDisplay(JAXBElement<AxdEnumECPsalesOrdersViewType> value) {
        this.webSalesOrderDisplay = ((JAXBElement<AxdEnumECPsalesOrdersViewType> ) value);
    }

    /**
     * Gets the value of the dirParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dirParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityDirPartyDirPartyTable }
     * 
     * 
     */
    public List<AxdEntityDirPartyDirPartyTable> getDirParty() {
        if (dirParty == null) {
            dirParty = new ArrayList<AxdEntityDirPartyDirPartyTable>();
        }
        return this.dirParty;
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
