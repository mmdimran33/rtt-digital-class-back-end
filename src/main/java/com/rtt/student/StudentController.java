package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentI studentService;

    @PostMapping("/create-students")
    public ResponseEntity<StudentServiceResponse> register(
            @RequestBody StudentRequest studentRequest) throws RegistrationException {
        try {
            SuccessRegistrationResponse response = studentService.createStudent(studentRequest);
            return ResponseEntity.ok(StudentServiceResponse.builder().successRegistrationResponse(response).build());
        } catch (Exception e) {
            throw new RegistrationException(RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
    }
    // Fetch all students and return the response

    @GetMapping("/get-all-students")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/get-total-recovered-amount")
    public ResponseEntity<TotalRecoveredServiceResponse> getTotalRecoveredAmount(){
        //Fetch All Students Recovered Amounts and return response
        TotalRecoveredResponse totalRecoveredResponse = studentService.getTotalRecoveredAmount();
        return ResponseEntity.ok(TotalRecoveredServiceResponse.builder().totalRecoveredResponse(totalRecoveredResponse).build());
    }

    @GetMapping("/get-total-earning-of-students")
    public ResponseEntity<TotalEarningServiceResponse> getTotalFeeAmount() {
        // Fetch total earning of students and return the response
        TotalEarningResponse totalEarningResponse = studentService.getTotalFeeAmount();
        return ResponseEntity.ok(TotalEarningServiceResponse.builder()
                .totalEarningResponse(totalEarningResponse).build());
    }

     // Fetch total no. of students return response
    @GetMapping("/get-total-number-of-student")
    public ResponseEntity<StudentCountServiceResponse>  getTotalNoOfStudent() {
        StudentCountResponse totalNoOfStudents= studentService.getTotalNoOfStudent();
       return  ResponseEntity.ok(StudentCountServiceResponse
                .builder().studentCountResponse(totalNoOfStudents).build());

    }
    @GetMapping("/get-total-pending-amount")
    public ResponseEntity<TotalPendingServiceResponse> getTotalPendingAmount(){
        TotalPendingResponse totalPendingResponse=studentService.getTotalPendingAmount();
        return ResponseEntity.ok(TotalPendingServiceResponse.builder().totalPendingResponse(totalPendingResponse).build());
    }

    @GetMapping("/get-standard-list-by-standard-name")
    public ResponseEntity<StudentListResponse> getStandardListByStandardWise(@RequestParam String standardName) {
        // Fetch the list of students based on the standard
        List<Object[]> standardList =  studentService.getStandardListByStandardWise(standardName);
      if (standardList.isEmpty()) {
          // Build and return the response
          return ResponseEntity.noContent().build();
      }

                          // Use standardName instead of studentListResponse

          return ResponseEntity.ok(StudentListResponse.builder().StandardList(standardList).build());
    }
    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<StudentUpdateServiceResponse> updateStudent(@PathVariable Integer studentId,@RequestBody StudentRequest studentRequest) {
        StudentUpdateServiceResponse response = studentService.getUpdateStudentById(studentId, studentRequest);
        return ResponseEntity.ok(response);
    }

}
