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
@WebServlet(name = "AlteraAtividadeServlet", urlPatterns = {"/AlteraAtividadeServlet"})
public class AlteraAtividadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando sessão de usuário; 
         * 2) Validando campos de preenchimento;
         * 3) Recebendo os dados;
         * 4) Executando método; e
         * 5) Tratando Exceções;
         */
        try {
            Atividades atividades = new Atividades();
            AtividadesDAO atividadesDAO = new AtividadesDAO();
            Date data = Date.valueOf(request.getParameter("data"));
            
            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("username");

            if (usuario == null) {
                response.sendRedirect("LogoffServlet");
                return;
            }

            if (request.getParameter("titulo").equals("") || request.getParameter("mensagem").equals("") || request.getParameter("data").equals("") || request.getParameter("status").equals("")) {
                response.sendRedirect("altera_atividade.jsp");

            } else {

                atividades.setTitulo(request.getParameter("titulo"));
                atividades.setMensagem(request.getParameter("mensagem"));
                atividades.setData(data);
                atividades.setStatus(request.getParameter("status"));
                atividades.setIdAtividade(Integer.parseInt(request.getParameter("id")));
                atividadesDAO.alterarAtividades(atividades);
                response.sendRedirect("AtividadesServlet");
            }

        } catch (IOException | NumberFormatException erro) {
            throw new RuntimeException("ERRO NA ALTERAÇÃO DE ATIVIDADES: " + erro.getMessage());
        }

    }

}