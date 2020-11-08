<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JPG | Resposta</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="lib/css/resposta_noticias.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <a href="index.jsp" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;<i class="fa fa-home" style="color: #4E5066; font-size: 30px;"></i></a>
        <br><br><br>
        <div class="login">
            <div class="login-triangle"></div>
            <h2 class="login-header">iNFORME:</h2>
            <form action="RespostaNoticiaServlet" class="login-container">
                <p>Para quem irá a resposta ?</p>
                <p><input type="text" name="paraEmail" placeholder="Para *" required></p>
                <p>Sobre oque se trata ?</p>
                <p><input type="text" name="nome" placeholder="Nome completo *" required></p>
                <p><input type="text" name="assunto" placeholder="Assunto *" required></p>
                <p><input type="text" name="mensagem" placeholder="Mensagem *" required></p>
                <br>
                <center>
                    <button class="noselect" type="submit">
                        <span><b>Encaminhar</b></span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 11c2.761.575 6.312 1.688 9 3.438 3.157-4.23 8.828-8.187 15-11.438-5.861 5.775-10.711 12.328-14 18.917-2.651-3.766-5.547-7.271-10-10.917z"/></svg>
                    </button>
                </center>
                <br>
                <center>
                    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
                    <a href="#" onclick="swal('Encaminhe a notícia selecionada em caso de dúvidas ou críticas sobre o assunto, e a encaminhe a um determinado trabalhista da instituição.\n\
                \n\
                Lembre-se sempre de preencher os campos corretamente.\n\
                \n\
                Informamos também que, não iremos violar de forma alguma os dados pessoais informados para envio.\n\
                \n\
                Caso queira saber mais sobre os Termos de Uso entre em contato com a Auditoria Interna da instituição JPG.');"><i class="fa fa-commenting" style="color: #4E5066; font-size: 20px;"></i></a>
                </center>
            </form>
        </div>
    </body>
</html>
