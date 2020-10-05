function validaAlteraPerfil(){
    
    var usuario = formAlteraPerfil.usuario.value;
    var senhaNova = formAlteraPerfil.senhaNova.value;
    var senhaRepitida = formAlteraPerfil.senhaRepitida.value;
    var email = formAlteraPerfil.email.value;
    var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    
    if (usuario.length < 5) {
        alert('Preencha o campo novo usuário com minímo 6 caracteres.');
        formAlteraPerfil.usuario.focus();
        return false;
    }
    
    if(!filtro.test(email)){
       alert('Email inválido.');
       formAlteraPerfil.email.focus();
       return false;
    }
 
    if (senhaNova.length < 5) {
        alert('Preencha o campo nova senha com minímo 6 caracteres.');
        formAlteraPerfil.senhaNova.focus();
        return false;
    }
    
    if (senhaNova !== senhaRepitida) {
        alert('As senhas são diferentes.');
        formAlteraPerfil.senhaRepitida.focus();
        return false;
    }
}

