package com.rtt.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {

    @JsonProperty("teacher_name")
    private String teacherName;

   /* @JsonProperty("subject")
    private String subject;*/

    @JsonProperty("phone_no")
    private long phoneNo;

    @JsonProperty("aadhar_no")
    private long aadharNo;

    @JsonProperty("salary")
    private float salary;

    @JsonProperty("mail_id")
    private String mailId;

    @JsonProperty("teacher_photo")
    private Blob teacherPhoto;

    @JsonProperty("teacher_qualification")
    private String teacherQualification;

    @JsonProperty("subject_Id")
    private Iterable<Integer> subjectId;
}

