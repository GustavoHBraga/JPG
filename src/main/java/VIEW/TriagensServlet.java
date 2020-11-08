package VIEW;

import DAO.TriagensDAO;
import MODEL.Triagens;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JPG
 */
@WebServlet(name = "TriagensServlet", urlPatterns = {"/TriagensServlet"})
public class TriagensServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {

            Triagens triagens = new Triagens();
            TriagensDAO triagensDAO = new TriagensDAO();
            Date dataNascimento = Date.valueOf(request.getParameter("data_nascimento"));

            triagens.setCpf(request.getParameter("cpf"));
            triagens.setNome(request.getParameter("nome"));
            triagens.setData_nascimento(dataNascimento);
            triagens.setEmail(request.getParameter("email"));
            triagens.setEstado(request.getParameter("estado"));
            triagens.setCep(request.getParameter("cep"));
            triagens.setContato1(request.getParameter("contato1"));
            triagens.setContato2(request.getParameter("contato2"));
            triagens.setSexo(request.getParameter("sexo"));
            triagens.setFebre(request.getParameter("form1"));
            triagens.setTosse_seca(request.getParameter("form2"));
            triagens.setCansaco(request.getParameter("form3"));
            triagens.setFalta_ar(request.getParameter("form4"));
            triagens.setPressao_peito(request.getParameter("form5"));
            triagensDAO.registrarTriagem(triagens);
            response.sendRedirect("login.jsp");

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE TRIAGENS: " + erro.getMessage());
        }

    }

}
