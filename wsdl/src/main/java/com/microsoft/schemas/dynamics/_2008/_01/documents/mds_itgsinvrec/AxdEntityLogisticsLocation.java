
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYes;


/**
 * <p>Java class for AxdEntity_LogisticsLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_LogisticsLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Description" minOccurs="0"/>
 *         &lt;element name="DunsNumberRecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsDunsNumberRecId" minOccurs="0"/>
 *         &lt;element name="IsPostalAddress" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_NoYes" minOccurs="0"/>
 *         &lt;element name="LocationId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationId" minOccurs="0"/>
 *         &lt;element name="ParentLocation" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LogisticsLocationRecId" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="LogisticsPostalAddress" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec}AxdEntity_LogisticsPostalAddress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="entity" />
 *       &lt;attribute name="action" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_AxdEntityAction" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_LogisticsLocation", propOrder = {
    "description",
    "dunsNumberRecId",
    "isPostalAddress",
    "locationId",
    "parentLocation",
    "recId",
    "recVersion",
    "logisticsPostalAddress"
})
public class AxdEntityLogisticsLocation {

    @XmlElementRef(name = "Description", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "DunsNumberRecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> dunsNumberRecId;
    @XmlElementRef(name = "IsPostalAddress", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<AxdEnumNoYes> isPostalAddress;
    @XmlElementRef(name = "LocationId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<String> locationId;
    @XmlElementRef(name = "ParentLocation", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> parentLocation;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElement(name = "LogisticsPostalAddress")
    protected List<AxdEntityLogisticsPostalAddress> logisticsPostalAddress;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dunsNumberRecId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDunsNumberRecId() {
        return dunsNumberRecId;
    }

    /**
     * Sets the value of the dunsNumberRecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDunsNumberRecId(JAXBElement<Long> value) {
        this.dunsNumberRecId = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the isPostalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public JAXBElement<AxdEnumNoYes> getIsPostalAddress() {
        return isPostalAddress;
    }

    /**
     * Sets the value of the isPostalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumNoYes }{@code >}
     *     
     */
    public void setIsPostalAddress(JAXBElement<AxdEnumNoYes> value) {
        this.isPostalAddress = ((JAXBElement<AxdEnumNoYes> ) value);
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocationId(JAXBElement<String> value) {
        this.locationId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getParentLocation() {
        return parentLocation;
    }

    /**
     * Sets the value of the parentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setParentLocation(JAXBElement<Long> value) {
        this.parentLocation = ((JAXBElement<Long> ) value);
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
     * Gets the value of the logisticsPostalAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logisticsPostalAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogisticsPostalAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityLogisticsPostalAddress }
     * 
     * 
     */
    public List<AxdEntityLogisticsPostalAddress> getLogisticsPostalAddress() {
        if (logisticsPostalAddress == null) {
            logisticsPostalAddress = new ArrayList<AxdEntityLogisticsPostalAddress>();
        }
        return this.logisticsPostalAddress;
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

}
