package com.projetos.fornecimento.controllers.DTO;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}