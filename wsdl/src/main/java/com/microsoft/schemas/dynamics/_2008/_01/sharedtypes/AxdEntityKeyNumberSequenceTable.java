
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_NumberSequenceTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_NumberSequenceTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberSequence" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NumberSequenceCode"/>
 *         &lt;element name="NumberSequenceScope_DataArea" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SelectableDataArea"/>
 *         &lt;element name="NumberSequenceScope_LegalEntity_DataArea" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SelectableDataArea"/>
 *         &lt;element name="NumberSequenceScope_OperatingUnit_PartyNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber"/>
 *         &lt;element name="NumberSequenceScope_FiscalCalendarPeriod_FiscalCalendarYear_FiscalCalendar_CalendarId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_FiscalCalendarID"/>
 *         &lt;element name="NumberSequenceScope_FiscalCalendarPeriod_FiscalCalendarYear_Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_FiscalYearName"/>
 *         &lt;element name="NumberSequenceScope_FiscalCalendarPeriod_Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_PeriodName"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_NumberSequenceTable", propOrder = {
    "numberSequence",
    "numberSequenceScopeDataArea",
    "numberSequenceScopeLegalEntityDataArea",
    "numberSequenceScopeOperatingUnitPartyNumber",
    "numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId",
    "numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName",
    "numberSequenceScopeFiscalCalendarPeriodName"
})
public class AxdEntityKeyNumberSequenceTable {

    @XmlElement(name = "NumberSequence", required = true)
    protected String numberSequence;
    @XmlElement(name = "NumberSequenceScope_DataArea", required = true)
    protected String numberSequenceScopeDataArea;
    @XmlElement(name = "NumberSequenceScope_LegalEntity_DataArea", required = true)
    protected String numberSequenceScopeLegalEntityDataArea;
    @XmlElement(name = "NumberSequenceScope_OperatingUnit_PartyNumber", required = true)
    protected String numberSequenceScopeOperatingUnitPartyNumber;
    @XmlElement(name = "NumberSequenceScope_FiscalCalendarPeriod_FiscalCalendarYear_FiscalCalendar_CalendarId", required = true)
    protected String numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId;
    @XmlElement(name = "NumberSequenceScope_FiscalCalendarPeriod_FiscalCalendarYear_Name", required = true)
    protected String numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName;
    @XmlElement(name = "NumberSequenceScope_FiscalCalendarPeriod_Name", required = true)
    protected String numberSequenceScopeFiscalCalendarPeriodName;

    /**
     * Gets the value of the numberSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequence() {
        return numberSequence;
    }

    /**
     * Sets the value of the numberSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequence(String value) {
        this.numberSequence = value;
    }

    /**
     * Gets the value of the numberSequenceScopeDataArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeDataArea() {
        return numberSequenceScopeDataArea;
    }

    /**
     * Sets the value of the numberSequenceScopeDataArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeDataArea(String value) {
        this.numberSequenceScopeDataArea = value;
    }

    /**
     * Gets the value of the numberSequenceScopeLegalEntityDataArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeLegalEntityDataArea() {
        return numberSequenceScopeLegalEntityDataArea;
    }

    /**
     * Sets the value of the numberSequenceScopeLegalEntityDataArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeLegalEntityDataArea(String value) {
        this.numberSequenceScopeLegalEntityDataArea = value;
    }

    /**
     * Gets the value of the numberSequenceScopeOperatingUnitPartyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeOperatingUnitPartyNumber() {
        return numberSequenceScopeOperatingUnitPartyNumber;
    }

    /**
     * Sets the value of the numberSequenceScopeOperatingUnitPartyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeOperatingUnitPartyNumber(String value) {
        this.numberSequenceScopeOperatingUnitPartyNumber = value;
    }

    /**
     * Gets the value of the numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId() {
        return numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId;
    }

    /**
     * Sets the value of the numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId(String value) {
        this.numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearFiscalCalendarCalendarId = value;
    }

    /**
     * Gets the value of the numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName() {
        return numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName;
    }

    /**
     * Sets the value of the numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName(String value) {
        this.numberSequenceScopeFiscalCalendarPeriodFiscalCalendarYearName = value;
    }

    /**
     * Gets the value of the numberSequenceScopeFiscalCalendarPeriodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberSequenceScopeFiscalCalendarPeriodName() {
        return numberSequenceScopeFiscalCalendarPeriodName;
    }

    /**
     * Sets the value of the numberSequenceScopeFiscalCalendarPeriodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSequenceScopeFiscalCalendarPeriodName(String value) {
        this.numberSequenceScopeFiscalCalendarPeriodName = value;
    }

}
