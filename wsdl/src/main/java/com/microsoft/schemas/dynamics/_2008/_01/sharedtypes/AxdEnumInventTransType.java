
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Production"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="InventTransaction"/>
 *     &lt;enumeration value="InventLossProfit"/>
 *     &lt;enumeration value="InventTransfer"/>
 *     &lt;enumeration value="SummedUp"/>
 *     &lt;enumeration value="ProdLine"/>
 *     &lt;enumeration value="BOMLine"/>
 *     &lt;enumeration value="BOMMain"/>
 *     &lt;enumeration value="WMSOrder"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="InventCounting"/>
 *     &lt;enumeration value="WMSTransport"/>
 *     &lt;enumeration value="QuarantineOrder"/>
 *     &lt;enumeration value="Asset"/>
 *     &lt;enumeration value="TransferOrderShip"/>
 *     &lt;enumeration value="TransferOrderReceive"/>
 *     &lt;enumeration value="TransferOrderScrap"/>
 *     &lt;enumeration value="SalesQuotation"/>
 *     &lt;enumeration value="QualityOrder"/>
 *     &lt;enumeration value="Blocking"/>
 *     &lt;enumeration value="KanbanJobProcess"/>
 *     &lt;enumeration value="KanbanJobTransferReceipt"/>
 *     &lt;enumeration value="KanbanJobPickingList"/>
 *     &lt;enumeration value="KanbanJobWIP"/>
 *     &lt;enumeration value="KanbanEmptied"/>
 *     &lt;enumeration value="KanbanJobTransferIssue"/>
 *     &lt;enumeration value="PmfProdCoBy"/>
 *     &lt;enumeration value="Statement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransType")
@XmlEnum
public enum AxdEnumInventTransType {

    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Production")
    PRODUCTION("Production"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("InventTransaction")
    INVENT_TRANSACTION("InventTransaction"),
    @XmlEnumValue("InventLossProfit")
    INVENT_LOSS_PROFIT("InventLossProfit"),
    @XmlEnumValue("InventTransfer")
    INVENT_TRANSFER("InventTransfer"),
    @XmlEnumValue("SummedUp")
    SUMMED_UP("SummedUp"),
    @XmlEnumValue("ProdLine")
    PROD_LINE("ProdLine"),
    @XmlEnumValue("BOMLine")
    BOM_LINE("BOMLine"),
    @XmlEnumValue("BOMMain")
    BOM_MAIN("BOMMain"),
    @XmlEnumValue("WMSOrder")
    WMS_ORDER("WMSOrder"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("InventCounting")
    INVENT_COUNTING("InventCounting"),
    @XmlEnumValue("WMSTransport")
    WMS_TRANSPORT("WMSTransport"),
    @XmlEnumValue("QuarantineOrder")
    QUARANTINE_ORDER("QuarantineOrder"),
    @XmlEnumValue("Asset")
    ASSET("Asset"),
    @XmlEnumValue("TransferOrderShip")
    TRANSFER_ORDER_SHIP("TransferOrderShip"),
    @XmlEnumValue("TransferOrderReceive")
    TRANSFER_ORDER_RECEIVE("TransferOrderReceive"),
    @XmlEnumValue("TransferOrderScrap")
    TRANSFER_ORDER_SCRAP("TransferOrderScrap"),
    @XmlEnumValue("SalesQuotation")
    SALES_QUOTATION("SalesQuotation"),
    @XmlEnumValue("QualityOrder")
    QUALITY_ORDER("QualityOrder"),
    @XmlEnumValue("Blocking")
    BLOCKING("Blocking"),
    @XmlEnumValue("KanbanJobProcess")
    KANBAN_JOB_PROCESS("KanbanJobProcess"),
    @XmlEnumValue("KanbanJobTransferReceipt")
    KANBAN_JOB_TRANSFER_RECEIPT("KanbanJobTransferReceipt"),
    @XmlEnumValue("KanbanJobPickingList")
    KANBAN_JOB_PICKING_LIST("KanbanJobPickingList"),
    @XmlEnumValue("KanbanJobWIP")
    KANBAN_JOB_WIP("KanbanJobWIP"),
    @XmlEnumValue("KanbanEmptied")
    KANBAN_EMPTIED("KanbanEmptied"),
    @XmlEnumValue("KanbanJobTransferIssue")
    KANBAN_JOB_TRANSFER_ISSUE("KanbanJobTransferIssue"),
    @XmlEnumValue("PmfProdCoBy")
    PMF_PROD_CO_BY("PmfProdCoBy"),
    @XmlEnumValue("Statement")
    STATEMENT("Statement");
    private final String value;

    AxdEnumInventTransType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransType fromValue(String v) {
        for (AxdEnumInventTransType c: AxdEnumInventTransType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
