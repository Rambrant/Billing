
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntity_DirParty_DirOrganizationBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_DirOrganizationBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_DirPartyTable">
 *       &lt;sequence>
 *         &lt;element name="DunsNumberRecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsDunsNumber" minOccurs="0"/>
 *         &lt;element name="PhoneticName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyName" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_DirOrganizationBase", propOrder = {
    "dunsNumberRecId",
    "phoneticName"
})
@XmlSeeAlso({
    AxdEntityDirPartyDirOrganization.class,
    AxdEntityDirPartyOMInternalOrganization.class
})
public class AxdEntityDirPartyDirOrganizationBase
    extends AxdEntityDirPartyDirPartyTable
{

    @XmlElementRef(name = "DunsNumberRecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> dunsNumberRecId;
    @XmlElementRef(name = "PhoneticName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> phoneticName;

    /**
     * Gets the value of the dunsNumberRecId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDunsNumberRecId() {
        return dunsNumberRecId;
    }

    /**
     * Sets the value of the dunsNumberRecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDunsNumberRecId(JAXBElement<String> value) {
        this.dunsNumberRecId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phoneticName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneticName() {
        return phoneticName;
    }

    /**
     * Sets the value of the phoneticName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneticName(JAXBElement<String> value) {
        this.phoneticName = ((JAXBElement<String> ) value);
    }

}
