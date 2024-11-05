package com.rtt.feesstandard;

import com.rtt.student.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "standard")
public class StudentStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "standard_id")
    private Integer standardId;
    @Column(name = "standard_name")
    private String standardName;
   /* @Column(name = "student_id")
    private Integer studentId;*/


    // One-to-One relationship with StudentEntity
    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)  // Foreign key column in StudentStandard table
    private StudentEntity studentEntity;

}
