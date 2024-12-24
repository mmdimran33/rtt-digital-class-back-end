package com.rtt.attendance;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class StudentAttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="student_phoneno")
    private Long studentPhoneNo;
    @Column(name="standard_name")
    private String standardName;
}
