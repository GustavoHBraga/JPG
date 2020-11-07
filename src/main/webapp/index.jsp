<%-- 
    Author     : JPG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Dashboard</title>
        <link rel="stylesheet" type="text/css" href="lib/css/index.css">
        <link rel="shortcut icon" type="imagem/png" href="lib/img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("username");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>
    <body>
        <div class="container">
            <nav>
                <input type="checkbox" id="nav" class="hidden">
                <label for="nav" class="nav-btn">
                    <i></i>
                    <i></i>
                    <i></i>
                </label>
                <div class="logo">
                    <a href="index.jsp">Join For Protect Get</a>
                    <hr>
                </div>
                <div class="nav-wrapper">
                    <ul>
                        <li><a href="PerfilServlet">Olá&nbsp;<c:out value="${sessionScope.username}"></c:out></a></li>
                        <li><a href="triagens_medico.jsp">Triagens</a></li>
                        <li><a href="NoticiasServlet">Eventos</a></li>
                        <li><a href="AtividadesServlet">Atividades</a></li>
                        <li><a href="sobre.jsp">Sobre</a></li>
                        <li><a href="LogoffServlet">Logoff</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <style type="text/css">
            a{
                text-decoration:none;
                color: black;
            }
        </style>
        <br><br><br><br><br><br><br>
        <h1 style="color: #4E5066">&nbsp;&nbsp;O Coronavírus</h1>

        <b><p style="color: #4E5066">&nbsp;&nbsp;&nbsp;&nbsp;Coronavírus é uma família de vírus que causam infecções</p>  
        <p style="color: #4E5066">&nbsp;&nbsp;&nbsp;&nbsp;respiratórias. O novo agente do coronavírus (nCoV-2019)</p>
        <p style="color: #4E5066">&nbsp;&nbsp;&nbsp;&nbsp;foi descoberto em 31/12/19 após casos registrados na China.</p></b>

        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('A transmissão acontece de uma pessoa doente para outra ou por contato próximo por meio de:\n\
        \n\
        - Toque do aperto de mão contaminadas;\n\
        - Espirro;\n\
        - Tosse;\n\
        - Catarro;\n\
        \n\
        Objetos ou superfícies contaminadas como: \n\
        \n\
        - celulares;\n\
        - mesas;\n\
        - talheres;\n\
        - maçanetas;\n\
        - brinquedos;\n\
        - teclados de computador etc...');">
            <b style="color: #4E5066"><i class="fa fa-bar-chart" style="color: #4E5066; font-size: 20px;"></i>&nbsp;&nbsp;Como é transmitido ?</b></a>

        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Os sintomas da COVID-19 podem variar de um resfriado, a uma Síndrome Gripal-SG (presença de um quadro respiratório agudo, caracterizado por, pelo menos dois dos seguintes sintomas: sensação febril ou febre associada a dor de garganta, dor de cabeça, tosse, coriza) até uma pneumonia severa. Sendo os sintomas mais comuns:\n\
        \n\
        - Tosse;\n\
        - Febre;\n\
        - Tosse;\n\
        - Coriza;\n\
        - Dor de garganta;\n\
        - Dificuldade para respirar;\n\
        - Perda de olfato (anosmia);\n\
        - Alteração do paladar (ageusia);\n\
        - Distúrbios gastrintestinais (náuseas/vômitos/diarreia);\n\
        - Cansaço (astenia);\n\
        - Diminuição do apetite (hiporexia);\n\
        - Dispnéia ( falta de ar);');">
            <b style="color: #4E5066"><i class="fa fa-stethoscope" style="color: #4E5066; font-size: 25px;"></i>&nbsp;&nbsp;Quais são os sintomas ?</b></a>

        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('As recomendações de prevenção à COVID-19 são as seguintes:\n\
        \n\
        - Lave com frequência as mãos até a altura dos punhos, com água e sabão, ou então higienize com álcool em gel 70%. Essa frequência deve ser ampliada quando estiver em algum ambiente público (ambientes de trabalho, prédios e instalações comerciais, etc), quando utilizar estrutura de transporte público ou tocar superfícies e objetos de uso compartilhado.\n\
        \n\
        - Ao tossir ou espirrar, cubra nariz e boca com lenço ou com a parte interna do cotovelo. Não tocar olhos, nariz, boca ou a máscara de proteção fácil com as mãos não higienizadas. Se tocar olhos, nariz, boca ou a máscara, higienize sempre as mãos como já indicado.\n\
        \n\
        - Mantenha distância mínima de 1 (um) metro entre pessoas em lugares públicos e de convívio social. Evite abraços, beijos e apertos de mãos. Adote um comportamento amigável sem contato físico, mas sempre com um sorriso no rosto.');">
            <b style="color: #4E5066"><i class="fa fa-street-view" style="color: #4E5066; font-size: 25px;"></i>&nbsp;&nbsp;Como se proteger ?</b></a>

        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Informe aos amigos e colegas de trabalho sobre a importância do uso de máscara e da higienização das mãos na prevenção da disseminação do vírus causador da doença COVID-19.\n\
        \n\
        Dicas para viajantes:\n\
        \n\
        Caso você precise viajar, avalie a real necessidade. Se for inevitável viajar, previna-se e siga as orientações das autoridades de saúde locais.\n\
        \n\
        Ao voltar de viagens internacionais ou locais recomenda-se:\n\
        \n\
        - Reforçar os hábitos de higiene e proteção como a utilização de máscara, higienização das mãos com água e sabão ou com álcool em gel 70 %.\n\
        \n\
        - Caso apresente sintomas de gripe, busque atendimento nos serviços de saúde, e evite contato com outras pessoas.');">
            <b style="color: #4E5066"><i class="fa fa-group" style="color: #4E5066; font-size: 21px;"></i>&nbsp;&nbsp;Como estimular outras pessoas ?</b></a>

        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Se estiver doente, com sintomas compatíveis com a COVID-19, tais como febre, tosse, dor de garganta e/ou coriza, com ou sem falta de ar, evite contato físico com outras pessoas, incluindo os familiares, principalmente, idosos e doentes crônicos, Procure imediatamente os postos de triagem nas Unidades Básicas de Saúde / UPAS ou outras unidades de saúde.\n\
        \n\
        Também é possível ser consultado pela plataforma JPG, onde médicos profíssionais estarão aptos e disponíveis para o atendimento.\n\
        \n\
        UTILIZE MÁSCARA O TEMPO TODO.');">
            <b style="color: #4E5066"><i class="fa fa-user-md" style="color: #4E5066; font-size: 25px;"></i>&nbsp;&nbsp;Se eu ficar doente ?</b></a>

        <br><br><br><br>
        &nbsp;&nbsp;
        <iframe src="https://player.vimeo.com/video/447264182" width="450" height="300" frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
        <br>
        <i style="color: #4E5066">&nbsp;&nbsp;&nbsp;#NALINHADEFRENTE</i>
    </body>
</html>
