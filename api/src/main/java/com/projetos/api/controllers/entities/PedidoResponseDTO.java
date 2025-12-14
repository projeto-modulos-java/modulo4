package com.projetos.api.controllers.entities;

public record PedidoResponseDTO(
    int id,
    String description,
    ProdutoResponseDTO produto,
    int qtd
) {
    
}