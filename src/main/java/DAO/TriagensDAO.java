package DAO;

import MODEL.Triagens;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author JPG
 */
public class TriagensDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;

    public TriagensDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarTriagem(Triagens triagem) {

        String sql = "INSERT INTO triagens (cpf, febre, tosse_seca, cansaco, falta_ar, pressao_peito) VALUES (?,?,?,?,?,?)";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, triagem.getCpf());
            preparedStatement.setString(2, triagem.getFebre());
            preparedStatement.setString(3, triagem.getTosse_seca());
            preparedStatement.setString(4, triagem.getCansaco());
            preparedStatement.setString(5, triagem.getFalta_ar());
            preparedStatement.setString(6, triagem.getPressao_peito());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE TRIAGEM: " + erro.getMessage());
        }
    }
}
