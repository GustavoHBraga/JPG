package MODEL;

import java.util.Date;

/**
 *
 * @author JPG
 */
public class Triagens {

    private int idTriagem;
    private String cpf;
    private String nome;
    private Date data_nascimento;
    private String email;
    private String cep;
    private String estado;
    private String contato1;
    private String contato2;
    private String sexo;
    private String febre;
    private String tosse_seca;
    private String cansaco;
    private String falta_ar;
    private String pressao_peito;

    public int getIdTriagem() {
        return idTriagem;
    }

    public void setIdTriagem(int idTriagem) {
        this.idTriagem = idTriagem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFebre() {
        return febre;
    }

    public void setFebre(String febre) {
        this.febre = febre;
    }

    public String getTosse_seca() {
        return tosse_seca;
    }

    public void setTosse_seca(String tosse_seca) {
        this.tosse_seca = tosse_seca;
    }

    public String getCansaco() {
        return cansaco;
    }

    public void setCansaco(String cansaco) {
        this.cansaco = cansaco;
    }

    public String getFalta_ar() {
        return falta_ar;
    }

    public void setFalta_ar(String falta_ar) {
        this.falta_ar = falta_ar;
    }

    public String getPressao_peito() {
        return pressao_peito;
    }

    public void setPressao_peito(String pressao_peito) {
        this.pressao_peito = pressao_peito;
    }

}
