package VIEW;

import DAO.RegistrosDAO;
import MODEL.Registros;
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
@WebServlet(name = "RegistrosServlet", urlPatterns = {"/RegistrosServlet"})
public class RegistrosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Registros registro = new Registros();
            RegistrosDAO registroDAO = new RegistrosDAO();

            if (request.getParameter("username").equals("") || request.getParameter("nome").equals("") || request.getParameter("email").equals("") || request.getParameter("crm").equals("") || request.getParameter("especializacao").equals("") || request.getParameter("senha").equals("") || request.getParameter("senhaRepitida").equals("")) {

                response.sendRedirect("registros.jsp");

            } else if (request.getParameter("username").length() >= 6 && request.getParameter("email").length() >= 6 && request.getParameter("senha").length() >= 6 && request.getParameter("senha").equals(request.getParameter("senhaRepitida"))) {

                registro.setUsername(request.getParameter("username"));
                registro.setNome(request.getParameter("nome"));
                registro.setEmail(request.getParameter("email"));
                registro.setCrm(request.getParameter("crm"));
                registro.setEspecializacao(request.getParameter("especializacao"));
                registro.setSenha(request.getParameter("senha"));
                registroDAO.registrarMedicos(registro);
                response.sendRedirect("login.jsp");

            }

        } catch (Exception erro) {
            response.sendRedirect("infoRegistro.jsp");
            System.out.println("ERRO NO REGISTRAMENTO DE USUÁRIOS: " + erro.getMessage());
        }
    }
}
