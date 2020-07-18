package com.eduardoabe.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoabe.prova.model.Pessoa;
import com.eduardoabe.prova.service.PessoaService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable String id){
		try {
			Pessoa pessoa = service.getPessoa(id);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/pessoa")
	public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
		return service.newPessoa(pessoa);
	}
	
	@PutMapping("/pessoa/{id}")
	public ResponseEntity updatePessoa(@RequestBody Pessoa pessoa, @PathVariable String id) {
		try {
			Pessoa updatedPessoa = service.updatePessoa(pessoa,id);
			return new ResponseEntity(updatedPessoa, HttpStatus.OK);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity deletePessoa(@PathVariable String id) {
		try {
			service.deletePessoa(id);
			return new ResponseEntity(HttpStatus.OK);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
  
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> searchPessoa(@RequestParam(required = false, name = "estado")  String estado,
			@RequestParam(required = false, name = "perfilAcesso") String perfilAcesso){
		List<Pessoa> result = service.searchPessoa(estado, perfilAcesso);
		return new ResponseEntity<List<Pessoa>>(result, HttpStatus.OK);
		
	}
	
}
