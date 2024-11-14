package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.student.StudentRequest;
import com.rtt.student.StudentServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/standardandfees")
public class StudentStandardAndFeesController {

    @Autowired
    private StudentStandardAndFeesI studentStandardAndFeesI;

    @Autowired
    private GeneratePdfService pdfService;

    @PostMapping("/add-fees")
    public ResponseEntity<StudentStandardAndFeesServiceResponse> addStandardFees(
        @RequestBody StudentStandardAndFeesRequest studentStandardAndFeesRequest)throws RegistrationException {

            try{
                SuccessRegistrationResponse response  =studentStandardAndFeesI.addOrUpdateFees(studentStandardAndFeesRequest);
                return ResponseEntity.ok(StudentStandardAndFeesServiceResponse.builder().successRegistrationResponse(response).build());
            }catch (Exception e){
                throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
                        RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
            }
        }

    @GetMapping("/standard-list")
    public StudentStandardAndFeesListServiceResponse getStandardAndFeesList() {
        //List<StudentStandardAndFeesEntity>studentStandardAndFeesList =  studentStandardAndFeesI.getStandardAndFeesList();
        return StudentStandardAndFeesListServiceResponse.builder().
                studentStandardAndFeesEntityList(studentStandardAndFeesI.getStandardAndFeesList()).build();
    }

    @GetMapping("/get-student-fee-amount-by-standard-name")
    public StudentStandardAndFeesAmountServiceResponse getFeeAmountByStandardName(
            @RequestParam String standardName)  {
            // Call the service method to get fee amount based on standard name
            StudentStandardFeesAmountServiceResponse response = studentStandardAndFeesI.getFeeAmountByStandardName(standardName);
            // Return the response wrapped in a ResponseEntity
            return StudentStandardAndFeesAmountServiceResponse.builder().studentStandardFeesAmountServiceResponse(response)
                    .build();
    }


    @PostMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody StudentStandardAndFeesEntity standardAndFees) {
        byte[] pdfBytes = pdfService.generatePdfDoc(standardAndFees);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=student_standard_fees.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }




}
