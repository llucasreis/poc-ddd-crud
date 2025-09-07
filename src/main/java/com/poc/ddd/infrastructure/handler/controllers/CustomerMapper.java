package com.poc.ddd.infrastructure.handler.controllers;

import com.poc.ddd.domain.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class CustomerMapper {
    public static CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getDocument().getType(),
                customer.getDocument().getNumber()
        );
    }
}
