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
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("LogoffServlet");
            return;
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
                    <br>
                    <a href="altera_perfil.jsp?username=<c:out value="${l.getUsername()}"/>&nome=<c:out value="${l.getNome()}"/>&email=<c:out value="${l.getEmail()}"/>&crm=<c:out value="${l.getCrm()}"/>&especializacao=<c:out value="${l.getEspecializacao()}"/>"><i class="fa fa-pencil" style="color: orange; font-size: 30px;"></i></a>
                    <br><br>
                    <a href="index.jsp"><i class="fa fa-home" style="color: #4E5066; font-size: 30px;"></i></a>
                </c:forEach>
            </div>
        </div>
        <br>
    </body>
</html>
