
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdType_LedgerAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdType_LedgerAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DisplayValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MainAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Values" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DimensionAttributeValues" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdType_LedgerAccount", propOrder = {
    "displayValue",
    "mainAccount",
    "values"
})
public class AxdTypeLedgerAccount {

    @XmlElement(name = "DisplayValue", required = true)
    protected String displayValue;
    @XmlElement(name = "MainAccount", required = true)
    protected String mainAccount;
    @XmlElementRef(name = "Values", namespace = "http://schemas.microsoft.com/dynamics/2008/01/sharedtypes", type = JAXBElement.class)
    protected JAXBElement<AxdTypeDimensionAttributeValues> values;

    /**
     * Gets the value of the displayValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * Sets the value of the displayValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayValue(String value) {
        this.displayValue = value;
    }

    /**
     * Gets the value of the mainAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainAccount() {
        return mainAccount;
    }

    /**
     * Sets the value of the mainAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainAccount(String value) {
        this.mainAccount = value;
    }

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDimensionAttributeValues }{@code >}
     *     
     */
    public JAXBElement<AxdTypeDimensionAttributeValues> getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdTypeDimensionAttributeValues }{@code >}
     *     
     */
    public void setValues(JAXBElement<AxdTypeDimensionAttributeValues> value) {
        this.values = ((JAXBElement<AxdTypeDimensionAttributeValues> ) value);
    }

}
