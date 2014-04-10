package com.tradedoubler.billing.domain;

import java.math.BigDecimal;

/**
 * Represents a monthly forecast in the CRM
 *
 * @author bjorn
 * @since 2012-10-12
 */
public class MonthlyForecast {
    private final String sourceSystemAgreementId;
    private final int year;
    private final int month;
    private final Currency currencyCode;
    private final Money accountManagement;
    private final Money consulting;
    private final Money filehostingFee;
    private final Money minimumTransactionFee;
    private final Money networkFee;
    private final Money other;
    private final Money suf;
    private final Money tradedoublerCommission;
    private final Money transactionalRevenue;
    private final Money fixedAndOtherRevenue;

    public MonthlyForecast(String sourceSystemAgreementId, int year, int month, Currency currencyCode, BigDecimal accountManagement, BigDecimal consulting, BigDecimal filehostingFee, BigDecimal minimumTransactionFee, BigDecimal networkFee, BigDecimal other, BigDecimal suf, BigDecimal tradedoublerCommission, BigDecimal transactionalRevenue, BigDecimal fixedAndOtherRevenue) {
        this.sourceSystemAgreementId = sourceSystemAgreementId;
        this.year = year;
        this.month = month;
        this.currencyCode = currencyCode;
        this.accountManagement = new Money(accountManagement);
        this.consulting = new Money(consulting);
        this.filehostingFee = new Money(filehostingFee);
        this.minimumTransactionFee = new Money(minimumTransactionFee);
        this.networkFee = new Money(networkFee);
        this.other = new Money(other);
        this.suf = new Money(suf);
        this.tradedoublerCommission = new Money(tradedoublerCommission);
        this.transactionalRevenue = new Money(transactionalRevenue);
        this.fixedAndOtherRevenue = new Money(fixedAndOtherRevenue);
    }

    /** The program/agreement the monthly forecast belongs to */
    public String getSourceSystemAgreementId() {
        return sourceSystemAgreementId;
    }

    /** The year the monthly forecast belongs to (YYYY) */
    public int getYear() {
        return year;
    }

    /** The month the monthly forecast belongs to (1-12) */
    public int getMonth() {
        return month;
    }

    /** The agreement currency */
    public Currency getCurrencyCode() {
        return currencyCode;
    }

    public Money getAccountManagement() {
        return accountManagement;
    }

    public Money getConsulting() {
        return consulting;
    }

    public Money getFilehostingFee() {
        return filehostingFee;
    }

    public Money getMinimumTransactionFee() {
        return minimumTransactionFee;
    }

    public Money getNetworkFee() {
        return networkFee;
    }

    public Money getOther() {
        return other;
    }

    /** Setup fee */
    public Money getSuf() {
        return suf;
    }

    public Money getTradedoublerCommission() {
        return tradedoublerCommission;
    }

    public Money getTransactionalRevenue() {
        return transactionalRevenue;
    }

    public Money getFixedAndOtherRevenue() {
        return fixedAndOtherRevenue;
    }

    /** Create forecast with only zero values */
    public static MonthlyForecast createZeroMonthlyForecast(String sourceSystemAgreementId, int year, int month, Currency currencyCode) {
        return new MonthlyForecast(sourceSystemAgreementId, year, month, currencyCode,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO);
    }
}
