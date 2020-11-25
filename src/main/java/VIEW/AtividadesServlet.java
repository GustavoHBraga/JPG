package VIEW;

import DAO.AtividadesDAO;
import MODEL.Atividades;
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
@WebServlet(name = "AtividadesServlet", urlPatterns = {"/AtividadesServlet"})
public class AtividadesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando sessão de usuário; 
         * 2) Validando campos de preenchimento; 
         * 3) Exibindo dados; e
         * 4) Tratando Exceções;
         */
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("LogoffServlet");
            return;
        }

        try {

            AtividadesDAO atividadesDAO = new AtividadesDAO();

            if (request.getParameter("mensagem") == null || request.getParameter("mensagem").equals("")) {

                ArrayList<Atividades> lista = atividadesDAO.listarAtividades(usuario);

                for (Atividades l : lista) {
                    l.getIdAtividade();
                    l.getTitulo();
                    l.getMensagem();
                    l.getData();
                    l.getStatus();
                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("atividades.jsp").forward(request, response);

            } else {
                ArrayList<Atividades> lista = atividadesDAO.pesquisaAtividades(request.getParameter("mensagem"));

                for (Atividades l : lista) {
                    l.getIdAtividade();
                    l.getTitulo();
                    l.getMensagem();
                    l.getData();
                    l.getStatus();
                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("atividades.jsp").forward(request, response);
            }


        } catch (IOException | ServletException erro) {
            throw new RuntimeException("ERRO NA LISTAGEM DE ATIVIDADES: " + erro.getMessage());
        }
    }

}
