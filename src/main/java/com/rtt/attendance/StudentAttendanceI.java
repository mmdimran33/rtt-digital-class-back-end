package com.rtt.attendance;

import java.util.List;

public interface StudentAttendanceI {
    public List<StudentAttendanceListResponse> getStudentsAttendanceList(String standardName);
}
