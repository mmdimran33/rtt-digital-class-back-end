package com.rtt.feesstandard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentStandardAndFeesRequest {

   @JsonProperty("fee_amount")
    private Integer feeAmount;
   @JsonProperty("standard_name")
    private String standardName;


}