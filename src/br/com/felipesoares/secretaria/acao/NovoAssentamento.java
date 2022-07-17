package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.felipesoares.secretaria.modelo.Assentamento;

public class NovoAssentamento implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		
		
		System.out.println(request.getParameter("nome"));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Assentamento assentamento = new Assentamento();
		assentamento.setNome(request.getParameter("nome"));
		assentamento.setSobrenome(request.getParameter("sobrenome"));
		
			String nascimento = request.getParameter("nascimento");
			assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
			
		assentamento.setRe(request.getParameter("re"));
		assentamento.setCaixa(Integer.valueOf(request.getParameter("caixa")));
		
		request.setAttribute("assentamento", assentamento); 
		
		return "forward:confirmacaoDeCadastro.jsp";
		 
	}

}
