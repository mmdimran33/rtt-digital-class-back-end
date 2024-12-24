package com.rtt.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class StudentAttendanceListServiceResponse {

    private static final long serialVersionUID = 1L;
    @JsonProperty("student-attendance-list-response-status")
     private List<StudentAttendanceListResponse> studentAttendanceListResponse;
}
