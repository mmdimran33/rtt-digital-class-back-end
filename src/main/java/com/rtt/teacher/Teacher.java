package com.rtt.teacher;

import com.rtt.subject.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Teacher_details")
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teacher_Id")
    private Integer teacherId;
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
//    @Column(name="teacher_Photo")
//    private Blob teacherPhoto;
    @Column(name="teacher_Qualification")
    private String teacherQualification;

//    @ManyToMany
//    @JoinTable(
//            name = "Teacher_Subject",
//            joinColumns = @JoinColumn(name = "teacher_Id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_Id")
//    )
//    private Set<Subject> subjects; // A teacher can teach multiple subjects
}
