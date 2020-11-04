package VIEW;

import DAO.NoticiasDAO;
import MODEL.Noticias;
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
@WebServlet(name = "NoticiasServlet", urlPatterns = {"/NoticiasServlet"})
public class NoticiasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {

            NoticiasDAO noticiasDAO = new NoticiasDAO();

            if (request.getParameter("mensagem") == null || request.getParameter("mensagem").equals("")) {

                ArrayList<Noticias> lista = noticiasDAO.listarNoticias();

                for (Noticias l : lista) {
                    System.out.println(l.getIdNoticias());
                    System.out.println(l.getUsernameMedico());
                    System.out.println(l.getTitulo());
                    System.out.println(l.getMensagem());
                    System.out.println(l.getData());

                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("noticias.jsp").forward(request, response);

            } else {
                ArrayList<Noticias> lista = noticiasDAO.pesquisaNoticias(request.getParameter("mensagem"));

                for (Noticias l : lista) {
                    System.out.println(l.getIdNoticias());
                    System.out.println(l.getUsernameMedico());
                    System.out.println(l.getTitulo());
                    System.out.println(l.getMensagem());
                    System.out.println(l.getData());

                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("noticias.jsp").forward(request, response);
            }

        } catch (Exception erro) {

            throw new RuntimeException("ERRO NA LISTAGEM DE NOTÍCIAS: " + erro.getMessage());
        }

    }

}
