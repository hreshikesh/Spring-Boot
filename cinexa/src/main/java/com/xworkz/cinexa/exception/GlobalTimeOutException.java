package com.xworkz.cinexa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class GlobalTimeOutException {
    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<String> timeOutException(TimeoutException ex){
        return ResponseEntity.status(408).body(ex.getMessage());
    }

}
