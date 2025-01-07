package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import com.rtt.feesdetails.FeesManagementEntity;
import com.rtt.feesdetails.FeesManagementRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentI {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private FeesManagementRepository feesManagementRepository;

    @Override
    public SuccessRegistrationResponse createStudent(StudentRequest studentRequest) {

        try {

            var student = StudentEntity.builder().
                    firstName(studentRequest.getFirstName())
                    .lastName(studentRequest.getLastName())
                    .standardName(studentRequest.getStandardName())
                    .fatherName(studentRequest.getFatherName())
                    .motherName(studentRequest.getMotherName())
                    .gaurdianName(studentRequest.getGaurdianName())
                    .gender(studentRequest.getGender())
                    .email(studentRequest.getEmail())
                    .studentPhoneNo(studentRequest.getStudentPhoneNo())
                    .gaurdianPhoneNo(studentRequest.getGaurdianPhoneNo())
                    .address(studentRequest.getAddress())
                    .registrationDate(studentRequest.getRegistrationDate())
                    .totalFeeAmount(studentRequest.getTotalFeeAmount())
                    .paidAmount(studentRequest.getPaidAmount())
                    .paymentMethod(studentRequest.getPaymentMethod())
                    .discountInPercentages(studentRequest.getDiscountInPercentages())
                    .balanceAmount(studentRequest.getBalanceAmount())
                    .build();

          /*  var standard = StudentStandard.builder()
                    .standardName(studentRequest.getStandardName())
                    .studentEntity(student)
                    .build();
            student.setStudentStandard(standard);*/

            StudentEntity savedStudent = repository.save(student);

            if (savedStudent.getId() != null) {

                var feesManagementEntity = FeesManagementEntity.builder().
                studentId(savedStudent.getId())
                        .firstName(savedStudent.getFirstName())
                        .standardName(savedStudent.getStandardName())
                        .email(savedStudent.getEmail())
                        .studentPhoneNo(savedStudent.getStudentPhoneNo())
                        .totalFeeAmount(savedStudent.getTotalFeeAmount())
                       // .discountInPercentages(savedStudent.getDiscountInPercentages())
                        .paymentMethod(savedStudent.getPaymentMethod())
                        .paidAmount(savedStudent.getPaidAmount())
                        .balanceAmount(savedStudent.getBalanceAmount())
                        .updatedDate(savedStudent.getRegistrationDate()).build();
                feesManagementRepository.save(feesManagementEntity);

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
    public List<StudentEntity> getAllStudents() {
        // Fetch all student records from the repository
        return repository.findAll();
    }

    @Override
    public TotalRecoveredResponse getTotalRecoveredAmount() {
        Float totalRecoveredAmount = repository.calculateTotalRecoveredAmount();
        return TotalRecoveredResponse.builder().paidAmount(totalRecoveredAmount).build();
    }

    @Override
    public StudentCountResponse getTotalNoOfStudent() {
        Integer totalNumberOfStudent = repository.getTotalNumberOfStudents();
        return StudentCountResponse.builder().totalNoOfStudents(totalNumberOfStudent).build();

    }

    @Override
    public TotalPendingResponse getTotalPendingAmount() {
        //Fetch pending Amount of the Student from repository
        Float totalPendingAmount = repository.calculateTotalPendingAmount();
        return TotalPendingResponse.builder().balanceAmount(totalPendingAmount).build();
    }

    @Override
    public List<Object[]> getStandardListByStandardWise(String standardName) {
        // Fetch the list of standard-wise details from the repository
        List<Object[]> standardList = repository.findStandardListByStandardWise(standardName);

        // Log the first element for debugging purposes (ensure the list is not empty)
        if (!standardList.isEmpty()) {
            System.out.println("First record: " + Arrays.toString(standardList.get(0)));
        } else {
            System.out.println("No records found for the given standard: " + standardName);
        }

        // Return the fetched list
        return standardList;
    }

    @Override
    public StudentUpdateServiceResponse getUpdateStudentById(Integer studentId, StudentRequest updatedStudent) {
        StudentEntity studentEntity = repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        // Update fields
        studentEntity.setFirstName(updatedStudent.getFirstName());
        studentEntity.setFirstName(updatedStudent.getFirstName());
        studentEntity.setLastName(updatedStudent.getLastName());
        studentEntity.setStandardName(updatedStudent.getStandardName());
        studentEntity.setFatherName(updatedStudent.getFatherName());
        studentEntity.setMotherName(updatedStudent.getMotherName());
        studentEntity.setGaurdianName(updatedStudent.getGaurdianName());
        studentEntity.setGender(updatedStudent.getGender());
        studentEntity.setEmail(updatedStudent.getEmail());
        studentEntity.setStudentPhoneNo(updatedStudent.getStudentPhoneNo());
        studentEntity.setGaurdianPhoneNo(updatedStudent.getGaurdianPhoneNo());
        studentEntity.setAddress(updatedStudent.getAddress());
        studentEntity.setTotalFeeAmount(updatedStudent.getTotalFeeAmount());
        studentEntity.setDiscountInPercentages(updatedStudent.getDiscountInPercentages());
        studentEntity.setPaymentMethod(updatedStudent.getPaymentMethod());
        studentEntity.setPaidAmount(updatedStudent.getPaidAmount());
        studentEntity.setBalanceAmount(updatedStudent.getBalanceAmount());

        // Save updated student
        StudentEntity updated = repository.save(studentEntity);
       StudentUpdateResponse studentUpdateResponse=new StudentUpdateResponse(updated.getId(),"Student updated Sucessfully");
        return StudentUpdateServiceResponse.builder().studentUpdateResponse(studentUpdateResponse).build();
    }



    @Override
    public TotalEarningResponse getTotalFeeAmount() {
        // Fetch total earning of students from the repository
        Float totalEarningAmount = repository.calculateTotalEarningAmount();
        return TotalEarningResponse.builder().totalEarningAmount(totalEarningAmount).build();
    }
}



/*
    private Path generateStudentRegistrationInvoice(StudentEntity student){
        ///List<StudentEntity> existingRecord=repository.findAll();
        try{
            // Define the local file path for saving the PDF
            String filePath = "D:\\invoice\\student_registration_invoice.pdf";  // Specify your desired path here
            Path path = Paths.get(filePath);

            // Initialize PDF writer and document
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Add content from standardAndFees to the PDF
            Paragraph description=new Paragraph("Student Registration Invoice")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(18);
            document.add(description);

            // Table with borders, centered text, and alternating row colors
            Table table = new Table(7);// six columns
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            // Header Row
            //1
            table.addHeaderCell(new Cell().add(new Paragraph("Student First Name").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getFirstName()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //2
            table.addHeaderCell(new Cell().add(new Paragraph("Student Last Name").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getLastName()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //3
            table.addHeaderCell(new Cell().add(new Paragraph("Standard ").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getStandardName()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //4
            table.addHeaderCell(new Cell().add(new Paragraph("PhoneNo").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getGaurdianPhoneNo()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //5
            table.addHeaderCell(new Cell().add(new Paragraph("Total Fee Amount ").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getTotalfeeAmount()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //6
            table.addHeaderCell(new Cell().add(new Paragraph("Paid Fee Amount").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getPaidAmount()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));
            //7
            table.addHeaderCell(new Cell().add(new Paragraph("Balance Fee Amount ").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER))
                    .addCell(new Cell().add(new Paragraph(String.valueOf(student.getBalanceAmount()))
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontColor(ColorConstants.BLUE)));

            // Data Rows
            document.add(table);  // Add table to document

            // Drawing border around the page using PdfCanvas
            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
            float margin = 20;  // margin around the page
            float xStart = margin;
            float yStart = margin;
            float width = pdfDocument.getPage(1).getPageSize().getWidth() - (2 * margin);
            float height = pdfDocument.getPage(1).getPageSize().getHeight() - (2 * margin);

            canvas.setLineWidth(1f)
                    .setStrokeColor(ColorConstants.BLACK)
                    .rectangle(xStart, yStart, width, height)
                    .stroke();  // Draw the border

            // Close the document to finalize PDF content
            document.close();
            // Return the generated PDF as a byte array
            return path;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

*/


