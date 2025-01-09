package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/get-fees-management-list")
    public FeesManagementListResponse getFeesManagementList() {
        List<FeesManagementEntity> feesManagementList = feesDetailsServiceI.getFeesManagementList();
        FeesManagementListResponse response = new FeesManagementListResponse();
        response.setFeesManagementList(feesManagementList);
        if (!feesManagementList.isEmpty()) {
            System.out.println("First record: " + feesManagementList.get(0));
        } else {
            System.out.println("No records found for the given List");
        }
        return response;
    }
}
