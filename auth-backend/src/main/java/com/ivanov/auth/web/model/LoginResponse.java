package com.ivanov.auth.web.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {
    @JsonProperty("token")
    private String token;
}
