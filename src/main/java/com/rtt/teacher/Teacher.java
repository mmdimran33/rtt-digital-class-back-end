package com.rtt.teacher;

import com.rtt.subject.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teacher_details")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teacher_Id")
    private Integer teacherId;

    @Column(name="teacher_Name")
    private String teacherName;

   /* @Column(name="teacher_Subject")
    private String subject;*/

    @Column(name="phone_No")
    private long phoneNo;

    @Column(name="aadhar_No")
    private long aadharNo;

    @Column(name="teacher_Salary")
    private float salary;

    @Column(name="mail_Id")
    private String mailId;

    @Column(name="teacher_Qualification")
    private String teacherQualification;

    @Column(name="about_teacher" , columnDefinition = "TEXT")
    private String aboutTeacher;

    @Lob // Specifies that the field is a large object
    @Column(name = "teacher_photo", columnDefinition = "BLOB")
    private byte[] teacher_photo;


    @ManyToMany
    @JoinTable(
            name = "Teacher_Subject", // Join table name
            joinColumns = @JoinColumn(name = "teacher_Id"), // Foreign key in the join table for Teacher
            inverseJoinColumns = @JoinColumn(name = "subject_Id") // Foreign key in the join table for Subject
    )
    private Set<Subject> subjects; // A teacher can teach multiple subjects
}
