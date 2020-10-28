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
        <div class="skew">
            <div class="content">
                <image src="lib/img/icone medico.jpg">
                <c:forEach items="${dados}" var="l">
                <h1><b><c:out value="${l.getUsername()}"/></b></h1>    
                <p><b><c:out value="${l.getNome()}"/></b></p>
                <p><b><c:out value="${l.getEmail()}"/></b></p>
                <p><b><c:out value="${l.getCrm()}"/></b></p>
                <p><b><c:out value="${l.getEspecializacao()}"/></b></p>
                </c:forEach>
            </div>
        </div>
        <br>
        <div class="container">
            <a href="altera_perfil.jsp"><button class="btn-5" style="font-size: 13px;">Alterar Perfil</button></a>
        </div>
        <br>
        <div class="cancel">
            <a href="index.jsp" style="color: #4E5066">Dashboard</a>
        </div>
    </body>
</html>
