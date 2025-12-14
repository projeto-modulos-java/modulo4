package com.projetos.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.projetos.api.entities.Pedido;
import com.projetos.api.repositories.PedidoRepository;
import com.projetos.api.services.adapters.PedidoServiceAdapter;

@Service
public class PedidoService {

    final private PedidoRepository repository;
    final private PedidoServiceAdapter adapter;

    public PedidoService(PedidoRepository repository, PedidoServiceAdapter adapter){
        this.repository = repository;
        this.adapter = adapter;
    }

    public List<Pedido> findAll(){
        return adapter.adaptEntities(repository.findAll());
    } 

    public Pedido findById( int id){
        return adapter.adapt(repository.findById(id).orElseThrow());
    }
}
