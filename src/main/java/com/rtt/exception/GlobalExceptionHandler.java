package com.rtt.exception;

import com.rtt.auth.RegistrationResponse;
import com.rtt.common.SuccessRegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<SuccessRegistrationResponse> handleCustomRegistrationException(RegistrationException ex) {
        SuccessRegistrationResponse response = new SuccessRegistrationResponse();
        response.setResponseCode(ex.getResponseCode());
        response.setResponseDescription(ex.getResponseDescription());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
