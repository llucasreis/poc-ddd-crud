package com.poc.ddd.application;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.ports.ICustomerRepository;
import com.poc.ddd.domain.ports.ICustomerService;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(String name, String documentType, String documentNumber) {
        Document document = new Document(documentType, documentNumber);
        Customer customer = Customer.create(name, document);
        customerRepository.save(customer);
        return customer;
    }

    public Optional<Customer> findById(UUID id) {
        CustomerId customerId = new CustomerId(id);
        return customerRepository.findById(customerId);
    }

}
