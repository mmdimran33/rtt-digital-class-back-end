package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;

import java.util.List;

public interface StudentI {

    public SuccessRegistrationResponse createStudent(StudentRequest studentRequest );

    // Method to fetch all students
    List<StudentEntity> getAllStudents();

    public TotalRecoveredResponse getTotalRecoveredAmount();
}
