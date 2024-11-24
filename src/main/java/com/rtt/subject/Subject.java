package com.rtt.subject;

import com.rtt.teacher.Teacher;
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
@Table(name = "Subject_master")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_Id")
    private Integer subjectId;

    @Column(name="subject_Name")
    private String subjectName;

    @Column(name="subject_desc")
    private String subjectDescription;

    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers; // A subject can be taught by multiple teachers
}

