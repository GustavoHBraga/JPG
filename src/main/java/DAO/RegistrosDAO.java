/**
 *
 * @author JPG
 */
package DAO;

import MODEL.Registros;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrosDAO {

    private Connection conexao;
    private PreparedStatement preparedStatement;

    public RegistrosDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrar(Registros registro) {

        String sql = "INSERT INTO medicos (username, nome, email, crm, especializacao, senha) VALUES (?,?,?,?,?,?)";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, registro.getUsername());
            preparedStatement.setString(2, registro.getNome());
            preparedStatement.setString(3, registro.getEmail());
            preparedStatement.setString(4, registro.getCrm());
            preparedStatement.setString(5, registro.getEspecializacao());
            preparedStatement.setString(6, registro.getSenha());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE USUÁRIOS: " + erro.getMessage());
        }
    }
    
    public void alteraPerfil(Registros registro){
        
        String sql = "UPDATE medicos SET username = ?, nome = ?, email = ?, crm = ?, especializacao = ?, senha = ? WHERE id = ?";
        
        try {
            
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, registro.getUsername());
            preparedStatement.setString(2, registro.getNome());
            preparedStatement.setString(3, registro.getEmail());
            preparedStatement.setString(4, registro.getCrm());
            preparedStatement.setString(5, registro.getEspecializacao());
            preparedStatement.setString(6, registro.getSenha());
            preparedStatement.setInt(7, registro.getId_user());
            preparedStatement.execute();
            preparedStatement.close();
            
        } catch (Exception erro) {
            throw new RuntimeException("HOUVE UM ERRO NA ALTERAÇÃO DE PERFIL: " + erro.getMessage());
        }
        
    }
}
