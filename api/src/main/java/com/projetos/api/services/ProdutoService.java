package com.projetos.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.api.entities.Produto;
import com.projetos.api.repositories.ProdutoRepository;
import com.projetos.api.services.adapters.ProdutoServiceAdapter;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoServiceAdapter adapter;

    public ProdutoService(ProdutoRepository repository, ProdutoServiceAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    public List<Produto> findAll(){
        return adapter.adaptProdutos(this.repository.findAll());
    }

    public Produto findById(int id){
        return adapter.adapt(this.repository.findById(id).orElseThrow());
    }

}
