package DAO;

import MODEL.Registros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JPG
 */
public class RegistrosDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private final ArrayList<Registros> lista = new ArrayList<>();

    public RegistrosDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarMedicos(Registros registro) {

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

    public ArrayList<Registros> exibePerfil(String usuario) {

        String sql = "SELECT username, nome, email, crm, especializacao FROM medicos WHERE username = '" + usuario + "'";

        try {

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Registros registro = new Registros();
                registro.setUsername(resultSet.getString("username"));
                registro.setNome(resultSet.getString("nome"));
                registro.setEmail(resultSet.getString("email"));
                registro.setCrm(resultSet.getString("crm"));
                registro.setEspecializacao(resultSet.getString("especializacao"));
                lista.add(registro);
            }

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA EXIBIÇÃO DE PERFIL: " + erro.getMessage());
        }
        return lista;
    }

    public void alteraPerfil(Registros registro) {

        String sql = "UPDATE medicos SET username = ?, nome = ?, email = ?, crm = ?, especializacao = ?, senha = ? WHERE id = ?";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, registro.getUsername());
            preparedStatement.setString(2, registro.getNome());
            preparedStatement.setString(3, registro.getEmail());
            preparedStatement.setString(4, registro.getCrm());
            preparedStatement.setString(5, registro.getEspecializacao());
            preparedStatement.setString(6, registro.getSenha());
            preparedStatement.setInt(7, registro.getIdUser());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("HOUVE UM ERRO NA ALTERAÇÃO DE PERFIL: " + erro.getMessage());
        }

    }
}
