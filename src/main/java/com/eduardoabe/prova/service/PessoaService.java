package com.eduardoabe.prova.service;

import java.util.InputMismatchException;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.eduardoabe.prova.model.Endereco;
import com.eduardoabe.prova.model.Pessoa;
import com.eduardoabe.prova.repository.PessoaRepository;

import javassist.NotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	private EnderecoService enderecoService = new EnderecoService();
	
	public Pessoa newPessoa(Pessoa pessoa) throws InvalidAttributesException {
		if(!validaPessoa(pessoa)) {
			throw new InvalidAttributesException("Atributos inválidos");
		}
		return repository.insert(pessoa);
		
	}

	public Pessoa updatePessoa(Pessoa pessoa, String id) throws NotFoundException, InvalidAttributesException {
		
		if(!validaPessoa(pessoa)) {
			throw new InvalidAttributesException("Atributos inválidos");
		}
		
		Pessoa pessoaToUpdate = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

		pessoaToUpdate.setCpf(pessoa.getCpf());
		pessoaToUpdate.setNome(pessoa.getNome());
		pessoaToUpdate.setEndereco(pessoa.getEndereco());
		pessoaToUpdate.setPerfilAcesso(pessoa.getPerfilAcesso());

		return repository.save(pessoaToUpdate);
	}

	public void deletePessoa(String id) {
		repository.deleteById(id);
	}

	public Pessoa getPessoa(String id) throws NotFoundException {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa Não Encontrada"));
	}

	public List<Pessoa> searchPessoa(String estado, String perfilAcesso) {
		Pessoa pessoaFilter = new Pessoa();
		Endereco enderecoFilter = new Endereco();
		enderecoFilter.setEstado(estado);
		pessoaFilter.setEndereco(enderecoFilter);
		pessoaFilter.setPerfilAcesso(perfilAcesso);
		Example example = Example.of(pessoaFilter);

		return repository.findAll(example);
	}
	
	public boolean validaPessoa(Pessoa pessoa) {
		if(pessoa.getCpf() != null && pessoa.getNome()  != null && pessoa.getPerfilAcesso() != null) {
			return enderecoService.validaEndereco(pessoa.getEndereco());
		}
		return false;
	}
}
