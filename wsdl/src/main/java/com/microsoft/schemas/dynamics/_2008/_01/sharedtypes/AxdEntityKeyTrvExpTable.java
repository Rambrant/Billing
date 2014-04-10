
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

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
