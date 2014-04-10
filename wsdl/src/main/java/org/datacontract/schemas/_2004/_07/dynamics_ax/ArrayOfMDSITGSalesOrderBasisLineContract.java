
package org.datacontract.schemas._2004._07.dynamics_ax;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMDS_ITGSalesOrderBasisLineContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMDS_ITGSalesOrderBasisLineContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MDS_ITGSalesOrderBasisLineContract" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}MDS_ITGSalesOrderBasisLineContract" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMDS_ITGSalesOrderBasisLineContract", propOrder = {
    "mdsitgSalesOrderBasisLineContract"
})
public class ArrayOfMDSITGSalesOrderBasisLineContract {

    @XmlElement(name = "MDS_ITGSalesOrderBasisLineContract", nillable = true)
    protected List<MDSITGSalesOrderBasisLineContract> mdsitgSalesOrderBasisLineContract;

    /**
     * Gets the value of the mdsitgSalesOrderBasisLineContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mdsitgSalesOrderBasisLineContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMDSITGSalesOrderBasisLineContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MDSITGSalesOrderBasisLineContract }
     * 
     * 
     */
    public List<MDSITGSalesOrderBasisLineContract> getMDSITGSalesOrderBasisLineContract() {
        if (mdsitgSalesOrderBasisLineContract == null) {
            mdsitgSalesOrderBasisLineContract = new ArrayList<MDSITGSalesOrderBasisLineContract>();
        }
        return this.mdsitgSalesOrderBasisLineContract;
    }

}
