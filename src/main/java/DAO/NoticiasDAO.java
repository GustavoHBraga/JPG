package DAO;

import MODEL.Noticias;
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
public class NoticiasDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Noticias> lista = new ArrayList<>();

    public NoticiasDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarNoticias(Noticias noticia) {

        String sql = "INSERT INTO noticias (username, titulo, mensagem, data) VALUES (?,?,?,?)";
        
        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, noticia.getUsernameMedico());
            preparedStatement.setString(2, noticia.getTitulo());
            preparedStatement.setString(3, noticia.getMensagem());
            preparedStatement.setDate(4, (Date) noticia.getData());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE NOTÍCIAS: " + erro.getMessage());
        }
    }

    public void alterarNoticias(Noticias noticia) {

        String sql = "UPDATE noticias SET titulo = ?, mensagem = ?, data = ? WHERE id = ?";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, noticia.getTitulo());
            preparedStatement.setString(2, noticia.getMensagem());
            preparedStatement.setDate(3, (Date) noticia.getData());
            preparedStatement.setInt(5, noticia.getIdNoticias());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA ALTERAÇÃO DE NOTÍCIAS: " + erro.getMessage());
        }

    }

    public void removerNoticias(int id) {

        String sql = "DELETE FROM noticias WHERE id = " + id;

        try {

            statement = conexao.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA REMOÇÃO DE NOTÍCIAS: " + erro.getMessage());
        }
    }

    public ArrayList<Noticias> listarNoticias() {

        String sql = "SELECT * FROM noticias";

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

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA LISTAGEM DAS NOTÍCIAS: " + erro.getMessage());
        }
        return lista;
    }

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

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA PESQUISA DAS NOTÍCIAS: " + erro.getMessage());
        }
        return lista;
    }

}
