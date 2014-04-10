package com.tradedoubler.billing.service.ax;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;

/**
 * Defines the interface for the integration service towards Dynamics AX
 *
 * @since 2012-06-12
 */
public interface AxService {

    /** @see AxServiceImpl#updateInvoicingRule */
    ServiceResult updateInvoicingRule(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#updateAgreement */
    ServiceResult updateAgreement(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#updateClient */
    ServiceResult updateClient(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#insertInvoicingRule */
    ServiceResult insertInvoicingRule(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#deleteInvoiceRecipient */
    ServiceResult deleteInvoiceRecipient(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#deleteSplittingRule */
    ServiceResult deleteSplittingRule(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#updateMarketMessage */
    ServiceResult updateMarketMessage(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#fetchCreatedInvoice */
    ServiceResult fetchCreatedInvoice(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#createOrderLines */
    ServiceResult createOrderLines(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#finalizeInvoice */
    ServiceResult finalizeInvoice(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#moveFailedInvoice */
    ServiceResult moveFailedInvoice(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#insertClient */
    ServiceResult insertClient(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#insertAgreement */
    ServiceResult insertAgreement(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#startInvoicing */
    ServiceResult startInvoicing(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#insertResellerClient */
    ServiceResult insertResellerClient(ServiceResult serviceResult) throws BillingServiceException;

    /** @see AxServiceImpl#checkResellerClientExists */
    ServiceResult checkResellerClientExists(ServiceResult serviceResult) throws BillingServiceException;
}
