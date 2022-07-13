package br.com.felipesoares.secretaria.modelo;

import java.time.LocalDate;

public class Assentamento {

	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate nascimento;
	private String re;
	private Integer caixa;
	
	
	
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
		this.nome = nome.toUpperCase();
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome.toUpperCase();
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
		this.re = re;
	}

	public Integer getCaixa() {
		return caixa;
	}

	public void setCaixa(Integer caixa) {
		this.caixa = caixa;
	}
	


	@Override
	public String toString() {
		return "Assentamento [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nascimento=" + nascimento
				+ ", re=" + re + ", caixa=" + caixa + "]";
	}
	
	

}
