package com.poc.ddd.domain.repositories;

import com.poc.ddd.domain.entities.Customer;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerRepository {
    void save(Customer customer);
    Optional<Customer> findById(UUID id);
}
