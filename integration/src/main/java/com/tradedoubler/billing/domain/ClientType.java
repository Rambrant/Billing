package com.tradedoubler.billing.domain;

/**
 * The type of client. 0 = Advertiser, 1 = Reseller
 *
 * @author bjoek
 * @since 2013-02-13
 */
public enum ClientType {
    ADVERTISER(0), RESELLER(1);
    private final int value;

    private ClientType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ClientType getByValue(int value) {
        ClientType[] values = ClientType.values();
        for (ClientType clientType : values) {
            if (clientType.value == value) {
                return clientType;
            }
        }
        throw new IllegalArgumentException("Cannot find ClientType for value " + value);
    }
}
