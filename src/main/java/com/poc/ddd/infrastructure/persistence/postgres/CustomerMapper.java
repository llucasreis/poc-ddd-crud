package com.poc.ddd.infrastructure.persistence.postgres;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.entities.Vehicle;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;
import com.poc.ddd.domain.vos.LicensePlate;
import com.poc.ddd.domain.vos.VehicleId;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerModel toPersistence(Customer domainCustomer) {
        CustomerModel model = new CustomerModel();
        model.setId(domainCustomer.getId().value());
        model.setName(domainCustomer.getName());
        model.setDocumentType(domainCustomer.getDocument().getType());
        model.setDocumentNumber(domainCustomer.getDocument().getNumber());

        List<VehicleModel> vehicleEntities = domainCustomer.getVehicles().stream()
                .map(CustomerMapper::toPersistence)
                .collect(Collectors.toList());
        vehicleEntities.forEach(vehicleEntity -> vehicleEntity.setCustomer(model));

        model.setVehicles(vehicleEntities);
        return model;
    }

    public static Customer toDomain(CustomerModel model) {
        CustomerId customerId = new CustomerId(model.getId());
        Document document = new Document(model.getDocumentType(), model.getDocumentNumber());

        List<Vehicle> domainVehicles = model.getVehicles().stream()
                .map(CustomerMapper::toDomain)
                .collect(Collectors.toList());
        return Customer.restore(customerId, model.getName(), document, domainVehicles);
    }

    private static VehicleModel toPersistence(Vehicle domainVehicle) {
        VehicleModel model = new VehicleModel();
        model.setId(domainVehicle.getId().value());
        model.setLicensePlate(domainVehicle.getLicensePlate().getValue());
        return model;
    }

    private static Vehicle toDomain(VehicleModel model) {
        VehicleId vehicleId = new VehicleId(model.getId());
        LicensePlate licensePlate = new LicensePlate(model.getLicensePlate());
        return Vehicle.restore(vehicleId, licensePlate);
    }
}
