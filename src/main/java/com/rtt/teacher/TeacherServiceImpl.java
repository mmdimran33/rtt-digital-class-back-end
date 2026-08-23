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
import java.util.List;
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
                    //.subject(teacherRequest.getSubject())
                    .phoneNo(teacherRequest.getPhoneNo())
                    .aadharNo(teacherRequest.getAadharNo())
                    .salary(teacherRequest.getSalary())
                    .mailId(teacherRequest.getMailId())
                    .teacherQualification(teacherRequest.getTeacherQualification())
                    .aboutTeacher(teacherRequest.getAboutTeacher())
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

    @Override
    public SuccessTeacherResponse updateTeacher(
            Integer teacherId,
            TeacherRequest teacherRequest) {

        try {

            // Find existing teacher
            Teacher teacher = repository.findById(teacherId)
                    .orElseThrow(() -> new RegistrationException(
                            RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                            "Teacher not found with ID: " + teacherId
                    ));

            // Fetch subjects from database
            Set<Subject> subjects = new HashSet<>(
                    subjectRepository.findAllById(
                            teacherRequest.getSubjectId()
                    )
            );

            // Update teacher fields
            teacher.setTeacherName(teacherRequest.getTeacherName());
            teacher.setPhoneNo(teacherRequest.getPhoneNo());
            teacher.setAadharNo(teacherRequest.getAadharNo());
            teacher.setSalary(teacherRequest.getSalary());
            teacher.setMailId(teacherRequest.getMailId());
            teacher.setTeacherQualification(
                    teacherRequest.getTeacherQualification()
            );
            teacher.setAboutTeacher(
                    teacherRequest.getAboutTeacher()
            );

            // Update Many-to-Many subjects
            teacher.setSubjects(subjects);

            // Save updated teacher
            Teacher updatedTeacher = repository.save(teacher);

            if (updatedTeacher.getTeacherId() != null) {

                return SuccessTeacherResponse.builder()
                        .responseCode(
                                RegistrationResponseConstants
                                        .REGISTRATION_RESPONSE_SUCCESS_CODE
                        )
                        .responseDescription(
                                "Teacher updated successfully"
                        )
                        .build();
            }

        } catch (RegistrationException e) {
            throw e;

        } catch (Exception e) {

            throw new RegistrationException(
                    RegistrationResponseConstants
                            .REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants
                            .REGISTRATION_RESPONSE_FAILURE_DESCTIPTION
                            + e.getMessage()
            );
        }

        return null;
    }

    @Override
    public SuccessTeacherResponse deleteTeacher(Integer teacherId) {

        try {

            Teacher teacher = repository.findById(teacherId)
                    .orElseThrow(() -> new RegistrationException(
                            RegistrationResponseConstants
                                    .REGISTRATION_RESPONSE_FAILURE_CODE,
                            "Teacher not found with ID: " + teacherId
                    ));

            repository.delete(teacher);

            return SuccessTeacherResponse.builder()
                    .responseCode(
                            RegistrationResponseConstants
                                    .REGISTRATION_RESPONSE_SUCCESS_CODE
                    )
                    .responseDescription(
                            "Teacher deleted successfully"
                    )
                    .build();

        } catch (RegistrationException e) {
            throw e;

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
    public List<Teacher> allTeacherList() {
        return repository.findAll();
    }


}
