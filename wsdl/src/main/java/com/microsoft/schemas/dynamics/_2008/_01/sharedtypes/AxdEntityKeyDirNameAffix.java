
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_DirNameAffix complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_DirNameAffix">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AffixType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_DirNameAffixType"/>
 *         &lt;element name="Affix" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameAffixValue"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_DirNameAffix", propOrder = {
    "affixType",
    "affix"
})
public class AxdEntityKeyDirNameAffix {

    @XmlElement(name = "AffixType", required = true)
    protected AxdEnumDirNameAffixType affixType;
    @XmlElement(name = "Affix", required = true)
    protected String affix;

    /**
     * Gets the value of the affixType property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumDirNameAffixType }
     *     
     */
    public AxdEnumDirNameAffixType getAffixType() {
        return affixType;
    }

    /**
     * Sets the value of the affixType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumDirNameAffixType }
     *     
     */
    public void setAffixType(AxdEnumDirNameAffixType value) {
        this.affixType = value;
    }

    /**
     * Gets the value of the affix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffix() {
        return affix;
    }

    /**
     * Sets the value of the affix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffix(String value) {
        this.affix = value;
    }

}
