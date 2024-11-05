package com.rtt.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessRegistrationResponse {

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("response_description")
    private String responseDescription;
}
