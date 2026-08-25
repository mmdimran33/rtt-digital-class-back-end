package com.rtt.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceRequest {

    private Long studentId;

    private LocalDate attendanceMarkedDate;

    private String attendanceAction;
}
