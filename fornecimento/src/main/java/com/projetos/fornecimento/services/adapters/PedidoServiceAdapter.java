package com.projetos.fornecimento.services.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.fornecimento.entities.Pedido;
import com.projetos.fornecimento.repositories.entities.PedidoEntity;

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

    public List<Pedido> adaptEntities(List<PedidoEntity> pedidos){
        return pedidos.stream().map(this::adapt).toList();
    }   

    public List<PedidoEntity> adaptPedidos(List<Pedido> pedidos){
        return pedidos.stream().map(value -> 
            new PedidoEntity(value.getId(), 
                value.getQtd(), 
                value.getDescription(), 
                produtoAdapter.adapt(value.getProduto()))
        ).toList();
    }


}