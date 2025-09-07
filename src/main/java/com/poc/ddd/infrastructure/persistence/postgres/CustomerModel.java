package com.poc.ddd.infrastructure.persistence.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class CustomerModel {
    @Id
    private UUID id;
    private String name;
    private String documentType;
    private String documentNumber;
}
