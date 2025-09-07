package com.poc.ddd.infrastructure.handler.controllers;

import com.poc.ddd.application.CustomerUseCase;
import com.poc.ddd.domain.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequestDTO request) {
        Customer customer = customerUseCase.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerMapper.toResponse(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") UUID id) {
        Optional<Customer> optionalCustomer = customerUseCase.findById(id);

        return optionalCustomer
                .map(CustomerMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
