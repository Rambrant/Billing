package com.tradedoubler.billing.transform.ftp;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.transform.AxConverterService;
import com.tradedoubler.billing.transform.webservice.DateConverter;
import com.tradedoubler.customerinvoice.*;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.tradedoubler.billing.domain.InvoiceOrderLineStatus.NONE;
import static com.tradedoubler.billing.domain.InvoiceOrderLineStatus.getByAxName;
import static com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus.*;

/**
 * This class transforms and extracts parts of the ax-invoice into domain object representations. <br/>
 * For background info, see the IDD for CustomerInvoice and the information model.
 */
public class AxCustomerInvoiceToInvoiceTransformer {

    public static final String MIGRATED_INVOICE_TAG = "CIMIG";
    private final AxConverterService axConverter;
    private String workAroundRevenueType;

    public AxCustomerInvoiceToInvoiceTransformer(AxConverterService axConverter) {

        this.axConverter = axConverter;
    }

    /**
     * Starts the XML-parsing and the extraction of the domain Invoice from the XML content
     *
     * @param axInvoice
     * @throws BillingServiceException
     */
    public void transform(AxInvoice axInvoice) throws BillingServiceException {

        //PropertyBag
        AxdMDSITGSCustInv axCustomerInvoice;


        XMLtoAxCustomerInvoiceTransformer xmLtoAxCustomerInvoiceTransformer = new XMLtoAxCustomerInvoiceTransformer();
        axCustomerInvoice = xmLtoAxCustomerInvoiceTransformer.transform(axInvoice.getInvoiceXml());
        axInvoice.setGuidForInvoiceFile(xmLtoAxCustomerInvoiceTransformer.getInvoiceMessageGUID());
        transformInvoicePart(axInvoice, axCustomerInvoice);
        if (axInvoice.getInvoice().getEvent() != Event.POSTED) {
            transformForUpdate(axInvoice);
        }
    }

    /**
     * Performs the update transformation which is similar to the create transformation except for the Meta-Info content
     * and the modifiedOn time stamp.
     *
     * @param axInvoice
     * @throws Exception
     */
    private void transformForUpdate(AxInvoice axInvoice) {
        axInvoice.getInvoice().setModifiedOn(axInvoice.getTimeStampForInvoiceFile().getTimestamp());

        MetaData metaDataForUpdate = new MetaData("UpdateInvoiceInformation", axInvoice.getGuidForInvoiceFile(), axInvoice.getTimeStampForInvoiceFile(), "1", "AX");
        axInvoice.setMetaData(metaDataForUpdate);
    }

