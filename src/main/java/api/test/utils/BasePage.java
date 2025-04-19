package api.test.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import io.restassured.response.Response;

public class BasePage {

	public static void takeScreenshot(Response response, String titulo) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmm");
        String format = formatter.format(LocalDateTime.now());

        String baseFolderPath = "Evidences/API";
        File baseFolder = new File(baseFolderPath);
        if (!baseFolder.exists()) {
            baseFolder.mkdirs(); 
        }
        String testFolderPath = baseFolderPath + "/" + titulo;
        File testFolder = new File(testFolderPath);
        if (!testFolder.exists()) {
            testFolder.mkdirs(); 
        }
        String filePath = testFolderPath + "/evidences_" + format + ".pdf";
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("RESPONSE TAKESCREENSHOT")
            .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
            .setFontSize(16));
        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph("STATUS CODE: " + response.getStatusCode()));
        document.add(new Paragraph("RESPONSE BODY: " + response.getBody().asString()));
        document.add(new Paragraph("RESPONSE HEADERS: " + response.getHeaders().toString()));
        document.add(new Paragraph("TIMESTAMP: " + LocalDateTime.now()));
        document.close();
        System.out.println("Evidence generated in PDF format in the folder '" + testFolderPath + "'!");
    }
}
