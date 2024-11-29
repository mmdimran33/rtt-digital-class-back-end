package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

     // Fetch total no. of students return response
    @GetMapping("/get-total-number-of-student")
    public ResponseEntity<StudentCountServiceResponse>  getTotalNoOfStudent() {
        StudentCountResponse totalNoOfStudents= studentService.getTotalNoOfStudent();
       return  ResponseEntity.ok(StudentCountServiceResponse
                .builder().studentCountResponse(totalNoOfStudents).build());

    }
}