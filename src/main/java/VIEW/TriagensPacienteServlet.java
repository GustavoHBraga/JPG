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
@WebServlet(name = "TriagensPacienteServlet", urlPatterns = {"/TriagensPacienteServlet"})
public class TriagensPacienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Recebendo os dados;
         * 2) Executando método; e
         * 3) Tratando Exceções;
         */
        
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
            response.sendRedirect("confirma_triagem_paciente.jsp");

        } catch (IOException erro) {
            response.sendRedirect("infoTriagemPaciente.jsp");
            System.out.println("ERRO NO REGISTRAMENTO DE TRIAGENS: " + erro.getMessage());
        }

    }

}
