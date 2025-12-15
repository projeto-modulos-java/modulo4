package com.projetos.cancelamento.controllers.DTO;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}