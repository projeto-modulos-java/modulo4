package com.projetos.fornecimento.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.fornecimento.repositories.entities.ProdutoEntity;


@Repository
public interface ProdutoRepository extends ListCrudRepository<ProdutoEntity, Integer> {
    
}