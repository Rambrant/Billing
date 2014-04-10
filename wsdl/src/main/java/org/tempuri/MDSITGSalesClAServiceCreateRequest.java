
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdMDSITGSalesClA;


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
 *         &lt;element ref="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA}MDS_ITGSalesClA" minOccurs="0"/>
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
    "mdsitgSalesClA"
})
@XmlRootElement(name = "MDS_ITGSalesClAServiceCreateRequest")
public class MDSITGSalesClAServiceCreateRequest {

    @XmlElement(name = "MDS_ITGSalesClA", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA")
    protected AxdMDSITGSalesClA mdsitgSalesClA;

    /**
     * Gets the value of the mdsitgSalesClA property.
     * 
     * @return
     *     possible object is
     *     {@link AxdMDSITGSalesClA }
     *     
     */
    public AxdMDSITGSalesClA getMDSITGSalesClA() {
        return mdsitgSalesClA;
    }

    /**
     * Sets the value of the mdsitgSalesClA property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdMDSITGSalesClA }
     *     
     */
    public void setMDSITGSalesClA(AxdMDSITGSalesClA value) {
        this.mdsitgSalesClA = value;
    }

}
