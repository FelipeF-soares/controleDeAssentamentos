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

}
