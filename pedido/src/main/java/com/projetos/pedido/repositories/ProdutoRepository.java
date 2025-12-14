package com.projetos.pedido.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.pedido.repositories.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends ListCrudRepository<ProdutoEntity, Integer> {

}
