package com.projetos.cancelamento.controllers.adapter;

import org.springframework.stereotype.Service;

import com.projetos.cancelamento.controllers.DTO.PedidoRequestDTO;
import com.projetos.cancelamento.entities.Pedido;
import com.projetos.cancelamento.entities.Produto;

@Service
public class PedidoDTOAdapter {
    public Pedido adapt(PedidoRequestDTO pedido){
        Produto produto = new Produto(pedido.produtoId());
        return new Pedido(null, pedido.description(), pedido.qtd(), produto);
    }
}
