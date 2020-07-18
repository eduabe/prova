package com.eduardoabe.prova.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eduardoabe.prova.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String>{
	
	@Query(value = "{'endereco.estado': '?0', 'perfilAcesso': '?1'}")
	public List<Pessoa> findAllByEstadoAndPerfil(String estado, String perfilAcesso);

}
