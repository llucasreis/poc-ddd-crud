package com.poc.ddd.infrastructure.handler.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class VehicleResponse {
    private UUID id;
    @JsonProperty("license_plate")
    private String licensePlate;
}
