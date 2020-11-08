package VIEW;

import DAO.TriagensDAO;
import MODEL.Triagens;
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
@WebServlet(name = "TriagensServlet", urlPatterns = {"/TriagensServlet"})
public class TriagensServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        try {

            Triagens triagem = new Triagens();
            TriagensDAO triagemDAO = new TriagensDAO();
                
                triagem.setCpf("awda");
                triagem.setFebre(request.getParameter("form1"));
                triagem.setTosse_seca(request.getParameter("form2"));
                triagem.setCansaco(request.getParameter("form3"));
                triagem.setFalta_ar(request.getParameter("form4"));
                triagem.setPressao_peito(request.getParameter("form5"));
                triagemDAO.registrarTriagem(triagem);
                response.sendRedirect("formulario_paciente.jsp");
            

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE FORMULÁRIOS: " + erro.getMessage());
        }
    }

}
