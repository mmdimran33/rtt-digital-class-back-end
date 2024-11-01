package com.rtt.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
public class UserLoginResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("user_login_response")
    private AuthenticationResponse authenticationResponse;
}
