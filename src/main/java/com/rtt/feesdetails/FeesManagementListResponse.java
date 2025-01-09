package com.rtt.feesdetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeesManagementListResponse {

    private static final long serialVersionUID=1L;
    @JsonProperty("get-fees-management-list-status")
    private List<FeesManagementEntity> FeesManagementList;
}
