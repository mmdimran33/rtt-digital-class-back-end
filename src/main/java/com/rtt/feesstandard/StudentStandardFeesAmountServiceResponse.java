package com.rtt.feesstandard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StudentStandardFeesAmountServiceResponse {
    private static final long serialVersionUID = 1L;

    @JsonProperty("student_fee_amount")
    private Double studentFeeAmount;
}
