package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.dao.AssentamentoDao;
import br.com.felipesoares.secretaria.modelo.Assentamento;

@WebServlet("/pesquisaPorId")
public class PesquisaPorIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Assentamento assentamento = new Assentamento();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		
		try {
			assentamento = new AssentamentoDao().pesquisar(id);
		} catch (NumberFormatException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		RequestDispatcher url = request.getRequestDispatcher("/assentamentoEdicao.jsp");
		request.setAttribute("assentamento", assentamento);
		url.forward(request, response);
	}

}
