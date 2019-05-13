package com.timeseries.dto;

public enum ItemType {

    VOLTAGE("Voltage"),
    TEMPERATURE("Temperature"),
    UNDEFINED("undefined");

    private String value;

    ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ItemType fromString(String type) {
        try {
            if (type == null || type.isEmpty()) {
                return UNDEFINED;
            }
            return valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return UNDEFINED;
        }

    }
}
