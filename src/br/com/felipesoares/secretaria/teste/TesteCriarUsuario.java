package br.com.felipesoares.secretaria.teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.felipesoares.secretaria.dao.UsuarioDao;
import br.com.felipesoares.secretaria.modelo.Usuario;

public class TesteCriarUsuario {

	public static void main(String[] args) throws SQLException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Usuario usuario = new Usuario();
		
		usuario.setNome("F");
		usuario.setSobrenome("F S");
		usuario.setNascimento(LocalDate.parse("1900-01-01", formatter));
		usuario.setRe("123456");
		usuario.setSenha("root");
		
		usuario = new UsuarioDao().criarUsuario(usuario);
		
		System.out.println(usuario);

	}

}
