package com.rtt.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}

