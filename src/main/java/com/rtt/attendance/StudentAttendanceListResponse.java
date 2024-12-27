package com.rtt.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StudentAttendanceListResponse {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("student_phone_no")
    private String studentPhoneNo;
    @JsonProperty("standard_name")
    private String standardName;

}
