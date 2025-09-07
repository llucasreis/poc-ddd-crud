package com.poc.ddd.application;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.repositories.ICustomerRepository;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import com.poc.ddd.infrastructure.handler.controllers.CreateCustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerUseCase {
    private final ICustomerRepository customerRepository;

    public CustomerUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequestDTO request) {
        Customer customer = Customer.create(
                request.getName(), new Document(request.getDocumentType(), request.getDocumentNumber()));
        customerRepository.save(customer);
        return customer;
    }

    public Optional<Customer> findById(UUID id) {
        CustomerId customerId = new CustomerId(id);
        return customerRepository.findById(customerId);
    }

}
