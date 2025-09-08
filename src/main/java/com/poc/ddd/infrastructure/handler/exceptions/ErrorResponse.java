package com.poc.ddd.infrastructure.handler.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp
) {
}
