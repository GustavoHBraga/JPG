package DAO;

import MODEL.Triagens;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JPG
 */
public class TriagensDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Triagens> lista = new ArrayList<>();

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
    
    public ArrayList<Triagens> listarTriagens() {

        String sql = "SELECT * FROM triagens";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Triagens triagem = new Triagens();
                triagem.setIdTriagem(resultSet.getInt("id"));
                triagem.setCpf(resultSet.getString("cpf"));
                triagem.setNome(resultSet.getString("nome"));
                triagem.setData_nascimento(resultSet.getDate("data_nascimento"));
                triagem.setEmail(resultSet.getString("email"));
                triagem.setCep(resultSet.getString("cep"));
                triagem.setEstado(resultSet.getString("estado"));
                triagem.setContato1(resultSet.getString("contato1"));
                triagem.setContato2(resultSet.getString("contato2"));
                triagem.setSexo(resultSet.getString("sexo"));
                triagem.setFebre(resultSet.getString("febre"));
                triagem.setTosse_seca(resultSet.getString("tosse_seca"));
                triagem.setCansaco(resultSet.getString("cansaco"));
                triagem.setFalta_ar(resultSet.getString("falta_ar"));
                triagem.setPressao_peito(resultSet.getString("pressao_peito"));
                lista.add(triagem);
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA LISTAGEM DAS TRIAGENS: " + erro.getMessage());
        }
        return lista;
    }

    public ArrayList<Triagens> pesquisaTriagem(String cpf) {

        String sql = "SELECT * FROM triagens WHERE cpf LIKE '%" + cpf + "%'";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Triagens triagem = new Triagens();
                triagem.setIdTriagem(resultSet.getInt("id"));
                triagem.setCpf(resultSet.getString("cpf"));
                triagem.setNome(resultSet.getString("nome"));
                triagem.setData_nascimento(resultSet.getDate("data_nascimento"));
                triagem.setEmail(resultSet.getString("email"));
                triagem.setCep(resultSet.getString("cep"));
                triagem.setEstado(resultSet.getString("estado"));
                triagem.setContato1(resultSet.getString("contato1"));
                triagem.setContato2(resultSet.getString("contato2"));
                triagem.setSexo(resultSet.getString("sexo"));
                triagem.setFebre(resultSet.getString("febre"));
                triagem.setTosse_seca(resultSet.getString("tosse_seca"));
                triagem.setCansaco(resultSet.getString("cansaco"));
                triagem.setFalta_ar(resultSet.getString("falta_ar"));
                triagem.setPressao_peito(resultSet.getString("pressao_peito"));
                lista.add(triagem);
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA PESQUISA DAS TRIAGENS: " + erro.getMessage());
        }
        return lista;
    }
}
