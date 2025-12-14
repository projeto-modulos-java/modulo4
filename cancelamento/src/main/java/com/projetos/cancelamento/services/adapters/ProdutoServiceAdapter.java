package com.projetos.cancelamento.services.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.cancelamento.entities.Produto;
import com.projetos.cancelamento.repositories.entities.ProdutoEntity;


@Service
public class ProdutoServiceAdapter {
    public Produto adapt(ProdutoEntity produto){
        return new Produto(produto.getId(), produto.getNome(), produto.getDescription(), produto.getQtdEstoque());
    }

    public ProdutoEntity adapt(Produto produto){
        return new ProdutoEntity(produto.getId(), produto.getNome(), produto.getDescription(), produto.getQtdEstoque());
    }

    public List<Produto> adaptProdutos(List<ProdutoEntity> produtos){
        return produtos.stream().map(produto -> this.adapt(produto)).toList();
    }
}