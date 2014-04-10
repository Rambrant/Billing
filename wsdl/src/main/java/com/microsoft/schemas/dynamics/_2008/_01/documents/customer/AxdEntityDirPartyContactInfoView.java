
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumLogisticsElectronicAddressMethodType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumValidTimeStateUpdate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeDirPartyIsLocationOwner;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeEffectiveDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeExpirationDateTime;


/**
 * <p>Java class for AxdEntity_DirPartyContactInfoView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirPartyContactInfoView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryRegionCode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsCountryRegionCode" minOccurs="0"/>
 *         &lt;element name="ElectronicAddress" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="IsLocationOwner" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyIsLocationOwner" minOccurs="0"/>
 *         &lt;element name="IsPrimary" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="IsPrivate" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="LocationId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationId" minOccurs="0"/>
 *         &lt;element name="LocationName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Description" minOccurs="0"/>
 *         &lt;element name="Locator" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsElectronicAddressLocator" minOccurs="0"/>
 *         &lt;element name="LocatorExtension" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PhoneLocal" minOccurs="0"/>
 *         &lt;element name="Party" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber" minOccurs="0"/>
 *         &lt;element name="PartyLocation" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="Roles" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyLocationRoleNames" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_LogisticsElectronicAddressMethodType" minOccurs="0"/>
 *         &lt;element name="TypeIcon" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Integer" minOccurs="0"/>
 *         &lt;element name="ValidFrom" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EffectiveDateTime" minOccurs="0"/>
 *         &lt;element name="ValidTo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ExpirationDateTime" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_DirPartyContactInfoView", propOrder = {
    "countryRegionCode",
    "electronicAddress",
    "isLocationOwner",
    "isPrimary",
    "isPrivate",
    "location",
    "locationId",
    "locationName",
    "locator",
    "locatorExtension",
    "party",
    "partyLocation",
    "recId",
    "recVersion",
    "roles",
    "type",
    "typeIcon",
    "validFrom",
    "validTo"
})
public class AxdEntityDirPartyContactInfoView {

    @XmlElementRef(name = "CountryRegionCode", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> countryRegionCode;
    @XmlElementRef(name = "ElectronicAddress", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> electronicAddress;
    @XmlElementRef(name = "IsLocationOwner", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeDirPartyIsLocationOwner> isLocationOwner;
    @XmlElementRef(name = "IsPrimary", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isPrimary;
    @XmlElementRef(name = "IsPrivate", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isPrivate;
    @XmlElementRef(name = "Location", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> location;
    @XmlElementRef(name = "LocationId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> locationId;
    @XmlElementRef(name = "LocationName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> locationName;
    @XmlElementRef(name = "Locator", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> locator;
    @XmlElementRef(name = "LocatorExtension", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> locatorExtension;
    @XmlElementRef(name = "Party", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> party;
    @XmlElementRef(name = "PartyLocation", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> partyLocation;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "Roles", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> roles;
    @XmlElementRef(name = "Type", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumLogisticsElectronicAddressMethodType> type;
    @XmlElementRef(name = "TypeIcon", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> typeIcon;
    @XmlElementRef(name = "ValidFrom", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeEffectiveDateTime> validFrom;
    @XmlElementRef(name = "ValidTo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeExpirationDateTime> validTo;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;
    @XmlAttribute(name = "updateMode")
    protected AxdEnumValidTimeStateUpdate updateMode;

    /**
     * Gets the value of the countryRegionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryRegionCode() {
        return countryRegionCode;
    }

    /**
     * Sets the value of the countryRegionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryRegionCode(JAXBElement<String> value) {
        this.countryRegionCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the electronicAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getElectronicAddress() {
        return electronicAddress;
    }

    /**
     * Sets the value of the electronicAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setElectronicAddress(JAXBElement<Long> value) {
        this.electronicAddress = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the isLocationOwner property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeDirPartyIsLocationOwner }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeDirPartyIsLocationOwner> getIsLocationOwner() {
        return isLocationOwner;
    }

    /**
     * Sets the value of the isLocationOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeDirPartyIsLocationOwner }{@code >}
     *     
     */
    public void setIsLocationOwner(JAXBElement<AxdExtTypeDirPartyIsLocationOwner> value) {
        this.isLocationOwner = ((JAXBElement<AxdExtTypeDirPartyIsLocationOwner> ) value);
    }

    /**
     * Gets the value of the isPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the value of the isPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsPrimary(JAXBElement<AxdEnumNoYes> value) {
        this.isPrimary = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the isPrivate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsPrivate() {
        return isPrivate;
    }

    /**
     * Sets the value of the isPrivate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsPrivate(JAXBElement<AxdEnumNoYes> value) {
        this.isPrivate = ((JAXBElement<AxdEnumNoYes> ) value);
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
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocationId(JAXBElement<String> value) {
        this.locationId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the locationName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocationName() {
        return locationName;
    }

    /**
     * Sets the value of the locationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocationName(JAXBElement<String> value) {
        this.locationName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the locator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocator() {
        return locator;
    }

    /**
     * Sets the value of the locator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocator(JAXBElement<String> value) {
        this.locator = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the locatorExtension property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocatorExtension() {
        return locatorExtension;
    }

    /**
     * Sets the value of the locatorExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocatorExtension(JAXBElement<String> value) {
        this.locatorExtension = ((JAXBElement<String> ) value);
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
     * Gets the value of the partyLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPartyLocation() {
        return partyLocation;
    }

    /**
     * Sets the value of the partyLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPartyLocation(JAXBElement<Long> value) {
        this.partyLocation = ((JAXBElement<Long> ) value);
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
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoles(JAXBElement<String> value) {
        this.roles = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumLogisticsElectronicAddressMethodType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumLogisticsElectronicAddressMethodType> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumLogisticsElectronicAddressMethodType }{@code >}
     *     
     */
    public void setType(JAXBElement<AxdEnumLogisticsElectronicAddressMethodType> value) {
        this.type = ((JAXBElement<AxdEnumLogisticsElectronicAddressMethodType> ) value);
    }

    /**
     * Gets the value of the typeIcon property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTypeIcon() {
        return typeIcon;
    }

    /**
     * Sets the value of the typeIcon property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTypeIcon(JAXBElement<Integer> value) {
        this.typeIcon = ((JAXBElement<Integer> ) value);
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
