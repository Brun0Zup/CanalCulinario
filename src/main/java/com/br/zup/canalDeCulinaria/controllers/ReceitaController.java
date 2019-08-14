package com.br.zup.canalDeCulinaria.controllers;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.canalDeCulinaria.models.Receita;
import com.br.zup.canalDeCulinaria.services.ReceitaService;

@RestController
@RequestMapping("/receita/")
public class ReceitaController {

	@Autowired
	ReceitaService receitaService;

	@GetMapping("exibir")
	public ResponseEntity<?> exibirTodasReceitas() {
		return ResponseEntity.ok().body(receitaService.exibirReceitas());
	}

	@PostMapping("criar")
	public ResponseEntity<?> criarReceitas(@Valid @RequestBody Receita receita) {
		try {
			receitaService.criarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("deletar/{id}")
		public ResponseEntity<?> excluirReceitaPorId(@PathVariable int id) {
			try {
				receitaService.deletarReceitaPorId(id);
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
			}
	}

	
	@GetMapping("{id}")
	public ResponseEntity<?> exibirReceitaPorId(@PathVariable int id){
		try {
			Receita receita = receitaService.getReceitaForId(id);
			return ResponseEntity.ok(receita);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PutMapping("atualizar/{id}")
	public ResponseEntity<?> ataualizarReceitaPorId(@PathVariable int id, @Valid @RequestBody Receita receita){
		try{
			receitaService.atualizarReceitaporId(id, receita);
			return ResponseEntity.ok(receita);
		}catch(Exception e ) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		 
	}
}

