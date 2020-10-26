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

        //*********
        //Corrigir caracteres especiais da tabela
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //*********
        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }

        try {

            AtividadesDAO atividadesDAO = new AtividadesDAO();

            if (request.getParameter("mensagem") == null || request.getParameter("mensagem").equals("")) {

                ArrayList<Atividades> lista = atividadesDAO.listarAtividades(usuario);

                for (Atividades l : lista) {
                    System.out.println(l.getIdAtividade());
                    System.out.println(l.getTitulo());
                    System.out.println(l.getMensagem());
                    System.out.println(l.getData());
                    System.out.println(l.getStatus());
                    request.setAttribute("dados", lista);
                    request.getRequestDispatcher("atividades.jsp").forward(request, response);
                }

            } else {
                ArrayList<Atividades> lista = atividadesDAO.pesquisaAtividades(request.getParameter("mensagem"));

                for (Atividades l : lista) {
                    System.out.println(l.getIdAtividade());
                    System.out.println(l.getTitulo());
                    System.out.println(l.getMensagem());
                    System.out.println(l.getData());
                    System.out.println(l.getStatus());
                    request.setAttribute("dados", lista);
                    request.getRequestDispatcher("atividades.jsp").forward(request, response);
                }
            }
            
            response.sendRedirect("atividades.jsp");
            
        } catch (Exception erro) {
            
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE ATIVIDADES: " + erro.getMessage());
        }
    }

}
