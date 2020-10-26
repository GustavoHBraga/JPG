package VIEW;

import DAO.AtividadesDAO;
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
@WebServlet(name = "RemoveAtividadeServlet", urlPatterns = {"/RemoveAtividadeServlet"})
public class RemoveAtividadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("username");
            
            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }

            AtividadesDAO atividadesDAO = new AtividadesDAO();
            atividadesDAO.removerAtividades(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("AtividadesServlet");

        } catch (Exception erro) {
            throw new RuntimeException("ERRO AO REMOVER ATIVIDADES " + erro.getMessage());
        }

    }

}
