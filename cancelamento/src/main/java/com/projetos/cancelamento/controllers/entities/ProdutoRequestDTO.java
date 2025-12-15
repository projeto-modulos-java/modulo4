package com.projetos.cancelamento.controllers.entities;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}