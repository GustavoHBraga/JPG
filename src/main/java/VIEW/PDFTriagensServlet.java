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
@WebServlet(name = "PDFTriagensServlet", urlPatterns = {"/PDFTriagensServlet"})
public class PDFTriagensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Instanciando um Objeto da biblioteca "itextpdf".
        Document documento = new Document();

        try {
            //Cria uma instância do documento (objeto) e da nome a ele.
            PdfWriter.getInstance(documento, new FileOutputStream("triagem.pdf"));
            //Abrindo o documento.
            documento.open();
            //Defindo o tamanho da página do PDF.
            documento.setPageSize(PageSize.A4);
            //Adicionando paragráfos e resgatando dados para utlizar no PDF.    
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("JOIN FOR PROTECT GET"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("Relatório de Triagem:"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("ID TRIAGEM:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("id")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("CPF:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("cpf")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("PACIENTE:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("nome")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("DATA DE NASCIMENTO:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("data_nascimento")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("E-MAIL:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("email")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("CEP:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("cep")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("ESTADO:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("estado")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("CONTATO 1:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("contato1")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("CONTATO 2:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("contato2")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("SEXO:"));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph(request.getParameter("sexo")));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("SINTOMAS | COVID-19"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("FEBRE:  " + request.getParameter("febre")));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("TOSSE SECA:  " + request.getParameter("tosse_seca")));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("CANSAÇO:  " + request.getParameter("cansaco")));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("FALTA DE AR:  " + request.getParameter("falta_ar")));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("PRESSÃO NO PEITO:  " + request.getParameter("pressao_peito")));
            
            
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
            Desktop.getDesktop().open(new File("triagem.pdf"));
            response.sendRedirect("TriagensMedicoServlet");

        } catch (IOException erro) {
            /**
             * @exception - Tratando exceções.
             */
            System.out.println("ERRO AO ABRIR O PDF: " + erro.getMessage());
        }

    }

}
