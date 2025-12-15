package com.projetos.pedido.controllers.entities;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}