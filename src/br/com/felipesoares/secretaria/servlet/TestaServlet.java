package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testaServlet")
public class TestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Testando Conex?o");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
			out.println("<body>");
				out.println("Testando Conex?o");
			out.println("</body>");
		out.println("</html>");
	}

}
