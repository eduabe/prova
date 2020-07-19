package com.eduardoabe.prova;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardoabe.prova.model.Endereco;
import com.eduardoabe.prova.service.EnderecoService;

@SpringBootTest
public class EnderecoServiceTest {
	
	EnderecoService enderecoService = new EnderecoService();
	
	@Test
	public void invalidEndereco() {
		Endereco invalidEndereco = new Endereco(null, null, null);
		
		assertFalse(enderecoService.validaEndereco(invalidEndereco));
	}
	
	@Test
	public void validEndereco() {
		Endereco validEndereco = new Endereco("RS", "Porto Alegre", "Duque de caxias");
		assertTrue(enderecoService.validaEndereco(validEndereco));
	}

}
