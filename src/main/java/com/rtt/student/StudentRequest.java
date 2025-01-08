package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("paid_person_name")
    private String paidPersonName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("standard_name")
    private String standardName;
    @JsonProperty("father_name")
    private String fatherName;
    @JsonProperty("mother_name")
    private String motherName;
    @JsonProperty("gaurdian_name")
    private String gaurdianName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("email")
    private String email;
    @JsonProperty("student_phone_no")
    private String studentPhoneNo;
    @JsonProperty("gaurdian_phone_no")
    private String gaurdianPhoneNo;
    @JsonProperty("address")
    private String address;
    @JsonProperty("registration_date")
    private LocalDate registrationDate;
    //New Request Added
    @JsonProperty("total_fee_amount")
    private  Float totalFeeAmount;
    @JsonProperty("discount_in_percentages")
    private  Float discountInPercentages;
    @JsonProperty("payment_method")
    private  String paymentMethod;
    @JsonProperty("paid_amount")
    private  Float paidAmount;
    @JsonProperty("balance_amount")
    private  Float balanceAmount;

}
