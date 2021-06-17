package com.ivanov.auth.web.handlers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ivanov.auth.web.entity.User;
import com.ivanov.auth.web.model.LoginRequest;
import com.ivanov.auth.web.model.LoginResponse;
import com.ivanov.auth.web.model.exceptions.LoginFault;
import com.ivanov.auth.web.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ivanov.auth.web.model.Constants.ROLE;
import static com.ivanov.auth.web.model.Constants.SECRET_KEY;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginHandler {
    @Autowired
    UserRepository userRepository;

    public LoginResponse invoke(LoginRequest loginRequest) throws LoginFault {
        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new LoginFault("UserName not found"));
        if (!user.getPassword().equals(password)) {
            throw new LoginFault("Password incorrect");
        }
        String token = JWT.create().withSubject(loginRequest.getUserName()).withExpiresAt(new Date(System.currentTimeMillis() + 60000 * 1000))
                .withClaim("roles", newArrayList(ROLE))
                .sign(Algorithm.HMAC512(SECRET_KEY.getBytes()));
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        return response;
    }

    private List<String> newArrayList(String value) {
        List<String> list = new ArrayList<>();
        list.add(value);
        return list;
    }
}
