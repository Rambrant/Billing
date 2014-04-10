package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.DomainEntityFactory;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-11-22
 */
public class OrderLineHandlerTest {
    private OrderLineHandler orderLineHandler = new OrderLineHandler();
    private List<OrderLine> orderLines = DomainEntityFactory.createValidationOrderLines();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testFilterNotFailed() throws Exception {
        assertThat(orderLines.size(), is(9));
        OrderLinesPanHandler orderLinesPanHandler = new OrderLinesPanHandler();
        orderLinesPanHandler.setDebitAndCredit(orderLines);

        List<OrderLine> actual = orderLineHandler.filterNotFailed(orderLines);
        assertThat(actual.size(), is(6));
        for (OrderLine orderLine : actual) {
            assertThat(orderLine.getStatus(), is(OrderLineStatus.NOT_PROCESSED));
        }
    }
}
