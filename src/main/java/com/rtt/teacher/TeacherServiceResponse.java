package com.rtt.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TeacherServiceResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("teacher_registration_response")
    private SuccessTeacherResponse successTeacherResponse;
}
