package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
public class StudentCountServiceResponse {

    private static final long serialVersionUID = 1L;
    @JsonProperty("total_number_students_status")
    private StudentCountResponse studentCountResponse;
}
