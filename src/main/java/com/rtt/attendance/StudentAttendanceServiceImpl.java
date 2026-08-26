package com.rtt.attendance;

import com.rtt.common.StudentAttendanceRequest;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.projection.ViewAttendanceProjection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rtt.common.SuccessRegistrationResponse;

import java.time.LocalDate;
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
    public List<SuccessRegistrationResponse> createAttendance(
            List<StudentAttendanceRequest> studentAttendanceRequests) {

        try {
            List<AttendanceMarkingEntity> attendances =
                    studentAttendanceRequests.stream()
                            .map(request -> AttendanceMarkingEntity.builder()
                                    .studentId(request.getStudentId())
                                    .attendanceMarkedDate(request.getAttendanceMarkedDate())
                                    .attendanceAction(request.getAttendanceAction())
                                    .build())
                            .collect(Collectors.toList());

            List<AttendanceMarkingEntity> savedAttendances =
                    attendanceRepository.saveAll(attendances);

            return savedAttendances.stream()
                    .map(savedAttendance -> SuccessRegistrationResponse.builder()
                            .responseCode(
                                    RegistrationResponseConstants
                                            .REGISTRATION_RESPONSE_SUCCESS_CODE)
                            .responseDescription(
                                    RegistrationResponseConstants
                                            .REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION)
                            .build())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RegistrationException(
                    RegistrationResponseConstants
                            .REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants
                            .REGISTRATION_RESPONSE_FAILURE_DESCTIPTION
                            + e.getMessage()
            );
        }
    }

    @Override
    public List<AttendanceMarkingEntity> getAllStudentsWithAttendance() {
        return attendanceRepository.findAll();

    }

    @Override
    public List<ViewAttendanceProjection> viewAttendance(
            ViewAttendanceRequest request) {

        LocalDate fromDate = request.getFromDate();
        LocalDate toDate = request.getToDate();

        if (fromDate == null || toDate == null) {
            throw new IllegalArgumentException(
                    "From date and To date are required");
        }

        if (toDate.isBefore(fromDate)) {
            throw new IllegalArgumentException(
                    "To date cannot be before From date");
        }

        if (toDate.isAfter(
                fromDate.plusMonths(1).minusDays(1))) {

            throw new IllegalArgumentException(
                    "Attendance view is limited to one month");
        }

        String standardName = request.getStandardName();
        Long courseId = request.getCourseId();

        if (standardName != null
                && !standardName.isBlank()
                && courseId != null) {

            throw new IllegalArgumentException(
                    "Provide either standardName or courseId, not both");
        }

        if ((standardName == null || standardName.isBlank())
                && courseId == null) {

            throw new IllegalArgumentException(
                    "Either standardName or courseId is required");
        }

        return repository.findAttendanceForView(
                fromDate,
                toDate,
                standardName,
                courseId);
    }
}
