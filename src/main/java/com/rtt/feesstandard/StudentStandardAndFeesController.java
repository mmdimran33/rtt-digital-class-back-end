package com.rtt.feesstandard;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
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

    @GetMapping("/standard-fee-list")
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
    public ResponseEntity<String> generatePdf(@RequestBody StudentStandardAndFeesEntity standardAndFees) {
        Path pdfPath = pdfService.generatePdfDoc(standardAndFees);
        return ResponseEntity.ok("PDF generated and saved at: " + pdfPath.toAbsolutePath().toString());
    }



    @GetMapping("/standard_master_list")
    public StudentStandardMListResponse getStandardNameList() {
        Map<Integer, String> standardMasterMap = studentStandardAndFeesI.getStandardNameList();
        return StudentStandardMListResponse.builder().studentStandardMListResponse(standardMasterMap).build();
    }
    /*@GetMapping("/get-standard-name-list")
    public List<String> getStandardNames() {
        // Fetch and return the list of distinct standard names
        return studentStandardAndFeesI.getStandardNameOfList();
    }*/
    @GetMapping("/get-standard-name-list")
    public StudentStandardNameListResponse getStandardNameOfList() {
        List<Map<String, String>> standardNameList= studentStandardAndFeesI.getStandardNameOfList();
        return StudentStandardNameListResponse.builder().studentStandardMListResponse(standardNameList).build();
    }
}
