package com.poc.ddd.domain.entities;

import com.poc.ddd.domain.vos.LicensePlate;
import com.poc.ddd.domain.vos.VehicleId;
import lombok.Getter;

@Getter
public class Vehicle {
    private final VehicleId id;
    private final LicensePlate licensePlate;

    private Vehicle(VehicleId id, LicensePlate licensePlate) {
        if (id == null) throw new IllegalArgumentException("Vehicle ID cannot be null");
        if (licensePlate == null) throw new IllegalArgumentException("License Plate cannot be null");
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public static Vehicle create(LicensePlate licensePlate) {
        VehicleId id = VehicleId.generate();
        return new Vehicle(id, licensePlate);
    }

    public static Vehicle restore(VehicleId id, LicensePlate licensePlate) {
        return new Vehicle(id, licensePlate);
    }
}
