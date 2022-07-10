package br.com.felipesoares.secretaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.felipesoares.secretaria.jdbc.ConexaoBd;
import br.com.felipesoares.secretaria.modelo.Assentamento;

public class AssentamentoDao {
	
	private Connection conexao;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public AssentamentoDao() throws SQLException {
		
		conexao = new ConexaoBd().mySql(); 
		
	}
	
	public Assentamento inserir (Assentamento assentamento) {
		String sql = "INSERT INTO assentamentos(nome, sobrenome, nascimento, re, caixa) "
				+ "VALUES (?,?,?,?,?)";
		try(PreparedStatement inserir = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			inserir.setString(1, assentamento.getNome());
			inserir.setString(2, assentamento.getSobrenome());
				
				String nascimento = formatter.format(assentamento.getNascimento());
				inserir.setString(3, nascimento);
				
			inserir.setString(4, assentamento.getRe());
			inserir.setInt(5, assentamento.getCaixa());
			
			inserir.execute();
			
			try(ResultSet id = inserir.getGeneratedKeys()){
				while(id.next()) {
					assentamento.setId(id.getInt(1));
				}
			}
				
			return assentamento;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Assentamento> listar(){
		
		String sql = "SELECT * FROM assentamentos";
		List<Assentamento> assentamentos = new ArrayList<Assentamento>();
		
		try(PreparedStatement listar = conexao.prepareStatement(sql)){
			listar.execute();
			try(ResultSet retorna = listar.getResultSet()){
				while(retorna.next()) {
					Assentamento assentamento = new Assentamento();
					assentamento.setId(retorna.getInt(1));
					assentamento.setNome(retorna.getString(2));
					assentamento.setSobrenome(retorna.getString(3));
					
						String nascimento = retorna.getString(4);
						assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
						
					assentamento.setRe(retorna.getString(5));
					assentamento.setCaixa(retorna.getInt(6));
					
					assentamentos.add(assentamento);
				}
				
				return assentamentos;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Assentamento pesquisar(Integer id) {
		Assentamento assentamento = new Assentamento();
		String sql = "SELECT * FROM assentamentos WHERE id = ?";
		try(PreparedStatement pesquisar = conexao.prepareStatement(sql)){
			pesquisar.setInt(1, id);
			pesquisar.execute();
			try(ResultSet exibir = pesquisar.getResultSet()){
				
				while(exibir.next()) {
				assentamento.setId(exibir.getInt(1));
				assentamento.setNome(exibir.getString(2));
				assentamento.setSobrenome(exibir.getString(3));
				
					String nascimento = exibir.getString(4);
					assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
					
				assentamento.setRe(exibir.getString(5));
				assentamento.setCaixa(exibir.getInt(6));
				}
			}
			
			return assentamento;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Assentamento> pesquisar(String re){
		List<Assentamento> assentamentos = new ArrayList<Assentamento>();
		String sql = "SELECT * FROM assentamentos WHERE re = ?";
		
		try(PreparedStatement pesquisar = conexao.prepareStatement(sql)){
			pesquisar.setString(1, re);
			pesquisar.execute();
			try(ResultSet exibir = pesquisar.getResultSet()){
				while(exibir.next()) {
					Assentamento assentamento = new Assentamento();
					assentamento.setId(exibir.getInt(1));
					assentamento.setNome(exibir.getString(2));
					assentamento.setSobrenome(exibir.getString(3));
					
						String nascimento = exibir.getString(4);
						assentamento.setNascimento(LocalDate.parse(nascimento, formatter));
						
					assentamento.setRe(exibir.getString(5));
					assentamento.setCaixa(exibir.getInt(6));
					
					assentamentos.add(assentamento);
				}
				
				return assentamentos;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Assentamento> pesquisar(String nome, LocalDate nascimento){
		List<Assentamento> assentamentos = new ArrayList<Assentamento>();
		String sql = "SELECT * FROM assentamentos WHERE nome = ? AND nascimento = ?";
		try(PreparedStatement pesquisar = conexao.prepareStatement(sql)){
			pesquisar.setString(1, nome);
				
				String dataNascimento = nascimento.format(formatter);
				pesquisar.setString(2, dataNascimento);
				
			pesquisar.execute();
			try(ResultSet retorna = pesquisar.getResultSet()){
				while(retorna.next()) {
					Assentamento assentamento = new Assentamento();
					assentamento.setId(retorna.getInt(1));
					assentamento.setNome(retorna.getString(2));
					assentamento.setSobrenome(retorna.getString(3));
					
						String retonoNascimento = retorna.getString(4);
						assentamento.setNascimento(LocalDate.parse(retonoNascimento, formatter));
						
					assentamento.setRe(retorna.getString(5));
					assentamento.setCaixa(retorna.getInt(6));
					
					assentamentos.add(assentamento);
				}
				return assentamentos;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Integer id) {
		String sql ="DELETE FROM assentamentos WHERE id = ?";
		try(PreparedStatement excluir = conexao.prepareStatement(sql)){
			excluir.setInt(1, id);
			excluir.execute();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Assentamento atualizar(Assentamento assentamento, Integer id) {
		String sql = "UPDATE assentamentos SET nome = ?, sobrenome = ?, nascimento = ?, re = ?, caixa = ? WHERE id = ? ";
		try(PreparedStatement atualizar = conexao.prepareStatement(sql)){
			atualizar.setString(1, assentamento.getNome());
			atualizar.setString(2, assentamento.getSobrenome());
			
				String nascimento = formatter.format(assentamento.getNascimento());
				atualizar.setString(3, nascimento);
			
			atualizar.setString(4, assentamento.getRe());
			atualizar.setInt(5, assentamento.getCaixa());
			
			atualizar.setInt(6, id);
			atualizar.execute();
			
			return assentamento;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}



