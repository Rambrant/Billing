
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventReportDimHistoryLogType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventReportDimHistoryLogType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="PurchPurchaseOrder"/>
 *     &lt;enumeration value="SalesQuotation"/>
 *     &lt;enumeration value="ProdJournalBOM"/>
 *     &lt;enumeration value="ProdJournalProd"/>
 *     &lt;enumeration value="SalesPackingSlip"/>
 *     &lt;enumeration value="SalesInvoice"/>
 *     &lt;enumeration value="DEL_InventPickingList"/>
 *     &lt;enumeration value="SalesConfirm"/>
 *     &lt;enumeration value="PurchReceiptList"/>
 *     &lt;enumeration value="PurchPackingSlip"/>
 *     &lt;enumeration value="PurchInvoice"/>
 *     &lt;enumeration value="DEL_PmfJournalCoBy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventReportDimHistoryLogType")
@XmlEnum
public enum AxdEnumInventReportDimHistoryLogType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("PurchPurchaseOrder")
    PURCH_PURCHASE_ORDER("PurchPurchaseOrder"),
    @XmlEnumValue("SalesQuotation")
    SALES_QUOTATION("SalesQuotation"),
    @XmlEnumValue("ProdJournalBOM")
    PROD_JOURNAL_BOM("ProdJournalBOM"),
    @XmlEnumValue("ProdJournalProd")
    PROD_JOURNAL_PROD("ProdJournalProd"),
    @XmlEnumValue("SalesPackingSlip")
    SALES_PACKING_SLIP("SalesPackingSlip"),
    @XmlEnumValue("SalesInvoice")
    SALES_INVOICE("SalesInvoice"),
    @XmlEnumValue("DEL_InventPickingList")
    DEL_INVENT_PICKING_LIST("DEL_InventPickingList"),
    @XmlEnumValue("SalesConfirm")
    SALES_CONFIRM("SalesConfirm"),
    @XmlEnumValue("PurchReceiptList")
    PURCH_RECEIPT_LIST("PurchReceiptList"),
    @XmlEnumValue("PurchPackingSlip")
    PURCH_PACKING_SLIP("PurchPackingSlip"),
    @XmlEnumValue("PurchInvoice")
    PURCH_INVOICE("PurchInvoice"),
    @XmlEnumValue("DEL_PmfJournalCoBy")
    DEL_PMF_JOURNAL_CO_BY("DEL_PmfJournalCoBy");
    private final String value;

    AxdEnumInventReportDimHistoryLogType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventReportDimHistoryLogType fromValue(String v) {
        for (AxdEnumInventReportDimHistoryLogType c: AxdEnumInventReportDimHistoryLogType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
