package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.FindInvoiceRecipientCall;
import org.datacontract.schemas._2004._07.dynamics_ax.*;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * This class contains helper methods for the Ax web service calls.
 * Date: 2012-08-29
 */
public class AxUtil {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(AxUtil.class);

    /**
     * This method is called after a creation of a bank account for the client has been performed.
     * It updates the BankAccount entity with the accountID
     *
     * @param axdCustomer   AX Customer to be updated
     * @param bankAccountId the accountID to update the BankAccount with
     */
    public static void updateCustomerForBankAccount(AxdCustomer axdCustomer, String bankAccountId) throws BillingServiceException {
        if (bankAccountId == null || bankAccountId.isEmpty()) {
            throw new IllegalArgumentException("Bank account id can not be null or empty");
        }

        List<AxdEntityCustTable> custTableList = axdCustomer.getCustTable();
        throwExceptionForMultipleEntries(custTableList, "Customer custTable", "Customer accountNum: unknown");

        AxdEntityCustTable custTable = custTableList.get(0);
        log.debug("Transforming bank account no " + bankAccountId + " on customer " + custTable.getAccountNum().getValue());
        ObjectFactory objectFactory = new ObjectFactory();
        custTable.setBankAccount(objectFactory.createAxdEntityCustTableBankAccount(bankAccountId));

    }

    /**
     * This method is called prior to update of Customer. It adds the necessary attributes  provided by
     * a previous read call, according to the IDD- document.
     *
     * @param axdCustomer AX Customer to be updated
     */
    public static void addUpdateInfoOnCustomer(AxdCustomer axdCustomer, JAXBElement<AxdTypeDateTime> validAsOfDateTime, JAXBElement<String> documentHash, JAXBElement<Long> dirPartyRecId, JAXBElement<Long> dirPartyPostalAddressViewRecId) throws BillingServiceException {
        axdCustomer.setValidAsOfDateTime(validAsOfDateTime);
        List<AxdEntityCustTable> custTableList = axdCustomer.getCustTable();
        throwExceptionForMultipleEntries(custTableList, "AxdCustomer custTable", "Customer accountNum: unknown");

        for (AxdEntityCustTable custTable : custTableList) {
            custTable.setDocumentHash(documentHash);
            custTable.setAction(AxdEnumAxdEntityAction.UPDATE);

            List<AxdEntityDirPartyDirPartyTable> dirPartyList = custTable.getDirParty();
            throwExceptionForMultipleEntries(dirPartyList, "AxdCustomer custTable dirParty", "Customer accountNum: " + custTable.getAccountNum());

            for (AxdEntityDirPartyDirPartyTable dirPartyTable : dirPartyList) {
                dirPartyTable.setAction(AxdEnumAxdEntityAction.UPDATE);
                dirPartyTable.setRecId(dirPartyRecId);

                List<AxdEntityDirPartyPostalAddressView> postalAddressViewList = dirPartyTable.getDirPartyPostalAddressView();
                throwExceptionForMultipleEntries(dirPartyList, "AxdCustomer custTable dirParty postalAddressView", "Customer accountNum: " + custTable.getAccountNum());

                for (AxdEntityDirPartyPostalAddressView postalAddressView : postalAddressViewList) {
                    postalAddressView.setAction(AxdEnumAxdEntityAction.UPDATE);
                    postalAddressView.setUpdateMode(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED);
                    postalAddressView.setRecId(dirPartyPostalAddressViewRecId);
                }
            }
        }

    }

