package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.modelo.Usuario;

public class NovoUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setSobrenome(request.getParameter("sobrenome"));
		
			String nascimento =
		
		
		
		return null;
	}

}
