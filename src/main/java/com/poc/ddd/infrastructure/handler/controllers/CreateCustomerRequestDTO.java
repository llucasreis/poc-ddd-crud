package com.poc.ddd.infrastructure.handler.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequestDTO {
    private String name;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("document_number")
    private String documentNumber;
}
