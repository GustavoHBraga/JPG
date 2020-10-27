<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Perfil</title>
        <link rel="stylesheet" type="text/css" href="lib/css/altera_perfil.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="lib/js/validaAlteraPerfil.js"></script>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <body class="align">
        <h1>Perfil</h1>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Caso queria alterar apenas um dado em especifíco, repita aos outros campos os mesmos dados da conta atual.');"><i class="fa fa-commenting" style="color: #fff; font-size: 20px;"></i></a>
        <br>
        <div class="grid">
            <form action="AlteraPerfilServlet" method="post" class="form login"  name="formAlteraPerfil">
                <div class="form__field">
                    <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Usuário</span></label>
                    <input id="login__username" type="text" name="username" class="form__input" placeholder="Novo nome de usuário *" required>
                </div>
                <div class="form__field">
                    <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
                    <input id="login__username" type="text" name="nome" class="form__input" placeholder="Alterar nome completo *" required>
                </div>
                <div class="form__field">
                    <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
                    <input id="login__username" type="email" name="email" class="form__input" placeholder="Novo e-mail *" required>
                </div>
                <div class="form__field">
                    <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
                    <input id="login__username" type="text" name="crm" class="form__input" maxlength="10" placeholder="Novo crm *" required>
                </div>
                <div class="form__field">
                    <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
                    <input id="login__username" type="text" name="especializacao" class="form__input" placeholder="Nova especialização *" required>
                </div>
                <div class="form__field">
                    <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">SenhaNova</span></label>
                    <input id="login__password" type="password" name="senhaNova" class="form__input" placeholder="Nova senha *" required>
                </div>
                <div class="form__field">
                    <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">SenhaRepitida</span></label>
                    <input id="login__password" type="password" name="senhaRepitida" class="form__input" placeholder="Repita a nova senha *" required>
                </div>
                <div class="form__field">
                    <input type="submit" value="Alterar meus Dados" onclick="return validaAlteraPerfil(), alert('Clique em OK para prosseguir.')">
                </div>
            </form>
            <p class="text--center"><a href="PerfilServlet">Cancelar</a><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="assets/images/icons.svg#arrow-right"></use></svg></p>
        </div>
    <svg xmlns="http://www.w3.org/2000/svg" class="icons"><symbol id="arrow-right" viewBox="0 0 1792 1792"><path d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z"/></symbol><symbol id="lock" viewBox="0 0 1792 1792"><path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z"/></symbol><symbol id="user" viewBox="0 0 1792 1792"><path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z"/></symbol></svg>
</body>
</html>
