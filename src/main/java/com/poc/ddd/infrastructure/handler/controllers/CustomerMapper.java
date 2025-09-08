package com.poc.ddd.infrastructure.handler.controllers;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.entities.Vehicle;

import java.util.List;

public class CustomerMapper {
    public static VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId().value(),
                vehicle.getLicensePlate().getValue()
        );
    }
    public static CustomerResponse toResponse(Customer customer) {
        List<VehicleResponse> vehicleResponses = customer.getVehicles().stream()
                .map(CustomerMapper::toResponse)
                .toList();

        return new CustomerResponse(
                customer.getId().value(),
                customer.getName(),
                customer.getDocument().getType(),
                customer.getDocument().getNumber(),
                vehicleResponses
        );
    }
}

