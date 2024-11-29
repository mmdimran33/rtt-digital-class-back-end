package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.auth.RegistrationResponse;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StudentServiceResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("student_registration_response")
    private SuccessRegistrationResponse successRegistrationResponse;
}

