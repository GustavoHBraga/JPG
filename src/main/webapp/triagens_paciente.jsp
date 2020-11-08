<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Triagem</title>
        <link rel="stylesheet" type="text/css" href="lib/css/triagem_paciente.css">
        <link rel="stylesheet" type="text/css" href="lib/css/botao.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <br><br><br><br><br>
        <h1>Join For Protect Get</h1>
        <br>
        <h2 style="text-align: center; font-size: 20px;">Atendimento | Passo 02</h2>
        <br>
    <center>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Caro paciente,\n\
                     \n\
                    O senhor(a) está no passo 02 desse atendimento.\n\
                    \n\
                    Informe de acordo ao questionário como se sente em seu estado atual, para que assim o atendimento seja mais preciso.');"><i class="fa fa-commenting" style="color: #4E5066; font-size: 20px;"></i></a>
    </center>
    <br><br><br>
    <form action="TriagensServlet" method="post">
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;1. Caro paciente, o senhor(a) sente alguma febre ?</h2>
        <div class="quiz"><br>
            <input class="quiz__radio" id="pets-yes" name="form1" value="Sim" type="radio" required><label class="quiz__label" for="pets-yes">Sim&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="pets-no" name="form1" value="Não" type="radio"><label class="quiz__label" for="pets-no">Não&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
            <div class="quiz__explanation">
                <p><b>É importante medir a temperatura do corpo com frequência para saber se a febre está baixando.</b></p>
                <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
            </div>
        </div>
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;2. Caro paciente, o senhor(a) ao tossir sente uma tosse diferente ? Em outras palavras uma tosse seca ?</h2>
        <div class="quiz"><br>
            <input class="quiz__radio" id="workspace-yes" name="form2" value="Sim" type="radio" required><label class="quiz__label" for="workspace-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="workspace-no" name="form2" value="Não" type="radio"><label class="quiz__label" for="workspace-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
            <div class="quiz__explanation">
                <p><b>A tosse nem sempre é sintoma de uma doença.</b></p>
                <p><b>Algumas causas comuns incluem liberação normal das vias aéreas, agentes irritantes, como fumaça e gases, uso de tabaco ou deglutição inadequada de líquidos e alimentos.</b></p> 
                <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
            </div>
        </div>
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;3. Caro paciente, o senhor(a) ultimamente vem sentindo muinto cansaço ?</h2>
        <div class="quiz"><br>
            <input class="quiz__radio" id="mj-yes" name="form3" value="Sim" type="radio" required><label class="quiz__label" for="mj-yes">Sim&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="mj-no" name="form3" value="Não" type="radio"><label class="quiz__label" for="mj-no">Não&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
            <div class="quiz__explanation">
                <p><b>A fadiga pode não ser causada por doenças subjacentes.</b></p>
                <p><b>Algumas causas comuns são falta de sono, esforço pesado, jetlag, refeição pesada ou envelhecimento.</b></p> 
                <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
            </div>
        </div>
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;4. Caro paciente, o senhor(a) vem sentindo falta de ar ?</h2>
        <div class="quiz">
            <input class="quiz__radio" id="vehicle-yes" name="form4" value="Sim" type="radio" required><label class="quiz__label" for="vehicle-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="vehicle-no" name="form4" value="Não" type="radio"><label class="quiz__label" for="vehicle-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
            <div class="quiz__explanation">
                <p><b>A falta de ar pode não ser causada por doenças subjacentes.</b></p>
                <p><b>Algumas causas comuns são exercícios, altitude, longos períodos em repouso absoluto ou estilo de vida sedentário.</b></p>
                <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
            </div>
        </div>
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;5. Caro paciente, o senhor(a) sente alguma pressão na região do peitoral ?</h2>
        <div class="quiz">
            <input class="quiz__radio" id="insurance-yes" name="form5" value="Sim" type="radio" required><label class="quiz__label" for="insurance-yes">Sim&nbsp;&nbsp;<span class="quiz__answer correct"><i class="fa fa-frown-o" style="color: salmon; font-size: 23px;"></i></span></label> <input class="quiz__radio" id="insurance-no" name="form5" value="Não" type="radio"><label class="quiz__label" for="insurance-no">Não&nbsp;&nbsp;<span class="quiz__answer incorrect"><i class="fa fa-smile-o" style="color: seagreen; font-size: 23px;"></i></span></label>
            <div class="quiz__explanation">
                <p><b>A dor no peito pode não ser causada por doenças subjacentes.</b></p>
                <p><b>Algumas causas comuns são levantar muito peso, trauma físico no peito ou engolir um pedaço de alimento grande demais.</b></p>
                <p style="color: seagreen;"><b>Mas não se preocupe, nós da JPG iremos sempre atender e resolver seu problema !</b></p>
            </div>
        </div>
    <br><br><br><br>
    <div class="container">
        <button class="btn-5" type="submit" style="font-size: 12px;">Encaminhar triagem</button>
    </div>
    <br>
    <div class="container">
        <a href="triagens_paciente.jsp"><button class="btn-5" style="font-size: 12px;">Refazer triagem</button></a>
    </div>
    </form>
    <br><br><br>
</body>
</html>
