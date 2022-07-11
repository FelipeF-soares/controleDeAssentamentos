package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;


@WebServlet("/novoAssentamento")
public class NovoAssentamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String nome = request.getParameter("nome");
		System.out.println("cadastrando "+ nome + " ");
		Assentamento assentamento = new Assentamento();
		assentamento.setNome(request.getParameter("nome"));
		assentamento.setSobrenome(request.getParameter("sobrenome"));
		
			String nascimento = request.getParameter("nascimento");
			assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
			
		assentamento.setRe(request.getParameter("re"));
		assentamento.setCaixa(Integer.valueOf(request.getParameter("caixa")));
		
			try {
				assentamento = new AssentamentoDao().inserir(assentamento);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		RequestDispatcher url = request.getRequestDispatcher("/assentamentoCadastrado.jsp");
		request.setAttribute("assentamento", assentamento);
		url.forward(request, response);	
	}

}
