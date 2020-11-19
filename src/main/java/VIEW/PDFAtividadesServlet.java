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

/**
 * Neste cód. foi adicionada uma biblioteca .jar chamada "itextpdf".
 * Que nos permite criar documentos em PDF.
 */
@WebServlet(name = "PDFAtividadesServlet", urlPatterns = {"/PDFAtividadesServlet"})
public class PDFAtividadesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Instanciando um Objeto da biblioteca "itextpdf".
        Document documento = new Document();

        try {
            //Cria uma instância do documento (objeto) e da nome a ele.
            PdfWriter.getInstance(documento, new FileOutputStream("atividade.pdf"));
            //Abrindo o documento.
            documento.open();
            //Defindo o tamanho da página do PDF.
            documento.setPageSize(PageSize.A4);
            //Adicionando paragráfos e resgatando dados para utlizar no PDF. 
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
            /**
             * @exception - Tratando exceções.
             */
            System.out.println("ERRO AO GERAR O PDF: " + erro.getMessage());

        } finally {
            //Fechando o documento.
            documento.close();
        }

        try {
            //Abrindo o PDF automaticamente após ser criado.
            Desktop.getDesktop().open(new File("atividade.pdf"));
            response.sendRedirect("AtividadesServlet");

        } catch (IOException erro) {
            /**
             * @exception - Tratando exceções.
             */
            System.out.println("ERRO AO ABRIR O PDF: " + erro.getMessage());
        }

    }

}
