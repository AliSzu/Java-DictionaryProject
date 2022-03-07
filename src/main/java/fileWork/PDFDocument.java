package fileWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFDocument {
    static List<String> information = new ArrayList<>();
    public static void CreatePDF() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDDocumentInformation pdd = document.getDocumentInformation();

        pdd.setAuthor("Alicja Szulecka");
        pdd.setTitle("Przyrost I");
        pdd.setSubject("Projekt z tematów 1-4");
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 30);
        contentStream.setLeading(14.5f);

        contentStream.newLineAtOffset(20, 750);
        contentStream.showText("Alicja Szulecka nr 464914");
        contentStream.newLine();
        contentStream.newLine();
        PDFont font = PDType0Font.load(document, new File("c:/windows/fonts/Arial.ttf"));

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 20);
        contentStream.showText("Projekt z Pracownii Programowania");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.setFont(font, 12);
       for (String text : information)
        {
            contentStream.showText(text);
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();


        document.save("Document/document_log.pdf");
        document.close();

    }

    public static void addLogToList(String log)
    {
        information.add(log);
    }

}