    /**
     * This method is called prior to update of InvoiceRecipient. It adds the necessary attributes provided by
     * a previous read call, according to the IDD- document.
     * According to CRM integration part, everything will be updated on update - even when adding a splitter, for instance.
     *
     * @param axdInvoiceRecipient AX invoice recipient
     * @param findCall            previous find call
     */
    public static void addUpdateInfoOnInvoiceRecipient(FindInvoiceRecipientCall findCall, AxdEntityMDSSalesInvoiceRecipient axdInvoiceRecipient) throws BillingServiceException {
        axdInvoiceRecipient.setAction(AxdEnumAxdEntityAction.UPDATE);
        axdInvoiceRecipient.setDocumentHash(findCall.getDocumentHash());

        List<AxdEntityLogisticsLocation> logisticsLocationList = axdInvoiceRecipient.getLogisticsLocation();
        throwExceptionForMultipleEntries(logisticsLocationList, "InvoiceRecipient logisticsLocation", "InvoiceRecipientId: " + axdInvoiceRecipient.getInvoiceRecipientId());

        for (AxdEntityLogisticsLocation logisticsLocation : logisticsLocationList) {
            logisticsLocation.setRecId(findCall.getLogisticLocationRecId());
            logisticsLocation.setAction(AxdEnumAxdEntityAction.UPDATE);

            List<AxdEntityLogisticsPostalAddress> logisticsPostalAddressList = logisticsLocation.getLogisticsPostalAddress();
            throwExceptionForMultipleEntries(logisticsPostalAddressList, "InvoiceRecipient logisticsLocation logisticsPostalAddressList", "InvoiceRecipientId: " + axdInvoiceRecipient.getInvoiceRecipientId());

            for (AxdEntityLogisticsPostalAddress logisticsPostalAddress : logisticsPostalAddressList) {
                logisticsPostalAddress.setAction(AxdEnumAxdEntityAction.UPDATE);
                logisticsPostalAddress.setUpdateMode(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED);
                logisticsPostalAddress.setLocation(findCall.getPostalAddressLocationId());
                logisticsPostalAddress.setRecId(findCall.getPostalAddressRecId());
            }
        }

        List<AxdEntityMDSSalesSplitter> mdsSalesSplitter = axdInvoiceRecipient.getMDSSalesSplitter();
        for (AxdEntityMDSSalesSplitter axdEntityMDSSalesSplitter : mdsSalesSplitter) {
            axdEntityMDSSalesSplitter.setAction(AxdEnumAxdEntityAction.UPDATE);
        }
    }

    /**
     * This method is called prior to update of InvoiceMessageRule. It adds the necessary attributes  provided by
     * a previous read call, according to the IDD- document.
     */
    public static void addUpdateInfoOnInvoiceMessage(AxdEntityMDSSalesInvoiceMessage axInvMessage, JAXBElement<String> documentHash, AxdEnumMDSSalesMessageSourceType sourceType) {
        axInvMessage.setAction(AxdEnumAxdEntityAction.UPDATE);
        axInvMessage.setDocumentHash(documentHash);
        axInvMessage.setSourceType(sourceType);
    }

    /**
     * This method is called prior to update of Bank. It adds the necessary attributes  provided by
     * a previous read call, according to the IDD- document.
     */
    public static void addUpdateInfoOnBankAccount(AxdEntityCustBankAccount axCustBankAccount, JAXBElement<String> documentHash) {
        axCustBankAccount.setAction(AxdEnumAxdEntityAction.UPDATE);
        axCustBankAccount.setDocumentHash(documentHash);

    }

    /**
     * This method is called prior to update of Order Lines. It adds the necessary attributes  provided by
     * a previous read call, according to the IDD- document.
     */
    public static void addUpdateInfoOrderLine(ArrayOfMDSITGSalesOrderBasisLineContract orderBasisLineContractArray) {
        for (MDSITGSalesOrderBasisLineContract orderBasisLineContract : orderBasisLineContractArray.getMDSITGSalesOrderBasisLineContract()) {
            orderBasisLineContract.setParmStatus(MDSSalesOrderBasisLineStatus.READY_FOR_REPROCESS);
        }
    }

    /**
     * In order to clear previously set fields in Ax, an empty string must be inserted.
     *
     * @param s the string to insert
     * @return empty string "" or the string itself if it was not null 
     */
    public static String convertNullToEmptyString(String s) {
        return s == null ? "" : s;
    }

    /** The street field in Ax in one line and Crm uses two lines, This method concatenates the lines with a newline in between */
    public static String createStreet(String line1, String line2) {
        StringBuilder returnValue = new StringBuilder();
        if (line1 != null && !line1.isEmpty()) {
            returnValue.append(line1);
        }
        if (line2 != null && !line2.isEmpty()) {
            if (returnValue.length() != 0) {
                returnValue.append("\r\n");
            }

            returnValue.append(line2);
        }
        return returnValue.toString();
    }

    private static void throwExceptionForMultipleEntries(List<?> list, String objectMessage, String entityKeyInfo) throws BillingServiceException {
        int size = list.size();
        if (size != 1) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "%s contained %s entries, expected only one entry. This indicates that Ax has inconsistencies. %s",
                    objectMessage, size, entityKeyInfo));
        }
    }

}
