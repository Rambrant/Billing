
package org.datacontract.schemas._2004._07.dynamics_ax;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.microsoft_dynamics_ax.XppObjectBase;


/**
 * <p>Java class for MDS_ITGSalesOrderBasisLineContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MDS_ITGSalesOrderBasisLineContract">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.Ax.Xpp}XppObjectBase">
 *       &lt;sequence>
 *         &lt;element name="parmClientAgreementSourceSystemAgreement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmCostAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="parmCreditedInvoiceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmDateOfPrepayment" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="parmDebit" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}NoYes" minOccurs="0"/>
 *         &lt;element name="parmDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmException" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}MDS_ITG_SalesOrderBasisLineImportError" minOccurs="0"/>
 *         &lt;element name="parmInvoiceable" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}NoYes" minOccurs="0"/>
 *         &lt;element name="parmOrderBasisLineId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmOrderItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="parmSplitterValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parmStatus" type="{http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application}MDS_SalesOrderBasisLineStatus" minOccurs="0"/>
 *         &lt;element name="parmTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MDS_ITGSalesOrderBasisLineContract", propOrder = {
    "parmClientAgreementSourceSystemAgreement",
    "parmCostAmount",
    "parmCreditedInvoiceId",
    "parmDateOfPrepayment",
    "parmDebit",
    "parmDescription",
    "parmErrorMsg",
    "parmException",
    "parmInvoiceable",
    "parmOrderBasisLineId",
    "parmOrderItemId",
    "parmPeriod",
    "parmQuantity",
    "parmSplitterValue",
    "parmStatus",
    "parmTotalAmount"
})
public class MDSITGSalesOrderBasisLineContract
    extends XppObjectBase
{

    @XmlElementRef(name = "parmClientAgreementSourceSystemAgreement", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmClientAgreementSourceSystemAgreement;
    protected BigDecimal parmCostAmount;
    @XmlElementRef(name = "parmCreditedInvoiceId", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmCreditedInvoiceId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar parmDateOfPrepayment;
    protected NoYes parmDebit;
    @XmlElementRef(name = "parmDescription", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmDescription;
    @XmlElementRef(name = "parmErrorMsg", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmErrorMsg;
    protected MDSITGSalesOrderBasisLineImportError parmException;
    protected NoYes parmInvoiceable;
    @XmlElementRef(name = "parmOrderBasisLineId", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmOrderBasisLineId;
    @XmlElementRef(name = "parmOrderItemId", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmOrderItemId;
    @XmlElementRef(name = "parmPeriod", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmPeriod;
    protected Integer parmQuantity;
    @XmlElementRef(name = "parmSplitterValue", namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", type = JAXBElement.class)
    protected JAXBElement<String> parmSplitterValue;
    protected MDSSalesOrderBasisLineStatus parmStatus;
    protected BigDecimal parmTotalAmount;

    /**
     * Gets the value of the parmClientAgreementSourceSystemAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmClientAgreementSourceSystemAgreement() {
        return parmClientAgreementSourceSystemAgreement;
    }

    /**
     * Sets the value of the parmClientAgreementSourceSystemAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmClientAgreementSourceSystemAgreement(JAXBElement<String> value) {
        this.parmClientAgreementSourceSystemAgreement = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmCostAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getParmCostAmount() {
        return parmCostAmount;
    }

    /**
     * Sets the value of the parmCostAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setParmCostAmount(BigDecimal value) {
        this.parmCostAmount = value;
    }

    /**
     * Gets the value of the parmCreditedInvoiceId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmCreditedInvoiceId() {
        return parmCreditedInvoiceId;
    }

    /**
     * Sets the value of the parmCreditedInvoiceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmCreditedInvoiceId(JAXBElement<String> value) {
        this.parmCreditedInvoiceId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmDateOfPrepayment property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getParmDateOfPrepayment() {
        return parmDateOfPrepayment;
    }

    /**
     * Sets the value of the parmDateOfPrepayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setParmDateOfPrepayment(XMLGregorianCalendar value) {
        this.parmDateOfPrepayment = value;
    }

    /**
     * Gets the value of the parmDebit property.
     * 
     * @return
     *     possible object is
     *     {@link NoYes }
     *     
     */
    public NoYes getParmDebit() {
        return parmDebit;
    }

    /**
     * Sets the value of the parmDebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoYes }
     *     
     */
    public void setParmDebit(NoYes value) {
        this.parmDebit = value;
    }

    /**
     * Gets the value of the parmDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmDescription() {
        return parmDescription;
    }

    /**
     * Sets the value of the parmDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmDescription(JAXBElement<String> value) {
        this.parmDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmErrorMsg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmErrorMsg() {
        return parmErrorMsg;
    }

    /**
     * Sets the value of the parmErrorMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmErrorMsg(JAXBElement<String> value) {
        this.parmErrorMsg = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmException property.
     * 
     * @return
     *     possible object is
     *     {@link MDSITGSalesOrderBasisLineImportError }
     *     
     */
    public MDSITGSalesOrderBasisLineImportError getParmException() {
        return parmException;
    }

    /**
     * Sets the value of the parmException property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDSITGSalesOrderBasisLineImportError }
     *     
     */
    public void setParmException(MDSITGSalesOrderBasisLineImportError value) {
        this.parmException = value;
    }

    /**
     * Gets the value of the parmInvoiceable property.
     * 
     * @return
     *     possible object is
     *     {@link NoYes }
     *     
     */
    public NoYes getParmInvoiceable() {
        return parmInvoiceable;
    }

    /**
     * Sets the value of the parmInvoiceable property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoYes }
     *     
     */
    public void setParmInvoiceable(NoYes value) {
        this.parmInvoiceable = value;
    }

    /**
     * Gets the value of the parmOrderBasisLineId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmOrderBasisLineId() {
        return parmOrderBasisLineId;
    }

    /**
     * Sets the value of the parmOrderBasisLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmOrderBasisLineId(JAXBElement<String> value) {
        this.parmOrderBasisLineId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmOrderItemId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmOrderItemId() {
        return parmOrderItemId;
    }

    /**
     * Sets the value of the parmOrderItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmOrderItemId(JAXBElement<String> value) {
        this.parmOrderItemId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmPeriod() {
        return parmPeriod;
    }

    /**
     * Sets the value of the parmPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmPeriod(JAXBElement<String> value) {
        this.parmPeriod = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParmQuantity() {
        return parmQuantity;
    }

    /**
     * Sets the value of the parmQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParmQuantity(Integer value) {
        this.parmQuantity = value;
    }

    /**
     * Gets the value of the parmSplitterValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParmSplitterValue() {
        return parmSplitterValue;
    }

    /**
     * Sets the value of the parmSplitterValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParmSplitterValue(JAXBElement<String> value) {
        this.parmSplitterValue = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the parmStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MDSSalesOrderBasisLineStatus }
     *     
     */
    public MDSSalesOrderBasisLineStatus getParmStatus() {
        return parmStatus;
    }

    /**
     * Sets the value of the parmStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDSSalesOrderBasisLineStatus }
     *     
     */
    public void setParmStatus(MDSSalesOrderBasisLineStatus value) {
        this.parmStatus = value;
    }

    /**
     * Gets the value of the parmTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getParmTotalAmount() {
        return parmTotalAmount;
    }

    /**
     * Sets the value of the parmTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setParmTotalAmount(BigDecimal value) {
        this.parmTotalAmount = value;
    }

}
