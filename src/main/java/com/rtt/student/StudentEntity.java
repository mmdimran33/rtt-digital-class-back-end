package com.rtt.student;

import com.rtt.feesstandard.StudentStandard;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    @Column(name = "first_name")
    private String firstName;
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

    // One-to-One relationship with StudentStandard
    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
    private StudentStandard studentStandard;



}
