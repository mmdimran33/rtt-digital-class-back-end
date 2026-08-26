package com.rtt.attendance;

import com.rtt.common.StudentAttendanceRequest;
import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.projection.ViewAttendanceProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/v1/attendance")
@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AttendanceController {
    @Autowired
    private StudentAttendanceI studentAttendanceService;

    @GetMapping("/get-students-attendance-list/{standardName}")
    public ResponseEntity<?> getStudentsAttendance(@PathVariable String standardName) {
        List<StudentAttendanceListResponse> responseList = studentAttendanceService.getStudentsAttendanceList(standardName);
        if (responseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(StudentAttendanceListServiceResponse.builder().studentAttendanceListResponse(responseList).build());
    }

    @PostMapping("students-attendance-marking-batch")
    public ResponseEntity<?> createAttendances(@RequestBody List<StudentAttendanceRequest> studentAttendanceRequests) {
        try {
            List<SuccessRegistrationResponse> SuccessRegistrationResponse = studentAttendanceService.createAttendance(studentAttendanceRequests);
            return ResponseEntity.ok(SuccessRegistrationResponse);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-attendance-marked-list")
    public StudentAttendanceResponse getStudentsWithAttendance() {
        List<AttendanceMarkingEntity> attendanceList = studentAttendanceService.getAllStudentsWithAttendance();
        return new StudentAttendanceResponse(attendanceList);
    }

    @PostMapping("view-attendance")
    public ResponseEntity<?> viewAttendance(
            @RequestBody ViewAttendanceRequest request) {

        try {

            List<ViewAttendanceProjection> response =
                    studentAttendanceService.viewAttendance(request);

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}

