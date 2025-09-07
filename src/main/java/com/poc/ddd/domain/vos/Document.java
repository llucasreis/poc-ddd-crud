package com.poc.ddd.domain.vos;

import lombok.Getter;

@Getter
public class Document {
    private final String type;
    private final String number;

    public Document(String type, String number) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Document type cannot be empty.");
        }
        if (number == null || !isValidNumber(number)) {
            throw new IllegalArgumentException("Document number is invalid.");
        }
        this.type = type;
        this.number = number;
    }

    private boolean isValidNumber(String number) {
        return !number.trim().isEmpty();
    }
}
