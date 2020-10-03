package com.order.pizza.status;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HealthLevel {
    OK("OK"),
    ERROR("ERROR");

    private final String value;

    HealthLevel(String value) {
        this.value = value;
    }

    @JsonValue
    public java.lang.String getValue() {
        return value;
    }
}
