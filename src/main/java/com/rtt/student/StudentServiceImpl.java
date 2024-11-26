package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.feesstandard.StudentStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentI {

    @Autowired
    private StudentRepository repository;


    @Override
    public SuccessRegistrationResponse createStudent(StudentRequest studentRequest) {

        try {

            var student = StudentEntity.builder().
                    firstName(studentRequest.getFirstName())
                    .lastName(studentRequest.getLastName())
                    .standardName(studentRequest.getStandardName())
                    .fatherName(studentRequest.getFatherName())
                    .motherName(studentRequest.getMotherName())
                    .gaurdianName(studentRequest.getGaurdianName())
                    .gender(studentRequest.getGender())
                    .email(studentRequest.getEmail())
                    .studentPhoneNo(studentRequest.getStudentPhoneNo())
                    .gaurdianPhoneNo(studentRequest.getGaurdianPhoneNo())
                    .address(studentRequest.getAddress())
                    .registrationDate(studentRequest.getRegistrationDate())
                    .build();

            var standard = StudentStandard.builder()
                    .standardName(studentRequest.getStandardName())
                    .studentEntity(student)
                    .build();
            student.setStudentStandard(standard);
            StudentEntity savedStudent = repository.save(student);

            if (savedStudent.getStudentId() != null) {
           return SuccessRegistrationResponse.builder().responseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE)
                        .responseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION).build();
            }

        }catch (Exception e){
            throw new RegistrationException(RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
    return null;
    }


    @Override
    public List<StudentEntity> getAllStudents() {
        // Fetch all student records from the repository
        return repository.findAll();
    }

}
