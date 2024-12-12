package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;

import java.util.List;

public interface StudentI {

    public SuccessRegistrationResponse createStudent(StudentRequest studentRequest );

    // Method to fetch all students

    List<StudentEntity> getAllStudents();
    // Method to fetch all students total earning
    public TotalEarningResponse getTotalFeeAmount();
    public TotalRecoveredResponse getTotalRecoveredAmount();
    public StudentCountResponse getTotalNoOfStudent();
    public TotalPendingResponse getTotalPendingAmount();
    public List<Object[]> getStandardListByStandardWise(String standardName);
}
