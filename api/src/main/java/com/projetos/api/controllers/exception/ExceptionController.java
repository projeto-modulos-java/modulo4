package com.projetos.api.controllers.exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElement(NoSuchElementException exception){
        return ResponseEntity.notFound().build();
    }
    
}
