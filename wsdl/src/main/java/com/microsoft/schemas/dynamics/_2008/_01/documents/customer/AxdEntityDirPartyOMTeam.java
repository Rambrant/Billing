
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;


/**
 * <p>Java class for AxdEntity_DirParty_OMTeam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_OMTeam">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_OMInternalOrganization">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Description"/>
 *         &lt;element name="IsActive" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="TeamAdministrator" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_UserId" minOccurs="0"/>
 *         &lt;element name="TeamMembershipCriterion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_OMTeamMembershipCriterionId"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_OMTeam", propOrder = {
    "description",
    "isActive",
    "teamAdministrator",
    "teamMembershipCriterion"
})
public class AxdEntityDirPartyOMTeam
    extends AxdEntityDirPartyOMInternalOrganization
{

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElementRef(name = "IsActive", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isActive;
    @XmlElementRef(name = "TeamAdministrator", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> teamAdministrator;
    @XmlElement(name = "TeamMembershipCriterion", required = true)
    protected String teamMembershipCriterion;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsActive(JAXBElement<AxdEnumNoYes> value) {
        this.isActive = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the teamAdministrator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTeamAdministrator() {
        return teamAdministrator;
    }

    /**
     * Sets the value of the teamAdministrator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTeamAdministrator(JAXBElement<String> value) {
        this.teamAdministrator = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the teamMembershipCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamMembershipCriterion() {
        return teamMembershipCriterion;
    }

    /**
     * Sets the value of the teamMembershipCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamMembershipCriterion(String value) {
        this.teamMembershipCriterion = value;
    }

}
