<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Atividades</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="lib/css/atividades.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <br><br>
        <a href="index.jsp">&nbsp;&nbsp;&nbsp;<i class="fa fa-home" style="color: white; font-size: 30px;"></i></a>
        <br><br><br><br>
        <div class="table-title">
            <h3>Atividades</h3>
            <br>
            <form action="AtividadesServlet" name="busca">
                <a href="javascript:busca.submit()"><i class="fa fa-search" style="color: white; font-size: 25px;"></i></a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:busca.submit()"><i class="fa fa-refresh" style="color: white; font-size: 25px;"></i></a>
                <input type="text" class="form-contact-input" name="mensagem" maxlength="50" placeholder="Busca por mensagem..."/>
            </form>
        </div>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">título</th>
                    <th class="text-left">mensagem</th>
                    <th class="text-left">previsão</th>
                    <th class="text-left">status</th>
                    <th class="text-left">ações</th>
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
                        <td class="text-left"><a href="altera_atividade.jsp?id=<c:out value="${l.getIdAtividade()}"/>&titulo=<c:out value="${l.getTitulo()}"/>&mensagem=<c:out value="${l.getMensagem()}"/>&data=<c:out value="${l.getData()}"/>&status=<c:out value="${l.getStatus()}"/>"><i class="fa fa-edit" style="color: orange; font-size: 30px;"></i></a>&nbsp;&nbsp;<a href="RemoveAtividadeServlet?id=<c:out value="${l.getIdAtividade()}"/>"<i class="fa fa-trash" style="color: salmon; font-size: 30px;"></i></a></td>
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
