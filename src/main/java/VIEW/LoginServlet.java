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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (request.getParameter("usuario") != null && request.getParameter("senha") != null) {

                String usuario = request.getParameter("usuario");
                String senha = request.getParameter("senha");

                Connection conexao = new ConnectionFactory().getConexao();
                Statement statement;
                ResultSet resultSet;

                String sql = "SELECT * FROM registros WHERE usuario = '" + usuario + "' AND senha = '" + senha + "'";

                statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("index.jsp");

                } else {
                    response.sendRedirect("login.jsp");
                    System.out.print("<h5 style='color: crimson'>Usuário ou Senha inválidos!</h5>");
                }
            }
        } catch (Exception erro) {
            System.out.println("ERRO AO REALIZAR ACESSO AO SISTEMA: " + erro.getMessage());

        }
    }

}
