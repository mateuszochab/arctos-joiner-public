package com.analitiker.arctos.arctosjoinerpublic.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContactType {
    EMAIL("EMAIL"),
    PHONE("PHONE");

    @JsonValue
    public String getValue() {
        return value;
    }

    private final String value;
}
