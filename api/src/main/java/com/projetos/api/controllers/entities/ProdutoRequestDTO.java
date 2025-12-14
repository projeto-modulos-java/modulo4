package com.projetos.api.controllers.entities;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}