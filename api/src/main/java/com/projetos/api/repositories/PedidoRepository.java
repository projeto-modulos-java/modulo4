package com.projetos.api.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.api.repositories.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends ListCrudRepository<PedidoEntity, Integer> {
    
}
