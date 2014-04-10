package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.service.crm.call.*;

/**
 * @author bjoek
 * @since 2012-08-30
 */
public class MockAzureCallFactory extends AzureCallFactory {

    private final AbstractAzureCall[] calls;

    public MockAzureCallFactory(AbstractAzureCall... calls) {
        this.calls = calls;
    }

    @Override
    public <T extends AbstractAzureCall> T createCall(Class<T> clazz) {
        for (AbstractAzureCall call : calls) {
            if (clazz.isAssignableFrom(call.getClass()))
                return (T) call;
        }

        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
