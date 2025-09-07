package com.poc.ddd.domain.ports;

import com.poc.ddd.domain.entities.Customer;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerService {
    Customer create(String name, String documentType, String documentNumber);
    Optional<Customer> findById(UUID id);
}
