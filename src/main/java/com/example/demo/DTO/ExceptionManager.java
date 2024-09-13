package com.example.demo.DTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.runtimeError(e.getMessage()));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> CustomeExceptionHandler(CustomException e){
        return ResponseEntity.status(HttpStatus.OK)
                .body(Response.error(e.getErrorCode()));
    }
}