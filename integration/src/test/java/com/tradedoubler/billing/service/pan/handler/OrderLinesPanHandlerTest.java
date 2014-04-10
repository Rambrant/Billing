package com.tradedoubler.billing.service.pan.handler;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.DomainEntityFactory;
import org.hamcrest.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-12-17
 */
public class OrderLinesPanHandlerTest {
    private OrderLinesPanHandler orderLinesPanHandler = new OrderLinesPanHandler();

    @Test
    public void totalZeroAndCostZeroShouldFail() throws Exception {
        OrderLine orderLine = createOrderLine("0", "0");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));

        assertThat(orderLine, new FaultyOrderLine("An order line cannot have both cost and total zero"));
    }

    @Test
    public void totalPositiveAndCostNegativeShouldFail() throws Exception {
        OrderLine orderLine = createOrderLine("1", "-1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));

        assertThat(orderLine, new FaultyOrderLine("An order line cannot have negative cost and positive total."));
    }

    @Test
    public void totalNegativeAndCostPositiveShouldFail() throws Exception {
        OrderLine orderLine = createOrderLine("-1", "1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));

        assertThat(orderLine, new FaultyOrderLine("An order line cannot have positive cost and negative total."));
    }

    @Test
    public void positiveTotalOrCostShouldMakeDebit() throws Exception {
        OrderLine orderLine = createOrderLine("1", "0");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));

        orderLine = createOrderLine("0", "1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));

        orderLine = createOrderLine("1", "1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));
    }

    @Test
    public void negativeTotalOrCostShouldMakeCredit() throws Exception {
        OrderLine orderLine = createOrderLine("-1", "0");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));

        orderLine = createOrderLine("0", "-1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));

        orderLine = createOrderLine("-1", "-1");
        orderLinesPanHandler.setDebitAndCredit(Arrays.asList(orderLine));
        assertThat(orderLine, new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));
    }

    @Test
    public void validationOfManyOrderLinesShouldWork() {
        List<OrderLine> validationOrderLines = DomainEntityFactory.createValidationOrderLines();
        orderLinesPanHandler.setDebitAndCredit(validationOrderLines);

        assertThat(validationOrderLines.get(0), new FaultyOrderLine("An order line cannot have both cost and total zero"));
        assertThat(validationOrderLines.get(1), new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));
        assertThat(validationOrderLines.get(2), new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));
        assertThat(validationOrderLines.get(3), new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));
        assertThat(validationOrderLines.get(4), new ValidatedOrderLine(DebitOrCredit.DEBIT, 1));
        assertThat(validationOrderLines.get(5), new FaultyOrderLine("An order line cannot have negative cost and positive total."));
        assertThat(validationOrderLines.get(6), new FaultyOrderLine("An order line cannot have positive cost and negative total."));
        assertThat(validationOrderLines.get(7), new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));
        assertThat(validationOrderLines.get(8), new ValidatedOrderLine(DebitOrCredit.CREDIT, -1));
    }

    private OrderLine createOrderLine(String total, String cost) {
        return new OrderLine("", null, true, null, null, new BigDecimal(total), new BigDecimal(cost), "1301", null, null, null);
    }

    private class FaultyOrderLine extends TypeSafeMatcher<OrderLine> {
        private final String errorMsg;
        private OrderLine orderLine;

        public FaultyOrderLine(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        @Override
        protected boolean matchesSafely(OrderLine item) {
            this.orderLine = item;
            return item.getStatus().isFailed() && errorMsg.equals(item.getErrorMessage());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format("Expected failed and error message: %s, was %s and error message: %s",
                    errorMsg, orderLine.getStatus(), orderLine.getErrorMessage()));
        }
    }

    private class ValidatedOrderLine extends TypeSafeMatcher<OrderLine> {
        private final DebitOrCredit debit;
        private final int quantity;
        private OrderLine orderLine;

        public ValidatedOrderLine(DebitOrCredit debit, int quantity) {
            this.debit = debit;
            this.quantity = quantity;
        }

        @Override
        protected boolean matchesSafely(OrderLine item) {
            this.orderLine = item;
            return !item.getStatus().isFailed() && item.getDebitOrCredit() == debit && item.getQuantity() == quantity;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format("Expected not failed, debitFlag: %s and quantity: %d, was %s, debitFlag: %s and quantity: %d",
                    debit, quantity, orderLine.getStatus(), orderLine.getDebitOrCredit(), orderLine.getQuantity()));
        }
    }
}
