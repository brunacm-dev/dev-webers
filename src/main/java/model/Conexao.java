package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/sistemaBancario?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "miguel2021";
	private Connection conexao = null;
	
	public Conexao() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return this.conexao;
	}
	
	public void closeConexao() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
