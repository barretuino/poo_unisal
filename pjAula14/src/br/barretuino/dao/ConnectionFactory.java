package br.barretuino.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Prover uma ponte de conex�o com SGBD - Sistema Gerenciador de B. Dados
 * @author Paulo Barreto
 * @data 03/05/2024
 */
public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aula",
					"root",
					"admin"
					);
		}catch(ClassNotFoundException erro) {
			throw new SQLException("Houve um erro, n�o foi poss�vel a conex�o "
					+ erro);
		}
	}
}
