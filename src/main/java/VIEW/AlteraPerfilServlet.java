package VIEW;

import DAO.ConnectionFactory;
import DAO.RegistrosDAO;
import MODEL.Registros;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String usuario = (String) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
        
        try {

            Connection conexao = new ConnectionFactory().getConexao();
            PreparedStatement preparedStatement;
            Statement statement;
            ResultSet resultSet;
            String user = usuario;
            Registros registro = new Registros();
            RegistrosDAO registroDAO = new RegistrosDAO();

            String sql = "SELECT id FROM registros WHERE usuario = '" + user + "'";
            statement = conexao.createStatement();
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            resultSet = statement.executeQuery(sql);
            resultSet.first();

            registro.setUsuario(request.getParameter("usuario"));
            registro.setNome(request.getParameter("nome"));
            registro.setEmail(request.getParameter("email"));
            registro.setSenha(request.getParameter("senhaNova"));
            registro.setId(Integer.parseInt(resultSet.getString("id")));

            String sql_table = "ALTER TABLE " + user + " RENAME TO " + request.getParameter("usuario");
            preparedStatement = conexao.prepareStatement(sql_table);
            preparedStatement.execute();
            preparedStatement.close();

            registroDAO.alteraPerfil(registro);

            response.sendRedirect("logoff.jsp");

        } catch (Exception erro) {
            System.out.println("<h1 style='color: crimson; font-family: candara; text-align: center'><br><br><br>Este nome de usuário já existe, tente outro nome.</h1>");
        }
    }

}
