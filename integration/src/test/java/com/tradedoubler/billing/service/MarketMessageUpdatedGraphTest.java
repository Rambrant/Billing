package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-09-04
 */
public class MarketMessageUpdatedGraphTest extends AbstractGraphHelper {

    private ServiceResult serviceResult;

    private InvoiceIssuerMessageRule invoiceMessageRule;

    public MarketMessageUpdatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        invoiceMessageRule = new InvoiceIssuerMessageRule("invoiceMessageRuleId", 51, "messageText", new Timestamp(), new Timestamp());
        serviceResult = createServiceResult(new MarketMessageUpdated(null, invoiceMessageRule));
    }

    @Test
    public void insertNewMarketMessageRuleShouldWork() throws Exception {
        when(findInvoiceMessageRuleCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(0);

        when(insertInvoiceMessageRuleCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);

        ServiceResult serviceResult = axService.updateMarketMessage(this.serviceResult);

        String invoiceMessageId = invoiceMessageRule.getInvoiceMessageRuleId().getGuidForAx();
        verify(findInvoiceMessageRuleCall).execute(invoiceMessageId, "SE02");
        verify(insertInvoiceMessageRuleCall).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq("SE02"), eq("SE02"));
        assertThat(serviceResult.isDisturbance(), is(false));
    }

    @Test
    public void updateExistingMarketMessageRuleShouldWork() throws Exception {
        when(findInvoiceMessageRuleCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(1);

        when(updateInvoiceMessageRuleCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);

        ServiceResult serviceResult = axService.updateMarketMessage(this.serviceResult);

        String invoiceMessageId = invoiceMessageRule.getInvoiceMessageRuleId().getGuidForAx();
        verify(findInvoiceMessageRuleCall).execute(invoiceMessageId, "SE02");
        verify(updateInvoiceMessageRuleCall).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq("SE02"), eq("SE02"));
        assertThat(serviceResult.isDisturbance(), is(false));
    }


}
