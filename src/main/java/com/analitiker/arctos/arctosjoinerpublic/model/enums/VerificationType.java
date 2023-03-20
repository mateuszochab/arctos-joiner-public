package com.analitiker.arctos.arctosjoinerpublic.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VerificationType {
    EMAIL("EMAIL"),
    PHONE("PHONE");

    @JsonValue
    public String getValue() {
        return value;
    }

    private final String value;

    @JsonCreator
    public static VerificationType getItem(String code) {
        for (VerificationType item : values()) {
            if (code.equals(item.getValue())) {
                return item;
            }
        }
        return null;
    }
}
