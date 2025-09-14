package com.poc.ddd.application;

import com.poc.ddd.application.exceptions.CustomerNotFoundException;
import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.entities.Vehicle;
import com.poc.ddd.infrastructure.persistence.repositories.CustomerRepository;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import com.poc.ddd.domain.vos.LicensePlate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(String name, String documentType, String documentNumber) {
        Document document = new Document(documentType, documentNumber);
        Customer customer = Customer.create(name, document);
        customerRepository.save(customer);
        return customer;
    }

    public Customer findById(UUID id) {
        CustomerId customerId = new CustomerId(id);
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public Customer addVehicleToCustomer(UUID id, String licensePlate) {
        CustomerId customerId = new CustomerId(id);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        Vehicle vehicle = Vehicle.create(new LicensePlate(licensePlate));
        customer.addVehicle(vehicle);
        customerRepository.save(customer);
        return customer;
    }

}
