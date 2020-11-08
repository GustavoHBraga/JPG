package DAO;

import MODEL.Triagens;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author JPG
 */
public class TriagensDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public TriagensDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarTriagem(Triagens triagem) {

        String sql = "INSERT INTO triagens (cpf, nome, data_nascimento, email, cep, estado, contato1, contato2, sexo, febre, tosse_seca, cansaco, falta_ar, pressao_peito) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, triagem.getCpf());
            preparedStatement.setString(2, triagem.getNome());
            preparedStatement.setDate(3, (Date) triagem.getData_nascimento());
            preparedStatement.setString(4, triagem.getEmail());
            preparedStatement.setString(5, triagem.getCep());
            preparedStatement.setString(6, triagem.getEstado());
            preparedStatement.setString(7, triagem.getContato1());
            preparedStatement.setString(8, triagem.getContato2());
            preparedStatement.setString(9, triagem.getSexo());
            preparedStatement.setString(10, triagem.getFebre());
            preparedStatement.setString(11, triagem.getTosse_seca());
            preparedStatement.setString(12, triagem.getCansaco());
            preparedStatement.setString(13, triagem.getFalta_ar());
            preparedStatement.setString(14, triagem.getPressao_peito());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE TRIAGEM: " + erro.getMessage());
        }
    }

    public void atenderTriagem(int id) {

        String sql = "DELETE FROM triagens WHERE id = " + id;

        try {

            statement = conexao.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO AO ATENDER TRIAGEM: " + erro.getMessage());
        }
    }
}
