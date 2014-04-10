
package com.microsoft.schemas.dynamics._2008._01.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList}EntityKeyList" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.microsoft.com/dynamics/2008/01/documents/Customer}Customer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entityKeyList",
    "customer"
})
@XmlRootElement(name = "CustomerServiceUpdateRequest")
public class CustomerServiceUpdateRequest {

    @XmlElement(name = "EntityKeyList", namespace = "http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList")
    protected EntityKeyList entityKeyList;
    @XmlElement(name = "Customer", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Customer")
    protected AxdCustomer customer;

    /**
     * Gets the value of the entityKeyList property.
     * 
     * @return
     *     possible object is
     *     {@link EntityKeyList }
     *     
     */
    public EntityKeyList getEntityKeyList() {
        return entityKeyList;
    }

    /**
     * Sets the value of the entityKeyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityKeyList }
     *     
     */
    public void setEntityKeyList(EntityKeyList value) {
        this.entityKeyList = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link AxdCustomer }
     *     
     */
    public AxdCustomer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdCustomer }
     *     
     */
    public void setCustomer(AxdCustomer value) {
        this.customer = value;
    }

}
