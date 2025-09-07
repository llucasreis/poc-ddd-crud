package com.poc.ddd.domain.vos;

import lombok.Getter;

@Getter
public class Document {
    private final String type;
    private final String number;

    public Document(String type, String number) {
        this.type = type;
        this.number = number;
    }
}
