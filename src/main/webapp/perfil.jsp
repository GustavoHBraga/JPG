<%-- 
    Author     : JPG
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="DAO.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Perfil</title>
        <link rel="stylesheet" type="text/css" href="lib/css/perfil.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
    </head>

    <%
        String usuario = (String) session.getAttribute("username");
        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
        String user = usuario;
        Connection conexao = new ConnectionFactory().getConexao();
        Statement statement;
        ResultSet resultSet;

        String sql = "SELECT nome, email, crm, especializacao FROM medicos WHERE username = '" + user + "'";
        statement = conexao.createStatement();
        statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
        resultSet = statement.executeQuery(sql);
        resultSet.first();
    %>
    <body>
        <div class="skew">
            <div class="content">
                <image src="lib/img/icone medico.jpg">
                <h1><b><%=usuario%></b></h1>
                <%do { %>
                <p><b><%out.print(resultSet.getString("nome"));%></b></p>
                <p><b><%out.print(resultSet.getString("crm"));%></b></p>
                <p><b><%out.print(resultSet.getString("email"));%></b></p>
                <p><b><%out.print(resultSet.getString("especializacao"));%></b></p>
                <%} while (resultSet.next());%>
            </div>
        </div>
        <br>
        <div class="container">
            <a href="altera_perfil.jsp"><button class="btn-5">Alterar Perfil</button></a>
        </div>
    </body>
</html>
