<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Atendimento Online</title>
        <link rel="stylesheet" type="text/css" href="lib/css/atendimento.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">

        <script>
            var wsUrl;
            if (window.location.protocol === 'http:') {
                wsUrl = 'ws://';
            } else {
                wsUrl = 'wss://';
            }
            var ws = new WebSocket(wsUrl + window.location.host + "/JPG/atendimento");

            ws.onmessage = function (event) {
                var mySpan = document.getElementById("chat");
                mySpan.innerHTML += event.data + "<br><br>";
            };

            ws.onerror = function (event) {
                console.log("Erro: ", event);
            };
            function sendMsg() {
                var msg = document.getElementById("msg").value;
                if (msg)
                {
                    ws.send("paciente: " + msg);
                }
                document.getElementById("msg").value = "";
            }
        </script>
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario != null) {
            response.sendRedirect("LogoffServlet");
            return;
        }
    %>
    <body>
        <br><br><br>
        <h1>Atendimento Online</h1>
        <div>
            <div id="chat" class="chat"></div>
            <center>
                <div>
                    <br>
                    <input type="text" class="form-contact-input" name="msg" id="msg" maxlength="50" placeholder="Digite..."/>
                    <br><br>
                    <div class="container">
                        <button onclick="return sendMsg();" class="btn-5" style="font-size: 12px; color: seagreen;">Enviar</button>
                        <br>
                        <a href="login.jsp"><button class="btn-5" style="font-size: 12px; color: salmon;">Finalizar Atendimento</button></a>
                        <br>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>
