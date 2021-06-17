package com.ivanov.auth.web.controller;

import com.ivanov.auth.web.model.exceptions.CommonFault;
import com.ivanov.auth.web.model.exceptions.LoginFault;
import com.ivanov.auth.web.model.exceptions.SignupFault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface WebExceptionController {
     @ResponseStatus(value = HttpStatus.BAD_REQUEST)
     @ExceptionHandler(SignupFault.class)
     ResponseEntity<CommonFault> handleException(SignupFault signupFault);
     @ResponseStatus(value = HttpStatus.BAD_REQUEST)
     @ExceptionHandler(LoginFault.class)
     ResponseEntity<CommonFault> handleException(LoginFault loginFault);
}
