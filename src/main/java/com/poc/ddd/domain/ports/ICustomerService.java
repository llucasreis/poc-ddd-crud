package com.poc.ddd.domain.ports;

import com.poc.ddd.domain.entities.Customer;

import java.util.UUID;

public interface ICustomerService {
    Customer create(String name, String documentType, String documentNumber);
    Customer findById(UUID id);
    Customer addVehicleToCustomer(UUID id, String licensePlate);
}
