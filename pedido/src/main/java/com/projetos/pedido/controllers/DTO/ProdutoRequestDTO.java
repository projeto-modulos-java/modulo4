package com.projetos.pedido.controllers.DTO;

public record ProdutoRequestDTO(
    String name,
    String description,
    int qtdEstoque
) {

}