    /**
     * Extracts the domain invoice from the AX-invoice representation
     *
     * @param axInvoice
     * @param axCustomerInvoice
     * @throws BillingServiceException
     */
    private void transformInvoicePart(AxInvoice axInvoice, AxdMDSITGSCustInv axCustomerInvoice) throws BillingServiceException {
        Invoice invoice = new Invoice();
        invoice.setInvoicePeriod(axCustomerInvoice.getInvoicePeriod().getValue());
        InvoiceConverter invoiceConverter = new InvoiceConverter();

        //Check if invoice is migrated invoice
        axInvoice.setMigratedInvoice(isInvoiceMigrated(axCustomerInvoice));

        invoice.setMarketId(axConverter.convertMarket(axCustomerInvoice.getSenderId().getValue()));
        BigDecimal gp = axCustomerInvoice.getGrossProfit().getValue();
        if (gp == null) gp = BigDecimal.ZERO;
        invoice.setGp(gp);
        invoice.setEvent(invoiceConverter.convertEventFromAXToDomain(axCustomerInvoice.getInvoiceEvent().getValue()));
        if (axCustomerInvoice.getLastSettleDate() != null && axCustomerInvoice.getLastSettleDate().getValue() != null) {
            invoice.setPaidDate(DateConverter.convertXMLGregorianDateToISODateTime(axCustomerInvoice.getLastSettleDate().getValue()));
        } else {
            invoice.setPaidDate(null);
        }


//        if (axCustomerInvoice.getSettleAmountCur() != null && axCustomerInvoice.getSettleAmountCur().getValue() != null) {
//            invoice.setAmountOpen(axCustomerInvoice.getSettleAmountCur().getValue());
//        }else{
//            //Note: Optional for Paid+ in Ax-doc but required by CRM schema
//            invoice.setAmountOpen(BigDecimal.ZERO);
//        }

        if (!axInvoice.isMigratedInvoice() && //No need for revenue type for migrated invoice
                axCustomerInvoice.getRevenueTypeId() != null &&
                axCustomerInvoice.getRevenueTypeId().getValue() != null) {
            invoice.setRevenueType(invoiceConverter.convertRevenueTypeFromAXToDomain(axCustomerInvoice.getRevenueTypeId().getValue()));
        }


        if (axCustomerInvoice.getCreditedInvoiceId() != null && axCustomerInvoice.getCreditedInvoiceId().getValue() != null && !axCustomerInvoice.getCreditedInvoiceId().getValue().isEmpty()) {
            invoice.setOriginalInvoiceId(axCustomerInvoice.getCreditedInvoiceId().getValue());
        } else {
            invoice.setOriginalInvoiceId(null);
        }

        for (AxdEntityCustInvoiceJour custInvoiceJour : axCustomerInvoice.getCustInvoiceJour()) {
            invoice.setInvoiceId(custInvoiceJour.getInvoiceId().getValue());

            invoice.setClientId(custInvoiceJour.getInvoiceAccount());


            invoice.setInvoicingDate(DateConverter.convertXMLGregorianDateToISODateTime(custInvoiceJour.getInvoiceDate()));
            invoice.setDueDate(DateConverter.convertXMLGregorianDateToISODateTime(custInvoiceJour.getDueDate().getValue()));
            if (custInvoiceJour.getSalesBalance() != null && custInvoiceJour.getSalesBalance().getValue() != null) {
                invoice.setNetAmount(custInvoiceJour.getSalesBalance().getValue());
            }

            //If no VAT set then set zero.
            BigDecimal vat = (custInvoiceJour.getSumTax() != null && custInvoiceJour.getSumTax().getValue() != null) ? custInvoiceJour.getSumTax().getValue() : BigDecimal.ZERO;
            invoice.setVat(vat);

            if (custInvoiceJour.getRemainAmountToBePaid() != null && custInvoiceJour.getRemainAmountToBePaid().getValue() != null) {
                invoice.setAmountOpen(custInvoiceJour.getRemainAmountToBePaid().getValue());
            } else {
                invoice.setAmountOpen(BigDecimal.ZERO); //Cause Ax sometimes leave empty tag if 0
            }

            if (!axInvoice.isMigratedInvoice()) { //No need PDF-doc or agreements for migrated invoices

                if (custInvoiceJour.getInvoiceAmount() != null && custInvoiceJour.getInvoiceAmount().getValue() != null) {
                    invoice.setTotalInvoiced(custInvoiceJour.getInvoiceAmount().getValue());
                }


                invoice.setCurrency(custInvoiceJour.getCurrencyCode());

                JAXBElement<String> documentLink = custInvoiceJour.getMDSSalesInvoiceDocumentLinkOrig();

                //If documentLink is missing the invoice is faulty and its status is set to
                if (documentLink != null && documentLink.getValue() != null && !documentLink.getValue().isEmpty()) {

                    String path = removeAxRootPath(documentLink.getValue().trim());
                    invoice.setLinkToInvoiceDocument(path);
                } else {
                    axInvoice.setInvoiceStatus(INVOICE_LACKS_DOCUMENT);
                }


                if (custInvoiceJour.getMDSSalesInvoiceDocumentLinkCopy() != null && custInvoiceJour.getMDSSalesInvoiceDocumentLinkCopy().getValue() != null && !custInvoiceJour.getMDSSalesInvoiceDocumentLinkCopy().getValue().trim().isEmpty()) {
                    String path = removeAxRootPath(custInvoiceJour.getMDSSalesInvoiceDocumentLinkCopy().getValue().trim());
                    invoice.setLinkToInvoiceDocumentCopy(path);
                } else {
                    invoice.setLinkToInvoiceDocumentCopy(null);
                }
                invoice.setInvoicedAgreements(extractInvoicedAgreements(custInvoiceJour, gp));
            }


        }
        //Workaround cause AX lacks the required Invoice Revenue type. Instead, here, the revenue type is retrieved from processedrevenueType from one of the salesOrderLines. These two revenues should be the same.
        if (invoice.getRevenueType() == InvoiceConverter.NO_REVENUE_TYPE) {
            invoice.setRevenueType(invoiceConverter.convertRevenueTypeFromAXToDomain(workAroundRevenueType));
        }

        XMLGregorianCalendar timeSent = axCustomerInvoice.getDateTimeSent().getValue().getValue();
        //To create correct time-format with milliseconds
        timeSent.setMillisecond(1);
        axInvoice.setTimeStampForInvoiceFile(DateConverter.convertXMLGregorianCalendarToTimeStamp(timeSent));

        MetaData metaData = new MetaData("CreateInvoiceInformation", axInvoice.getGuidForInvoiceFile(), axInvoice.getTimeStampForInvoiceFile(), "1", "AX");
        axInvoice.setInvoice(invoice);
        axInvoice.setMetaData(metaData);

        if (axInvoice.getInvoiceStatus() == INCOMPLETE) axInvoice.setInvoiceStatus(INVOICE_OK);
    }

