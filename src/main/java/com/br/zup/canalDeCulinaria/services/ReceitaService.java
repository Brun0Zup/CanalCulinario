package com.br.zup.canalDeCulinaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.zup.canalDeCulinaria.models.Receita;
import com.br.zup.canalDeCulinaria.repositories.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	ReceitaRepository receitaRepository;
	
	public void criarReceita(Receita receita) {
		receitaRepository.save(receita);
	}
	
	public Iterable<Receita> exibirReceitas(){
		return receitaRepository.findAll();
	}
	
	public Receita getReceitaForId(int id) {
		return receitaRepository.findById(id).get();
	}
	
	public void deletarReceitaPorId (int id) {
			receitaRepository.deleteById(id);
	}
	
	public void atualizarReceitaporId(int id, Receita receita) {
		Optional<Receita> optionalReceita = receitaRepository.findById(id);
		if (!optionalReceita.isPresent()) {
			String txt = "Não há receitas com esse id";
			
		}
		receita.setId(id);
		receitaRepository.save(receita);
		
		
		// Erro no método de ataulizar.
		
	}
	
	
	
}
