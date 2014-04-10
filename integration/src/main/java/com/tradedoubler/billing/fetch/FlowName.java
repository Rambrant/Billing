package com.tradedoubler.billing.fetch;

/** Enumeration of all flow names as specified in a Mule flow's flow component's name attribute. */
public enum FlowName {
    CreateInvoicingRuleCrm,
    UpdateInvoicingRuleCrm,
    UpdateAgreementCrm,
    UpdateClientCrm,
    DeleteInvoiceRecipientCrm,
    DeleteSplittingRuleCrm,
    UpdateMarketMessageCrm,

    CreateOrderLinesPan,
    UpdatePrepaymentForecastPan,
    StartAxInvoicingPan,
    DeliverInvoiceAx,

    CreateInvoicingRulePan,
    UpdateInvoicingRulePan,
    UpdateResellerClientPan,


    // Test flows
    ConcurrentInstancesOfFlow,
    ConcurrentParticipantFlow,
    TestInvoiceFlow,
    TestLoadFlow
}
