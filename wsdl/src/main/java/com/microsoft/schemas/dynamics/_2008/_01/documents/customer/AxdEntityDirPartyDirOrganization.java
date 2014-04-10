
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumABC;


/**
 * <p>Java class for AxdEntity_DirParty_DirOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_DirOrganization">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_DirOrganizationBase">
 *       &lt;sequence>
 *         &lt;element name="ABC" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_ABC" minOccurs="0"/>
 *         &lt;element name="NumberOfEmployees" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirOrganizationNumberOfEmployees" minOccurs="0"/>
 *         &lt;element name="OrgNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirOrganizationNumber" minOccurs="0"/>
 *         &lt;element name="OrganizationName" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_OrganizationName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_DirOrganization", propOrder = {
    "abc",
    "numberOfEmployees",
    "orgNumber",
    "organizationName"
})
public class AxdEntityDirPartyDirOrganization
    extends AxdEntityDirPartyDirOrganizationBase
{

    @XmlElementRef(name = "ABC", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumABC> abc;
    @XmlElementRef(name = "NumberOfEmployees", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> numberOfEmployees;
    @XmlElementRef(name = "OrgNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> orgNumber;
    @XmlElement(name = "OrganizationName")
    protected List<AxdEntityOrganizationName> organizationName;

    /**
     * Gets the value of the abc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumABC }{@code >}
     *     
     */
    public JAXBElement<AxdEnumABC> getABC() {
        return abc;
    }

    /**
     * Sets the value of the abc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumABC }{@code >}
     *     
     */
    public void setABC(JAXBElement<AxdEnumABC> value) {
        this.abc = ((JAXBElement<AxdEnumABC> ) value);
    }

    /**
     * Gets the value of the numberOfEmployees property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets the value of the numberOfEmployees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumberOfEmployees(JAXBElement<Integer> value) {
        this.numberOfEmployees = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the orgNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgNumber() {
        return orgNumber;
    }

    /**
     * Sets the value of the orgNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgNumber(JAXBElement<String> value) {
        this.orgNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizationName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityOrganizationName }
     * 
     * 
     */
    public List<AxdEntityOrganizationName> getOrganizationName() {
        if (organizationName == null) {
            organizationName = new ArrayList<AxdEntityOrganizationName>();
        }
        return this.organizationName;
    }

}
