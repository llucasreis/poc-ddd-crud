package com.poc.ddd.infrastructure.handler.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {
    private UUID id;
    private String name;
    private String documentType;
    private String documentNumber;
}
