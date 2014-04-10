package com.tradedoubler.billing.domain;

/**
* Provides states of invoice event
 */
public enum Event {
   POSTED, PAID, REMINDED, WRITE_OFF /*Same as BAD_DEBT in Pan*/, SETTLED
}
