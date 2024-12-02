package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TotalPendingServiceResponse {
    private static final long serialVersionUID = 1L;
    @JsonProperty("total_pending_amount_status")
    private TotalPendingResponse totalPendingResponse;
}
