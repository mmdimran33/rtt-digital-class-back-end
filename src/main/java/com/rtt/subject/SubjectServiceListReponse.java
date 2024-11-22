package com.rtt.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.common.SuccessRegistrationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
public class SubjectServiceListReponse {

    private static final long serialVersionUID = 1L;

    @JsonProperty("subject_service_list_response")
    private Map<Integer, String> subjectServiceListReponse;



}
