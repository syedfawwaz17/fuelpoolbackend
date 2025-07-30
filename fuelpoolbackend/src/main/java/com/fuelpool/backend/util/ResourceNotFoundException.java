package com.fuelpool.backend.util;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceNotFoundException {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ConfigDataResourceNotFoundException ex) {
        return new ResponseEntity<>(ApiResponse.failure(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ApiResponse.failure("Validation failed: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Generic Exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.failure("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
