package com.ivanov.auth.web.controller;

import com.ivanov.auth.web.model.LoginRequest;
import com.ivanov.auth.web.model.LoginResponse;
import com.ivanov.auth.web.model.SignUpRequest;
import com.ivanov.auth.web.model.SignUpResponse;
import com.ivanov.auth.web.model.exceptions.LoginFault;
import com.ivanov.auth.web.model.exceptions.SignupFault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface WebController {
    @RequestMapping(value = "/v1/auth/login",  produces = { "application/json; charset=UTF-8" },
            consumes = { "application/json; charset=UTF-8" }, method = RequestMethod.POST)
    LoginResponse login(@RequestBody LoginRequest requestBody) throws LoginFault;
    @RequestMapping(value = "/v1/auth/signup",  produces = { "application/json; charset=UTF-8" },
            consumes = { "application/json; charset=UTF-8" }, method = RequestMethod.POST)
    SignUpResponse signUp(@RequestBody SignUpRequest requestBody) throws SignupFault;
    @RequestMapping(value = "/v1/resources", produces = { "application/json; charset=UTF-8" },
            method = RequestMethod.GET)
    String getResources(@RequestHeader(value = "Authorization", required = true) String authToken);
}
