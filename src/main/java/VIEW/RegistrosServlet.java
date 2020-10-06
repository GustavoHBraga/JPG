package VIEW;

import DAO.ConnectionFactory;
import DAO.RegistrosDAO;
import MODEL.Registros;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JPG
 */
@WebServlet(name = "RegistrosServlet", urlPatterns = {"/RegistrosServlet"})
public class RegistrosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conexao = new ConnectionFactory().getConexao();
            PreparedStatement preparedStatement;
            Registros registro = new Registros();
            RegistrosDAO registroDAO = new RegistrosDAO();

            if (request.getParameter("usuario").equals("") || request.getParameter("nome").equals("") || request.getParameter("email").equals("") || request.getParameter("senha").equals("") || request.getParameter("senhaRepitida").equals("")) {
                response.sendRedirect("registros.jsp");

            } else {
                registro.setUsuario(request.getParameter("usuario"));
                registro.setNome(request.getParameter("nome"));
                registro.setEmail(request.getParameter("email"));
                registro.setSenha(request.getParameter("senha"));
                String criaTabela = "CREATE TABLE " + request.getParameter("usuario") + "(id int not null auto_increment, numero int not null, nome varchar(30) not null, email varchar(30), titulo varchar(20) not null, texto varchar(100) not null, dataInicio date, dataFim date, statusAtividade varchar(15), primary key(id));";
                preparedStatement = conexao.prepareStatement(criaTabela);
                preparedStatement.execute();
                preparedStatement.close();
                registroDAO.registrar(registro);
                response.sendRedirect("login.jsp");
            }

            
        } catch (Exception erro) {
            System.out.print("<h1 style='color: crimson'>Este nome de usuário já existe, tente outro nome.</h1>");
            response.sendRedirect("registros.jsp");
        }
    }

}
