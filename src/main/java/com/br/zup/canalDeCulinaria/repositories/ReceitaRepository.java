package com.br.zup.canalDeCulinaria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.canalDeCulinaria.models.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer>{

}
