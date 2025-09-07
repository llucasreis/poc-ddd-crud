package com.poc.ddd.infrastructure.persistence.postgres;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerModel, UUID> {

}
