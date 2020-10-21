package com.codeChallenge.codeChallenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotValidException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNotValidException(Long id)
    {
        super("Invalid user id");
    }
    
}
