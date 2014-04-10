
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_DirPartyLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_DirPartyLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Party_PartyNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber"/>
 *         &lt;element name="Location_LocationId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationId"/>
 *         &lt;element name="ValidFrom" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EffectiveDateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_DirPartyLocation", propOrder = {
    "partyPartyNumber",
    "locationLocationId",
    "validFrom"
})
public class AxdEntityKeyDirPartyLocation {

    @XmlElement(name = "Party_PartyNumber", required = true)
    protected String partyPartyNumber;
    @XmlElement(name = "Location_LocationId", required = true)
    protected String locationLocationId;
    @XmlElement(name = "ValidFrom", required = true)
    protected AxdExtTypeEffectiveDateTime validFrom;

    /**
     * Gets the value of the partyPartyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyPartyNumber() {
        return partyPartyNumber;
    }

    /**
     * Sets the value of the partyPartyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyPartyNumber(String value) {
        this.partyPartyNumber = value;
    }

    /**
     * Gets the value of the locationLocationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationLocationId() {
        return locationLocationId;
    }

    /**
     * Sets the value of the locationLocationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationLocationId(String value) {
        this.locationLocationId = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link AxdExtTypeEffectiveDateTime }
     *     
     */
    public AxdExtTypeEffectiveDateTime getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdExtTypeEffectiveDateTime }
     *     
     */
    public void setValidFrom(AxdExtTypeEffectiveDateTime value) {
        this.validFrom = value;
    }

}
