package com.rtt.feesstandard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class StudentStandardAndFeesListServiceResponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("standard_list_response")
    private List<StudentStandardAndFeesEntity> studentStandardAndFeesEntityList;
}
