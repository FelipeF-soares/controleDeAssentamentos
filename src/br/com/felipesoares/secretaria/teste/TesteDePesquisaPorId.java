package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;

public class TesteDePesquisaPorId {

	public static void main(String[] args) throws SQLException {
		
		System.out.println(new AssentamentoDao().pesquisar(2));
	}

}
