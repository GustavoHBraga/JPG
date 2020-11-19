
package MODEL;

import java.util.Date;

/**
 *
 * @author JPG
 */

//Encapsulando e definindo atributos.
public class Atividades {

    //Atributos.     
    private int idAtividade;
    private String usernameMedico;
    private String titulo;
    private String mensagem;
    private Date data;
    private String status;
    
    //Encapsulamentos.      
    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getUsernameMedico() {
        return usernameMedico;
    }

    public void setUsernameMedico(String usernameMedico) {
        this.usernameMedico = usernameMedico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
