package com.projetos.pedido.services.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.pedido.entities.Pedido;
import com.projetos.pedido.repositories.entities.PedidoEntity;

@Service
public class PedidoServiceAdapter {
    private final ProdutoServiceAdapter produtoAdapter;

    public PedidoServiceAdapter(ProdutoServiceAdapter produtoAdapter){
        this.produtoAdapter = produtoAdapter;
    }

    public Pedido adapt(PedidoEntity pedido){
        return new Pedido(pedido.getId(), pedido.getDescrition(), pedido.getQtd(), produtoAdapter.adapt(pedido.getProduto()));
    }

    public PedidoEntity adapt(Pedido pedido){
        return new PedidoEntity(pedido.getId(), pedido.getQtd(), pedido.getDescription(), produtoAdapter.adapt(pedido.getProduto()));
    }

    public List<Pedido> adaptEntities(List<PedidoEntity> produtos){
        return produtos.stream().map(this::adapt).toList();
    }   

}