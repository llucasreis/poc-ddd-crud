package com.poc.ddd.infrastructure.handler.controllers;

import com.poc.ddd.domain.entities.Customer;

public class CustomerMapper {
    public static CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId().value(),
                customer.getName(),
                customer.getDocument().getType(),
                customer.getDocument().getNumber()
        );
    }
}

