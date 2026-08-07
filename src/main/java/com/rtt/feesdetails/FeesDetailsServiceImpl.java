package com.rtt.feesdetails;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FeesDetailsServiceImpl implements FeesDetailsServiceI {

    @Autowired
    private FeesManagementRepository feesManagementRepository;

    @Override
    public SuccessRegistrationResponse createFeesManagement(FeesDetailsRequest feesDetailsRequest) throws RegistrationException {
        try {
            var feesManagementEntity = FeesManagementEntity.builder()
                    .firstName(feesDetailsRequest.getFirstName())
                    .studentId(feesDetailsRequest.getStudentId())
                    .paidPersonName(feesDetailsRequest.getPaidPersonName())
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

    @Override
    public List<FeesManagementEntity> getFeesManagementList() {
        List<FeesManagementEntity> feesManagementList = feesManagementRepository.findAll();
        if (!feesManagementList.isEmpty()) {
            System.out.println("First record: " + feesManagementList.get(0));
        } else {
            System.out.println("No records found for the given List");
        }
        return feesManagementList;
    }

    @Override
    public SuccessRegistrationResponse updateStudentFees(
            Long id,
            FeesDetailsRequest feesDetailsRequest) throws RegistrationException {

        try {
            FeesManagementEntity feesManagementEntity =
                    feesManagementRepository.findById(id)
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Fees details not found for id: " + id
                                    )
                            );

            feesManagementEntity.setFirstName(feesDetailsRequest.getFirstName());
            feesManagementEntity.setStudentId(feesDetailsRequest.getStudentId());
            feesManagementEntity.setPaidPersonName(feesDetailsRequest.getPaidPersonName());
            feesManagementEntity.setStandardName(feesDetailsRequest.getStandardName());
            feesManagementEntity.setEmail(feesDetailsRequest.getEmail());
            feesManagementEntity.setStudentPhoneNo(feesDetailsRequest.getStudentPhoneNo());
            feesManagementEntity.setTotalFeeAmount(feesDetailsRequest.getTotalFeeAmount());
            feesManagementEntity.setPaymentMethod(feesDetailsRequest.getPaymentMethod());
            feesManagementEntity.setPaidAmount(feesDetailsRequest.getPaidAmount());
            feesManagementEntity.setBalanceAmount(feesDetailsRequest.getBalanceAmount());
            feesManagementEntity.setUpdatedDate(feesDetailsRequest.getUpdatedDate());

            feesManagementRepository.save(feesManagementEntity);

            return SuccessRegistrationResponse.builder()
                    .responseCode(
                            RegistrationResponseConstants.STUDENT_FEES_UPDATE_SUCCESS_CODE)
                    .responseDescription(
                            RegistrationResponseConstants.STUDENT_FEES_UPDATE_SUCCESS_DESCRIPTION)
                    .build();

        } catch (Exception e) {
            throw new RegistrationException(
                    RegistrationResponseConstants.STUDENT_FEES_UPDATE_FAILURE_CODE,
                    RegistrationResponseConstants.STUDENT_FEES_UPDATE_FAILURE_DESCRIPTION
                            + e.getMessage()
            );
        }
    }
}
