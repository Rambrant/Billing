
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdType_DefaultAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdType_DefaultAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MainAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdType_DefaultAccount", propOrder = {
    "mainAccount"
})
public class AxdTypeDefaultAccount {

    @XmlElement(name = "MainAccount", required = true)
    protected String mainAccount;

    /**
     * Gets the value of the mainAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainAccount() {
        return mainAccount;
    }

    /**
     * Sets the value of the mainAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainAccount(String value) {
        this.mainAccount = value;
    }

}
