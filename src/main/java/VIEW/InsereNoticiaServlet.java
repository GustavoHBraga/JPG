package VIEW;

import DAO.NoticiasDAO;
import MODEL.Noticias;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "InsereNoticiaServlet", urlPatterns = {"/InsereNoticiaServlet"})
public class InsereNoticiaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando sessão de usuário; 
         * 2) Validando campos de preenchimento;
         * 3) Recebendo os dados;
         * 4) Executando método; e
         * 5) Tratando Exceções;
         */
        
        request.setCharacterEncoding("UTF-8");
        try {

            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("username");

            if (usuario == null) {
                response.sendRedirect("LogoffServlet");
                return;
            }

            Noticias noticia = new Noticias();
            NoticiasDAO noticiaDAO = new NoticiasDAO();
            Date data = Date.valueOf(request.getParameter("data"));

            if (request.getParameter("titulo").equals("") || request.getParameter("data").equals("")) {
                response.sendRedirect("registro_noticia.jsp");

            } else {

                noticia.setUsernameMedico(request.getParameter("usernameMedico"));
                noticia.setTitulo(request.getParameter("titulo"));
                noticia.setMensagem(request.getParameter("mensagem"));
                noticia.setData(data);
                noticiaDAO.registrarNoticias(noticia);
                response.sendRedirect("NoticiasServlet");
            }

        } catch (IOException erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE NOTÍCIAS: " + erro.getMessage());
        }
    }

}
