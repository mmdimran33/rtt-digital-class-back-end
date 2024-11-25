package com.rtt.teacher;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.subject.Subject;
import com.rtt.teacher.SuccessTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherI{

    @Autowired
    private TeacherRepository repository;

    @Override
    public SuccessTeacherResponse createTeacher(TeacherRequest teacherRequest) {

        try {
            // Build the Teacher entity from the request
            var teacher = Teacher.builder()
                    .teacherName(teacherRequest.getTeacherName())
                    .Subject(teacherRequest.getSubject())
                    .phoneNo(teacherRequest.getPhoneNo())
                    .AadharNo(teacherRequest.getAadharNo())
                    .salary(teacherRequest.getSalary())
                    .mailId(teacherRequest.getMailId())
                    .teacherQualification(teacherRequest.getTeacherQualification())
                    //.teacherPhoto(teacherRequest.getTeacherPhoto())
                    .build();

            // Save the teacher entity
//            var subject = Subject.builder().subjectId(teacher.getTeacherId())
            Teacher savedTeacher = repository.save(teacher);

            // Check if the teacher ID was generated and return success response
            if (savedTeacher.getTeacherId() != null) {
                return SuccessTeacherResponse.builder().responseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE)
                        .responseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION).build();
            }

        }catch (Exception e){
            throw new RegistrationException(RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
        return null;
    }
}
