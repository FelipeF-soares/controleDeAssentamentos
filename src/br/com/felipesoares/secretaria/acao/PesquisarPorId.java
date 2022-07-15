package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

public class PesquisarPorId implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("pesquisando por Id");
		
		Assentamento assentamento = new Assentamento();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		
		try {
			assentamento = new AssentamentoDao().pesquisar(id);
		} catch (NumberFormatException | SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("assentamento", assentamento);
		
		return "forward:assentamentoEdicao.jsp";
		
	}

}
