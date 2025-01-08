package com.rtt.feesdetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeesDetailsRequest {

    @JsonProperty("student_id")
    private Long studentId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("paid_person_name")
    private String paidPersonName;
    @JsonProperty("standard_name")
    private String standardName;
    @JsonProperty("email_id")
    private String email;
    @JsonProperty("student_phoneno")
    private String studentPhoneNo;
    @JsonProperty("total_fee_amount")
    private Float totalFeeAmount;
   /* @JsonProperty("discount_in_percentages")
    private Float discountInPercentages; */
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("paid_amount")
    private Float paidAmount;
    @JsonProperty("balance_amount")
    private Float balanceAmount;
    @JsonProperty("updated_date")
    private LocalDate updatedDate;

}
