
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec;

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
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumTimezone;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumValidTimeStateUpdate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeEffectiveDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeExpirationDateTime;


/**
 * <p>Java class for AxdEntity_LogisticsPostalAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_LogisticsPostalAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Addressing" minOccurs="0"/>
 *         &lt;element name="BuildingCompliment" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressBuildingCompliment" minOccurs="0"/>
 *         &lt;element name="City" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressCity" minOccurs="0"/>
 *         &lt;element name="CityRecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressCityRecId" minOccurs="0"/>
 *         &lt;element name="CountryRegionId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_LogisticsAddressCountryRegionId_AxdType_ExtCodeValue"/>
 *         &lt;element name="County" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_LogisticsAddressCountyId_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="District" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressDistrictRecId" minOccurs="0"/>
 *         &lt;element name="DistrictName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressDistrictName" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressLatitude" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationRecId"/>
 *         &lt;element name="Longitude" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressLongitude" minOccurs="0"/>
 *         &lt;element name="PostBox" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressPostBox" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="State" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_LogisticsAddressStateId_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="Street" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AddressStreet" minOccurs="0"/>
 *         &lt;element name="StreetNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressStreetNumber" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_Timezone" minOccurs="0"/>
 *         &lt;element name="ValidFrom" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EffectiveDateTime" minOccurs="0"/>
 *         &lt;element name="ValidTo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ExpirationDateTime" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdUnion_AxdExtType_LogisticsAddressZipCodeId_AxdType_ExtCodeValue" minOccurs="0"/>
 *         &lt;element name="ZipCodeRecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsAddressZipCodeRecId" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="entity" />
 *       &lt;attribute name="action" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_AxdEntityAction" />
 *       &lt;attribute name="updateMode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_ValidTimeStateUpdate" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_LogisticsPostalAddress", propOrder = {
    "address",
    "buildingCompliment",
    "city",
    "cityRecId",
    "countryRegionId",
    "county",
    "district",
    "districtName",
    "latitude",
    "location",
    "longitude",
    "postBox",
    "recId",
    "recVersion",
    "state",
    "street",
    "streetNumber",
    "timeZone",
    "validFrom",
    "validTo",
    "zipCode",
    "zipCodeRecId"
})
public class AxdEntityLogisticsPostalAddress {

    @XmlElementRef(name = "Address", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> address;
    @XmlElementRef(name = "BuildingCompliment", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> buildingCompliment;
    @XmlElementRef(name = "City", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> city;
    @XmlElementRef(name = "CityRecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> cityRecId;
    @XmlElement(name = "CountryRegionId", required = true)
    protected String countryRegionId;
    @XmlElementRef(name = "County", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> county;
    @XmlElementRef(name = "District", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> district;
    @XmlElementRef(name = "DistrictName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> districtName;
    @XmlElementRef(name = "Latitude", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> latitude;
    @XmlElement(name = "Location")
    protected long location;
    @XmlElementRef(name = "Longitude", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> longitude;
    @XmlElementRef(name = "PostBox", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> postBox;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "State", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> state;
    @XmlElementRef(name = "Street", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> street;
    @XmlElementRef(name = "StreetNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> streetNumber;
    @XmlElementRef(name = "TimeZone", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<AxdEnumTimezone> timeZone;
    @XmlElementRef(name = "ValidFrom", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeEffectiveDateTime> validFrom;
    @XmlElementRef(name = "ValidTo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeExpirationDateTime> validTo;
    @XmlElementRef(name = "ZipCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> zipCode;
    @XmlElementRef(name = "ZipCodeRecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> zipCodeRecId;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;
    @XmlAttribute(name = "updateMode")
    protected AxdEnumValidTimeStateUpdate updateMode;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress(JAXBElement<String> value) {
        this.address = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the buildingCompliment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuildingCompliment() {
        return buildingCompliment;
    }

    /**
     * Sets the value of the buildingCompliment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuildingCompliment(JAXBElement<String> value) {
        this.buildingCompliment = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cityRecId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCityRecId() {
        return cityRecId;
    }

    /**
     * Sets the value of the cityRecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCityRecId(JAXBElement<Long> value) {
        this.cityRecId = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the countryRegionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryRegionId() {
        return countryRegionId;
    }

    /**
     * Sets the value of the countryRegionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryRegionId(String value) {
        this.countryRegionId = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCounty(JAXBElement<String> value) {
        this.county = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDistrict(JAXBElement<Long> value) {
        this.district = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the districtName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDistrictName() {
        return districtName;
    }

    /**
     * Sets the value of the districtName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDistrictName(JAXBElement<String> value) {
        this.districtName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLatitude(JAXBElement<BigDecimal> value) {
        this.latitude = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the location property.
     * 
     */
    public long getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     */
    public void setLocation(long value) {
        this.location = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLongitude(JAXBElement<BigDecimal> value) {
        this.longitude = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the postBox property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostBox() {
        return postBox;
    }

    /**
     * Sets the value of the postBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostBox(JAXBElement<String> value) {
        this.postBox = ((JAXBElement<String> ) value);
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
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setState(JAXBElement<String> value) {
        this.state = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStreet(JAXBElement<String> value) {
        this.street = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStreetNumber(JAXBElement<String> value) {
        this.streetNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumTimezone }{@code >}
     *     
     */
    public JAXBElement<AxdEnumTimezone> getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumTimezone }{@code >}
     *     
     */
    public void setTimeZone(JAXBElement<AxdEnumTimezone> value) {
        this.timeZone = ((JAXBElement<AxdEnumTimezone> ) value);
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeEffectiveDateTime> getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}
     *     
     */
    public void setValidFrom(JAXBElement<AxdExtTypeEffectiveDateTime> value) {
        this.validFrom = ((JAXBElement<AxdExtTypeEffectiveDateTime> ) value);
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeExpirationDateTime> getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}
     *     
     */
    public void setValidTo(JAXBElement<AxdExtTypeExpirationDateTime> value) {
        this.validTo = ((JAXBElement<AxdExtTypeExpirationDateTime> ) value);
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setZipCode(JAXBElement<String> value) {
        this.zipCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the zipCodeRecId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getZipCodeRecId() {
        return zipCodeRecId;
    }

    /**
     * Sets the value of the zipCodeRecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setZipCodeRecId(JAXBElement<Long> value) {
        this.zipCodeRecId = ((JAXBElement<Long> ) value);
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

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumValidTimeStateUpdate }
     *     
     */
    public AxdEnumValidTimeStateUpdate getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumValidTimeStateUpdate }
     *     
     */
    public void setUpdateMode(AxdEnumValidTimeStateUpdate value) {
        this.updateMode = value;
    }

}
