package com.poc.ddd.domain.vos;

import lombok.Getter;

@Getter
public class LicensePlate {
    private String value;

    public LicensePlate(String value) {
        if (value == null || !isValidValue(value)) {
            throw new IllegalArgumentException("License Plate value is invalid.");
        }
        this.value = value;
    }

    private boolean isValidValue(String value) {
        return !value.trim().isEmpty();
    }

    public boolean equals(LicensePlate licensePlate) {
        return value.equalsIgnoreCase(licensePlate.getValue());
    }
}
