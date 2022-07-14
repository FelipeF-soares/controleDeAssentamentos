package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

@WebServlet("/pesquisaAvancada")
public class PesquisaAvancadaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Assentamento> assentamentos = new ArrayList<Assentamento>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String nome = request.getParameter("nome");
		String nascimentoString = request.getParameter("nascimento");
			
			LocalDate nascimento = LocalDate.parse(nascimentoString, formatter);
				
		try {
			assentamentos = new AssentamentoDao().pesquisar(nome, nascimento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("assentamentos", assentamentos);
		RequestDispatcher url = request.getRequestDispatcher("listarTodosAssentamentos.jsp");
		url.forward(request, response);
		
	}

}
