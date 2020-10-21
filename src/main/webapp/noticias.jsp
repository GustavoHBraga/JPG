<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Notícias</title>
        <link rel="stylesheet" type="text/css" href="lib/css/atividades.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <br><br><br><br>
        <div class="table-title">
            <h3>Notícias</h3>
        </div>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">usuario</th>
                    <th class="text-left">email</th>
                    <th class="text-left">telefone</th>
                    <th class="text-left">noticia</th>
                </tr>
            </thead>
            <tbody class="table-hover">
                <tr>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                </tr>
            </tbody>
        </table>
        <br>
    </body>
</html>
