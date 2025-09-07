package com.poc.ddd.infrastructure.handler.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequestDTO {
    private String name;
    private String documentType;
    private String documentNumber;
}
