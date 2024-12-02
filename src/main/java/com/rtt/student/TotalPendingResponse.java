package com.rtt.student;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
 @AllArgsConstructor
@NoArgsConstructor
@ToString

public class TotalPendingResponse {
    private static final long serialVersionUID = 1L;
    @JsonProperty("total_balance_amount")
    private Float balanceAmount;
}
