package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;

public interface StudentStandardAndFeesI {
    public SuccessRegistrationResponse addOrUpdateFees(StudentStandardAndFeesRequest studentStandardAndFeesRequest);
}
