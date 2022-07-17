package br.com.felipesoares.secretaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNovoUsuario implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formNovoUsuario.jsp";
	}
}
