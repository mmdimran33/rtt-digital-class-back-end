package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.exception.RegistrationException;

import java.util.List;

public interface FeesDetailsServiceI {

    public SuccessRegistrationResponse createFeesManagement(FeesDetailsRequest feesDetailsRequest) throws RegistrationException;
    public List<FeesManagementEntity> getFeesManagementList();
}
