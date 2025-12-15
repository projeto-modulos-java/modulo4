package com.projetos.api.controllers.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.api.controllers.entities.PedidoResponseDTO;
import com.projetos.api.entities.Pedido;

@Service
public class PedidoAdapter {

    private final ProdutoAdapter adapter;

    public PedidoAdapter(ProdutoAdapter adapter){
        this.adapter = adapter;
    }

    public PedidoResponseDTO adaptPedidoResponse(Pedido pedido){
        return new PedidoResponseDTO(pedido.getId(), pedido.getDescription(), adapter.adapt(pedido.getProduto()), pedido.getQtd());
    }

    public List<PedidoResponseDTO> adaptPedidoResponse(List<Pedido> pedidos){
        return pedidos.stream().map(this::adaptPedidoResponse).toList();
    }
}
