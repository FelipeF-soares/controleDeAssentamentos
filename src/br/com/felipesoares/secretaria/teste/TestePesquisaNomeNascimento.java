package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;

public class TestePesquisaNomeNascimento {

	public static void main(String[] args) throws SQLException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		LocalDate nascimento = LocalDate.parse("1987/06/18", formatter);
		
		new AssentamentoDao().pesquisar("felipe", nascimento).forEach(System.out::println);

	}

}
