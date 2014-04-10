
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEntityKey_BankLCExportLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdEntityKey_BankLCExportLine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LineNum" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdExtType_BankLCShipmentLineNum"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdEntityKey_BankLCExportLine", propOrder = {
    "lineNum"
})
public class AxdEntityKeyBankLCExportLine {

    @XmlElement(name = "LineNum")
    protected int lineNum;

    /**
     * Gets the value of the lineNum property.
     * 
     */
    public int getLineNum() {
        return lineNum;
    }

    /**
     * Sets the value of the lineNum property.
     * 
     */
    public void setLineNum(int value) {
        this.lineNum = value;
    }

}
