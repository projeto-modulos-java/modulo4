package com.projetos.cancelamento.controllers.DTO;

public record PedidoRequestDTO(
    int qtd,
    String description,
    int produtoId
) {
    
}
