package com.rtt.attendance;

import com.rtt.common.SuccessRegistrationResponse;

import java.util.List;

public interface StudentAttendanceI {
    public List<StudentAttendanceListResponse> getStudentsAttendanceList(String standardName);
    public List<SuccessRegistrationResponse> createAttendance(List<StudentAttendanceRequest> studentAttendanceRequests);
    public List<AttendanceMarkingEntity> getAllStudentsWithAttendance();
}