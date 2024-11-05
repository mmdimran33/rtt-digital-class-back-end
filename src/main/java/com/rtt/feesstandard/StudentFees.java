package com.rtt.feesstandard;

import jakarta.persistence.*;

@Entity
@Table(name="fee")
public class StudentFees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feeId;
    @Column(name = "student_id")
    private Integer studentId;

}
