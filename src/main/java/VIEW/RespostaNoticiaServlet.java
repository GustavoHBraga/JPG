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

/**
 * Neste cód. foi adicionada uma biblioteca .jar chamada "mail, commons-email...".
 * Que nos permite criar enviar e-mails via Gmail da Google.
 */
@WebServlet(name = "RespostaNoticiaServlet", urlPatterns = {"/RespostaNoticiaServlet"})
public class RespostaNoticiaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Credências de um gmail criado como exemplo.
        String meuEmail = "JPG.informe@gmail.com";
        String minhaSenha = "JPG@1234";
        
        //Resgatando dados e armazenando em variáveis auxiliares.
        String paraEmail = request.getParameter("paraEmail");
        String nome = request.getParameter("nome");
        String assunto = request.getParameter("assunto");
        String mensagem = request.getParameter("mensagem");
        
        //Instância do Objeto que ira configurar o e-mail a ser enviado.
        SimpleEmail email = new SimpleEmail();
        
        //Host do Google.
        email.setHostName("smtp.gmail.com");
        //Porta do host.
        email.setSmtpPort(465);
        //Autenticação do envio do email.
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        //Ativa a conexão de forma segura.
        email.setSSLOnConnect(true);
        
        //Preparação e envio do email.
        try {
            //De onde virá o email.
            email.setFrom(meuEmail);
            //Adicionando assunto no email.
            email.setSubject(assunto);
            //Adicionando mensagem no email.
            email.setMsg("Solicitante: " + nome + "\n\n" + mensagem);
            //Para quem irá este email.
            email.addTo(paraEmail);
            //confirmando o envio.
            email.send();
            response.sendRedirect("NoticiasServlet");

        } catch (IOException | EmailException erro) {
            /**
             * @exception - Tratando exceções.
             */
            response.sendRedirect("NoticiasServlet");
            System.out.println("ERRO AO ENVIAR E-MAIL: " + erro.getMessage());
        }
    }

}
