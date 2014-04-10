
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;


/**
 * <p>Java class for AxdEntity_DirParty_DirPartyTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_DirPartyTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstanceRelationType" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RelationType" minOccurs="0"/>
 *         &lt;element name="KnownAs" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyName" minOccurs="0"/>
 *         &lt;element name="LanguageId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_LanguageId" minOccurs="0"/>
 *         &lt;element name="Memo" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirMemo" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyName" minOccurs="0"/>
 *         &lt;element name="NameAlias" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_NameAlias" minOccurs="0"/>
 *         &lt;element name="PartyNumber" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPartyNumber" minOccurs="0"/>
 *         &lt;element name="RecId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecId" minOccurs="0"/>
 *         &lt;element name="RecVersion" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_RecVersion" minOccurs="0"/>
 *         &lt;element name="DirPartyPostalAddressView" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirPartyPostalAddressView" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DirPartyContactInfoView" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirPartyContactInfoView" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AxdEntity_DirParty_DirPartyTable", propOrder = {
    "instanceRelationType",
    "knownAs",
    "languageId",
    "memo",
    "name",
    "nameAlias",
    "partyNumber",
    "recId",
    "recVersion",
    "dirPartyPostalAddressView",
    "dirPartyContactInfoView"
})
@XmlSeeAlso({
    AxdEntityDirPartyDirPerson.class,
    AxdEntityDirPartyDirOrganizationBase.class
})
public class AxdEntityDirPartyDirPartyTable {

    @XmlElementRef(name = "InstanceRelationType", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> instanceRelationType;
    @XmlElementRef(name = "KnownAs", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> knownAs;
    @XmlElementRef(name = "LanguageId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> languageId;
    @XmlElementRef(name = "Memo", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> memo;
    @XmlElementRef(name = "Name", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "NameAlias", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> nameAlias;
    @XmlElementRef(name = "PartyNumber", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> partyNumber;
    @XmlElementRef(name = "RecId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Long> recId;
    @XmlElementRef(name = "RecVersion", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> recVersion;
    @XmlElement(name = "DirPartyPostalAddressView")
    protected List<AxdEntityDirPartyPostalAddressView> dirPartyPostalAddressView;
    @XmlElement(name = "DirPartyContactInfoView")
    protected List<AxdEntityDirPartyContactInfoView> dirPartyContactInfoView;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "action")
    protected AxdEnumAxdEntityAction action;

    /**
     * Gets the value of the instanceRelationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInstanceRelationType() {
        return instanceRelationType;
    }

    /**
     * Sets the value of the instanceRelationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInstanceRelationType(JAXBElement<Long> value) {
        this.instanceRelationType = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the knownAs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKnownAs() {
        return knownAs;
    }

    /**
     * Sets the value of the knownAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKnownAs(JAXBElement<String> value) {
        this.knownAs = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the languageId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguageId() {
        return languageId;
    }

    /**
     * Sets the value of the languageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguageId(JAXBElement<String> value) {
        this.languageId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the memo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemo() {
        return memo;
    }

    /**
     * Sets the value of the memo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemo(JAXBElement<String> value) {
        this.memo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nameAlias property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameAlias() {
        return nameAlias;
    }

    /**
     * Sets the value of the nameAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameAlias(JAXBElement<String> value) {
        this.nameAlias = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartyNumber() {
        return partyNumber;
    }

    /**
     * Sets the value of the partyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartyNumber(JAXBElement<String> value) {
        this.partyNumber = ((JAXBElement<String> ) value);
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
     * Gets the value of the dirPartyPostalAddressView property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dirPartyPostalAddressView property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirPartyPostalAddressView().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityDirPartyPostalAddressView }
     * 
     * 
     */
    public List<AxdEntityDirPartyPostalAddressView> getDirPartyPostalAddressView() {
        if (dirPartyPostalAddressView == null) {
            dirPartyPostalAddressView = new ArrayList<AxdEntityDirPartyPostalAddressView>();
        }
        return this.dirPartyPostalAddressView;
    }

    /**
     * Gets the value of the dirPartyContactInfoView property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dirPartyContactInfoView property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirPartyContactInfoView().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityDirPartyContactInfoView }
     * 
     * 
     */
    public List<AxdEntityDirPartyContactInfoView> getDirPartyContactInfoView() {
        if (dirPartyContactInfoView == null) {
            dirPartyContactInfoView = new ArrayList<AxdEntityDirPartyContactInfoView>();
        }
        return this.dirPartyContactInfoView;
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
