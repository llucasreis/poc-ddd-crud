package com.poc.ddd.application;

import com.poc.ddd.application.exceptions.CustomerNotFoundException;
import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.entities.Vehicle;
import com.poc.ddd.domain.ports.ICustomerRepository;
import com.poc.ddd.domain.ports.ICustomerService;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import com.poc.ddd.domain.vos.LicensePlate;
import org.springframework.stereotype.Service;

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

    @Override
    public Customer findById(UUID id) {
        CustomerId customerId = new CustomerId(id);
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    @Override
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
