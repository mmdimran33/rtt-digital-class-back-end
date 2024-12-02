package com.rtt.student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder
public class TotalEarningServiceResponse {
    private static final long serialVersionUID = 1L;
    @JsonProperty("total_earning_students_status")
    private TotalEarningResponse totalEarningResponse;
}
