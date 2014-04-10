package com.tradedoubler.billing.ax;

/**
 * @author bjoek
 * @since 2012-06-11
 */
public class LogTimer {
    private long time = System.currentTimeMillis();

    @Override
    public String toString() {
        return String.format("%d ms", System.currentTimeMillis() - time);
    }

    public void reset() {
        time = System.currentTimeMillis();
    }
}
