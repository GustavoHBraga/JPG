package DAO;

import MODEL.Registros;
import java.sql.Connection;
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
public class RegistrosDAO {

    //Atribuições necessárias.
    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Registros> lista = new ArrayList<>();

    //Método Construtor para realizar a conexão ao Banco de Dados.
    public RegistrosDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    /**
     * Método para registrar os dados no Banco de Dados.
     * @param registro - Objetos definidos.
     */
    public void registrarMedicos(Registros registro) {

        //Definindo Script SQL a ser executada.
        String sql = "INSERT INTO medicos (username, nome, email, crm, especializacao, senha) VALUES (?,?,?,?,?,?)";

        try {
            //Preparando Script SQL a ser executada e setando os dados a serem armazenados no Banco de Dados.
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, registro.getUsername());
            preparedStatement.setString(2, registro.getNome());
            preparedStatement.setString(3, registro.getEmail());
            preparedStatement.setString(4, registro.getCrm());
            preparedStatement.setString(5, registro.getEspecializacao());
            preparedStatement.setString(6, registro.getSenha());
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE USUÁRIOS: " + erro.getMessage());
        }
    }

    /**
     * Método para para exibir os dados do Banco de Dados.
     * @param usuario - Parametro String para auxiliar na exibição de dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Registros> exibePerfil(String usuario) {

        //Definindo Script SQL a ser executada.
        String sql = "SELECT username, nome, email, crm, especializacao FROM medicos WHERE username = '" + usuario + "'";

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //Setando e armazenando dados no ArrayList para serem exibidos.
                Registros registro = new Registros();
                registro.setUsername(resultSet.getString("username"));
                registro.setNome(resultSet.getString("nome"));
                registro.setEmail(resultSet.getString("email"));
                registro.setCrm(resultSet.getString("crm"));
                registro.setEspecializacao(resultSet.getString("especializacao"));
                lista.add(registro);
            }

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA EXIBIÇÃO DE PERFIL: " + erro.getMessage());
        }
        return lista;
    }

    /**
     * Método para alterar os dados no Banco de Dados.
     * @param registro - Objetos definidos.
     */
    public void alteraPerfil(Registros registro) {

        //Definindo Script SQL a ser executada.
        String sql = "UPDATE medicos SET username = ?, nome = ?, email = ?, crm = ?, especializacao = ?, senha = ? WHERE id = ?";

        try {
            //Preparando Script SQL a ser executada e setando os dados a serem alterados no Banco de Dados.
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, registro.getUsername());
            preparedStatement.setString(2, registro.getNome());
            preparedStatement.setString(3, registro.getEmail());
            preparedStatement.setString(4, registro.getCrm());
            preparedStatement.setString(5, registro.getEspecializacao());
            preparedStatement.setString(6, registro.getSenha());
            preparedStatement.setInt(7, registro.getIdUser());
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("HOUVE UM ERRO NA ALTERAÇÃO DE PERFIL: " + erro.getMessage());
        }

    }
}
