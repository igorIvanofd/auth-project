package com.ivanov.auth.web.controller.impl;

import com.ivanov.auth.web.controller.WebController;
import com.ivanov.auth.web.handlers.LoginHandler;
import com.ivanov.auth.web.handlers.SignUpHandler;
import com.ivanov.auth.web.model.LoginRequest;
import com.ivanov.auth.web.model.LoginResponse;
import com.ivanov.auth.web.model.SignUpRequest;
import com.ivanov.auth.web.model.SignUpResponse;
import com.ivanov.auth.web.model.exceptions.LoginFault;
import com.ivanov.auth.web.model.exceptions.SignupFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class WebAuthControllerImpl implements WebController {
    @Autowired
    LoginHandler loginHandler;
    @Autowired
    SignUpHandler signUpHandler;

    @Override
    public LoginResponse login(LoginRequest requestBody) throws LoginFault {
        return loginHandler.invoke(requestBody);
    }

    @Override
    public SignUpResponse signUp(SignUpRequest requestBody) throws SignupFault {
        return signUpHandler.invoke(requestBody);
    }

    @Override
    public String getResources(String authToken) {
        return "resources";
    }
}
