package com.tradedoubler.billing.domain;

/**
 * Language code according to ISO 639-1 (Alpha-2)
 *
 * @author bjoek
 * @since 2012-08-17
 */
public class Language {
    private final String languageCode;

    public Language(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
