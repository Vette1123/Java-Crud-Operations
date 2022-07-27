package com.example.springapitask.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception exception , WebRequest request) {
        return  new ResponseEntity<>(exception, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