    /**
     * Removes the server names in the beginning of path created by Ax. This is to comply with the CRM path.
     *
     * @param pathWithRoot
     * @return
     */
    private String removeAxRootPath(String pathWithRoot) {
        if (pathWithRoot.contains("\\PDF")) {
            return pathWithRoot.substring(pathWithRoot.indexOf("\\PDF"));
        }
        return pathWithRoot;
    }


    private List<InvoicedAgreement> extractInvoicedAgreements(AxdEntityCustInvoiceJour custInvoiceJour, BigDecimal gp) throws BillingServiceException {


        //Check this again
        String invoiceID = custInvoiceJour.getInvoiceId().getValue();
        List<InvoicedAgreement> invoicedAgreements = new ArrayList<InvoicedAgreement>();
        Map<String, InvoicedAgreement> agreementIDvsInvoicedAgreement = new LinkedHashMap<String, InvoicedAgreement>();

        for (AxdEntityCustInvoiceTrans axdEntityCustInvoiceTrans : custInvoiceJour.getCustInvoiceTrans()) {

            for (AxdEntityMDSSalesOrderBasisLine axOrderBasisLine : axdEntityCustInvoiceTrans.getSalesLine().get(0).getMDSSalesOrderBasisLine()) {
//                String creditInvoiceId = (axOrderBasisLine.getCreditedInvoiceId() != null)? axOrderBasisLine.getCreditedInvoiceId().getValue(): null;

                validateAxOrderBasisLine(axOrderBasisLine);


                OrderLine orderLine = createOrderLine(axOrderBasisLine);
                //Workaround cause AX lacks the required Invoice Revenue type. Instead, here, the revenue type is retrieved from processedrevenueType from one of the salesOrderLines. These two revenues should be the same.
                if (axOrderBasisLine.getProcessedInvoiceRuleRevenueTypeId() != null) {
                    workAroundRevenueType = axOrderBasisLine.getProcessedInvoiceRuleRevenueTypeId().getValue();
                }

                InvoiceOrderLineStatus status = (axOrderBasisLine.getProcessedStatus() != null && axOrderBasisLine.getProcessedStatus().getValue() != null) ? getByAxName(axOrderBasisLine.getProcessedStatus().getValue().value()) : NONE;

                InvoicedOrderLine invoicedOrderLine = new InvoicedOrderLine(axOrderBasisLine.getOrderBasisLineId().getValue(), invoiceID,
                        axConverter.convertMarket(axOrderBasisLine.getProcessedDataAreaId().getValue()), new Currency(axOrderBasisLine.getProcessedAgreementCurrencyCode().getValue()), orderLine, workAroundRevenueType, status);
                String invoicedAgreementID = axOrderBasisLine.getClientAgreementSourceSystemAgreement().getValue();


                //use an existing InvoicedAgreement or create a new if not present.
                InvoicedAgreement invoicedAgreement = agreementIDvsInvoicedAgreement.get(invoicedAgreementID);
                if (invoicedAgreement == null) {
                    invoicedAgreement = new InvoicedAgreement(invoicedAgreementID, gp);
                    agreementIDvsInvoicedAgreement.put(invoicedAgreementID, invoicedAgreement);
                    //And, finally, add to list
                    invoicedAgreements.add(invoicedAgreement);
                }

                //Add invoicedOrderLine to the agreement
                invoicedAgreement.getInvoicedOrderLines().add(invoicedOrderLine);

            }

        }
        return invoicedAgreements;
    }

    /**
     * This method checks if the invoice is migrated. The condition is that the AxdEntityCustInvoiceTrans tag
     * numberSequenceGroup contains "CIMIG".
     *
     * @param axCustomerInvoice
     * @return
     */
    private boolean isInvoiceMigrated(AxdMDSITGSCustInv axCustomerInvoice) {
        boolean isMigratedInvoice = false;
        for (AxdEntityCustInvoiceJour custInvoiceJour : axCustomerInvoice.getCustInvoiceJour()) {
            for (AxdEntityCustInvoiceTrans axdEntityCustInvoiceTrans : custInvoiceJour.getCustInvoiceTrans()) {
                isMigratedInvoice = axdEntityCustInvoiceTrans.getNumberSequenceGroup() != null && axdEntityCustInvoiceTrans.getNumberSequenceGroup().getValue() != null && axdEntityCustInvoiceTrans.getNumberSequenceGroup().getValue().toUpperCase().trim().contains(MIGRATED_INVOICE_TAG);
                if (isMigratedInvoice) break;
            }
        }
        return isMigratedInvoice;
    }

