package com.codeChallenge.codeChallenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFound(UserNotFoundException e)
    {
        Error error = new Error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(UserNotValidException.class)
    public ResponseEntity<Error> handleUserNotValid(UserNotValidException e)
    {
        Error error = new Error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Error> handleInvalidInput(InvalidInputException e)
    {
        Error error = new Error(e.getMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(error);
    }



    
}
