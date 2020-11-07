package DAO;

import MODEL.Pacientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author JPG
 */
public class PacientesDAO {

    private final Connection conexao;
    private PreparedStatement preparedStatement;

    public PacientesDAO() {

        conexao = new ConnectionFactory().getConexao();
    }

    public void registrarFormulario(Pacientes paciente) {

        String sql = "INSERT INTO pacientes (cpf, nome, data_nascimento, email, estado, cep, contato1, contato2, sexo) VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, paciente.getCpf());
            preparedStatement.setString(2, paciente.getNome());
            preparedStatement.setDate(3, (Date) paciente.getData());
            preparedStatement.setString(4, paciente.getEmail());
            preparedStatement.setString(5, paciente.getEstado());
            preparedStatement.setString(6, paciente.getCep());
            preparedStatement.setString(7, paciente.getContato1());
            preparedStatement.setString(8, paciente.getContato2());
            preparedStatement.setString(9, paciente.getSexo());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            throw new RuntimeException("ERRO NO REGISTRAMENTO DO FORMULÁRIO: " + erro.getMessage());
        }
    }
}
