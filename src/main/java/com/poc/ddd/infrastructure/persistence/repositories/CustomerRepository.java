package com.poc.ddd.infrastructure.persistence.repositories;

import com.poc.ddd.domain.entities.Customer;

import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.infrastructure.persistence.postgres.CustomerMapper;
import com.poc.ddd.infrastructure.persistence.postgres.CustomerModel;
import com.poc.ddd.infrastructure.persistence.postgres.SpringDataCustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepository {

    private final SpringDataCustomerRepository jpaRepository;

    public CustomerRepository(SpringDataCustomerRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public void save(Customer customer) {
        CustomerModel model = CustomerMapper.toPersistence(customer);
        this.jpaRepository.save(model);
    }

    public Optional<Customer> findById(CustomerId id) {
        UUID modelId = id.value();
        Optional<CustomerModel> optionalCustomerModel = this.jpaRepository.findById(modelId);
        return optionalCustomerModel.map(CustomerMapper::toDomain);
    }
}
