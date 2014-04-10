
package com.microsoft.schemas.dynamics._2010._01.datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;


/**
 * <p>Java class for CallContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LogonAsUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PropertyBag" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfstringstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallContext", propOrder = {
    "company",
    "language",
    "logonAsUser",
    "messageId",
    "propertyBag"
})
public class CallContext {

    @XmlElementRef(name = "Company", namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", type = JAXBElement.class)
    protected JAXBElement<String> company;
    @XmlElementRef(name = "Language", namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", type = JAXBElement.class)
    protected JAXBElement<String> language;
    @XmlElementRef(name = "LogonAsUser", namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", type = JAXBElement.class)
    protected JAXBElement<String> logonAsUser;
    @XmlElementRef(name = "MessageId", namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", type = JAXBElement.class)
    protected JAXBElement<String> messageId;
    @XmlElementRef(name = "PropertyBag", namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfstringstring> propertyBag;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompany(JAXBElement<String> value) {
        this.company = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<String> value) {
        this.language = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the logonAsUser property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLogonAsUser() {
        return logonAsUser;
    }

    /**
     * Sets the value of the logonAsUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLogonAsUser(JAXBElement<String> value) {
        this.logonAsUser = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageId(JAXBElement<String> value) {
        this.messageId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the propertyBag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfstringstring> getPropertyBag() {
        return propertyBag;
    }

    /**
     * Sets the value of the propertyBag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public void setPropertyBag(JAXBElement<ArrayOfKeyValueOfstringstring> value) {
        this.propertyBag = ((JAXBElement<ArrayOfKeyValueOfstringstring> ) value);
    }

}
