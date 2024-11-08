package com.rtt.teacher;
import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.student.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private  TeacherI teacherI;

    @PostMapping("/add-teacher")
    public ResponseEntity<TeacherServiceResponse> addTeacher(
            @RequestBody TeacherRequest teacherRequest) throws RegistrationException {
            try{
                SuccessTeacherResponse response  =teacherI.createTeacher(teacherRequest);
                return ResponseEntity.ok(TeacherServiceResponse.builder().successTeacherResponse(response).build());
            }catch (Exception e){
                throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                        RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
            }
    }
}


