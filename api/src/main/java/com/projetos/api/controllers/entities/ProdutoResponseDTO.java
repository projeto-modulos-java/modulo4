package com.projetos.api.controllers.entities;

public record ProdutoResponseDTO(
    int id,
    String name,
    String description,
    int qtdEstoque
) {
    
}
