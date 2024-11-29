package com.rtt.student;

import com.rtt.common.SuccessRegistrationResponse;
import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentI {

    @Override
    public TotalRecoveredResponse getTotalRecoveredAmount() {
        Float totalRecoveredAmount = repository.calculateTotalRecoveredAmount();
        return TotalRecoveredResponse.builder().paidAmount(totalRecoveredAmount).build();
    }

    @Autowired
    private StudentRepository repository;


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
                    .TotalfeeAmount(studentRequest.getTotalfeeAmount())
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

            if (savedStudent.getStudentId() != null) {
               // generateStudentRegistrationInvoice(savedStudent);
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
    public List<StudentEntity> getAllStudents() {
        // Fetch all student records from the repository
        return repository.findAll();
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

}
