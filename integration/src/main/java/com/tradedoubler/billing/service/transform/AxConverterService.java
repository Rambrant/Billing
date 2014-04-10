package com.tradedoubler.billing.service.transform;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;

/**
 * Service interface for conversion methods for constants between Ax, Pan and Crm.
 *
 * @see AxConverterServiceImpl
 * @author bjoek
 * @since 2012-10-29
 */
public interface AxConverterService {
    String convert(AddressType addressType) throws BillingServiceException;

    String convert(Country countryCode) throws BillingServiceException;

    String convert(Currency currencyCode);

    String convert(Language invoiceLanguage);

    String convert(Market marketId) throws BillingServiceException;

    String convert(PaymentMethod paymentMethod) throws BillingServiceException;

    String convert(ProductType productType);

    String convert(TermsOfPayment termsOfPayment);

    String convert(PostingProfile postingProfile) throws BillingServiceException;

    String convert(DistributionMode distributionMode) throws BillingServiceException;

    String convert(RevenueType revenueType);

    Market convertMarket(String dataAreaID) throws BillingServiceException;
}
