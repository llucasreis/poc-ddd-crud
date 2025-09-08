package com.poc.ddd.infrastructure.persistence.postgres;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class VehicleModel {
    @Id
    private UUID id;
    private String licensePlate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;
}
