package DAO;

import MODEL.Atividades;
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
public class AtividadesDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Atividades> lista = new ArrayList<>();

    public AtividadesDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarAtividades(Atividades atividade) {

        String sql = "INSERT INTO atividades (username, titulo, mensagem, data, status) VALUES (?,?,?,?,?)";
        
        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getUsernameMedico());
            preparedStatement.setString(2, atividade.getTitulo());
            preparedStatement.setString(3, atividade.getMensagem());
            preparedStatement.setDate(4, (Date) atividade.getData());
            preparedStatement.setString(5, atividade.getStatus());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DE ATIVIDADES: " + erro.getMessage());
        }
    }

    public void alterarAtividades(Atividades atividade) {

        String sql = "UPDATE atividades SET titulo = ?, mensagem = ?, data = ?, status = ? WHERE id = ?";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getTitulo());
            preparedStatement.setString(2, atividade.getMensagem());
            preparedStatement.setDate(3, (Date) atividade.getData());
            preparedStatement.setString(4, atividade.getStatus());
            preparedStatement.setInt(5, atividade.getIdAtividade());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA ALTERAÇÃO DE ATIVIDADES: " + erro.getMessage());
        }

    }

    public void removerAtividades(int id) {

        String sql = "DELETE FROM atividades WHERE id = " + id;

        try {

            statement = conexao.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA REMOÇÃO DE ATIVIDADES: " + erro.getMessage());
        }
    }

    public ArrayList<Atividades> listarAtividades(String usuario) {

        String sql = "SELECT * FROM atividades WHERE username = '" + usuario + "'";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Atividades atividade = new Atividades();
                atividade.setIdAtividade(resultSet.getInt("id"));
                atividade.setTitulo(resultSet.getString("titulo"));
                atividade.setMensagem(resultSet.getString("mensagem"));
                atividade.setData(resultSet.getDate("data"));
                atividade.setStatus(resultSet.getString("status"));
                lista.add(atividade);
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA LISTAGEM DAS ATIVIDADES: " + erro.getMessage());
        }
        return lista;
    }

    public ArrayList<Atividades> pesquisaAtividades(String mensagem) {

        String sql = "SELECT * FROM atividades WHERE mensagem LIKE '%" + mensagem + "%'";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Atividades atividade = new Atividades();
                atividade.setIdAtividade(resultSet.getInt("id"));
                atividade.setTitulo(resultSet.getString("titulo"));
                atividade.setMensagem(resultSet.getString("mensagem"));
                atividade.setData(resultSet.getDate("data"));
                atividade.setStatus(resultSet.getString("status"));
                lista.add(atividade);
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA PESQUISA DAS ATIVIDADES: " + erro.getMessage());
        }
        return lista;
    }

}
