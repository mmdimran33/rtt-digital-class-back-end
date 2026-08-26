package com.rtt.projection;

import java.time.LocalDate;

public interface ViewAttendanceProjection {

    Long getAttendanceId();

    Long getStudentId();

    String getFirstName();

    String getLastName();

    String getStudentPhoneNo();

    String getStandardName();

    LocalDate getAttendanceMarkedDate();

    String getAttendanceAction();
}
