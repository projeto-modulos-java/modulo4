package com.projetos.pedido.controllers.entities;

public record PedidoRequestDTO(
    int qtd,
    String description,
    int produtoId
) {
    
}
