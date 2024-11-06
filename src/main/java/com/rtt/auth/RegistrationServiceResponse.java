package com.rtt.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class RegistrationServiceResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("user_registration_response")
    private SuccessRegistrationResponse successRegistrationResponse;
}
