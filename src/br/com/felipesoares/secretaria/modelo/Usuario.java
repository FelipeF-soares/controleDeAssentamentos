package br.com.felipesoares.secretaria.modelo;

import java.time.LocalDate;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate nascimento;
	private String re;
	private String senha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase().trim();
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome.toUpperCase().trim();
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getRe() {
		return re;
	}
	public void setRe(String re) {
		this.re = re.trim();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean validador(String re, String senha) {
		if(!this.re.equals(re)) {
			return false;
		}
		
		if(!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nascimento=" + nascimento
				+ ", re=" + re + ", senha=" + senha + "]";
	}
	
	
	
	
}
