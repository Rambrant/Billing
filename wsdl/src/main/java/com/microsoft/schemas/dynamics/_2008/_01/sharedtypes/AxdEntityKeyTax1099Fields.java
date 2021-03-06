
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_Tax1099Fields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_Tax1099Fields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tax1099Type" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_Tax1099Type"/>
 *         &lt;element name="Tax1099Box" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Tax1099Box"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_Tax1099Fields", propOrder = {
    "tax1099Type",
    "tax1099Box"
})
public class AxdEntityKeyTax1099Fields {

    @XmlElement(name = "Tax1099Type", required = true)
    protected AxdEnumTax1099Type tax1099Type;
    @XmlElement(name = "Tax1099Box", required = true)
    protected String tax1099Box;

    /**
     * Gets the value of the tax1099Type property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumTax1099Type }
     *     
     */
    public AxdEnumTax1099Type getTax1099Type() {
        return tax1099Type;
    }

    /**
     * Sets the value of the tax1099Type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumTax1099Type }
     *     
     */
    public void setTax1099Type(AxdEnumTax1099Type value) {
        this.tax1099Type = value;
    }

    /**
     * Gets the value of the tax1099Box property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTax1099Box() {
        return tax1099Box;
    }

    /**
     * Sets the value of the tax1099Box property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTax1099Box(String value) {
        this.tax1099Box = value;
    }

}
