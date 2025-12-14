package com.projetos.fornecimento.controllers.adapters;

import org.springframework.stereotype.Service;

import com.projetos.fornecimento.controllers.DTO.ProdutoRequestDTO;
import com.projetos.fornecimento.entities.Produto;

@Service
public class ProdutoDTOAdapter {
    public Produto adapt(ProdutoRequestDTO produto){
        return new Produto(null, produto.name(), produto.description(), produto.qtdEstoque());
    }
}
