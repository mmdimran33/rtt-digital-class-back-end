package com.rtt.attendance;

import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rtt.common.SuccessRegistrationResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentAttendanceServiceImpl implements StudentAttendanceI{
    @Autowired
      private StudentAttendanceRepository repository;
    @Autowired
      private StudentAttendanceMarkingRepository attendanceRepository;

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

    @Override
    public List<SuccessRegistrationResponse> createAttendance(List<StudentAttendanceRequest> studentAttendanceRequests) {
        try {
            List<AttendanceMarkingEntity> attendances = studentAttendanceRequests.stream()
                    .map(request -> AttendanceMarkingEntity.builder()
                            .firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .studentPhoneNo(request.getStudentPhoneNo())
                            .standardName(request.getStandardName())
                            .attendanceMarkedDate(request.getAttendanceMarkedDate())
                            .attendanceAction(request.getAttendanceAction())
                            .build())
                    .collect(Collectors.toList());
            List<AttendanceMarkingEntity> savedAttendances = attendanceRepository.saveAll(attendances);
            return savedAttendances.stream()
                    .map(savedAttendance -> SuccessRegistrationResponse.builder()
                            .responseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE)
                            .responseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION)
                            .build())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RegistrationException(
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage()
            );
        }
    }
    @Override
    public List<AttendanceMarkingEntity> getAllStudentsWithAttendance() {
        return attendanceRepository.findAll();

    }
}
