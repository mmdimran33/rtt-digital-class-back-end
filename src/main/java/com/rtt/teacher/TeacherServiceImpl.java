package com.rtt.teacher;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.subject.Subject;
import com.rtt.subject.SubjectRepository;
import com.rtt.teacher.SuccessTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherI{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository repository;

    @Override
    public SuccessTeacherResponse createTeacher(TeacherRequest teacherRequest) {

        try {
            //Fetch subjects from the database
            Set<Subject> subjects=new HashSet<>(subjectRepository.findAllById(teacherRequest.getSubjectId()));

            // Build the Teacher entity from the request
            var teacher = Teacher.builder()
                    .teacherName(teacherRequest.getTeacherName())
                    .subject(teacherRequest.getSubject())
                    .phoneNo(teacherRequest.getPhoneNo())
                    .aadharNo(teacherRequest.getAadharNo())
                    .salary(teacherRequest.getSalary())
                    .mailId(teacherRequest.getMailId())
                    .teacherQualification(teacherRequest.getTeacherQualification())
                    .subjects(subjects) //Associate subjects with teacher
                    //.teacherPhoto(teacherRequest.getTeacherPhoto())
                    .build();

            // Save the teacher entity
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
