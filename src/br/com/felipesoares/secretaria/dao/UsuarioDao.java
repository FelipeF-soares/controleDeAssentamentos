package br.com.felipesoares.secretaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.felipesoares.secretaria.jdbc.ConexaoBd;
import br.com.felipesoares.secretaria.modelo.Usuario;

public class UsuarioDao {
	
	Connection conexao;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public UsuarioDao() throws SQLException {
		conexao  = new ConexaoBd().mySql();
	}
	
	public Usuario criarUsuario(Usuario usuario){
		String sql = "INSERT INTO usuario(nome, sobrenome, nascimento, re, senha) VALUES (?,?,?,?,?)";
		try(PreparedStatement criarUsuario = conexao.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
			criarUsuario.setString(1,usuario.getNome());
			criarUsuario.setString(2, usuario.getSobrenome());
				
				String nascimento = formatter.format(usuario.getNascimento());
				criarUsuario.setString(3, nascimento);
				
			criarUsuario.setString(4, usuario.getRe());
			criarUsuario.setString(5, usuario.getSenha());
			criarUsuario.execute();
			
			try(ResultSet id = criarUsuario.getGeneratedKeys()){
				while(id.next()) {
					usuario.setId(id.getInt(1));
				}
			}
			
			return usuario;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public Usuario localizaUsuario(String re) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE re = ?";
		try(PreparedStatement localiza = conexao.prepareStatement(sql)){
			localiza.setString(1, re);
			localiza.execute();
			try(ResultSet retorna = localiza.getResultSet()){
				while(retorna.next()) {
					usuario.setId(retorna.getInt(1));
					usuario.setNome(retorna.getString(2));
					usuario.setSobrenome(retorna.getString(3));
						
						usuario.setNascimento(LocalDate.parse(retorna.getString(4), formatter));
						
					usuario.setRe(retorna.getString(5));
					usuario.setSenha(retorna.getString(6));
				}
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
