package com.poc.ddd.domain.vos;

import java.util.UUID;

public record VehicleId(UUID value) {
    public static VehicleId generate() {
        return new VehicleId(UUID.randomUUID());
    }
}
