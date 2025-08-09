package com.github.vitorlima1602.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
