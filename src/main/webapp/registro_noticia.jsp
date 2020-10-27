<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Registro de notícias</title>
        <link rel="stylesheet" type="text/css" href="lib/css/registro_noticia.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <br><br><br><br><br><br><br>
        <div class="formulario">
            <form action="InsereNoticiaServlet" class="form-contact" method="post" tabindex="1">
                <input type="text" hidden class="form-contact-input" value="<%=session.getAttribute("username")%>" name="usernameMedico" maxlength="50" placeholder="Título *" required />
                <br><br>
                <input type="text" class="form-contact-input" name="titulo" maxlength="50" placeholder="Título *" required />
                <br><br>
                <textarea class="form-contact-textarea" name="mensagem" maxlength="150" placeholder="Mensagem *" required></textarea>
                <br><br>
                <input type="date" class="form-contact-input" name="data" required/>
                <br><br>
                <div class="container">
                    <button class="btn-5" type="submit" style="font-size: 13px;">Publicar notícia</button>
                </div>
            </form>
        </div>
        <br>
        <div class="cancel">
            <a href="NoticiasServlet" style="color: white">Cancelar</a>
        </div>
    </body>
</html>
