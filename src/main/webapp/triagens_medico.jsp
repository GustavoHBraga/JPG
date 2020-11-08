<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Triagem do Médico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="lib/css/triagens_medico.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="stylesheet" type="text/css" href="lib/css/triagensSearch.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>
    <body>
        <br><br>
        <a href="index.jsp">&nbsp;&nbsp;&nbsp;<i class="fa fa-home" style="color: #4E5066; font-size: 30px;"></i></a>
        <br><br><br><br>
        <h3>TRIAGENS</h3>
            <br>
        <div class="table-title">
            <form action="TriagensMedicoServlet" name="busca">
            <div class="search-box">
                <input class="search-txt" type="text" name="cpf" class="text" maxlength="50" placeholder="Busca por CPF..."/>
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
            <a href="TriagensMedicoServlet"><i class="fa fa-refresh" style="color: #4E5066; font-size: 30px;"></i></a>
            <br><br><br><br>
        </div>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">ID</th>
                    <th class="text-left">CPF</th>
                    <th class="text-left">nome</th>
                    <th class="text-left">nascimento</th>
                    <th class="text-left">email</th>
                    <th class="text-left">CEP</th>
                    <th class="text-left">estado</th>
                    <th class="text-left">1°&nbsp;contato</th>
                    <th class="text-left">2°&nbsp;contato</th>
                    <th class="text-left">sexo</th>
                    <th class="text-left">febre</th>
                    <th class="text-left">tosse</th>
                    <th class="text-left">cansaço</th>
                    <th class="text-left">falta&nbsp;de&nbsp;ar</th>
                    <th class="text-left">pressão&nbsp;no&nbsp;peito</th>
                    <th class="text-left">interações</th>
                </tr>
            </thead>
            <tbody class="table-hover">

                <c:forEach items="${dados}" var="l">
                    <tr>
                        <td class="text-left"><c:out value="${l.getIdTriagem()}"/></td>
                        <td class="text-left"><c:out value="${l.getCpf()}"/></td>
                        <td class="text-left"><c:out value="${l.getNome()}"/></td>
                        <td class="text-left"><fmt:formatDate pattern="dd/MM/yyyy" value="${l.getData_nascimento()}"/></td>
                        <td class="text-left"><c:out value="${l.getEmail()}"/></td>
                        <td class="text-left"><c:out value="${l.getCep()}"/></td>
                        <td class="text-left"><c:out value="${l.getEstado()}"/></td>
                        <td class="text-left"><c:out value="${l.getContato1()}"/></td>
                        <td class="text-left"><c:out value="${l.getContato2()}"/></td>
                        <td class="text-left"><c:out value="${l.getSexo()}"/></td>
                        <td class="text-left"><c:out value="${l.getFebre()}"/></td>
                        <td class="text-left"><c:out value="${l.getTosse_seca()}"/></td>
                        <td class="text-left"><c:out value="${l.getCansaco()}"/></td>
                        <td class="text-left"><c:out value="${l.getFalta_ar()}"/></td>
                        <td class="text-left"><c:out value="${l.getPressao_peito()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
    </body>
</html>

