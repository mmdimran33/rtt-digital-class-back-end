package com.rtt.subject;


import com.rtt.common.SuccessRegistrationResponse;

import java.util.List;
import java.util.Map;

public interface SubjectI {
    public SuccessRegistrationResponse createSubject(SubjectRequest subjectRequest);

    public List<Subject>getSubjectList();
    public Map<Integer, String> getSubjectNameList();
}
