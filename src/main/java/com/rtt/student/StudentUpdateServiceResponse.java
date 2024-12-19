package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StudentUpdateServiceResponse {

    private static final long serialVersionUID = 1L;
    @JsonProperty("student-update-response-status")
    private StudentUpdateResponse studentUpdateResponse;
}
