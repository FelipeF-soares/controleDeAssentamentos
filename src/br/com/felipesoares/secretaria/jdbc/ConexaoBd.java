package br.com.felipesoares.secretaria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {
	
	public Connection mySql() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaria?useTimezone=true&serverTimezone=UTC","root","root");
		
	}

}
