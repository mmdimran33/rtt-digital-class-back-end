package com.rtt.common;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentAttendanceResponse {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String studentPhoneNo;
    private String standardName;

}




