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
            function Emoji() {
                var variavel;
                var e = document.getElementById("emoji");
                var itemSelecionado = e.options[e.selectedIndex].value;
                if (itemSelecionado === "feliz") {
                    variavel = "&#128515;";
                } else if (itemSelecionado === "positivo") {
                    variavel = "&#128077;";
                }
                 else if (itemSelecionado === "anotacao") {
                    variavel = "&#9997;";
                }
                else if (itemSelecionado === "hospital") {
                    variavel = "&#127973;";
                }
                else if (itemSelecionado === "tchau") {
                    variavel = "&#128075;";
                }
                else if (itemSelecionado === "negativo") {
                    variavel = "&#128078;";
                }
                 else if (itemSelecionado === "triste") {
                    variavel = "&#128533;";
                }
                 else if (itemSelecionado === "concorda") {
                    variavel = "&#129309;";
                }
                 else if (itemSelecionado === "piscada") {
                    variavel = "&#128521;";
                }
                 else if (itemSelecionado === "bem") {
                    variavel = "&#128591;";
                }
                 else if (itemSelecionado === "carro") {
                    variavel = "&#128657;";
                }
                document.getElementById('msg').value = variavel;

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
                    <select name="emoji" id="emoji" onchange="Emoji()">
                        <option>Emojis</option>
                        <option value="feliz">&#128515;</option>
                        <option value="positivo">&#128077;</option>
                        <option value="anotacao">&#9997;</option>
                        <option value="hospital">&#127973;</option>
                        <option value="tchau">&#128075;</option>
                        <option value="negativo">&#128078;</option>
                        <option value="triste">&#128533;</option>
                        <option value="concorda">&#129309;</option>
                        <option value="piscada">&#128521;</option>
                        <option value="concorda">&#129309;</option>
                        <option value="concorda">&#129309;</option>
                        <option value="bem">&#128591;</option>
                        <option value="carro">&#128657;</option>
                    </select>
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
