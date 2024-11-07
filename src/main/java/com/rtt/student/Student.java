package com.rtt.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="student_Id")
   private int studentId;
   @Column(name="student_name")
   private String name;
   @Column(name="student_mailId")
   private String mailId;
    @Column(name="student_phoneno")
   private long phoneNo;
    @Column(name="father_name")
   private String fatherName;
    @Column(name="mother_name")
   private String motherName;
    @Column(name="gaurdian_name")
   private String gaurdian;
   



}
