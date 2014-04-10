
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
 *         &lt;element name="_orderBasisLine" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}ArrayOfMDS_ITGSalesOrderBasisLineContract" minOccurs="0"/>
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
    "orderBasisLine"
})
@XmlRootElement(name = "MDS_SalesOrderBasisLineServiceOrderBasisLineInboundRequest")
public class MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest {

    @XmlElementRef(name = "_orderBasisLine", namespace = "http://tempuri.org", type = JAXBElement.class)
    protected JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> orderBasisLine;

    /**
     * Gets the value of the orderBasisLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> getOrderBasisLine() {
        return orderBasisLine;
    }

    /**
     * Sets the value of the orderBasisLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}
     *     
     */
    public void setOrderBasisLine(JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> value) {
        this.orderBasisLine = ((JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> ) value);
    }

}
