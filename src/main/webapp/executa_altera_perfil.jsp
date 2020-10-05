<%@page import="java.sql.PreparedStatement"%>
<%@page import="DAO.RegistrosDAO"%>
<%@page import="MODEL.Registros"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="DAO.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<link rel="stylesheet" type="text/css" href="lib/css/registros.css">
<%
    try{
        
    String usuario = (String) session.getAttribute("usuario");

    Connection conexao = new ConnectionFactory().getConexao();
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    String user = usuario;
    Registros registro = new Registros();
    RegistrosDAO registroDAO = new RegistrosDAO();

    String sql = "SELECT id FROM registros WHERE usuario = '" + user + "'";
    statement = conexao.createStatement();
    statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
    resultSet = statement.executeQuery(sql);
    resultSet.first();
    
    registro.setUsuario(request.getParameter("usuario"));
    registro.setNome(request.getParameter("nome"));
    registro.setEmail(request.getParameter("email"));
    registro.setSenha(request.getParameter("senhaNova"));
    registro.setId(Integer.parseInt(resultSet.getString("id")));
    
    String sql_table = "ALTER TABLE " + user + " RENAME TO " + request.getParameter("usuario");
    preparedStatement = conexao.prepareStatement(sql_table);
    preparedStatement.execute();
    preparedStatement.close();
    
    registroDAO.alteraPerfil(registro);
    
    response.sendRedirect("logoff.jsp");
    
    } catch (Exception erro) {
        out.print("<h1 style='color: crimson; font-family: candara; text-align: center'><br><br><br>Este nome de usuário já existe, tente outro nome.</h1>");
    } 
%>
