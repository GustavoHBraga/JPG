package DAO;

import MODEL.Triagens;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JPG
 */
//Realização de métodos.
public class TriagensDAO {

    //Atribuições necessárias.
    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Triagens> lista = new ArrayList<>();

    //Método Construtor para realizar a conexão ao Banco de Dados.
    public TriagensDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    /**
     * Método para registrar os dados no Banco de Dados.
     * @param triagem - Objetos definidos.
     */
    public void registrarTriagem(Triagens triagem) {

        //Definindo Script SQL a ser executada.
        String sql = "INSERT INTO triagens (cpf, nome, data_nascimento, email, cep, estado, contato1, contato2, sexo, febre, tosse_seca, cansaco, falta_ar, pressao_peito) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            //Preparando Script SQL a ser executada e setando os dados a serem armazenados no Banco de Dados.
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
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE TRIAGEM: " + erro.getMessage());
        }
    }

    /**
     * Método para remover dados no Banco de Dados.
     * @param id - Parametro inteiro para auxiliar na remoção de dados.
     */
    public void atenderTriagem(int id) {

        //Definindo Script SQL a ser executada.
        String sql = "DELETE FROM triagens WHERE id = " + id;

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            statement.execute(sql);
            //Fechando a conexão.
            statement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO AO ATENDER TRIAGEM: " + erro.getMessage());
        }
    }

    /**
     * Método para para exibir os dados do Banco de Dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Triagens> listarTriagens() {

        //Definindo Script SQL a ser executada.
        String sql = "SELECT * FROM triagens";

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //Setando e armazenando dados no ArrayList para serem exibidos.
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

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA LISTAGEM DAS TRIAGENS: " + erro.getMessage());
        }
        return lista;
    }

    /**
     * Método para para pesquisar dados no Banco de Dados.
     * @param cpf - Parametro String para auxiliar na exibição de dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Triagens> pesquisaTriagem(String cpf) {

        //Definindo Script SQL a ser executada.
        String sql = "SELECT * FROM triagens WHERE cpf LIKE '%" + cpf + "%'";

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //Setando e armazenando dados no ArrayList para serem exibidos.
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

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA PESQUISA DAS TRIAGENS: " + erro.getMessage());
        }
        return lista;
    }
}
