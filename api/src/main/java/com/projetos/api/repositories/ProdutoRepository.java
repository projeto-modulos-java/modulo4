package com.projetos.api.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.api.repositories.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends ListCrudRepository<ProdutoEntity, Integer> {
    
}
