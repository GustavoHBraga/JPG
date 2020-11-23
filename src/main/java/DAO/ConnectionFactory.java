package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JPG
 */

//Realizando a conexão entre o sistema e o Banco de Dados.
public class ConnectionFactory {
    
    public Connection getConexao(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://senac-tads-mysql-8.mysql.database.azure.com:3306/jpg?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC", "tads@senac-tads-mysql-8", "abc123@@");
        } catch (ClassNotFoundException | SQLException erro) {
            /**
             * @exception - Tratando exceções.
             */
            throw new RuntimeException("ERRO NA CONEXÃO COM O BANCO DE DADOS: " + erro.getMessage());
        }
    }
    }
