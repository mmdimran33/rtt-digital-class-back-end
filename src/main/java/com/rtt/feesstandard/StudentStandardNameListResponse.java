package com.rtt.feesstandard;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
public class StudentStandardNameListResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("student-standard-name-list-status")
    private List<Map<String, String>> studentStandardMListResponse;


}
