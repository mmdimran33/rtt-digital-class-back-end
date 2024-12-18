package com.rtt.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentUpdateResponse {
    @JsonProperty("student_id")
    private Integer studentId;

    @JsonProperty("response_description")
    private String responseDescription;
}
