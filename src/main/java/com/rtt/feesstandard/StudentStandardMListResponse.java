package com.rtt.feesstandard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@Builder
public class StudentStandardMListResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("subject_service_list_response")
    private Map<Integer, String> studentStandardMListResponse;
}
