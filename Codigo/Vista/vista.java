package Vista;

import Controlador.Correos;
import java.util.ArrayList;

public class vista {
    public static void main(String[] args) {
        // Crear una instancia de la clase Correos
        Correos objCorreos = new Correos();
        
        ArrayList<String> correos = new ArrayList<>();
        // Llamar al método generarCorreoPDF
        correos = objCorreos.generarCorreoPDF();

        // Imprimir los correos generados
        for (String correo : correos) {
            System.out.println(correo);
        }
        
        // Crear una instancia de la clase PDFCreator
        PDFCreator pdf=new PDFCreator();
        
        //Llamar al método generarPDF
        try {
        	pdf.generarPDF("CorreosPDF.pdf");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el PDF: " + e.getMessage());
        }
    }
}
