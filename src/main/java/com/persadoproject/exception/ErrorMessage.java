package com.persadoproject.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
public class ErrorMessage {
    private HttpStatus statusCode;
    private Date timestamp;
    private String description;
    private List<String> errors;

    public ErrorMessage(HttpStatus statusCode, Date timestamp, String description, List<String> errors) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.description = description;
        this.errors = errors;
    }

}