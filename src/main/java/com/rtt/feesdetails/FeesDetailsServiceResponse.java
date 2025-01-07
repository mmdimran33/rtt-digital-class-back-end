package com.rtt.feesdetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class FeesDetailsServiceResponse {

    private static final long serialVersionUID = 1L;
    @JsonProperty("create-fees-mgmt-status")
    private SuccessRegistrationResponse successRegistrationResponse;
}
