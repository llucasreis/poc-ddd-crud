package com.poc.ddd.infrastructure.persistence.repositories;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.repositories.ICustomerRepository;
import com.poc.ddd.infrastructure.persistence.postgres.SpringDataCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private final SpringDataCustomerRepository jpaRepository;

    public CustomerRepository(SpringDataCustomerRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return Optional.empty();
    }
}
