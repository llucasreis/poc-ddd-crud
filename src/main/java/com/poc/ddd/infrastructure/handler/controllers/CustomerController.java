package com.poc.ddd.infrastructure.handler.controllers;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.ports.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequestDTO request) {
        Customer customer = customerService.create(request.getName(), request.getDocumentType(), request.getDocumentNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerMapper.toResponse(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") UUID id) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        return optionalCustomer
                .map(CustomerMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
