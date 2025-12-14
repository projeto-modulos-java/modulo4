package com.projetos.cancelamento.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.cancelamento.repositories.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends ListCrudRepository<ProdutoEntity, Integer> {

}
