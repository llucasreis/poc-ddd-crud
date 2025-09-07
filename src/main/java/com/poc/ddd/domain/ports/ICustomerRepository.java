package com.poc.ddd.domain.ports;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.vos.CustomerId;

import java.util.Optional;

public interface ICustomerRepository {
    void save(Customer customer);
    Optional<Customer> findById(CustomerId id);
}
