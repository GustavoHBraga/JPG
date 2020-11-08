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
        <link rel="stylesheet" type="text/css" href="lib/css/triagens_paciente.css">
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
    <center>
        <form action="TriagensServlet" method="post">
            <div class="contact_form">
                <div class="formulario">            
                    <h1>Join For Protect Get</h1>
                    <h2>Triagem | Passo 1</h2>
                    <br>
                    <center>
                        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
                        <a href="#" onclick="swal('Caro paciente,\n\
                     \n\
                    Seja Bem ao atendimento do sistema JPG !\n\
                    \n\
                    Preencha a triagem para que seu atendimento seja de rápido e preciso. \n\
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
                    <input type="text" name="cpf" placeholder="CPF *" maxlength="20" required>
                    <input type="text" name="nome" placeholder="Nome Completo *" maxlength="40" required>
                    <input type="date" name="data_nascimento" style="color: #ccc" required>
                    <input type="email" name="email" placeholder="E-mail *" maxlength="40" required>
                    <input type="text" name="cep" placeholder="CEP *" maxlength="6" required>
                    <input type="text" name="estado" placeholder="Estado *" maxlength="40" required>
                    <input type="text" name="contato1" placeholder="Forma de contato *" maxlength="40" required>
                    <input type="text" name="contato2" placeholder="Outra forma de contato" maxlength="40">
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
            <br><br>
            <h2>Triagem | Passo 2</h2>
            <br><br>
            <hr>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;1. Caro paciente, o senhor(a) sente alguma febre ?</h2>
            <div class="quiz"><br>
                <input class="quiz__radio" id="pets-yes" name="form1" value="Sim" type="radio" required><label class="quiz__label" for="pets-yes">Sim&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="pets-no" name="form1" value="Não" type="radio"><label class="quiz__label" for="pets-no">Não&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
                <div class="quiz__explanation">
                    <p><b>É importante medir a temperatura do corpo com frequência para saber se a febre está baixando.</b></p>
                    <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
                </div>
            </div>
            <hr>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;2. Caro paciente, o senhor(a) ao tossir sente uma tosse diferente ? Em outras palavras uma tosse seca ?</h2>
            <div class="quiz"><br>
                <input class="quiz__radio" id="workspace-yes" name="form2" value="Sim" type="radio" required><label class="quiz__label" for="workspace-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="workspace-no" name="form2" value="Não" type="radio"><label class="quiz__label" for="workspace-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
                <div class="quiz__explanation">
                    <p><b>A tosse nem sempre é sintoma de uma doença.</b></p>
                    <p><b>Algumas causas comuns incluem liberação normal das vias aéreas, agentes irritantes, como fumaça e gases, uso de tabaco ou deglutição inadequada de líquidos e alimentos.</b></p> 
                    <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
                </div>
            </div>
            <hr>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;3. Caro paciente, o senhor(a) ultimamente vem sentindo muinto cansaço ?</h2>
            <div class="quiz"><br>
                <input class="quiz__radio" id="mj-yes" name="form3" value="Sim" type="radio" required><label class="quiz__label" for="mj-yes">Sim&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="mj-no" name="form3" value="Não" type="radio"><label class="quiz__label" for="mj-no">Não&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
                <div class="quiz__explanation">
                    <p><b>A fadiga pode não ser causada por doenças subjacentes.</b></p>
                    <p><b>Algumas causas comuns são falta de sono, esforço pesado, jetlag, refeição pesada ou envelhecimento.</b></p> 
                    <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
                </div>
            </div>
            <hr>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;4. Caro paciente, o senhor(a) vem sentindo falta de ar ?</h2>
            <div class="quiz">
                <input class="quiz__radio" id="vehicle-yes" name="form4" value="Sim" type="radio" required><label class="quiz__label" for="vehicle-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="vehicle-no" name="form4" value="Não" type="radio"><label class="quiz__label" for="vehicle-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
                <div class="quiz__explanation">
                    <p><b>A falta de ar pode não ser causada por doenças subjacentes.</b></p>
                    <p><b>Algumas causas comuns são exercícios, altitude, longos períodos em repouso absoluto ou estilo de vida sedentário.</b></p>
                    <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
                </div>
            </div>
            <hr>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;5. Caro paciente, o senhor(a) sente alguma pressão na região do peitoral ?</h2>
            <div class="quiz">
                <input class="quiz__radio" id="insurance-yes" name="form5" value="Sim" type="radio" required><label class="quiz__label" for="insurance-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="insurance-no" name="form5" value="Não" type="radio"><label class="quiz__label" for="insurance-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
                <div class="quiz__explanation">
                    <p><b>A dor no peito pode não ser causada por doenças subjacentes.</b></p>
                    <p><b>Algumas causas comuns são levantar muito peso, trauma físico no peito ou engolir um pedaço de alimento grande demais.</b></p>
                    <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
                </div>
            </div>
            <hr>
            <br>
            <div class="container">
                <button class="btn-5" type="submit" style="font-size: 12px; color: darkcyan;">Encaminhar triagem</button>
            </div>
        </form>
        <div class="container">
            <a href="triagens_paciente.jsp"><button class="btn-5" style="font-size: 12px; color: goldenrod;">Refazer triagem</button></a>
        </div>
        <br><br>
        <div class="container">
            <a href="login.jsp"><button class="btn-5" style="font-size: 12px; color: salmon;">Cancelar triagem</button></a>
        </div>
        <br><br><br><br>
    </center>
</body>
</html>
