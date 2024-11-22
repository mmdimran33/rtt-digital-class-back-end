package com.rtt.subject;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {
    @Autowired
    private SubjectI subjectI;

    @Autowired
    private SubjectServiceImpl service;

    @PostMapping("/add-subject")
    public ResponseEntity<SubjectServiceResponse> addSubject(@RequestBody SubjectRequest subjectRequest)throws RegistrationException {
        try{
            SuccessRegistrationResponse response=subjectI.createSubject(subjectRequest);
            return ResponseEntity.ok(SubjectServiceResponse.builder().successSubjectResponse(response).build());
        }catch (Exception e){
            throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
    }

    @GetMapping("/subject_list")
    public SubjectServiceListReponse getSubjectlist() {
        Map<Integer, String> subjectMap =  service.getSubjectNameList();
        return SubjectServiceListReponse.builder().subjectServiceListReponse(subjectMap).build();

    }
}
