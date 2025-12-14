package com.projetos.pedido.controllers.DTO;

public record PedidoRequestDTO(
    int qtd,
    String description,
    int produtoId
) {
    
}
