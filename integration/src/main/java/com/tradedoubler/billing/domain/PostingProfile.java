package com.tradedoubler.billing.domain;

/**
 * The Posting profile of an Invoicing rule
 * 1 - Means standard
 *
 * @author bjoek
 * @since 2012-08-17
 */
public class PostingProfile {
    private final int value;

    public PostingProfile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
