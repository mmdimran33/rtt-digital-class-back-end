package com.rtt.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewAttendanceRequest {

    private LocalDate fromDate;

    private LocalDate toDate;

    private String standardName;

    private Long courseId;
}