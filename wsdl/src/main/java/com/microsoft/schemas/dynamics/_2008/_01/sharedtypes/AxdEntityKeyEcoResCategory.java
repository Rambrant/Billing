
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_EcoResCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_EcoResCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EcoResCategoryName"/>
 *         &lt;element name="CategoryHierarchy_Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EcoResCategoryHierarchyName"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_EcoResCategory", propOrder = {
    "name",
    "categoryHierarchyName"
})
public class AxdEntityKeyEcoResCategory {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "CategoryHierarchy_Name", required = true)
    protected String categoryHierarchyName;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the categoryHierarchyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryHierarchyName() {
        return categoryHierarchyName;
    }

    /**
     * Sets the value of the categoryHierarchyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryHierarchyName(String value) {
        this.categoryHierarchyName = value;
    }

}
