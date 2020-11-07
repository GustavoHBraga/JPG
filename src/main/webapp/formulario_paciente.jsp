<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Formulário</title>
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" type="text/css" href="lib/css/formulario_paciente.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario != null) {
            response.sendRedirect("index.jsp");
            return;
        }
    %>
    <body>
        <form action="PacientesServlet" method="post"> 
            <div class="contact_form">
                <div class="formulario">            
                    <h1>Join For Protect Get</h1>
                    <h2>Atendimento | Passo 01</h2>
                    <br>
                    <center>
                        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
                        <a href="#" onclick="swal('Caro paciente,\n\
                     \n\
                    Seja Bem ao atendimento do sistema JPG !\n\
                    \n\
                    O senhor(a) está no passo 01 desse atendimento.\n\
                    \n\
                    Preencha o formulário para que seu atendimento seja de rápida prontidão. \n\
                    \n\
                    Lembre-se sempre de preencher os campos corretamente.\n\
                    \n\
                    Lembramos que de forma alguma iremos violar seus dados pessoais, caso queira saber mais acesse os Termos de Uso da auditoria Interna da Instituição JPG.\n\
                    \n\
                    Então vamos lá !!!\n\
                    \n\
                    Clique em OK para prosseguir o atendimento.');"><i class="fa fa-commenting" style="color: #4E5066; font-size: 20px;"></i></a>
                    </center>
                    <h3>Informe abaixo suas credências para solicitar um atendimento.</h3>
                    <input type="text" name="cpf" placeholder="CPF *" required>
                    <input type="text" name="nome" placeholder="Nome Completo *" required>
                    <input type="date" name="data" style="color: #ccc" required>
                    <input type="email" name="email" placeholder="E-mail *" required>
                    <input type="text" name="estado" placeholder="Estado *" required>
                    <input type="text" name="cep" placeholder="CEP *" required>
                    <input type="text" name="contato1" placeholder="Forma de contato *" required>
                    <input type="text" name="contato2" placeholder="Outra forma de contato">
                    <div class="sexo">
                        <input type="radio" id="masculino" name="sexo" value="masculino">
                        <h4><i class="fa fa-male" style="color: #4E5066; font-size: 30px;"></i></h4>
                        <input type="radio" id="feminino" name="sexo" value="feminino">
                        <h5><i class="fa fa-female" style="color: #4E5066; font-size: 30px;"></i></h5>
                        <input type="radio" id="outros" name="sexo" value="outros">
                        <h6>Outros</h6>
                    </div>
                </div>  
            </div>
            <div class="container">
                <button class="btn-5" type="submit" style="font-size: 12px;">Solicitar Atendimento</button>
            </div>
            <br><br>
        </form>
    </body>
</html>
