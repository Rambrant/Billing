//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_AccountingDistribution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_AccountingDistribution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceDocumentLine" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_SourceDocumentLineRecId"/>
 *         &lt;element name="Number" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_AccountingDistributionNumber"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_AccountingDistribution", propOrder = {
    "sourceDocumentLine",
    "number"
})
public class AxdEntityKeyAccountingDistribution {

    @XmlElement(name = "SourceDocumentLine")
    protected long sourceDocumentLine;
    @XmlElement(name = "Number")
    protected long number;

    /**
     * Gets the value of the sourceDocumentLine property.
     * 
     */
    public long getSourceDocumentLine() {
        return sourceDocumentLine;
    }

    /**
     * Sets the value of the sourceDocumentLine property.
     * 
     */
    public void setSourceDocumentLine(long value) {
        this.sourceDocumentLine = value;
    }

    /**
     * Gets the value of the number property.
     * 
     */
    public long getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(long value) {
        this.number = value;
    }

}
