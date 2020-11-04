<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Notícias</title>
        <link rel="stylesheet" type="text/css" href="lib/css/noticias.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="stylesheet" type="text/css" href="lib/css/noticiasSearch.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>
    <body style="background-color: #B0E0E6">
        <br><br>
        <a href="index.jsp">&nbsp;&nbsp;&nbsp;<i class="fa fa-home" style="color: #4E5066; font-size: 30px;"></i></a>
        <br><br><br><br>
        <h3>NOTÍCIAS</h3>
        <br>
        <div class="container">
            <a href="registro_noticia.jsp"><button class="btn-5" style="font-size: 11px;">Publicar</button></a>
        </div>
        <form action="#" name="busca">
            <div class="search-box">
                <input class="search-txt" type="text" name="mensagem" class="text" maxlength="50" placeholder="Busca por mensagem..."/>
                <a class="search-btn" href="javascript:busca.submit()"><i class="fa fa-search"></i></a>
            </div>
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="NoticiasServlet"><i class="fa fa-refresh" style="color: #4E5066; font-size: 30px;"></i></a>
        </form>
        <script src="https://use.fontawesome.com/f295c5c492.js"></script>
        <div class="page">
            <c:forEach items="${dados}" var="l">
            <div class="timeline">
                <div class="timeline__group">
                    <span class="timeline__year time" aria-hidden="true"><b><fmt:formatDate pattern="dd/MM/yyyy" value="${l.getData()}"/></b></span>
                    <div class="timeline__cards">
                        <div class="timeline__card card">
                            <header class="card__header">
                                <time class="time">
                                    <span class="time__day"><c:out value="${l.getUsernameMedico()}"/></span>
                                </time>
                                <h4 class="card__title r-title"><c:out value="${l.getTitulo()}"/></h4>
                            </header>
                            <div class="card__content">
                                <p><c:out value="${l.getMensagem()}"/></p>
                                <br>
                            </div>
                            <a href="resposta_noticias.jsp"><i class="fa fa-envelope-o" style="color: #4E5066; font-size: 25px;"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </body>
</html>
