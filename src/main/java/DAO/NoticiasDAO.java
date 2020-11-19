package DAO;

import MODEL.Noticias;
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
public class NoticiasDAO {

    //Atribuições necessárias.
    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Noticias> lista = new ArrayList<>();

    //Método Construtor para realizar a conexão ao Banco de Dados.
    public NoticiasDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    /**
     * Método para registrar os dados no Banco de Dados.
     * @param noticia - Objetos definidos.
     */
    public void registrarNoticias(Noticias noticia) {

        //Definindo Script SQL a ser executada.
        String sql = "INSERT INTO noticias (username, titulo, mensagem, data) VALUES (?,?,?,?)";

        try {
            //Preparando Script SQL a ser executada e setando os dados a serem armazenados no Banco de Dados.
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, noticia.getUsernameMedico());
            preparedStatement.setString(2, noticia.getTitulo());
            preparedStatement.setString(3, noticia.getMensagem());
            preparedStatement.setDate(4, (Date) noticia.getData());
            //Abrindo a conexão para executar o Script SQL definido.
            preparedStatement.execute();
            //Fechando a conexão.
            preparedStatement.close();

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE NOTÍCIAS: " + erro.getMessage());
        }
    }

    /**
     * Método para para exibir os dados do Banco de Dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Noticias> listarNoticias() {

        String sql = "SELECT * FROM noticias";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Noticias noticia = new Noticias();
                noticia.setIdNoticias(resultSet.getInt("id"));
                noticia.setUsernameMedico(resultSet.getString("username"));
                noticia.setTitulo(resultSet.getString("titulo"));
                noticia.setMensagem(resultSet.getString("mensagem"));
                noticia.setData(resultSet.getDate("data"));
                lista.add(noticia);
            }

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA LISTAGEM DAS NOTÍCIAS: " + erro.getMessage());
        }
        return lista;
    }

    /**
     * Método para para pesquisar dados no Banco de Dados.
     * @param mensagem - Parametro String para auxiliar na exibição de dados.
     * @return - Retornando o ArrayList com os Objetos.
     */
    public ArrayList<Noticias> pesquisaNoticias(String mensagem) {

        String sql = "SELECT * FROM noticias WHERE mensagem LIKE '%" + mensagem + "%'";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Noticias noticia = new Noticias();
                noticia.setIdNoticias(resultSet.getInt("id"));
                noticia.setTitulo(resultSet.getString("titulo"));
                noticia.setMensagem(resultSet.getString("mensagem"));
                noticia.setData(resultSet.getDate("data"));
                lista.add(noticia);
            }

        } catch (SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA PESQUISA DAS NOTÍCIAS: " + erro.getMessage());
        }
        return lista;
    }

}
