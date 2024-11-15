package com.rtt.feesstandard;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneratePdfService {
    @Autowired
    private StudentStandardAndFeesRepository studentStandardAndFeesRepository;

    public Path generatePdfDoc(StudentStandardAndFeesEntity standardAndFees) {
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream())
        try{
            List<StudentStandardAndFeesEntity> existingRecord = studentStandardAndFeesRepository.findAll();

            // Ensure we have data
            if (existingRecord.isEmpty()) {
                throw new RuntimeException("No records found to generate the PDF");
            }

            // Define the local file path for saving the PDF
            String filePath = "D:\\pdf\\student_standard_fees.pdf";  // Specify your desired path here
            Path path = Paths.get(filePath);

            // Initialize PDF writer and document
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Add content from standardAndFees to the PDF
            Paragraph description=new Paragraph("Student Standard and Fees Details")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(18);

            document.add(description);

            // Table with borders, centered text, and alternating row colors
            Table table = new Table(2);// Two columns
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            // Header Row
            table.addHeaderCell(new Cell().add(new Paragraph("Field").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("Value").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.CENTER));


            // Data Rows
            table.addCell(new Cell().add(new Paragraph("Standard Name")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph( existingRecord.get(0).getStandardName())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.BLUE)));

            table.addCell(new Cell().add(new Paragraph("Fee Amount")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(existingRecord.get(0).getFeeAmount()))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.BLUE)));

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
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}
