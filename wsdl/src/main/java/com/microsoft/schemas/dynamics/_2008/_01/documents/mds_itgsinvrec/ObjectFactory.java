
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdValidTimeStateType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumTimezone;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeEffectiveDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeExpirationDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec package. 
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

    private final static QName _MDSITGSInvRec_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "MDS_ITGSInvRec");
    private final static QName _AxdMDSITGSInvRecDocPurpose_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "DocPurpose");
    private final static QName _AxdMDSITGSInvRecValidFromDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidFromDateTime");
    private final static QName _AxdMDSITGSInvRecValidAsOfDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidAsOfDateTime");
    private final static QName _AxdMDSITGSInvRecSenderId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "SenderId");
    private final static QName _AxdMDSITGSInvRecValidTimeStateType_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidTimeStateType");
    private final static QName _AxdMDSITGSInvRecValidToDateTime_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidToDateTime");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientInvoiceRuleId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "InvoiceRuleId");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientRecVersion_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "RecVersion");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientAttentionRow2_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "AttentionRow2");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientAttentionRow1_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "AttentionRow1");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientEmail_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Email");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientLocation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Location");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "RecId");
    private final static QName _AxdEntityMDSSalesInvoiceRecipientDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "_DocumentHash");
    private final static QName _AxdEntityLogisticsLocationDescription_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Description");
    private final static QName _AxdEntityLogisticsLocationLocationId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "LocationId");
    private final static QName _AxdEntityLogisticsLocationIsPostalAddress_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "IsPostalAddress");
    private final static QName _AxdEntityLogisticsLocationParentLocation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ParentLocation");
    private final static QName _AxdEntityLogisticsLocationDunsNumberRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "DunsNumberRecId");
    private final static QName _AxdEntityLogisticsPostalAddressValidFrom_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidFrom");
    private final static QName _AxdEntityLogisticsPostalAddressStreet_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Street");
    private final static QName _AxdEntityLogisticsPostalAddressCityRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "CityRecId");
    private final static QName _AxdEntityLogisticsPostalAddressStreetNumber_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "StreetNumber");
    private final static QName _AxdEntityLogisticsPostalAddressCity_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "City");
    private final static QName _AxdEntityLogisticsPostalAddressPostBox_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "PostBox");
    private final static QName _AxdEntityLogisticsPostalAddressZipCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ZipCode");
    private final static QName _AxdEntityLogisticsPostalAddressZipCodeRecId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ZipCodeRecId");
    private final static QName _AxdEntityLogisticsPostalAddressCounty_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "County");
    private final static QName _AxdEntityLogisticsPostalAddressAddress_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Address");
    private final static QName _AxdEntityLogisticsPostalAddressDistrict_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "District");
    private final static QName _AxdEntityLogisticsPostalAddressState_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "State");
    private final static QName _AxdEntityLogisticsPostalAddressTimeZone_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "TimeZone");
    private final static QName _AxdEntityLogisticsPostalAddressValidTo_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "ValidTo");
    private final static QName _AxdEntityLogisticsPostalAddressDistrictName_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "DistrictName");
    private final static QName _AxdEntityLogisticsPostalAddressLongitude_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Longitude");
    private final static QName _AxdEntityLogisticsPostalAddressLatitude_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "Latitude");
    private final static QName _AxdEntityLogisticsPostalAddressBuildingCompliment_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "BuildingCompliment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AxdEntityLogisticsPostalAddress }
     * 
     */
    public AxdEntityLogisticsPostalAddress createAxdEntityLogisticsPostalAddress() {
        return new AxdEntityLogisticsPostalAddress();
    }

    /**
     * Create an instance of {@link AxdMDSITGSInvRec }
     * 
     */
    public AxdMDSITGSInvRec createAxdMDSITGSInvRec() {
        return new AxdMDSITGSInvRec();
    }

    /**
     * Create an instance of {@link AxdEntityMDSSalesInvoiceRecipient }
     * 
     */
    public AxdEntityMDSSalesInvoiceRecipient createAxdEntityMDSSalesInvoiceRecipient() {
        return new AxdEntityMDSSalesInvoiceRecipient();
    }

    /**
     * Create an instance of {@link AxdEntityLogisticsLocation }
     * 
     */
    public AxdEntityLogisticsLocation createAxdEntityLogisticsLocation() {
        return new AxdEntityLogisticsLocation();
    }

    /**
     * Create an instance of {@link AxdEntityMDSSalesSplitter }
     * 
     */
    public AxdEntityMDSSalesSplitter createAxdEntityMDSSalesSplitter() {
        return new AxdEntityMDSSalesSplitter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGSInvRec }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "MDS_ITGSInvRec")
    public JAXBElement<AxdMDSITGSInvRec> createMDSITGSInvRec(AxdMDSITGSInvRec value) {
        return new JAXBElement<AxdMDSITGSInvRec>(_MDSITGSInvRec_QNAME, AxdMDSITGSInvRec.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "DocPurpose", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<AxdEnumXMLDocPurpose> createAxdMDSITGSInvRecDocPurpose(AxdEnumXMLDocPurpose value) {
        return new JAXBElement<AxdEnumXMLDocPurpose>(_AxdMDSITGSInvRecDocPurpose_QNAME, AxdEnumXMLDocPurpose.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidFromDateTime", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<AxdTypeDateTime> createAxdMDSITGSInvRecValidFromDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdMDSITGSInvRecValidFromDateTime_QNAME, AxdTypeDateTime.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidAsOfDateTime", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<AxdTypeDateTime> createAxdMDSITGSInvRecValidAsOfDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdMDSITGSInvRecValidAsOfDateTime_QNAME, AxdTypeDateTime.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "SenderId", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<String> createAxdMDSITGSInvRecSenderId(String value) {
        return new JAXBElement<String>(_AxdMDSITGSInvRecSenderId_QNAME, String.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumAxdValidTimeStateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidTimeStateType", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<AxdEnumAxdValidTimeStateType> createAxdMDSITGSInvRecValidTimeStateType(AxdEnumAxdValidTimeStateType value) {
        return new JAXBElement<AxdEnumAxdValidTimeStateType>(_AxdMDSITGSInvRecValidTimeStateType_QNAME, AxdEnumAxdValidTimeStateType.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdTypeDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidToDateTime", scope = AxdMDSITGSInvRec.class)
    public JAXBElement<AxdTypeDateTime> createAxdMDSITGSInvRecValidToDateTime(AxdTypeDateTime value) {
        return new JAXBElement<AxdTypeDateTime>(_AxdMDSITGSInvRecValidToDateTime_QNAME, AxdTypeDateTime.class, AxdMDSITGSInvRec.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "InvoiceRuleId", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRecipientInvoiceRuleId(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientInvoiceRuleId_QNAME, String.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecVersion", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesInvoiceRecipientRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceRecipientRecVersion_QNAME, Integer.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "AttentionRow2", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRecipientAttentionRow2(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientAttentionRow2_QNAME, String.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "AttentionRow1", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRecipientAttentionRow1(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientAttentionRow1_QNAME, String.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Email", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRecipientEmail(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientEmail_QNAME, String.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Location", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceRecipientLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceRecipientLocation_QNAME, Long.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecId", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<Long> createAxdEntityMDSSalesInvoiceRecipientRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceRecipientRecId_QNAME, Long.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "_DocumentHash", scope = AxdEntityMDSSalesInvoiceRecipient.class)
    public JAXBElement<String> createAxdEntityMDSSalesInvoiceRecipientDocumentHash(String value) {
        return new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientDocumentHash_QNAME, String.class, AxdEntityMDSSalesInvoiceRecipient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecVersion", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<Integer> createAxdEntityLogisticsLocationRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceRecipientRecVersion_QNAME, Integer.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Description", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<String> createAxdEntityLogisticsLocationDescription(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsLocationDescription_QNAME, String.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "LocationId", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<String> createAxdEntityLogisticsLocationLocationId(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsLocationLocationId_QNAME, String.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "IsPostalAddress", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<AxdEnumNoYes> createAxdEntityLogisticsLocationIsPostalAddress(AxdEnumNoYes value) {
        return new JAXBElement<AxdEnumNoYes>(_AxdEntityLogisticsLocationIsPostalAddress_QNAME, AxdEnumNoYes.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecId", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<Long> createAxdEntityLogisticsLocationRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceRecipientRecId_QNAME, Long.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ParentLocation", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<Long> createAxdEntityLogisticsLocationParentLocation(Long value) {
        return new JAXBElement<Long>(_AxdEntityLogisticsLocationParentLocation_QNAME, Long.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "DunsNumberRecId", scope = AxdEntityLogisticsLocation.class)
    public JAXBElement<Long> createAxdEntityLogisticsLocationDunsNumberRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityLogisticsLocationDunsNumberRecId_QNAME, Long.class, AxdEntityLogisticsLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecVersion", scope = AxdEntityMDSSalesSplitter.class)
    public JAXBElement<Integer> createAxdEntityMDSSalesSplitterRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceRecipientRecVersion_QNAME, Integer.class, AxdEntityMDSSalesSplitter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecId", scope = AxdEntityMDSSalesSplitter.class)
    public JAXBElement<Long> createAxdEntityMDSSalesSplitterRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceRecipientRecId_QNAME, Long.class, AxdEntityMDSSalesSplitter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidFrom", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<AxdExtTypeEffectiveDateTime> createAxdEntityLogisticsPostalAddressValidFrom(AxdExtTypeEffectiveDateTime value) {
        return new JAXBElement<AxdExtTypeEffectiveDateTime>(_AxdEntityLogisticsPostalAddressValidFrom_QNAME, AxdExtTypeEffectiveDateTime.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Street", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressStreet(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressStreet_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "CityRecId", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<Long> createAxdEntityLogisticsPostalAddressCityRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityLogisticsPostalAddressCityRecId_QNAME, Long.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "StreetNumber", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressStreetNumber(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressStreetNumber_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecId", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<Long> createAxdEntityLogisticsPostalAddressRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityMDSSalesInvoiceRecipientRecId_QNAME, Long.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "City", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressCity(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressCity_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "PostBox", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressPostBox(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressPostBox_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ZipCode", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressZipCode(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressZipCode_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ZipCodeRecId", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<Long> createAxdEntityLogisticsPostalAddressZipCodeRecId(Long value) {
        return new JAXBElement<Long>(_AxdEntityLogisticsPostalAddressZipCodeRecId_QNAME, Long.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "County", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressCounty(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressCounty_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "RecVersion", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<Integer> createAxdEntityLogisticsPostalAddressRecVersion(Integer value) {
        return new JAXBElement<Integer>(_AxdEntityMDSSalesInvoiceRecipientRecVersion_QNAME, Integer.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Address", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressAddress(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressAddress_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "District", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<Long> createAxdEntityLogisticsPostalAddressDistrict(Long value) {
        return new JAXBElement<Long>(_AxdEntityLogisticsPostalAddressDistrict_QNAME, Long.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "State", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressState(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressState_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdEnumTimezone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "TimeZone", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<AxdEnumTimezone> createAxdEntityLogisticsPostalAddressTimeZone(AxdEnumTimezone value) {
        return new JAXBElement<AxdEnumTimezone>(_AxdEntityLogisticsPostalAddressTimeZone_QNAME, AxdEnumTimezone.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "ValidTo", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<AxdExtTypeExpirationDateTime> createAxdEntityLogisticsPostalAddressValidTo(AxdExtTypeExpirationDateTime value) {
        return new JAXBElement<AxdExtTypeExpirationDateTime>(_AxdEntityLogisticsPostalAddressValidTo_QNAME, AxdExtTypeExpirationDateTime.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "DistrictName", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressDistrictName(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressDistrictName_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Longitude", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<BigDecimal> createAxdEntityLogisticsPostalAddressLongitude(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityLogisticsPostalAddressLongitude_QNAME, BigDecimal.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "Latitude", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<BigDecimal> createAxdEntityLogisticsPostalAddressLatitude(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AxdEntityLogisticsPostalAddressLatitude_QNAME, BigDecimal.class, AxdEntityLogisticsPostalAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", name = "BuildingCompliment", scope = AxdEntityLogisticsPostalAddress.class)
    public JAXBElement<String> createAxdEntityLogisticsPostalAddressBuildingCompliment(String value) {
        return new JAXBElement<String>(_AxdEntityLogisticsPostalAddressBuildingCompliment_QNAME, String.class, AxdEntityLogisticsPostalAddress.class, value);
    }

}
