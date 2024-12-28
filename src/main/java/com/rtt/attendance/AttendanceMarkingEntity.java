package com.rtt.attendance;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Attendance_marking")
public class AttendanceMarkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="student_phoneno")
    private String studentPhoneNo;
    @Column(name="standard_name")
    private String standardName;
    @Column(name = "attendance_marked_date")
    private LocalDate attendanceMarkedDate;
    @Column(name = "attendance_action")
    private String attendanceAction;
}
