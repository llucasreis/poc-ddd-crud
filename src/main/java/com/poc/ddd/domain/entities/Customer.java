package com.poc.ddd.domain.entities;

import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {
    private final CustomerId id;
    private final String name;
    private final Document document;

    private Customer(CustomerId id, String name, Document document) {
        if (id == null) throw new IllegalArgumentException("Customer ID cannot be null");
        if (name == null) throw new IllegalArgumentException("Customer name cannot be null");
        if (document == null) throw new IllegalArgumentException("Document cannot be null");
        this.id = id;
        this.name = name;
        this.document = document;
    }

    public static Customer create(String name, Document document) {
        if (name.trim().length() < 3) {
            throw new IllegalArgumentException("Customer name cannot be less than 3 characters");
        }
        CustomerId id = CustomerId.generate();
        return new Customer(id, name, document);
    }

    public static Customer restore(CustomerId id, String name, Document document) {
        return new Customer(id, name, document);
    }
}
