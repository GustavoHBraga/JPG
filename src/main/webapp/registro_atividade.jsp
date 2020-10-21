<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Registro de atividades</title>
        <link rel="stylesheet" type="text/css" href="lib/css/registro_atividade.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
    </head>
    <body>
        <br><br><br><br><br><br><br>
        <div class="formulario">
            <form action="#" class="form-contact" method="post" tabindex="1">
                <input type="text" class="form-contact-input" name="titulo" maxlength="50" placeholder="Título da atividade..." required />
                <br><br>
                <textarea class="form-contact-textarea" name="mensagem" minlength="150" placeholder="Mensagem da atividade..."></textarea>
                <br><br>
                <input type="date" class="form-contact-input" name="data"/>
                <br><br>
                <input type="text" class="form-contact-input" name="status" maxlength="20" placeholder="Status da atividade..." required />
            </form>
        </div>
        <div class="container">
            <a href="#"><button class="btn-5" style="font-size: 13px;">Registrar atividade</button></a>
        </div>
        <br>
        <div class="cancel">
            <a href="index.jsp" style="color: white">Cancelar</a>
        </div>
    </body>
</html>
