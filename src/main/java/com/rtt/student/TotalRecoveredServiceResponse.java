package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TotalRecoveredServiceResponse {
    private static final long serialVersionUID = 1L;
    @JsonProperty("total_recovered_amount_status")
    private  TotalRecoveredResponse totalRecoveredResponse;

}
