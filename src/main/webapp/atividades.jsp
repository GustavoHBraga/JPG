<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Atividades</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="lib/css/atividades.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="stylesheet" type="text/css" href="lib/css/atividadesSearch.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("LogoffServlet");
            return;
        }
    %>
    <body>
        <br><br>
        <a href="index.jsp">&nbsp;&nbsp;&nbsp;<i class="fa fa-home" style="color: #4E5066; font-size: 30px;"></i></a>
        <br><br><br><br>
        <h3>ATIVIDADES</h3>
            <br>
        <div class="table-title">
            <form action="AtividadesServlet" name="busca">
            <div class="search-box">
                <input class="search-txt" type="text" name="mensagem" class="text" maxlength="50" placeholder="Busca por mensagem..."/>
                <a class="search-btn" href="javascript:busca.submit()"><i class="fa fa-search"></i></a>
            </div>
            </form>
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
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="AtividadesServlet"><i class="fa fa-refresh" style="color: #4E5066; font-size: 30px;"></i></a>
            <br><br><br><br>
        </div>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">título</th>
                    <th class="text-left">mensagem</th>
                    <th class="text-left">previsão</th>
                    <th class="text-left">status</th>
                    <th class="text-left">interações</th>
                </tr>
            </thead>
            <tbody class="table-hover">

                <c:forEach items="${dados}" var="l">
                    <tr>
                        <td class="text-left" hidden><c:out value="${l.getIdAtividade()}"/></td>
                        <td class="text-left"><c:out value="${l.getTitulo()}"/></td>
                        <td class="text-left"><c:out value="${l.getMensagem()}"/></td>
                        <td class="text-left"><fmt:formatDate pattern="dd/MM/yyyy" value="${l.getData()}"/></td>
                        <td class="text-left"><c:out value="${l.getStatus()}"/></td>
                        <td class="text-left"><a href="altera_atividade.jsp?id=<c:out value="${l.getIdAtividade()}"/>&titulo=<c:out value="${l.getTitulo()}"/>&mensagem=<c:out value="${l.getMensagem()}"/>&data=<c:out value="${l.getData()}"/>&status=<c:out value="${l.getStatus()}"/>"><i class="fa fa-pencil" style="color: orange; font-size: 30px;"></i>&nbsp;&nbsp;&nbsp;<a href="PDFAtividadesServlet?titulo=<c:out value="${l.getTitulo()}"/>&mensagem=<c:out value="${l.getMensagem()}"/>&data=<c:out value="${l.getData()}"/>&status=<c:out value="${l.getStatus()}"/>"><i class="fa fa-file-pdf-o" style="color: teal; font-size: 28px;"></i></a></a>&nbsp;&nbsp;<a onclick="return confirm('Deseja realmente excluir esta atividade ?')" href="RemoveAtividadeServlet?id=<c:out value="${l.getIdAtividade()}"/>"<i class="fa fa-trash" style="color: salmon; font-size: 30px;"></i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <div class="container">
            <a href="registro_atividade.jsp"><button class="btn-5" style="font-size: 12px;">Nova atividade</button></a>
        </div>
    </body>
</html>
