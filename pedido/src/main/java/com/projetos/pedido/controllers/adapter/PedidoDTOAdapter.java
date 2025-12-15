package com.projetos.pedido.controllers.adapter;

import org.springframework.stereotype.Service;

import com.projetos.pedido.controllers.entities.PedidoRequestDTO;
import com.projetos.pedido.entities.Pedido;
import com.projetos.pedido.entities.Produto;

@Service
public class PedidoDTOAdapter {
    public Pedido adapt(PedidoRequestDTO pedido){
        Produto produto = new Produto(pedido.produtoId());
        return new Pedido(null, pedido.description(), pedido.qtd(), produto);
    }
}
