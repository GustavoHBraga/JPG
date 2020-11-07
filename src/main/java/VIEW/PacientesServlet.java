package VIEW;

import DAO.PacientesDAO;
import MODEL.Pacientes;
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
@WebServlet(name = "PacientesServlet", urlPatterns = {"/PacientesServlet"})
public class PacientesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {

            Pacientes paciente = new Pacientes();
            PacientesDAO pacienteDAO = new PacientesDAO();
            Date data = Date.valueOf(request.getParameter("data"));

            if (request.getParameter("cpf").equals("") || request.getParameter("nome").equals("") || request.getParameter("data").equals("") || request.getParameter("email").equals("") || request.getParameter("estado").equals("") || request.getParameter("cep").equals("") || request.getParameter("contato1").equals("")) {
                response.sendRedirect("formulario_paciente.jsp");

            } else {

                paciente.setCpf(request.getParameter("cpf"));
                paciente.setNome(request.getParameter("nome"));
                paciente.setData(data);
                paciente.setEmail(request.getParameter("email"));
                paciente.setEstado(request.getParameter("estado"));
                paciente.setCep(request.getParameter("cep"));
                paciente.setContato1(request.getParameter("contato1"));
                paciente.setContato2(request.getParameter("contato2"));
                paciente.setSexo(request.getParameter("sexo"));
                pacienteDAO.registrarFormulario(paciente);
                response.sendRedirect("triagens_paciente.jsp");
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE FORMULÁRIOS: " + erro.getMessage());
        }

    }

}
