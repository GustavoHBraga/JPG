package VIEW;

import DAO.AtividadesDAO;
import MODEL.Atividades;
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
@WebServlet(name = "InsereAtividadeServlet", urlPatterns = {"/InsereAtividadeServlet"})
public class InsereAtividadeServlet extends HttpServlet {

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

            Atividades atividade = new Atividades();
            AtividadesDAO atividadeDAO = new AtividadesDAO();
            Date data = Date.valueOf(request.getParameter("data"));

            if (request.getParameter("titulo").equals("") || request.getParameter("mensagem").equals("") || request.getParameter("data").equals("") || request.getParameter("status").equals("")) {
                response.sendRedirect("registro_atividade.jsp");

            } else {

                atividade.setUsernameMedico(request.getParameter("usernameMedico"));
                atividade.setTitulo(request.getParameter("titulo"));
                atividade.setMensagem(request.getParameter("mensagem"));
                atividade.setData(data);
                atividade.setStatus(request.getParameter("status"));
                atividadeDAO.registrarAtividades(atividade);
                response.sendRedirect("AtividadesServlet");
            }

        } catch (IOException erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE ATIVIDADES: " + erro.getMessage());
        }

    }

}
