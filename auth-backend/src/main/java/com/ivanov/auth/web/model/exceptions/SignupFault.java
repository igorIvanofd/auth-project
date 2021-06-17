package com.ivanov.auth.web.model.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

public class SignupFault extends Exception{
    public SignupFault(String message) {
        super(message);
    }
}
