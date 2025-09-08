package com.poc.ddd.infrastructure.persistence.postgres;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL, // Salva/atualiza/deleta veículos junto com o cliente
            orphanRemoval = true,      // Remove veículos do banco se forem removidos da lista
            fetch = FetchType.EAGER    // Carrega os veículos junto com o cliente
    )
    private List<VehicleModel> vehicles = new ArrayList<>();
}
