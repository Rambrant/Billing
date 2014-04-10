
package com.microsoft.schemas.dynamics._2008._01.documents.customer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEntityKeyDirNameAffix;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEntityKeyDirPartyLocation;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumDirPersonMaritalStatus;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumGender;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMonthsOfYear;


/**
 * <p>Java class for AxdEntity_DirParty_DirPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntity_DirParty_DirPerson">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_DirParty_DirPartyTable">
 *       &lt;sequence>
 *         &lt;element name="AnniversaryDay" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Day" minOccurs="0"/>
 *         &lt;element name="AnniversaryMonth" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_MonthsOfYear" minOccurs="0"/>
 *         &lt;element name="AnniversaryYear" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_Integer" minOccurs="0"/>
 *         &lt;element name="BirthDay" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_Day" minOccurs="0"/>
 *         &lt;element name="BirthMonth" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_MonthsOfYear" minOccurs="0"/>
 *         &lt;element name="BirthYear" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdType_Integer" minOccurs="0"/>
 *         &lt;element name="ChildrenNames" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPersonChildrenNames" minOccurs="0"/>
 *         &lt;element name="CommunicatorSignIn" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEntityKey_DirPartyLocation" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_Gender" minOccurs="0"/>
 *         &lt;element name="Hobbies" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPersonHobbies" minOccurs="0"/>
 *         &lt;element name="Initials" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPersonInitials" minOccurs="0"/>
 *         &lt;element name="MaritalStatus" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_DirPersonMaritalStatus" minOccurs="0"/>
 *         &lt;element name="NameSequence" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameSequenceDisplayAs" minOccurs="0"/>
 *         &lt;element name="PersonalSuffix" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEntityKey_DirNameAffix" minOccurs="0"/>
 *         &lt;element name="PersonalTitle" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEntityKey_DirNameAffix" minOccurs="0"/>
 *         &lt;element name="PersonSuffix" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameAffixValue" minOccurs="0"/>
 *         &lt;element name="PersonTitle" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameAffixValue" minOccurs="0"/>
 *         &lt;element name="PhoneticFirstName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPhoneticFirstName" minOccurs="0"/>
 *         &lt;element name="PhoneticLastName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPhoneticLastName" minOccurs="0"/>
 *         &lt;element name="PhoneticMiddleName" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirPhoneticMiddleName" minOccurs="0"/>
 *         &lt;element name="ProfessionalSuffix" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameProfessionalSuffix" minOccurs="0"/>
 *         &lt;element name="ProfessionalTitle" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DirNameProfessionalTitle" minOccurs="0"/>
 *         &lt;element name="PersonName" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}AxdEntity_PersonName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntity_DirParty_DirPerson", propOrder = {
    "anniversaryDay",
    "anniversaryMonth",
    "anniversaryYear",
    "birthDay",
    "birthMonth",
    "birthYear",
    "childrenNames",
    "communicatorSignIn",
    "gender",
    "hobbies",
    "initials",
    "maritalStatus",
    "nameSequence",
    "personalSuffix",
    "personalTitle",
    "personSuffix",
    "personTitle",
    "phoneticFirstName",
    "phoneticLastName",
    "phoneticMiddleName",
    "professionalSuffix",
    "professionalTitle",
    "personName"
})
public class AxdEntityDirPartyDirPerson
    extends AxdEntityDirPartyDirPartyTable
{

    @XmlElementRef(name = "AnniversaryDay", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> anniversaryDay;
    @XmlElementRef(name = "AnniversaryMonth", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumMonthsOfYear> anniversaryMonth;
    @XmlElementRef(name = "AnniversaryYear", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> anniversaryYear;
    @XmlElementRef(name = "BirthDay", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> birthDay;
    @XmlElementRef(name = "BirthMonth", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumMonthsOfYear> birthMonth;
    @XmlElementRef(name = "BirthYear", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<Integer> birthYear;
    @XmlElementRef(name = "ChildrenNames", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> childrenNames;
    @XmlElementRef(name = "CommunicatorSignIn", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEntityKeyDirPartyLocation> communicatorSignIn;
    @XmlElementRef(name = "Gender", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumGender> gender;
    @XmlElementRef(name = "Hobbies", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> hobbies;
    @XmlElementRef(name = "Initials", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> initials;
    @XmlElementRef(name = "MaritalStatus", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEnumDirPersonMaritalStatus> maritalStatus;
    @XmlElementRef(name = "NameSequence", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> nameSequence;
    @XmlElementRef(name = "PersonalSuffix", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEntityKeyDirNameAffix> personalSuffix;
    @XmlElementRef(name = "PersonalTitle", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<AxdEntityKeyDirNameAffix> personalTitle;
    @XmlElementRef(name = "PersonSuffix", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> personSuffix;
    @XmlElementRef(name = "PersonTitle", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> personTitle;
    @XmlElementRef(name = "PhoneticFirstName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> phoneticFirstName;
    @XmlElementRef(name = "PhoneticLastName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> phoneticLastName;
    @XmlElementRef(name = "PhoneticMiddleName", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> phoneticMiddleName;
    @XmlElementRef(name = "ProfessionalSuffix", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> professionalSuffix;
    @XmlElementRef(name = "ProfessionalTitle", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", type = JAXBElement.class)
    protected JAXBElement<String> professionalTitle;
    @XmlElement(name = "PersonName")
    protected List<AxdEntityPersonName> personName;

    /**
     * Gets the value of the anniversaryDay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAnniversaryDay() {
        return anniversaryDay;
    }

    /**
     * Sets the value of the anniversaryDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAnniversaryDay(JAXBElement<Integer> value) {
        this.anniversaryDay = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the anniversaryMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}
     *     
     */
    public JAXBElement<AxdEnumMonthsOfYear> getAnniversaryMonth() {
        return anniversaryMonth;
    }

    /**
     * Sets the value of the anniversaryMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}
     *     
     */
    public void setAnniversaryMonth(JAXBElement<AxdEnumMonthsOfYear> value) {
        this.anniversaryMonth = ((JAXBElement<AxdEnumMonthsOfYear> ) value);
    }

    /**
     * Gets the value of the anniversaryYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAnniversaryYear() {
        return anniversaryYear;
    }

    /**
     * Sets the value of the anniversaryYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAnniversaryYear(JAXBElement<Integer> value) {
        this.anniversaryYear = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBirthDay(JAXBElement<Integer> value) {
        this.birthDay = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the birthMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}
     *     
     */
    public JAXBElement<AxdEnumMonthsOfYear> getBirthMonth() {
        return birthMonth;
    }

    /**
     * Sets the value of the birthMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumMonthsOfYear }{@code >}
     *     
     */
    public void setBirthMonth(JAXBElement<AxdEnumMonthsOfYear> value) {
        this.birthMonth = ((JAXBElement<AxdEnumMonthsOfYear> ) value);
    }

    /**
     * Gets the value of the birthYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBirthYear() {
        return birthYear;
    }

    /**
     * Sets the value of the birthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBirthYear(JAXBElement<Integer> value) {
        this.birthYear = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the childrenNames property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChildrenNames() {
        return childrenNames;
    }

    /**
     * Sets the value of the childrenNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChildrenNames(JAXBElement<String> value) {
        this.childrenNames = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the communicatorSignIn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirPartyLocation }{@code >}
     *     
     */
    public JAXBElement<AxdEntityKeyDirPartyLocation> getCommunicatorSignIn() {
        return communicatorSignIn;
    }

    /**
     * Sets the value of the communicatorSignIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirPartyLocation }{@code >}
     *     
     */
    public void setCommunicatorSignIn(JAXBElement<AxdEntityKeyDirPartyLocation> value) {
        this.communicatorSignIn = ((JAXBElement<AxdEntityKeyDirPartyLocation> ) value);
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumGender }{@code >}
     *     
     */
    public JAXBElement<AxdEnumGender> getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumGender }{@code >}
     *     
     */
    public void setGender(JAXBElement<AxdEnumGender> value) {
        this.gender = ((JAXBElement<AxdEnumGender> ) value);
    }

    /**
     * Gets the value of the hobbies property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHobbies() {
        return hobbies;
    }

    /**
     * Sets the value of the hobbies property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHobbies(JAXBElement<String> value) {
        this.hobbies = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the initials property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInitials() {
        return initials;
    }

    /**
     * Sets the value of the initials property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInitials(JAXBElement<String> value) {
        this.initials = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumDirPersonMaritalStatus }{@code >}
     *     
     */
    public JAXBElement<AxdEnumDirPersonMaritalStatus> getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumDirPersonMaritalStatus }{@code >}
     *     
     */
    public void setMaritalStatus(JAXBElement<AxdEnumDirPersonMaritalStatus> value) {
        this.maritalStatus = ((JAXBElement<AxdEnumDirPersonMaritalStatus> ) value);
    }

    /**
     * Gets the value of the nameSequence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameSequence() {
        return nameSequence;
    }

    /**
     * Sets the value of the nameSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameSequence(JAXBElement<String> value) {
        this.nameSequence = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personalSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}
     *     
     */
    public JAXBElement<AxdEntityKeyDirNameAffix> getPersonalSuffix() {
        return personalSuffix;
    }

    /**
     * Sets the value of the personalSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}
     *     
     */
    public void setPersonalSuffix(JAXBElement<AxdEntityKeyDirNameAffix> value) {
        this.personalSuffix = ((JAXBElement<AxdEntityKeyDirNameAffix> ) value);
    }

    /**
     * Gets the value of the personalTitle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}
     *     
     */
    public JAXBElement<AxdEntityKeyDirNameAffix> getPersonalTitle() {
        return personalTitle;
    }

    /**
     * Sets the value of the personalTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEntityKeyDirNameAffix }{@code >}
     *     
     */
    public void setPersonalTitle(JAXBElement<AxdEntityKeyDirNameAffix> value) {
        this.personalTitle = ((JAXBElement<AxdEntityKeyDirNameAffix> ) value);
    }

    /**
     * Gets the value of the personSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPersonSuffix() {
        return personSuffix;
    }

    /**
     * Sets the value of the personSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPersonSuffix(JAXBElement<String> value) {
        this.personSuffix = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personTitle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPersonTitle() {
        return personTitle;
    }

    /**
     * Sets the value of the personTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPersonTitle(JAXBElement<String> value) {
        this.personTitle = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phoneticFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneticFirstName() {
        return phoneticFirstName;
    }

    /**
     * Sets the value of the phoneticFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneticFirstName(JAXBElement<String> value) {
        this.phoneticFirstName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phoneticLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneticLastName() {
        return phoneticLastName;
    }

    /**
     * Sets the value of the phoneticLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneticLastName(JAXBElement<String> value) {
        this.phoneticLastName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phoneticMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneticMiddleName() {
        return phoneticMiddleName;
    }

    /**
     * Sets the value of the phoneticMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneticMiddleName(JAXBElement<String> value) {
        this.phoneticMiddleName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the professionalSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfessionalSuffix() {
        return professionalSuffix;
    }

    /**
     * Sets the value of the professionalSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfessionalSuffix(JAXBElement<String> value) {
        this.professionalSuffix = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the professionalTitle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfessionalTitle() {
        return professionalTitle;
    }

    /**
     * Sets the value of the professionalTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfessionalTitle(JAXBElement<String> value) {
        this.professionalTitle = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityPersonName }
     * 
     * 
     */
    public List<AxdEntityPersonName> getPersonName() {
        if (personName == null) {
            personName = new ArrayList<AxdEntityPersonName>();
        }
        return this.personName;
    }

}
