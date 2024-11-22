package com.rtt.subject;

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
@Table(name = "Subject_master")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_Id")
    private Integer subjectId;
    @Column(name="subject_Name")
    private  String subjectName;
    @Column(name="subject_desc")
    private String subjectDescription;

}
