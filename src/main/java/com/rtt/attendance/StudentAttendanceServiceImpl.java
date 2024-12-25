package com.rtt.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceI{
    @Autowired
    private StudentAttendanceRepository repository;
    @Override
    public List<StudentAttendanceListResponse> getStudentsAttendanceList(String standardName) {
        List<Object[]> attendanceList = repository.findStudentsAttendanceByStandardName(standardName);
        if (attendanceList.isEmpty()) {
            return new ArrayList<>();
        }
        List<StudentAttendanceListResponse> responseList = new ArrayList<>();
        for (Object[] record : attendanceList) {
            StudentAttendanceListResponse response = StudentAttendanceListResponse.builder()
                    .firstName((String) record[0])
                    .lastName((String) record[1])
                    .studentPhoneNo((String) record[2])
                    .standardName((String) record[3])
                    .build();
            responseList.add(response);
        }
        return responseList;
    }
}

