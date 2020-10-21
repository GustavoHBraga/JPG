package VIEW;

import DAO.ConnectionFactory;
import DAO.RegistrosDAO;
import MODEL.Registros;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
@WebServlet(name = "AlteraPerfilServlet", urlPatterns = {"/AlteraPerfilServlet"})
public class AlteraPerfilServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }

        try {

            Connection conexao = new ConnectionFactory().getConexao();
            Statement statement;
            ResultSet resultSet;
            String user = usuario;
            Registros registro = new Registros();
            RegistrosDAO registroDAO = new RegistrosDAO();

            String sql = "SELECT id FROM medicos WHERE username = '" + user + "'";
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            resultSet = statement.executeQuery(sql);
            resultSet.first();

            registro.setUsername(request.getParameter("username"));
            registro.setNome(request.getParameter("nome"));
            registro.setEmail(request.getParameter("email"));
            registro.setCrm(request.getParameter("crm"));
            registro.setEspecializacao(request.getParameter("especializacao"));
            registro.setSenha(request.getParameter("senhaNova"));
            registro.setId_user(Integer.parseInt(resultSet.getString("id")));

            if (request.getParameter("username").length() >= 6 && request.getParameter("email").length() >= 6 && request.getParameter("senhaNova").length() >= 6 && request.getParameter("senhaNova").equals(request.getParameter("senhaRepitida"))) {

                registroDAO.alteraPerfil(registro);
                response.sendRedirect("logoff.jsp");

            } else {
                response.sendRedirect("altera_perfil.jsp");
            }

        } catch (Exception erro) {
            response.sendRedirect("altera_perfil.jsp");
            System.out.println("ERRO Na ALTERAÇÃO DE PERFIL: " + erro.getMessage());

        }
    }

}
