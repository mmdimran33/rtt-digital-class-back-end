package com.rtt.exception;
import lombok.Data;

@Data
public class RegistrationException extends RuntimeException {

    private final String responseCode;
    private final String responseDescription;

    public RegistrationException(String responseCode, String responseDescription) {
        super(responseDescription);
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }
}
