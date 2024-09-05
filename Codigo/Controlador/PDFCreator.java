package control;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFCreator {

	Correos correo;
	
	public PDFCreator() {
		this.correo=new Correos();
	}
	
	public void generarPDF(String FileName) throws IOException {
		PDDocument doc = new PDDocument(); 
        ArrayList<String> correos = new ArrayList<>();
        
        correos = correo.generarCorreoPDF();
        
        for(String correoTexto: correos) {
        	PDPage page = new PDPage();
    		doc.addPage(page); 
    		
            PDPageContentStream contentStream;
            
            contentStream = new PDPageContentStream(doc,page);    	
        	contentStream.beginText();
        	contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);
        	contentStream.setLeading(14.5f);
        	contentStream.newLineAtOffset(20, 450);
        	
        	String[] lineas = correoTexto.split("\n");
            for (String linea : lineas) {
                contentStream.showText(linea);
                contentStream.newLine();
            }
            contentStream.endText();
            contentStream.close();
        }
        
        doc.save(FileName);
        
        System.out.println("PDF created "+FileName);    
      
        doc.close();
      
	}
}
