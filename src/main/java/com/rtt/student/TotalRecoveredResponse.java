package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotalRecoveredResponse {
   // private float total_recovered_amount_of_students;
    private static final long serialVersionUID = 1L;
   @JsonProperty("total_recovered_amount")
   private Float paidAmount;
}
