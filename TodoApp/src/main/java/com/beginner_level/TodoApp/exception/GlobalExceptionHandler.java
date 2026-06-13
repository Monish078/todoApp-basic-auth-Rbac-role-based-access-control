package com.beginner_level.TodoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // ye jaroori hota hai , central jagh aban jati hai jha sare exc pakdte hai
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)  // ye exception ko handle karta hai aur message bhejta hau
    public ResponseEntity<String> handle(ResourceNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
