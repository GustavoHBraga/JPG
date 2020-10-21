<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>JPG | Atividades</title>
	<link rel="stylesheet" type="text/css" href="lib/css/atividades.css">
</head>
<%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>
<body>
<br>
<h1><b>Minhas Atividades</b></h1>
<br><br>
<table class="container">
    <thead>
        <tr>
            <th><h1>N°</h1></th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
            <td>teste</td>
        </tr>
    </tbody>
</table>
</body>
</html>
