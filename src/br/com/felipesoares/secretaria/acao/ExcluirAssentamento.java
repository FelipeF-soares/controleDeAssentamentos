package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;

public class ExcluirAssentamento implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("removendo");
		
		try {
			new AssentamentoDao().excluir(Integer.valueOf(request.getParameter("id")));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		return "forward:formAssentamento.jsp";
		
	}

}
