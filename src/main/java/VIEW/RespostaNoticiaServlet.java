package VIEW;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author JPG
 */
@WebServlet(name = "RespostaNoticiaServlet", urlPatterns = {"/RespostaNoticiaServlet"})
public class RespostaNoticiaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String meuEmail = "JPG.informe@gmail.com";
        String minhaSenha = "JPG@1234";
        String paraEmail = request.getParameter("paraEmail");
        String nome = request.getParameter("nome");
        String assunto = request.getParameter("assunto");
        String mensagem = request.getParameter("mensagem");

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        try {

            email.setFrom(meuEmail);
            email.setSubject(assunto);
            email.setMsg("Solicitante: " + nome + "\n\n" + mensagem);
            email.addTo(paraEmail);
            email.send();
            response.sendRedirect("NoticiasServlet");

        } catch (IOException | EmailException erro) {
            response.sendRedirect("NoticiasServlet");
            System.out.println("ERRO AO ENVIAR E-MAIL: " + erro.getMessage());
        }
    }

}
