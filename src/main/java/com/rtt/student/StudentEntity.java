package com.rtt.student;

import com.rtt.feesstandard.StudentStandard;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "paid_person_name")
    private String paidPersonName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "standard_name")
    private String standardName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "gaurdian_name")
    private String gaurdianName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String email;
    @Column(name = "student_phoneno")
    private String studentPhoneNo;
    @Column(name = "gaurdian_phoneno")
    private String gaurdianPhoneNo;
    @Column(name = "address")
    private String address;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    //New Column Added
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
    @Column(name = "created_date")
    private  Timestamp createdDate;
    @Column(name = "updated_date")
    private  Timestamp updatedDate;




    // One-to-One bi-directional relationship flow from StudentStandard to StudentEntity
//    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
//    private StudentStandard studentStandard;
//


}
