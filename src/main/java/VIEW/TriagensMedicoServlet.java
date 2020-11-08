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
            response.sendRedirect("login.jsp");
            return;
        }

        try {

            TriagensDAO triagensDAO = new TriagensDAO();

            if (request.getParameter("cpf") == null || request.getParameter("cpf").equals("")) {

                ArrayList<Triagens> lista = triagensDAO.listarTriagens();

                for (Triagens l : lista) {
                    System.out.println(l.getIdTriagem());
                    System.out.println(l.getCpf());
                    System.out.println(l.getNome());
                    System.out.println(l.getData_nascimento());
                    System.out.println(l.getEmail());
                    System.out.println(l.getCep());
                    System.out.println(l.getEstado());
                    System.out.println(l.getContato1());
                    System.out.println(l.getContato2());
                    System.out.println(l.getSexo());
                    System.out.println(l.getFebre());
                    System.out.println(l.getTosse_seca());
                    System.out.println(l.getCansaco());
                    System.out.println(l.getFalta_ar());
                    System.out.println(l.getPressao_peito());
                    request.setAttribute("dados", lista);
                    request.getRequestDispatcher("triagens_medico.jsp").forward(request, response);
                }

            } else {
                ArrayList<Triagens> lista = triagensDAO.pesquisaTriagem(request.getParameter("cpf"));

                for (Triagens l : lista) {
                    System.out.println(l.getIdTriagem());
                    System.out.println(l.getCpf());
                    System.out.println(l.getNome());
                    System.out.println(l.getData_nascimento());
                    System.out.println(l.getEmail());
                    System.out.println(l.getCep());
                    System.out.println(l.getEstado());
                    System.out.println(l.getContato1());
                    System.out.println(l.getContato2());
                    System.out.println(l.getSexo());
                    System.out.println(l.getFebre());
                    System.out.println(l.getTosse_seca());
                    System.out.println(l.getCansaco());
                    System.out.println(l.getFalta_ar());
                    System.out.println(l.getPressao_peito());
                    request.setAttribute("dados", lista);
                    request.getRequestDispatcher("triagens_medico.jsp").forward(request, response);
                }
            }

            response.sendRedirect("triagens_medico.jsp");

        } catch (Exception erro) {

            throw new RuntimeException("ERRO NA LISTAGEM DE TRIAGENS: " + erro.getMessage());
        }
    }

}
