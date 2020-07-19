package com.eduardoabe.prova;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardoabe.prova.model.Endereco;
import com.eduardoabe.prova.model.Pessoa;
import com.eduardoabe.prova.service.PessoaService;

@SpringBootTest
public class PessoaServiceTest {
	
	PessoaService pessoaService = new PessoaService();
	
	@Test
	public void insertInvalidPessoa() {
		Pessoa invalidPessoa = new Pessoa(null, null, null, null);
		assertFalse(pessoaService.validaPessoa(invalidPessoa));
	}
	
	@Test
	public void insertValidPessoa() {
		Pessoa validPessoa = new Pessoa("02010450019", "João Silva", new Endereco("RS", "Porto Alegre", "Lima e Silva"), "admin");
		assertTrue(pessoaService.validaPessoa(validPessoa));
	}

}
