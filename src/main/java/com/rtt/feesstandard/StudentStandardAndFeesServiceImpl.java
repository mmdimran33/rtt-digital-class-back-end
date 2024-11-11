package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class StudentStandardAndFeesServiceImpl implements  StudentStandardAndFeesI {

    @Autowired
    private StudentStandardAndFeesRepository studentStandardAndFeesRepository;

    @Override
    public SuccessRegistrationResponse addOrUpdateFees(StudentStandardAndFeesRequest studentStandardAndFeesRequest) {

        try {
            // Check if a record with the same standard name already exists
            Optional<StudentStandardAndFeesEntity> existingRecord = studentStandardAndFeesRepository.findByStandardName(studentStandardAndFeesRequest.getStandardName());

            StudentStandardAndFeesEntity standardAndFees;

            if (existingRecord.isPresent()) {
                standardAndFees = existingRecord.get();
                standardAndFees.setFeeAmount(studentStandardAndFeesRequest.getFeeAmount());
                standardAndFees.setStandardName(studentStandardAndFeesRequest.getStandardName());
            } else {
                // Create new record
                standardAndFees = StudentStandardAndFeesEntity.builder()
                        .standardName(studentStandardAndFeesRequest.getStandardName())
                        .feeAmount(studentStandardAndFeesRequest.getFeeAmount())
                        .build();
            }

            StudentStandardAndFeesEntity savedStandardFees = studentStandardAndFeesRepository.save(standardAndFees);
            // Success response if saved successfully
            if (savedStandardFees.getFeeId() != null) {
                return SuccessRegistrationResponse.builder()
                        .responseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE)
                        .responseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION)
                        .build();
            }
        } catch (Exception e) {
            throw new RegistrationException(
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                    RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + " " + e.getMessage()
            );
        }
        return null;
    }


    //09-11 changes
    @Override
    public StudentStandardFeesAmountServiceResponse getFeeAmountByStandardName(String standardName) {
           // Double feeAmount= studentStandardAndFeesRepository.findFeesAmountByStandardName(standardName);
            Optional<StudentStandardAndFeesEntity> studentStandardAndFeesEntity = studentStandardAndFeesRepository.findByStandardName(standardName);
            StudentStandardAndFeesEntity standardAndFees;

                standardAndFees = studentStandardAndFeesEntity.get();

        return StudentStandardFeesAmountServiceResponse.builder().studentFeeAmount(standardAndFees.getFeeAmount())
                .build();
    }

}


