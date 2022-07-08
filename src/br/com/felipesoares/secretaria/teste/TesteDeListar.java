package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;

public class TesteDeListar {

	public static void main(String[] args) throws SQLException {
		
		new AssentamentoDao().listar().forEach(System.out::println);

	}

}
