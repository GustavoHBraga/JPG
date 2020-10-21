function validaRegistro(){
    
    var username = formRegistro.username.value;
    var senha = formRegistro.senha.value;
    var senhaRepitida = formRegistro.senhaRepitida.value;
    var email = formRegistro.email.value;
    var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    
    if (username.length < 5) {
        alert('Preencha o campo usuário com minímo 6 caracteres.');
        formRegistro.username.focus();
        return false;
    }
    
    if (senha.length < 5) {
        alert('Preencha o campo senha com minímo 6 caracteres.');
        formRegistro.senha.focus();
        return false;
    }
    if (senha !== senhaRepitida) {
        alert('As senhas são diferentes.');
        formRegistro.senhaRepitida.focus();
        return false;
    }
    
    if(!filtro.test(email)){
       alert('Email inválido.');
       formRegistro.email.focus();
       return false;
    }
    
}