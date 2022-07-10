package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

public class TesteDeAtualizar {

	public static void main(String[] args) throws SQLException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		new AssentamentoDao().listar().forEach(System.out::println);
		Assentamento assentamento = new Assentamento();
		
		assentamento.setNome("Charles");
		assentamento.setSobrenome("Xavier");
		
			LocalDate nascimento = LocalDate.parse("1934/05/23", formatter);
			assentamento.setNascimento(nascimento);
			
		assentamento.setRe("123456");
		assentamento.setCaixa(3);
		
		new AssentamentoDao().atualizar(assentamento, 4);
		
		new AssentamentoDao().listar().forEach(System.out::println);
	}

}
