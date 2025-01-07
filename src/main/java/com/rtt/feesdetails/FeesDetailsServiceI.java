package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.exception.RegistrationException;

public interface FeesDetailsServiceI {

    public SuccessRegistrationResponse createFeesManagement(FeesDetailsRequest feesDetailsRequest) throws RegistrationException;
}
