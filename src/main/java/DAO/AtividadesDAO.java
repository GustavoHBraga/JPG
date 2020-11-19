package DAO;

import MODEL.Atividades;
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
public class AtividadesDAO {
    
    //Atribuições necessárias.
    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Atividades> lista = new ArrayList<>();
    
    //Método Construtor para realizar a conexão ao Banco de Dados.
    public AtividadesDAO() {

        conexao = new ConnectionFactory().getConexao();
    }
    
    /**
     * Método para registrar os dados no Banco de Dados.
     * @param atividade - Objetos definidos. 
     */
    public void registrarAtividades(Atividades atividade) {
        
        //Definindo Script SQL a ser executada.
        String sql = "INSERT INTO atividades (username, titulo, mensagem, data, status) VALUES (?,?,?,?,?)";
        
        try {
            //Preparando Script SQL a ser executada e setando os dados a serem armazenados no Banco de Dados.
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getUsernameMedico());
            preparedStatement.setString(2, atividade.getTitulo());
            preparedStatement.setString(3, atividade.getMensagem());
            preparedStatement.setDate(4, (Date) atividade.getData());
            preparedStatement.setString(5, atividade.getStatus());
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE ATIVIDADES: " + erro.getMessage());
        }
    }

    /**
     * Método para alterar os dados no Banco de Dados.
     * @param atividade - Objetos definidos.
     */
    public void alterarAtividades(Atividades atividade) {

        //Definindo Script SQL a ser executada.
        String sql = "UPDATE atividades SET titulo = ?, mensagem = ?, data = ?, status = ? WHERE id = ?";

        try {
            //Preparando Script SQL a ser executada e setando os dados a serem alterados no Banco de Dados.
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getTitulo());
            preparedStatement.setString(2, atividade.getMensagem());
            preparedStatement.setDate(3, (Date) atividade.getData());
            preparedStatement.setString(4, atividade.getStatus());
            preparedStatement.setInt(5, atividade.getIdAtividade());
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA ALTERAÇÃO DE ATIVIDADES: " + erro.getMessage());
        }

    }
    
    /**
     * Método para remover dados no Banco de Dados.
     * @param id - Parametro inteiro para auxiliar na remoção de dados.
     */
    public void removerAtividades(int id) {
        
        //Definindo Script SQL a ser executada.
        String sql = "DELETE FROM atividades WHERE id = " + id;

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
            throw new RuntimeException("ERRO NA REMOÇÃO DE ATIVIDADES: " + erro.getMessage());
        }
    }
    
    /**
     * Método para para exibir os dados do Banco de Dados.
     * @param usuario - Parametro String para auxiliar na exibição de dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Atividades> listarAtividades(String usuario) {
        
        //Definindo Script SQL a ser executada.
        String sql = "SELECT * FROM atividades WHERE username = '" + usuario + "'";

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //Setando e armazenando dados no ArrayList para serem exibidos.
                Atividades atividade = new Atividades();
                atividade.setIdAtividade(resultSet.getInt("id"));
                atividade.setTitulo(resultSet.getString("titulo"));
                atividade.setMensagem(resultSet.getString("mensagem"));
                atividade.setData(resultSet.getDate("data"));
                atividade.setStatus(resultSet.getString("status"));
                lista.add(atividade);
            }

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA LISTAGEM DAS ATIVIDADES: " + erro.getMessage());
        }
        return lista;
    }
    
    /**
     * Método para para pesquisar dados no Banco de Dados.
     * @param mensagem - Parametro String para auxiliar na exibição de dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Atividades> pesquisaAtividades(String mensagem) {
        
        //Definindo Script SQL a ser executada.
        String sql = "SELECT * FROM atividades WHERE mensagem LIKE '%" + mensagem + "%'";

        try {
            //Preparando Script SQL a ser executada no Banco de Dados.
            statement = conexao.createStatement();
            //Abrindo a conexão para executar o Script SQL definido.
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //Setando e armazenando dados no ArrayList para serem exibidos.
                Atividades atividade = new Atividades();
                atividade.setIdAtividade(resultSet.getInt("id"));
                atividade.setTitulo(resultSet.getString("titulo"));
                atividade.setMensagem(resultSet.getString("mensagem"));
                atividade.setData(resultSet.getDate("data"));
                atividade.setStatus(resultSet.getString("status"));
                lista.add(atividade);
            }

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA PESQUISA DAS ATIVIDADES: " + erro.getMessage());
        }
        return lista;
    }

}
