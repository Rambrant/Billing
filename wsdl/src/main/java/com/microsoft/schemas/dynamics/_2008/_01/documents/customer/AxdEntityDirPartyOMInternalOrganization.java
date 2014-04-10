
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumOMInternalOrganizationType;


/**
 * <p>Java class for AxdEntity_DirParty_OMInternalOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_OMInternalOrganization">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_DirOrganizationBase">
 *       &lt;sequence>
 *         &lt;element name="OrganizationType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_OMInternalOrganizationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_OMInternalOrganization", propOrder = {
    "organizationType"
})
@XmlSeeAlso({
    AxdEntityDirPartyOMOperatingUnit.class,
    AxdEntityDirPartyCompanyInfo.class,
    AxdEntityDirPartyOMTeam.class
})
public abstract class AxdEntityDirPartyOMInternalOrganization
    extends AxdEntityDirPartyDirOrganizationBase
{

    @XmlElementRef(name = "OrganizationType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumOMInternalOrganizationType> organizationType;

    /**
     * Gets the value of the organizationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumOMInternalOrganizationType }{@code >}
     *     
     */
    public JAXBElement<AxdEnumOMInternalOrganizationType> getOrganizationType() {
        return organizationType;
    }

    /**
     * Sets the value of the organizationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumOMInternalOrganizationType }{@code >}
     *     
     */
    public void setOrganizationType(JAXBElement<AxdEnumOMInternalOrganizationType> value) {
        this.organizationType = ((JAXBElement<AxdEnumOMInternalOrganizationType> ) value);
    }

}
