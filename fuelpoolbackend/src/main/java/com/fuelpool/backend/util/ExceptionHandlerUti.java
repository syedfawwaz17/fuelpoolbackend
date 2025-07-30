package com.fuelpool.backend.util;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fuelpool.backend.util.ApiResponse; // ADD THIS IMPORT

@RestControllerAdvice
public class ExceptionHandlerUti {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ConfigDataResourceNotFoundException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(ApiResponse.failure(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        // Build readable validation error text
        StringBuilder sb = new StringBuilder("Validation failed: ");
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                sb.append("[").append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append("] ")
        );
        return new ResponseEntity<>(ApiResponse.failure(sb.toString().trim()), HttpStatus.BAD_REQUEST);
    }

    // Generic Exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.failure("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
