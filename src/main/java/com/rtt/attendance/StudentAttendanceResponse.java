package com.rtt.attendance;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class StudentAttendanceResponse {
    @JsonProperty("students-attendance-marked-response-status")
    private List<AttendanceMarkingEntity> studentsWithAttendance;

}




