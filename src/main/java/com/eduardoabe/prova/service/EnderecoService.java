package com.eduardoabe.prova.service;

import org.springframework.stereotype.Service;

import com.eduardoabe.prova.model.Endereco;

@Service
public class EnderecoService {

	public boolean validaEndereco(Endereco endereco) {
		if(endereco.getCidade() != null && endereco.getEstado() != null && endereco.getRua() != null) {
			return true;
		}
		return false;
	}
	
}
