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
 * <p>Java class for AxdType_DimensionAttributeValueSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdType_DimensionAttributeValueSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Values" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_DimensionAttributeValues"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdType_DimensionAttributeValueSet", propOrder = {
    "values"
})
public class AxdTypeDimensionAttributeValueSet {

    @XmlElement(name = "Values", required = true)
    protected AxdTypeDimensionAttributeValues values;

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link AxdTypeDimensionAttributeValues }
     *     
     */
    public AxdTypeDimensionAttributeValues getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdTypeDimensionAttributeValues }
     *     
     */
    public void setValues(AxdTypeDimensionAttributeValues value) {
        this.values = value;
    }

}