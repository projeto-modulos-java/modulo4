package com.projetos.cancelamento.controllers.entities;

public record PedidoRequestDTO(
    int qtd,
    String description,
    int produtoId
) {
    
}
