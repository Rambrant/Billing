
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_DocumentStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_DocumentStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Quotation"/>
 *     &lt;enumeration value="PurchaseOrder"/>
 *     &lt;enumeration value="Confirmation"/>
 *     &lt;enumeration value="PickingList"/>
 *     &lt;enumeration value="PackingSlip"/>
 *     &lt;enumeration value="ReceiptsList"/>
 *     &lt;enumeration value="Invoice"/>
 *     &lt;enumeration value="ApproveJournal"/>
 *     &lt;enumeration value="ProjectInvoice"/>
 *     &lt;enumeration value="ProjectPackingSlip"/>
 *     &lt;enumeration value="CRMQuotation"/>
 *     &lt;enumeration value="Lost"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="FreeTextInvoice"/>
 *     &lt;enumeration value="RFQ"/>
 *     &lt;enumeration value="RFQAccept"/>
 *     &lt;enumeration value="RFQReject"/>
 *     &lt;enumeration value="PurchReq"/>
 *     &lt;enumeration value="RFQReSend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_DocumentStatus")
@XmlEnum
public enum AxdEnumDocumentStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Quotation")
    QUOTATION("Quotation"),
    @XmlEnumValue("PurchaseOrder")
    PURCHASE_ORDER("PurchaseOrder"),
    @XmlEnumValue("Confirmation")
    CONFIRMATION("Confirmation"),
    @XmlEnumValue("PickingList")
    PICKING_LIST("PickingList"),
    @XmlEnumValue("PackingSlip")
    PACKING_SLIP("PackingSlip"),
    @XmlEnumValue("ReceiptsList")
    RECEIPTS_LIST("ReceiptsList"),
    @XmlEnumValue("Invoice")
    INVOICE("Invoice"),
    @XmlEnumValue("ApproveJournal")
    APPROVE_JOURNAL("ApproveJournal"),
    @XmlEnumValue("ProjectInvoice")
    PROJECT_INVOICE("ProjectInvoice"),
    @XmlEnumValue("ProjectPackingSlip")
    PROJECT_PACKING_SLIP("ProjectPackingSlip"),
    @XmlEnumValue("CRMQuotation")
    CRM_QUOTATION("CRMQuotation"),
    @XmlEnumValue("Lost")
    LOST("Lost"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("FreeTextInvoice")
    FREE_TEXT_INVOICE("FreeTextInvoice"),
    RFQ("RFQ"),
    @XmlEnumValue("RFQAccept")
    RFQ_ACCEPT("RFQAccept"),
    @XmlEnumValue("RFQReject")
    RFQ_REJECT("RFQReject"),
    @XmlEnumValue("PurchReq")
    PURCH_REQ("PurchReq"),
    @XmlEnumValue("RFQReSend")
    RFQ_RE_SEND("RFQReSend");
    private final String value;

    AxdEnumDocumentStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumDocumentStatus fromValue(String v) {
        for (AxdEnumDocumentStatus c: AxdEnumDocumentStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
