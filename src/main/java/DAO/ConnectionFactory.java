/**
 *
 * @author JPG
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    
    public Connection getConexao(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jpg?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception erro) {
            throw new RuntimeException("ERRO NA CONEXÃO COM O BANCO DE DADOS: " + erro);
        }
    }
    }
