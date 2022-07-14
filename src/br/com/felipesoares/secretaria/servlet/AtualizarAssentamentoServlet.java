package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

@WebServlet("/atualizarAssentamento")
public class AtualizarAssentamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Integer id = (Integer.valueOf(request.getParameter("id")));
		System.out.println(id);
		Assentamento assentamento = new Assentamento();
		assentamento.setNome(request.getParameter("nome"));
		assentamento.setSobrenome(request.getParameter("sobrenome"));
		
			String nascimento = request.getParameter("nascimento");
			assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
			
		assentamento.setRe(request.getParameter("re"));
		assentamento.setCaixa(Integer.valueOf(request.getParameter("caixa")));
		assentamento.setId(id);
		
		try {
			new AssentamentoDao().atualizar(assentamento,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/secretaria/pesquisaPorId?id="+id);
	}

}
