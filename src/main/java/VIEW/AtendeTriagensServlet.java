package VIEW;

import DAO.TriagensDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JPG
 */
@WebServlet(name = "AtendeTriagensServlet", urlPatterns = {"/AtendeTriagensServlet"})
public class AtendeTriagensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando sessão de usuário; 
         * 2) Recebendo os dados;
         * 3) Executando método; e
         * 4) Tratando Exceções;
         */
        
        try {

            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("username");

            if (usuario == null) {
                response.sendRedirect("LogoffServlet");
                return;
            }

            TriagensDAO triagensDAO = new TriagensDAO();
            triagensDAO.atenderTriagem(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("TriagensMedicoServlet");

        } catch (IOException | NumberFormatException erro) {
            throw new RuntimeException("ERRO AO ATENDER TRIAGEM: " + erro.getMessage());
        }

    }

}
