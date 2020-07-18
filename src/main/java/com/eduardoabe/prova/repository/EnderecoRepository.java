package com.eduardoabe.prova.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduardoabe.prova.model.Endereco;

public interface EnderecoRepository extends MongoRepository<Endereco, String>{

}
