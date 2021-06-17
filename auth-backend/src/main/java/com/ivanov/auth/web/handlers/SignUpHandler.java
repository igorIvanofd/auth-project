package com.ivanov.auth.web.handlers;

import com.ivanov.auth.web.entity.User;
import com.ivanov.auth.web.model.SignUpRequest;
import com.ivanov.auth.web.model.SignUpResponse;
import com.ivanov.auth.web.model.exceptions.SignupFault;
import com.ivanov.auth.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SignUpHandler {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public SignUpResponse invoke(SignUpRequest request) throws SignupFault {
        validateOnExistingByUserName(request.getUserName());
        validateOnExistingByEmail(request.getEmail());
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        SignUpResponse response = new SignUpResponse();
        response.setMessage("you'r sign");
        return response;
    }

    private void validateOnExistingByUserName(String userName) throws SignupFault {
        if (userRepository.findByUsername(userName).isPresent()) {
            throw new SignupFault("UserName exist");
        }
    }

    private void validateOnExistingByEmail(String email) throws SignupFault {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new SignupFault("Email exist");
        }
    }
}
