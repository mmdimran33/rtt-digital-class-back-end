package com.rtt.teacher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Teacher_details")
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teacher_Id")
    private int teacherId;
    @Column(name="teacher_Name")
    private  String teacherName;
    @Column(name="teacher_Subject")
    private String Subject;
    @Column(name="phone_No")
    private long phoneNo;
    @Column(name="Aadhar_No")
    private long AadharNo;
    @Column(name="teacher_Salary")
    private float salary;
    @Column(name="mail_Id")
    private String mailId;
    @Column(name="teacher_Photo")
    private Blob teacherPhoto;
    @Column(name="teacher_Qualification")
    private String teacherQualification;





}
