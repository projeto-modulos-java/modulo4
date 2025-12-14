package com.projetos.pedido.repositories;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.pedido.repositories.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends ListCrudRepository<PedidoEntity, Integer> {
   
}
