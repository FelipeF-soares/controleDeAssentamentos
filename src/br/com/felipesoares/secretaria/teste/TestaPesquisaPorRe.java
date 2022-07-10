package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;

public class TestaPesquisaPorRe {

	public static void main(String[] args) throws SQLException {
		new AssentamentoDao().pesquisar("150030").forEach(System.out::println);
	}

}
