package com.eduardoabe.prova.model;

import org.springframework.data.annotation.Id;

public class Pessoa {
	
	@Id
	private String id;
	private String cpf;
	private String nome;
	private Endereco endereco;
	private String perfilAcesso;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String cpf, String nome, Endereco endereco, String perfilAcesso) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.perfilAcesso = perfilAcesso;
	}
	
	public Pessoa(Pessoa pessoa) {
		this.cpf = pessoa.cpf;
		this.nome = pessoa.nome;
		this.endereco = pessoa.endereco;
		this.perfilAcesso = pessoa.perfilAcesso;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getPerfilAcesso() {
		return perfilAcesso;
	}
	public void setPerfilAcesso(String perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
