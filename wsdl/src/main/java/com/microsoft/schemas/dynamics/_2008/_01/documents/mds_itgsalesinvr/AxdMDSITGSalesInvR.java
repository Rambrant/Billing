
package com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumXMLDocPurpose;


/**
 * <p>Java class for AxdMDS_ITGSalesInvR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdMDS_ITGSalesInvR">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocPurpose" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_XMLDocPurpose" minOccurs="0"/>
 *         &lt;element name="SenderId" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_DataAreaId" minOccurs="0"/>
 *         &lt;element name="MDS_SalesInvoiceRule" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR}AxdEntity_MDS_SalesInvoiceRule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdMDS_ITGSalesInvR", propOrder = {
    "docPurpose",
    "senderId",
    "mdsSalesInvoiceRule"
})
public class AxdMDSITGSalesInvR {

    @XmlElementRef(name = "DocPurpose", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<AxdEnumXMLDocPurpose> docPurpose;
    @XmlElementRef(name = "SenderId", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesInvR", type = JAXBElement.class)
    protected JAXBElement<String> senderId;
    @XmlElement(name = "MDS_SalesInvoiceRule")
    protected List<AxdEntityMDSSalesInvoiceRule> mdsSalesInvoiceRule;

    /**
     * Gets the value of the docPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}
     *     
     */
    public JAXBElement<AxdEnumXMLDocPurpose> getDocPurpose() {
        return docPurpose;
    }

    /**
     * Sets the value of the docPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AxdEnumXMLDocPurpose }{@code >}
     *     
     */
    public void setDocPurpose(JAXBElement<AxdEnumXMLDocPurpose> value) {
        this.docPurpose = ((JAXBElement<AxdEnumXMLDocPurpose> ) value);
    }

    /**
     * Gets the value of the senderId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSenderId(JAXBElement<String> value) {
        this.senderId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the mdsSalesInvoiceRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mdsSalesInvoiceRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMDSSalesInvoiceRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AxdEntityMDSSalesInvoiceRule }
     * 
     * 
     */
    public List<AxdEntityMDSSalesInvoiceRule> getMDSSalesInvoiceRule() {
        if (mdsSalesInvoiceRule == null) {
            mdsSalesInvoiceRule = new ArrayList<AxdEntityMDSSalesInvoiceRule>();
        }
        return this.mdsSalesInvoiceRule;
    }

}
