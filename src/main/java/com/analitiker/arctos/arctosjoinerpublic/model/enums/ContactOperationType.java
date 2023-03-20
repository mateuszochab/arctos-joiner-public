package com.analitiker.arctos.arctosjoinerpublic.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContactOperationType {
    ADD("ADD"),
    UPDATE("UPDATE"),
    DELETED("DELETED");

    @JsonValue
    public String getValue() {
        return value;
    }

    private final String value;
}
