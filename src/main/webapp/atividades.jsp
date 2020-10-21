<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Atividades</title>
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
            <h3>Atividades</h3>
        </div>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">título</th>
                    <th class="text-left">mensagem</th>
                    <th class="text-left">data</th>
                    <th class="text-left">status</th>
                    <th class="text-left">ações</th>
                </tr>
            </thead>
            <tbody class="table-hover">
                <tr>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                    <td class="text-left">linha</td>
                    <td class="text-left"><i class="fa fa-edit"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-trash"></i></td>
                </tr>
            </tbody>
        </table>
        <br>
        <div class="container">
            <a href="registro_atividade.jsp"><button class="btn-5" style="font-size: 12px;">Nova atividade</button></a>
        </div>
    </body>
</html>
