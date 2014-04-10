
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumValidTimeStateUpdate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeEffectiveDateTime;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdExtTypeExpirationDateTime;


/**
 * <p>Java class for AxdEntity_OrganizationName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_OrganizationName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyName"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="ValidFrom" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_EffectiveDateTime" minOccurs="0"/>
 *         &lt;element name="ValidTo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_ExpirationDateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="entity" />
 *       &lt;attribute name="action" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_AxdEntityAction" />
 *       &lt;attribute name="updateMode" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_ValidTimeStateUpdate" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_OrganizationName", propOrder = {
    "name",
    "recId",
    "recVersion",
    "validFrom",
    "validTo"
})
public class AxdEntityOrganizationName {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElementRef(name = "ValidFrom", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeEffectiveDateTime> validFrom;
    @XmlElementRef(name = "ValidTo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdExtTypeExpirationDateTime> validTo;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;
    @XmlAttribute(name = "updateMode")
    protected AxdEnumValidTimeStateUpdate updateMode;

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
     * Gets the value of the recId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRecId() {
        return recId;
    }

    /**
     * Sets the value of the recId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRecId(JAXBElement<Long> value) {
        this.recId = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the recVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getRecVersion() {
        return recVersion;
    }

    /**
     * Sets the value of the recVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setRecVersion(JAXBElement<Integer> value) {
        this.recVersion = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeEffectiveDateTime> getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeEffectiveDateTime }{@code >}
     *     
     */
    public void setValidFrom(JAXBElement<AxdExtTypeEffectiveDateTime> value) {
        this.validFrom = ((JAXBElement<AxdExtTypeEffectiveDateTime> ) value);
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}
     *     
     */
    public JAXBElement<AxdExtTypeExpirationDateTime> getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdExtTypeExpirationDateTime }{@code >}
     *     
     */
    public void setValidTo(JAXBElement<AxdExtTypeExpirationDateTime> value) {
        this.validTo = ((JAXBElement<AxdExtTypeExpirationDateTime> ) value);
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        if (clazz == null) {
            return "entity";
        } else {
            return clazz;
        }
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumAxdEntityAction }
     *     
     */
    public AxdEnumAxdEntityAction getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumAxdEntityAction }
     *     
     */
    public void setAction(AxdEnumAxdEntityAction value) {
        this.action = value;
    }

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumValidTimeStateUpdate }
     *     
     */
    public AxdEnumValidTimeStateUpdate getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumValidTimeStateUpdate }
     *     
     */
    public void setUpdateMode(AxdEnumValidTimeStateUpdate value) {
        this.updateMode = value;
    }

}
