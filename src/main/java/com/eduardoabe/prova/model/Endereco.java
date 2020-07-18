package com.eduardoabe.prova.model;


public class Endereco {
	
	private String estado;
	private String cidade;
	private String rua;
	
	public Endereco(String estado, String cidade, String rua) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
	}
	
	public Endereco() {
		super();
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
}
