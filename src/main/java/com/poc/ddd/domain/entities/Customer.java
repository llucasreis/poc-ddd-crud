package com.poc.ddd.domain.entities;

import com.poc.ddd.domain.vos.Document;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {
    private final UUID id;
    private final String name;
    private final Document document;

    public Customer(UUID id, String name, Document document) {
        this.id = id;
        this.name = name;
        this.document = document;
    }
}
