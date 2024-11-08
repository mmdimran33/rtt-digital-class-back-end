package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentStandardAndFeesServiceImpl implements  StudentStandardAndFeesI{

    @Autowired
    private StudentStandardAndFeesRepository studentStandardAndFeesRepository;

    @Override
    public SuccessRegistrationResponse addStandardAndFees(StudentStandardAndFeesRequest studentStandardAndFeesRequest) {
        try {
            var standardAndFees = StudentStandardAndFeesEntity.builder()
                    .standardName(studentStandardAndFeesRequest.getStandardName())
                    .feeAmount(studentStandardAndFeesRequest.getFeeAmount()).build();
            StudentStandardAndFeesEntity saveStandardFees = studentStandardAndFeesRepository.save(standardAndFees);

            if(saveStandardFees.getFeeId() != null){
                return SuccessRegistrationResponse.builder().responseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE)
                        .responseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION).build();
            }

        } catch (Exception e) {
            throw new RegistrationException(RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
        }
        return null;
    }
}