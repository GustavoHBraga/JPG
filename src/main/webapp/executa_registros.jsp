<%-- 
    Author     : JPG
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="DAO.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="DAO.RegistrosDAO"%>
<%@page import="MODEL.Registros"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Cadastre-se</title>
    </head>
    <style>
        h1{
            text-align: center;
            font-family: Candara;
            color: #eee;
        }
    </style>
    <body bgcolor="#2c3338">
        <br><br><br><br><br>
<%

    try {
        Connection conexao = new ConnectionFactory().getConexao();
        PreparedStatement preparedStatement;
        Registros registro = new Registros();
        RegistrosDAO registroDAO = new RegistrosDAO();

        if (request.getParameter("usuario").equals("") || request.getParameter("senha").equals("")) {
            response.sendRedirect("registros.jsp");

        } else {
            registro.setUsuario(request.getParameter("usuario"));
            registro.setNome(request.getParameter("nome"));
            registro.setEmail(request.getParameter("email"));
            registro.setSenha(request.getParameter("senha"));
            String criaTabela = "CREATE TABLE " + request.getParameter("usuario") + "(id int not null auto_increment, numero int not null, nome varchar(30) not null, email varchar(30), titulo varchar(20) not null, texto varchar(100) not null, dataInicio date, dataFim date, statusAtividade varchar(15), primary key(id));";
            preparedStatement = conexao.prepareStatement(criaTabela);
            preparedStatement.execute();
            preparedStatement.close();
            registroDAO.registrar(registro);
            response.sendRedirect("login.jsp");
        }

    } catch (Exception erro) {
        out.print("<h1 style='color: crimson'>Este nome de usuário já existe, tente outro nome.</h1>");
    } 
%>
</body>
</html>