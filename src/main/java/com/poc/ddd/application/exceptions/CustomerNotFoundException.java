package com.poc.ddd.application.exceptions;

import com.poc.ddd.domain.vos.CustomerId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(CustomerId id) {
        super("Customer not found with id: " + id.value());
    }
}
