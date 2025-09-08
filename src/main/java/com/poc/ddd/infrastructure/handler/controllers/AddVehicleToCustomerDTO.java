package com.poc.ddd.infrastructure.handler.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddVehicleToCustomerDTO {
    @JsonProperty("license_plate")
    private String licensePlate;
}