    private OrderLine createOrderLine(AxdEntityMDSSalesOrderBasisLine axOrderBasisLine) {
        //TODO: not needed? int organizationId = new AxConverterImpl().convert(dataAreaId).getOrganizationId();


        String systemAgreementId = axOrderBasisLine.getClientAgreementSourceSystemAgreement().getValue();
        String orderLineId = axOrderBasisLine.getOrderBasisLineId().getValue();
        boolean invoiceable = axOrderBasisLine.getInvoiceable().getValue().equals(AxdExtTypeMDSSalesOrderBasisLineInvoiceable.YES);
        String salesPart = axOrderBasisLine.getOrderItemId().getValue();
        String description = (axOrderBasisLine.getDescription() != null) ? axOrderBasisLine.getDescription().getValue() : "";
        BigDecimal total = axOrderBasisLine.getTotalAmount().getValue();
        BigDecimal cost = (axOrderBasisLine.getCostAmount() != null) ? axOrderBasisLine.getCostAmount().getValue() : BigDecimal.ZERO;
        String period = axOrderBasisLine.getPeriod().getValue();

        Timestamp dateOfPrepayment = null;
        if (axOrderBasisLine.getDateOfPrepayment() != null) {
            dateOfPrepayment = DateConverter.convertXMLGregorianCalendarToTimeStamp(axOrderBasisLine.getDateOfPrepayment().getValue());
        }

        DebitOrCredit debitOrCredit = (axOrderBasisLine.getDebit().getValue().equals(AxdExtTypeMDSSalesOrderBasisLineDebit.YES)) ? DebitOrCredit.DEBIT : DebitOrCredit.CREDIT;
        String creditedInvoiceID = null;
        if (axOrderBasisLine.getCreditedInvoiceId() != null) {
            creditedInvoiceID = axOrderBasisLine.getCreditedInvoiceId().getValue();
        }

        String splitter = (axOrderBasisLine.getSplitterValue() != null) ? axOrderBasisLine.getSplitterValue().getValue() : null;
        //TODO: not needed? String currencyCode = axOrderBasisLine.getProcessedAgreementCurrencyCode().getValue();

        OrderLine orderLine = new OrderLine(systemAgreementId, orderLineId, invoiceable,
                salesPart, description, total, cost, period, dateOfPrepayment,
                creditedInvoiceID, splitter);

        return orderLine;
    }


    private void validateAxOrderBasisLine(AxdEntityMDSSalesOrderBasisLine axOrderBasisLine) throws BillingServiceException {
        if (axOrderBasisLine.getOrderBasisLineId() == null)
            throw BillingServiceException.createBugDisturbance("OrderBasisLineId is missing in the Ax invoiced OrderBasisLine.");
        if (axOrderBasisLine.getProcessedAgreementCurrencyCode() == null)
            throw BillingServiceException.createBugDisturbance("ProcessedAgreementCurrencyCode is missingis missing in the Ax invoiced OrderBasisLine id = " + axOrderBasisLine.getOrderBasisLineId().getValue());
        if (axOrderBasisLine.getProcessedAgreementDataAreaId() == null)
            throw BillingServiceException.createBugDisturbance("ProcessedAgreementDataAreaId is missingis missing in the Ax invoiced OrderBasisLine id = " + axOrderBasisLine.getOrderBasisLineId().getValue());
        if (axOrderBasisLine.getClientAgreementSourceSystemAgreement() == null)
            throw BillingServiceException.createBugDisturbance("ClientAgreementSourceSystemAgreement is missingis missing in the Ax invoiced OrderBasisLine id = " + axOrderBasisLine.getOrderBasisLineId().getValue());
        if (axOrderBasisLine.getTotalAmount() == null)
            throw BillingServiceException.createBugDisturbance("TotalAmount is missing in the Ax invoiced OrderBasisLine id = " + axOrderBasisLine.getOrderBasisLineId().getValue());
        if (axOrderBasisLine.getProcessedInvoiceRuleRevenueTypeId() == null)
            throw BillingServiceException.createBugDisturbance("ProcessedInvoiceRuleRevenueTypeId is missing in the Ax invoiced OrderBasisLine id = " + axOrderBasisLine.getOrderBasisLineId().getValue());

    }
}
