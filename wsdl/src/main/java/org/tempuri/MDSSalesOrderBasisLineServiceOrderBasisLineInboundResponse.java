
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.dynamics_ax.ArrayOfMDSITGSalesOrderBasisLineContract;


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
 *         &lt;element name="response" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}ArrayOfMDS_ITGSalesOrderBasisLineContract" minOccurs="0"/>
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
    "response"
})
@XmlRootElement(name = "MDS_SalesOrderBasisLineServiceOrderBasisLineInboundResponse")
public class MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse {

    @XmlElementRef(name = "response", namespace = "http://tempuri.org", type = JAXBElement.class)
    protected JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}
     *     
     */
    public void setResponse(JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> value) {
        this.response = ((JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> ) value);
    }

}
