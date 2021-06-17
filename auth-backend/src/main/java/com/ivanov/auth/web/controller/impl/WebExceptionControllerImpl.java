package com.ivanov.auth.web.controller.impl;

import com.ivanov.auth.web.controller.WebExceptionController;
import com.ivanov.auth.web.model.exceptions.CommonFault;
import com.ivanov.auth.web.model.exceptions.LoginFault;
import com.ivanov.auth.web.model.exceptions.SignupFault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class WebExceptionControllerImpl implements WebExceptionController {
    @Override
    public ResponseEntity<CommonFault> handleException(SignupFault signupFault) {
        CommonFault commonFault = new CommonFault(HttpStatus.BAD_REQUEST, signupFault.getMessage());
        return new ResponseEntity<>(commonFault, commonFault.getHttpStatus());
    }

    @Override
    public ResponseEntity<CommonFault> handleException(LoginFault loginFault) {
        CommonFault commonFault = new CommonFault(HttpStatus.BAD_REQUEST, loginFault.getMessage());
        return new ResponseEntity<>(commonFault, commonFault.getHttpStatus());
    }
}
