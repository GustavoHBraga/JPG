package VIEW;

import java.io.IOException;
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
@WebServlet(name = "LogoffServlet", urlPatterns = {"/LogoffServlet"})
public class LogoffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * 1) Removendo a atribuição de sessão do usuário;
         */
        
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");

    }

}
