package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;

import java.util.List;
import java.util.Map;

public interface StudentStandardAndFeesI {
    public SuccessRegistrationResponse addOrUpdateFees(StudentStandardAndFeesRequest studentStandardAndFeesRequest);

    public List<StudentStandardAndFeesEntity> getStandardAndFeesList();

    // Method to fetch fee amount by standard name
    public StudentStandardFeesAmountServiceResponse getFeeAmountByStandardName(String standardName);

    //Method to fetch Standard-Master List
    public Map<Integer, String> getStandardNameList();
}
