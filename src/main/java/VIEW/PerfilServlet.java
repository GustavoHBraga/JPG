package VIEW;

import DAO.ConnectionFactory;
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

@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("usuario");
            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }
            String user = usuario;
            Connection conexao = new ConnectionFactory().getConexao();
            Statement statement;
            ResultSet resultSet;

            String sql = "SELECT nome, email, id FROM registros WHERE usuario = '" + user + "'";
            statement = conexao.createStatement();
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            resultSet = statement.executeQuery(sql);
            resultSet.first();

        } catch (Exception erro) {
            System.out.println("ERRO AO VISUALIZAR PERFIL DE USUÁRIO: " + erro.getMessage());
        }
    }

}
