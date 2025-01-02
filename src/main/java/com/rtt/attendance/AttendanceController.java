package com.rtt.attendance;

import com.rtt.common.SuccessRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/v1/attendance")
@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AttendanceController {
    @Autowired
    private StudentAttendanceI studentAttendanceI;

    @GetMapping("/get-students-attendance-list/{standardName}")
    public ResponseEntity<?> getStudentsAttendance(@PathVariable String standardName) {
        List<StudentAttendanceListResponse> responseList = studentAttendanceI.getStudentsAttendanceList(standardName);
        if (responseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(StudentAttendanceListServiceResponse.builder().studentAttendanceListResponse(responseList).build());
    }

    @PostMapping("students-attendance-marking-batch")
    public ResponseEntity<?> createAttendances(@RequestBody List<StudentAttendanceRequest> studentAttendanceRequests) {
        try {
            List<SuccessRegistrationResponse> SuccessRegistrationResponse = studentAttendanceI.createAttendance(studentAttendanceRequests);
            return ResponseEntity.ok(SuccessRegistrationResponse);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-attendance-marked-list")
    public StudentAttendanceResponse getStudentsWithAttendance() {
        List<AttendanceMarkingEntity> attendanceList = studentAttendanceI.getAllStudentsWithAttendance();
        return new StudentAttendanceResponse(attendanceList);
    }
}

