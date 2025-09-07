package com.poc.ddd.domain.vos;

import java.util.UUID;

public record CustomerId(UUID value) {

    public static CustomerId generate() {
        return new CustomerId(UUID.randomUUID());
    }
}
