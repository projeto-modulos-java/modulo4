package com.projetos.cancelamento.repositories;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.cancelamento.repositories.entities.PedidoEntity;


@Repository
public interface PedidoRepository extends ListCrudRepository<PedidoEntity, Integer> {
   
}
