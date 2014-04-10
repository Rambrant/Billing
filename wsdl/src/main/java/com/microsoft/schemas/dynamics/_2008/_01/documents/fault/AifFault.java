
package com.microsoft.schemas.dynamics._2008._01.documents.fault;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework.ArrayOfInfologMessage;


/**
 * <p>Java class for AifFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AifFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomDetailXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaultMessageListArray" type="{http://schemas.microsoft.com/dynamics/2008/01/documents/Fault}ArrayOfFaultMessageList" minOccurs="0"/>
 *         &lt;element name="InfologMessageList" type="{http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services}ArrayOfInfologMessage" minOccurs="0"/>
 *         &lt;element name="StackTrace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="XppExceptionType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AifFault", propOrder = {
    "customDetailXml",
    "faultMessageListArray",
    "infologMessageList",
    "stackTrace",
    "xppExceptionType"
})
public class AifFault {

    @XmlElementRef(name = "CustomDetailXml", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", type = JAXBElement.class)
    protected JAXBElement<String> customDetailXml;
    @XmlElementRef(name = "FaultMessageListArray", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFaultMessageList> faultMessageListArray;
    @XmlElementRef(name = "InfologMessageList", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", type = JAXBElement.class)
    protected JAXBElement<ArrayOfInfologMessage> infologMessageList;
    @XmlElementRef(name = "StackTrace", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", type = JAXBElement.class)
    protected JAXBElement<String> stackTrace;
    @XmlElement(name = "XppExceptionType")
    protected Integer xppExceptionType;

    /**
     * Gets the value of the customDetailXml property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomDetailXml() {
        return customDetailXml;
    }

    /**
     * Sets the value of the customDetailXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomDetailXml(JAXBElement<String> value) {
        this.customDetailXml = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the faultMessageListArray property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFaultMessageList }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFaultMessageList> getFaultMessageListArray() {
        return faultMessageListArray;
    }

    /**
     * Sets the value of the faultMessageListArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFaultMessageList }{@code >}
     *     
     */
    public void setFaultMessageListArray(JAXBElement<ArrayOfFaultMessageList> value) {
        this.faultMessageListArray = ((JAXBElement<ArrayOfFaultMessageList> ) value);
    }

    /**
     * Gets the value of the infologMessageList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfInfologMessage }{@code >}
     *     
     */
    public JAXBElement<ArrayOfInfologMessage> getInfologMessageList() {
        return infologMessageList;
    }

    /**
     * Sets the value of the infologMessageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfInfologMessage }{@code >}
     *     
     */
    public void setInfologMessageList(JAXBElement<ArrayOfInfologMessage> value) {
        this.infologMessageList = ((JAXBElement<ArrayOfInfologMessage> ) value);
    }

    /**
     * Gets the value of the stackTrace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the value of the stackTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStackTrace(JAXBElement<String> value) {
        this.stackTrace = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the xppExceptionType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getXppExceptionType() {
        return xppExceptionType;
    }

    /**
     * Sets the value of the xppExceptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setXppExceptionType(Integer value) {
        this.xppExceptionType = value;
    }

}
