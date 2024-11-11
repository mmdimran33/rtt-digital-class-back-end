package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;

public interface StudentStandardAndFeesI {
    public SuccessRegistrationResponse addOrUpdateFees(StudentStandardAndFeesRequest studentStandardAndFeesRequest);

    // Method to fetch fee amount by standard name
    public StudentStandardFeesAmountServiceResponse getFeeAmountByStandardName(String standardName);
}
