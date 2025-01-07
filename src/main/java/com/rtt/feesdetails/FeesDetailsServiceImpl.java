package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesDetailsServiceImpl implements FeesDetailsServiceI {

    @Autowired
    private FeesManagementRepository feesManagementRepository;

    @Override
    public SuccessRegistrationResponse createFeesManagement(FeesDetailsRequest feesDetailsRequest) throws RegistrationException {
        try {
            var feesManagementEntity = FeesManagementEntity.builder()
                    .firstName(feesDetailsRequest.getFirstName())
                    .standardName(feesDetailsRequest.getStandardName())
                    .email(feesDetailsRequest.getEmail())
                    .studentPhoneNo(feesDetailsRequest.getStudentPhoneNo())
                    .totalFeeAmount(feesDetailsRequest.getTotalFeeAmount())
                   // .discountInPercentages(feesDetailsRequest.getDiscountInPercentages())
                    .paymentMethod(feesDetailsRequest.getPaymentMethod())
                    .paidAmount(feesDetailsRequest.getPaidAmount())
                    .balanceAmount(feesDetailsRequest.getBalanceAmount())
                    .updatedDate(feesDetailsRequest.getUpdatedDate()).build();
            feesManagementRepository.save(feesManagementEntity);
            if (feesManagementEntity.getId() != null) {
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
