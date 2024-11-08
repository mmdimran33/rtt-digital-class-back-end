package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.student.StudentRequest;
import com.rtt.student.StudentServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/standardandfees")
public class StudentStandardAndFeesController {

    @Autowired
    private StudentStandardAndFeesI studentStandardAndFeesI;

    @PostMapping("/add-fees")
    public ResponseEntity<StudentStandardAndFeesServiceResponse> addStandardFees(
        @RequestBody StudentStandardAndFeesRequest studentStandardAndFeesRequest)throws RegistrationException {

            try{
                SuccessRegistrationResponse response  =studentStandardAndFeesI.addOrUpdateFees(studentStandardAndFeesRequest);
                return ResponseEntity.ok(StudentStandardAndFeesServiceResponse.builder().successRegistrationResponse(response).build());
            }catch (Exception e){
                throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                        RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
            }
        }
}
