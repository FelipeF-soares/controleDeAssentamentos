package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

public class ConfirmaCadastroDeAssentamento implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Assentamento assentamento = new Assentamento();
		assentamento.setNome(request.getParameter("nome"));
		assentamento.setSobrenome(request.getParameter("sobrenome"));
		
			String nascimento = request.getParameter("nascimento");
			assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
			
		assentamento.setRe(request.getParameter("re").trim());
		assentamento.setCaixa(Integer.valueOf(request.getParameter("caixa")));
		
		try {
			assentamento = new AssentamentoDao().inserir(assentamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:entrada?acao=PesquisarPorId&id="+assentamento.getId();
	}

}
