package com.projetos.api.controllers.entities;

public record PedidoRequestDTO(
    int qtd,
    String description,
    int produtoId
) {
    
}