package VIEW;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JPG
 */
@WebServlet(name = "PDFAtividadesServlet", urlPatterns = {"/PDFAtividadesServlet"})
public class PDFAtividadesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Document documento = new Document();

        try {
            
            PdfWriter.getInstance(documento, new FileOutputStream("atividade.pdf"));
            documento.open();
            
            documento.setPageSize(PageSize.A4);
                       
            documento.add(new Paragraph(request.getParameter("data")));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("TÍTULO:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("titulo")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("MENSAGEM:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("mensagem")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("STATUS:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("status")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            
            
            
        } catch (FileNotFoundException | DocumentException erro) {
            System.out.println("HOUVE UM ERRO AO GERAR O PDF: " + erro.getMessage());

        } finally {
            
            documento.close();
        }

        try {
            
            Desktop.getDesktop().open(new File("atividade.pdf"));
            response.sendRedirect("AtividadesServlet");

        } catch (IOException erro) {
            System.out.println("HOUVE UM ERRO AO ABRIR O PDF: " + erro.getMessage());
        }

    }

}
