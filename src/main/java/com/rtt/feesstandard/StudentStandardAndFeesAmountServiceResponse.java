package com.rtt.feesstandard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StudentStandardAndFeesAmountServiceResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("student_fees_amount_response")
    private StudentStandardFeesAmountServiceResponse studentStandardFeesAmountServiceResponse;

}
