package com.analitiker.arctos.arctosjoinerpublic.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CountryMobilePhonePrefixType {
    PL("PL"),
    DK("DK");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CountryMobilePhonePrefixType getItem(String code) {
        for (CountryMobilePhonePrefixType item : values()) {
            if (code.equals(item.getValue())) {
                return item;
            }
        }
        return null;
    }
}
