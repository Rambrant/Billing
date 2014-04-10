package com.tradedoubler.billing.service.ax.webservice.call;

/**
 * @author bjoek
 * @since 2012-08-30
 */
public class MockWebServiceCallFactory extends WebServiceCallFactory {

    private final AbstractWebServiceCall[] calls;

    public MockWebServiceCallFactory(AbstractWebServiceCall... calls) {
        this.calls = calls;
    }

    @Override
    public <T extends AbstractWebServiceCall> T createCall(Class<T> clazz) {
        for (AbstractWebServiceCall call : calls) {
            if (clazz.isAssignableFrom(call.getClass()))
                return (T) call;
        }

        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
