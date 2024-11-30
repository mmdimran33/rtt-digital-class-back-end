package com.rtt.student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalEarningResponse {
    private static final long serialVersionUID=1L;
    @JsonProperty("total_earning_of_students")
    private Float balanceAmount;
}
