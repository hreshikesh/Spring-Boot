package com.xworkz.cinexa.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalIoException {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleFileUploadException(IOException ex){
        return ResponseEntity.status(202).body(ex.getMessage());
    }
}
