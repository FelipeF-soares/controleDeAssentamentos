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

@WebServlet("/edicaoDeAssentamento")
public class EdicaoDeAssentamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		Assentamento  assentamento = new Assentamento();
		
		try {
			assentamento = new AssentamentoDao().pesquisar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("assentamento", assentamento);
		RequestDispatcher url = request.getRequestDispatcher("/formEdicaoAssentamento.jsp");
		url.forward(request, response);
		

	}

}
