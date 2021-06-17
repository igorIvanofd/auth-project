package com.ivanov.auth.web.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoginFault extends Exception {
     public LoginFault(String message) {
         super(message);
     }
}
