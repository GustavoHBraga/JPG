package VIEW;

import DAO.RegistrosDAO;
import MODEL.Registros;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando sessão de usuário; 
         * 2) Exibindo dados; e
         * 3) Tratando Exceções;
         */
        
        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("LogoffServlet");
            return;
        }

        try {
            
            RegistrosDAO registroDAO = new RegistrosDAO();
            ArrayList<Registros> lista = registroDAO.exibePerfil(usuario);

            for (Registros l : lista) {
                System.out.println(l.getUsername());
                System.out.println(l.getNome());
                System.out.println(l.getEmail());
                System.out.println(l.getCrm());
                System.out.println(l.getEspecializacao());
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
            }

        } catch (IOException | ServletException erro) {
            System.out.println("ERRO AO VISUALIZAR PERFIL: " + erro.getMessage());
        }
    }

}
