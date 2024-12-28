package com.rtt.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceRequest {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("student_phoneno")
    private String studentPhoneNo;
    @JsonProperty("standard_name")
    private String standardName;
    @JsonProperty("attendance_marked_date")
    private LocalDate attendanceMarkedDate;
    @JsonProperty("attendance_action")
    private String attendanceAction;
}
