package com.projetos.api.controllers.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.api.controllers.entities.ProdutoResponseDTO;
import com.projetos.api.entities.Produto;

@Service
public class ProdutoAdapter {
    public ProdutoResponseDTO adapt(Produto produto){
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getDescription(), produto.getQtdEstoque());
    }

    public List<ProdutoResponseDTO> adapt(List<Produto> produtos){
        return produtos.stream().map(this::adapt).toList();
    }
}
