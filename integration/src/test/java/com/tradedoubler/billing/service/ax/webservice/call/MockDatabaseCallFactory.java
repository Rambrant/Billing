package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.service.pan.call.AbstractDatabaseCall;
import com.tradedoubler.billing.service.pan.call.DatabaseCallFactory;

/**
 * @author bjoek
 * @since 2012-08-30
 */
public class MockDatabaseCallFactory extends DatabaseCallFactory {

    private final AbstractDatabaseCall[] calls;

    public MockDatabaseCallFactory(AbstractDatabaseCall... calls) {
        this.calls = calls;
    }

    @Override
    public <T extends AbstractDatabaseCall> T createCall(Class<T> clazz) {
        for (AbstractDatabaseCall call : calls) {
            if (clazz.isAssignableFrom(call.getClass()))
                return (T) call;
        }

        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
