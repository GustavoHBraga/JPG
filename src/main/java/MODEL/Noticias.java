
package MODEL;

import java.util.Date;

/**
 *
 * @author JPG
 */
public class Noticias {
    
    private int idNoticias;
    private String usernameMedico;
    private String titulo;
    private String mensagem;
    private Date data;

    public int getIdNoticias() {
        return idNoticias;
    }

    public void setIdNoticias(int idNoticias) {
        this.idNoticias = idNoticias;
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
    
}
