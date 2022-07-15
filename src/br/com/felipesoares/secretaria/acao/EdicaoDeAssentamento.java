package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

public class EdicaoDeAssentamento implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		Assentamento  assentamento = new Assentamento();
		
		try {
			assentamento = new AssentamentoDao().pesquisar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("assentamento", assentamento);
		
		return "forward:formEdicaoAssentamento.jsp";
		
	}


}
