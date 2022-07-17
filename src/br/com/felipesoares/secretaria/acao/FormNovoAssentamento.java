package br.com.felipesoares.secretaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormNovoAssentamento implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formAssentamento.jsp";
	}
}
