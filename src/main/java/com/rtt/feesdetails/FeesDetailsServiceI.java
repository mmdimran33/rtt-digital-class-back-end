package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.exception.RegistrationException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeesDetailsServiceI {

    public SuccessRegistrationResponse createFeesManagement(FeesDetailsRequest feesDetailsRequest) throws RegistrationException;
    //public List<FeesManagementEntity> getFeesManagementList();
    List<FeesManagementItemResponse> getFeesManagementList();
    SuccessRegistrationResponse updateStudentFees(
            Long id,
            FeesDetailsRequest feesDetailsRequest) throws RegistrationException;
}
