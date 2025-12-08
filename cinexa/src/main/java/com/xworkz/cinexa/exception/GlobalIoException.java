package com.xworkz.cinexa.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;

@RestControllerAdvice
public class GlobalIoException {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleFileUploadException(IOException ex){
        return ResponseEntity.status(500).body(ex.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleFileupload(MaxUploadSizeExceededException ex){
        return ResponseEntity.badRequest().body("Image Size should be 2mb or lesser ");
    }
}
