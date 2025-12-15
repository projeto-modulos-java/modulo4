package com.projetos.fornecimento.controllers.entities;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}