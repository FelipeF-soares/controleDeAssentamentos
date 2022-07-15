package br.com.felipesoares.secretaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesoares.secretaria.acao.Acao;
import br.com.felipesoares.secretaria.acao.AtualizarAssentamento;
import br.com.felipesoares.secretaria.acao.ConfirmaCadastroDeAssentamento;
import br.com.felipesoares.secretaria.acao.EdicaoDeAssentamento;
import br.com.felipesoares.secretaria.acao.ExcluirAssentamento;
import br.com.felipesoares.secretaria.acao.FormNovoAssentamento;
import br.com.felipesoares.secretaria.acao.ListarAssentamento;
import br.com.felipesoares.secretaria.acao.NovoAssentamento;
import br.com.felipesoares.secretaria.acao.PesquisaAvancada;
import br.com.felipesoares.secretaria.acao.PesquisarPorId;
import br.com.felipesoares.secretaria.acao.PesquisarPorRe;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.felipesoares.secretaria.acao."+ paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		

		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
		RequestDispatcher url = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
		url.forward(request, response);
		}else {
		response.sendRedirect(tipoEEndereco[1]);
		}
		
		
		
		/*
		 * String nome = null;
		 * 
		 * 
		 * if(paramAcao.equals("formNovoAssentamento")) { FormNovoAssentamento acao =
		 * new FormNovoAssentamento(); nome = acao.executa(request, response);
		 * 
		 * }else if(paramAcao.equals("NovoAssentamento")) {
		 * 
		 * NovoAssentamento acao = new NovoAssentamento(); nome = acao.executa(request,
		 * response);
		 * 
		 * }else if(paramAcao.equals("ConfirmaCadastroDeAssentamento")) {
		 * 
		 * ConfirmaCadastroDeAssentamento acao = new ConfirmaCadastroDeAssentamento();
		 * nome = acao.executa(request, response);
		 * 
		 * }else if(paramAcao.equals("ListarAssentamento")) {
		 * 
		 * ListarAssentamento acao = new ListarAssentamento(); nome =
		 * acao.executa(request, response);
		 * 
		 * }else if(paramAcao.equals("ExcluirAssentamento")) {
		 * 
		 * ExcluirAssentamento acao = new ExcluirAssentamento(); nome =
		 * acao.executar(request, response);
		 * 
		 * }else if(paramAcao.equals("PesquisarPorRe")) {
		 * 
		 * PesquisarPorRe acao = new PesquisarPorRe(); nome = acao.executa(request,
		 * response);
		 * 
		 * }else if(paramAcao.equals("PesquisarPorId")) {
		 * 
		 * PesquisarPorId acao = new PesquisarPorId(); nome = acao.executa(request,
		 * response);
		 * 
		 * }else if(paramAcao.equals("PesquisaAvancada")) {
		 * 
		 * PesquisaAvancada acao = new PesquisaAvancada(); nome = acao.executa(request,
		 * response);
		 * 
		 * }else if(paramAcao.equals("EdicaoDeAssentamento")) {
		 * 
		 * EdicaoDeAssentamento acao = new EdicaoDeAssentamento(); nome =
		 * acao.executa(response, request);
		 * 
		 * }else if(paramAcao.equals("AtualizarAssentamento")) {
		 * 
		 * AtualizarAssentamento acao = new AtualizarAssentamento(); nome =
		 * acao.executa(request, response);
		 * 
		 * }
		 */
		 
		
	}

}
