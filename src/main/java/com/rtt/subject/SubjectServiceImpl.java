package com.rtt.subject;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectI{

    @Autowired
    private SubjectRepository repository;


    @Override
    public SuccessRegistrationResponse createSubject(SubjectRequest subjectRequest) {
        try{
            var subject= Subject.builder()
                    .subjectName(subjectRequest.getSubjectName())
                    .subjectDescription(subjectRequest.getSubjectDescription())
                    .build();

            Subject savedSubject= repository.save(subject);

            if (savedSubject.getSubjectId()!= null){
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
    public List<Subject> getSubjectList() {
        return null;
    }

    @Override
    public Map<Integer, String> getSubjectNameList() {
        // Fetch the subject data from the repository
        List<Object[]> repo = repository.getSubjectNameList();

        // Map the results to a Map<Integer, String>
        return repo.stream()
                .collect(Collectors.toMap(
                        row -> (Integer) row[1],    // subjectId (row[1])
                        row -> (String) row[0]      // subjectName (row[0])
                ));
    }


}
