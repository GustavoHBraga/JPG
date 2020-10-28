<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Alterar atividades</title>
        <link rel="stylesheet" type="text/css" href="lib/css/registro_atividade.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <form action="AlteraAtividadeServlet" class="form-contact" tabindex="1">
                <input type="text" hidden class="form-contact-input" name="id" value="<%=request.getParameter("id")%>"/>
                <br><br>
                <input type="text" class="form-contact-input" name="titulo" value="<%=request.getParameter("titulo")%>" maxlength="50" placeholder="Novo título *" required />
                <br><br>
                <textarea class="form-contact-textarea" name="mensagem" value="<%=request.getParameter("mensagem")%>" maxlength="150" placeholder="Nova mensagem *" required></textarea>
                <br><br>
                <input type="date" class="form-contact-input" name="data" value="<%=request.getParameter("data")%>" required/>
                <br><br>
                <input type="text" class="form-contact-input" name="status" value="<%=request.getParameter("status")%>" maxlength="20" placeholder="Novo Status *" required />
                <div class="container">
                <button class="btn-5" type="submit" style="font-size: 13px;">Alterar atividade</button>
                </div>
            </form>
        </div>
        <br>
        <div class="cancel">
            <a href="AtividadesServlet" style="color: #fff">Cancelar</a>
        </div>
    </body>
</html>
