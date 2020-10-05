<%-- 
    Author     : JPG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPG | Dashboard</title>
        <link rel="stylesheet" href="lib/css/index.css">
    </head>

    <%
        String usuario = (String) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    %>

    <body background="lib/img/background.jpg">
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
                        <li><a href="perfil.jsp">Olá<%out.print(" " + usuario);%></a></li>
                        <li><a href="#">Triagens</a></li>
                        <li><a href="#">Notícias</a></li>
                        <li><a href="atividades.jsp">Minhas Atividades</a></li>
                        <li><a href="sobre.jsp">Sobre</a></li>
                        <li><a href="logoff.jsp">Logoff</a></li>
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
        <h1>&nbsp;&nbsp;O Coronavírus</h1>
        
        <p>&nbsp;&nbsp;&nbsp;&nbsp;Coronavírus é uma família de vírus que causam infecções</p>  
        <p>&nbsp;&nbsp;&nbsp;&nbsp;respiratórias. O novo agente do coronavírus (nCoV-2019)</p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;foi descoberto em 31/12/19 após casos registrados na China.</p> 
        
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
        <b>&#10146;&nbsp;&nbsp;Como é transmitido ?</b></a>
        
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
        <b>&#10146;&nbsp;&nbsp;Quais são os sintomas ?</b></a>
        
        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('As recomendações de prevenção à COVID-19 são as seguintes:\n\
        \n\
        - Lave com frequência as mãos até a altura dos punhos, com água e sabão, ou então higienize com álcool em gel 70%. Essa frequência deve ser ampliada quando estiver em algum ambiente público (ambientes de trabalho, prédios e instalações comerciais, etc), quando utilizar estrutura de transporte público ou tocar superfícies e objetos de uso compartilhado.\n\
        \n\
        - Ao tossir ou espirrar, cubra nariz e boca com lenço ou com a parte interna do cotovelo. Não tocar olhos, nariz, boca ou a máscara de proteção fácil com as mãos não higienizadas. Se tocar olhos, nariz, boca ou a máscara, higienize sempre as mãos como já indicado.\n\
        \n\
        - Mantenha distância mínima de 1 (um) metro entre pessoas em lugares públicos e de convívio social. Evite abraços, beijos e apertos de mãos. Adote um comportamento amigável sem contato físico, mas sempre com um sorriso no rosto.');">
        <b>&#10146;&nbsp;&nbsp;Como se proteger ?</b></a>
        
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
        <b>&#10146;&nbsp;&nbsp;Como estimular outras pessoas ?</b></a>
        
        <br><br>&nbsp;&nbsp;
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <a href="#" onclick="swal('Se estiver doente, com sintomas compatíveis com a COVID-19, tais como febre, tosse, dor de garganta e/ou coriza, com ou sem falta de ar, evite contato físico com outras pessoas, incluindo os familiares, principalmente, idosos e doentes crônicos, Procure imediatamente os postos de triagem nas Unidades Básicas de Saúde / UPAS ou outras unidades de saúde.\n\
        \n\
        Também é possível ser consultado pela plataforma JPG, onde médicos profíssionais estarão aptos e disponíveis para o atendimento.\n\
        \n\
        UTILIZE MÁSCARA O TEMPO TODO.');">
        <b>&#10146;&nbsp;&nbsp;Se eu ficar doente ?</b></a>
        
        <br><br><br><br>
        &nbsp;&nbsp;
        <iframe src="https://player.vimeo.com/video/447264182" width="450" height="300" frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
        <br>
        <i>&nbsp;&nbsp;&nbsp;#NALINHADEFRENTE</i>
    </body>
</html>
