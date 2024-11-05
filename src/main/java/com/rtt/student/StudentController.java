package com.rtt.student;

import com.rtt.auth.RegisterRequest;
import com.rtt.auth.RegistrationResponse;
import com.rtt.auth.RegistrationServiceResponse;
import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentI studentService;

    @PostMapping("/create-students")
    public ResponseEntity<StudentServiceResponse> register(
            @RequestBody StudentRequest studentRequest) throws RegistrationException {

        try{
            SuccessRegistrationResponse response  = studentService.createStudent(studentRequest);
            response.setResponseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE);
            response.setResponseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION);
            return ResponseEntity.ok(StudentServiceResponse.builder().successRegistrationResponse(response).build());

        }catch (Exception e){
            throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
    }
}
