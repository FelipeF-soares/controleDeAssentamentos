package br.com.felipesoares.secretaria.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.felipesoares.secretaria.dao.UsuarioDao;
import br.com.felipesoares.secretaria.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String re = request.getParameter("re");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando "+ re);
		Usuario usuario = new Usuario();
		try {
			usuario = new UsuarioDao().localizaUsuario(re);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			if(usuario.validador(re, senha)) {
				System.out.println("Acesso Auatoriazado para "+usuario.getNome()+ "RE: "+usuario.getRe());
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuario", usuario);
				return "redirect:entrada?acao=FormNovoAssentamento";
			}else{
				System.out.println("Acesso Negado!");
				return "forward:login.jsp";	
			}
	}

}
