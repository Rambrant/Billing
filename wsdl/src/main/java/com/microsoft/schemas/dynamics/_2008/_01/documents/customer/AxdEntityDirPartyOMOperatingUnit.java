
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumOMOperatingUnitType;


/**
 * <p>Java class for AxdEntity_DirParty_OMOperatingUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_OMOperatingUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_OMInternalOrganization">
 *       &lt;sequence>
 *         &lt;element name="HcmWorker" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber" minOccurs="0"/>
 *         &lt;element name="OMOperatingUnitNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NumberSequenceGroupId"/>
 *         &lt;element name="OMOperatingUnitType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_OMOperatingUnitType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_OMOperatingUnit", propOrder = {
    "hcmWorker",
    "omOperatingUnitNumber",
    "omOperatingUnitType"
})
public class AxdEntityDirPartyOMOperatingUnit
    extends AxdEntityDirPartyOMInternalOrganization
{

    @XmlElementRef(name = "HcmWorker", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> hcmWorker;
    @XmlElement(name = "OMOperatingUnitNumber", required = true)
    protected String omOperatingUnitNumber;
    @XmlElement(name = "OMOperatingUnitType", required = true)
    protected AxdEnumOMOperatingUnitType omOperatingUnitType;

    /**
     * Gets the value of the hcmWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHcmWorker() {
        return hcmWorker;
    }

    /**
     * Sets the value of the hcmWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHcmWorker(JAXBElement<String> value) {
        this.hcmWorker = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the omOperatingUnitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOMOperatingUnitNumber() {
        return omOperatingUnitNumber;
    }

    /**
     * Sets the value of the omOperatingUnitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOMOperatingUnitNumber(String value) {
        this.omOperatingUnitNumber = value;
    }

    /**
     * Gets the value of the omOperatingUnitType property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumOMOperatingUnitType }
     *     
     */
    public AxdEnumOMOperatingUnitType getOMOperatingUnitType() {
        return omOperatingUnitType;
    }

    /**
     * Sets the value of the omOperatingUnitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumOMOperatingUnitType }
     *     
     */
    public void setOMOperatingUnitType(AxdEnumOMOperatingUnitType value) {
        this.omOperatingUnitType = value;
    }

}
