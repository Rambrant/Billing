
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_CaseCategoryHierarchyDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_CaseCategoryHierarchyDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_CaseCategoryType"/>
 *         &lt;element name="CaseCategory" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_CaseCategory"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_CaseCategoryHierarchyDetail", propOrder = {
    "categoryType",
    "caseCategory"
})
public class AxdEntityKeyCaseCategoryHierarchyDetail {

    @XmlElement(name = "CategoryType", required = true)
    protected AxdEnumCaseCategoryType categoryType;
    @XmlElement(name = "CaseCategory", required = true)
    protected String caseCategory;

    /**
     * Gets the value of the categoryType property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumCaseCategoryType }
     *     
     */
    public AxdEnumCaseCategoryType getCategoryType() {
        return categoryType;
    }

    /**
     * Sets the value of the categoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumCaseCategoryType }
     *     
     */
    public void setCategoryType(AxdEnumCaseCategoryType value) {
        this.categoryType = value;
    }

    /**
     * Gets the value of the caseCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseCategory() {
        return caseCategory;
    }

    /**
     * Sets the value of the caseCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseCategory(String value) {
        this.caseCategory = value;
    }

}
