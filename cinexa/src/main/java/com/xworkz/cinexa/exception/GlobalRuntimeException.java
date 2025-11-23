package com.xworkz.cinexa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class GlobalRuntimeException {


    @ExceptionHandler(java.lang.RuntimeException.class)
    public ResponseEntity<String> runtimeException(java.lang.RuntimeException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }



}
