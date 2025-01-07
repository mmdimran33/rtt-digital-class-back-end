package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/fees-details-mgmt")
public class FeesDetailsController {

    @Autowired
    private FeesDetailsServiceI feesDetailsServiceI;

    @PostMapping("/create-fees-details")
    public ResponseEntity<FeesDetailsServiceResponse> register(
            @RequestBody FeesDetailsRequest feesDetailsRequest) throws RegistrationException {
        try {
            SuccessRegistrationResponse response = feesDetailsServiceI.createFeesManagement(feesDetailsRequest);
            return ResponseEntity.ok(FeesDetailsServiceResponse.builder().successRegistrationResponse(response).build());
        } catch (Exception e) {
            throw new RegistrationException(RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
    }

}
