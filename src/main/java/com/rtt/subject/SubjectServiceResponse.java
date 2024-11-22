package com.rtt.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class SubjectServiceResponse {
    private static final long serialVersionUID = 1L;

    @JsonProperty("subject_registration_response")
    private SuccessRegistrationResponse successSubjectResponse;
}
