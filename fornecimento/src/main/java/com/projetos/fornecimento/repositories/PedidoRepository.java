package com.projetos.fornecimento.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.fornecimento.repositories.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends ListCrudRepository<PedidoEntity, Integer> {
     public List<PedidoEntity> findByProdutoId(int id);
     public void deleteByProdutoId(int id);
}
