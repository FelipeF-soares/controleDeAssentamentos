package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/listarAssentamento")
public class ListarAssentamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Assentamento> assentamentos = new ArrayList<Assentamento>();
		try {
			 assentamentos = new AssentamentoDao().listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher url = request.getRequestDispatcher("/listarTodosAssentamentos.jsp");
		request.setAttribute("assentamentos", assentamentos);
		url.forward(request, response);
	}

}
