//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_TrvExpTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_TrvExpTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExpNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_TrvExpNumber"/>
 *         &lt;element name="LegalEntity_DataArea" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SelectableDataArea"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_TrvExpTable", propOrder = {
    "expNumber",
    "legalEntityDataArea"
})
public class AxdEntityKeyTrvExpTable {

    @XmlElement(name = "ExpNumber", required = true)
    protected String expNumber;
    @XmlElement(name = "LegalEntity_DataArea", required = true)
    protected String legalEntityDataArea;

    /**
     * Gets the value of the expNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNumber() {
        return expNumber;
    }

    /**
     * Sets the value of the expNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNumber(String value) {
        this.expNumber = value;
    }

    /**
     * Gets the value of the legalEntityDataArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityDataArea() {
        return legalEntityDataArea;
    }

    /**
     * Sets the value of the legalEntityDataArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityDataArea(String value) {
        this.legalEntityDataArea = value;
    }

}