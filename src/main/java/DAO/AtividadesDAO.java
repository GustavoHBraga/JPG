
package DAO;

import MODEL.Atividades;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author JPG
 */
public class AtividadesDAO {
    
    private Connection conexao;
    private PreparedStatement preparedStatement;

    public AtividadesDAO() {

        conexao = new ConnectionFactory().getConexao();
    }
    
    public void registrarAtividades(Atividades atividade) {

        String sql = "INSERT INTO atividades (titulo, mensagem, data, status) VALUES (?,?,?,?)";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getTitulo());
            preparedStatement.setString(2, atividade.getMensagem());
            preparedStatement.setDate(3, atividade.getData());
            preparedStatement.setString(4, atividade.getStatus());
            preparedStatement.execute();
            preparedStatement.close();


        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE ATIVIDADES: " + erro.getMessage());
        }
    }
}
