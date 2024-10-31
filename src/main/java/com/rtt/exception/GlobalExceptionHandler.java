package com.rtt.exception;

import com.rtt.auth.AuthenticationResponse;
import com.rtt.common.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<RegistrationResponse> handleCustomRegistrationException(RegistrationException ex) {
        RegistrationResponse response = new RegistrationResponse();
        response.setResponseCode(ex.getResponseCode());
        response.setResponseDescription(ex.getResponseDescription());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
