package VIEW;

import DAO.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Validando campos de preenchimento;
         * 2) Recebendo os dados;
         * 3) Abrindo conexão e realizando busca no Banco de Dados;
         * 4) Atribuindo uma sessão ao usuário; e
         * 5) Tratando Exceções;
         */
        
        try {
            
            if (request.getParameter("username") != null && request.getParameter("senha") != null) {

                String usuario = request.getParameter("username");
                String senha = request.getParameter("senha");

                Connection conexao = new ConnectionFactory().getConexao();
                Statement statement;
                ResultSet resultSet;

                String sql = "SELECT * FROM medicos WHERE username = '" + usuario + "' AND senha = '" + senha + "'";

                statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", usuario);
                    response.sendRedirect("index.jsp");

                } else {

                    request.setAttribute("informacao", "Usuário ou Senha inválidos!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);

                }
            }

        } catch (IOException | SQLException | ServletException erro) {
            System.out.println("ERRO AO REALIZAR ACESSO AO SISTEMA: " + erro.getMessage());

        }
    }

}
