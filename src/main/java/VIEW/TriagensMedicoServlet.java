package VIEW;

import DAO.TriagensDAO;
import MODEL.Triagens;
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
@WebServlet(name = "TriagensMedicoServlet", urlPatterns = {"/TriagensMedicoServlet"})
public class TriagensMedicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("LogoffServlet");
            return;
        }

        try {

            TriagensDAO triagensDAO = new TriagensDAO();

            if (request.getParameter("cpf") == null || request.getParameter("cpf").equals("")) {

                ArrayList<Triagens> lista = triagensDAO.listarTriagens();

                for (Triagens l : lista) {
                    l.getIdTriagem();
                    l.getCpf();
                    l.getNome();
                    l.getData_nascimento();
                    l.getEmail();
                    l.getCep();
                    l.getEstado();
                    l.getContato1();
                    l.getContato2();
                    l.getSexo();
                    l.getFebre();
                    l.getTosse_seca();
                    l.getCansaco();
                    l.getFalta_ar();
                    l.getPressao_peito();
                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("triagens_medico.jsp").forward(request, response);

            } else {
                ArrayList<Triagens> lista = triagensDAO.pesquisaTriagem(request.getParameter("cpf"));

                for (Triagens l : lista) {
                    l.getIdTriagem();
                    l.getCpf();
                    l.getNome();
                    l.getData_nascimento();
                    l.getEmail();
                    l.getCep();
                    l.getEstado();
                    l.getContato1();
                    l.getContato2();
                    l.getSexo();
                    l.getFebre();
                    l.getTosse_seca();
                    l.getCansaco();
                    l.getFalta_ar();
                    l.getPressao_peito();
                }
                request.setAttribute("dados", lista);
                request.getRequestDispatcher("triagens_medico.jsp").forward(request, response);
            }

        } catch (IOException | ServletException erro) {
            throw new RuntimeException("ERRO NA LISTAGEM DE TRIAGENS: " + erro.getMessage());
        }
    }

}
