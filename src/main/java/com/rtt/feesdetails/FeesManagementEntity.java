package com.rtt.feesdetails;

import jakarta.persistence.*;
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
@Entity
@Table(name = "fees_details")
public class FeesManagementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "standard_name")
    private String standardName;
    @Column(name = "email_id")
    private String email;
    @Column(name = "student_phoneno")
    private String studentPhoneNo;
    @Column(name = "total_fee_amount")
    private Float totalFeeAmount;
    @Column(name = "discount_in_percentages")
    private Float discountInPercentages;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "paid_amount")
    private Float paidAmount;
    @Column(name = "balance_amount")
    private Float balanceAmount;
    @Column(name = "updated_date")
    private  Timestamp updatedDate;




    // One-to-One bi-directional relationship flow from StudentStandard to StudentEntity
//    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
//    private StudentStandard studentStandard;
//


}
