package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.student.StudentRequest;
import com.rtt.student.StudentServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
// Fresh Changes
    @GetMapping("/get-student-fee-amount-by-standard-name")
    public StudentStandardAndFeesAmountServiceResponse getFeeAmountByStandardName(
            @RequestParam String standardName)  {
            // Call the service method to get fee amount based on standard name
            StudentStandardFeesAmountServiceResponse response = studentStandardAndFeesI.getFeeAmountByStandardName(standardName);
            // Return the response wrapped in a ResponseEntity
            return StudentStandardAndFeesAmountServiceResponse.builder().studentStandardFeesAmountServiceResponse(response)
                    .build();

    }

}
