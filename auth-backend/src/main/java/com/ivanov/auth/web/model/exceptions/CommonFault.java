package com.ivanov.auth.web.model.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class CommonFault {
    private final HttpStatus httpStatus;
    private final String message;
}
