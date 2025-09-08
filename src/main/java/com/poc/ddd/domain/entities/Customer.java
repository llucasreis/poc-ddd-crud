package com.poc.ddd.domain.entities;

import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Customer {
    private final CustomerId id;
    private final String name;
    private final Document document;
    private final List<Vehicle> vehicles;

    private Customer(CustomerId id, String name, Document document, List<Vehicle> vehicles) {
        if (id == null) throw new IllegalArgumentException("Customer ID cannot be null");
        if (name == null) throw new IllegalArgumentException("Customer name cannot be null");
        if (document == null) throw new IllegalArgumentException("Document cannot be null");
        this.id = id;
        this.name = name;
        this.document = document;
        this.vehicles = vehicles;
    }

    public static Customer create(String name, Document document) {
        if (name.trim().length() < 3) {
            throw new IllegalArgumentException("Customer name cannot be less than 3 characters");
        }
        CustomerId id = CustomerId.generate();
        return new Customer(id, name, document, new ArrayList<>());
    }

    public static Customer restore(CustomerId id, String name, Document document, List<Vehicle> vehicles) {
        return new Customer(id, name, document, vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        // Regra de negócio: um cliente não pode ter dois veículos com a mesma placa.
        boolean licensePlateExists = this.vehicles.stream()
                .anyMatch(v -> v.getLicensePlate().equals(vehicle.getLicensePlate()));

        if (licensePlateExists) {
            throw new IllegalStateException("Vehicle with this license plate already registered for this customer.");
        }
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        // Protege a lista de modificações externas
        return Collections.unmodifiableList(vehicles);
    }

}
