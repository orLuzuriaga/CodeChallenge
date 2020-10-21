package com.codeChallenge.codeChallenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidInputException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public InvalidInputException()
    {
        super("Invalid input");
    }
    
}
