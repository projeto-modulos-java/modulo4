package com.projetos.fornecimento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.fornecimento.entities.Pedido;
import com.projetos.fornecimento.entities.Produto;
import com.projetos.fornecimento.repositories.PedidoRepository;
import com.projetos.fornecimento.repositories.ProdutoRepository;
import com.projetos.fornecimento.services.adapters.PedidoServiceAdapter;
import com.projetos.fornecimento.services.adapters.ProdutoServiceAdapter;

@Service
public class ProdutoService {
    final private ProdutoRepository repository;
    final private ProdutoServiceAdapter adapter;
    final private PedidoRepository pedidoRepository;
    final private PedidoServiceAdapter pedidoAdapter;

    public ProdutoService(ProdutoRepository repository, ProdutoServiceAdapter adapter,
            PedidoRepository pedidoRepository, PedidoServiceAdapter pedidoAdapter) {
        this.repository = repository;
        this.adapter = adapter;
        this.pedidoRepository = pedidoRepository;
        this.pedidoAdapter = pedidoAdapter;
    }

    public void create(Produto produto){
        this.repository.save(this.adapter.adapt(produto));
    }

    public void excluirProduto(int id){
        List<Pedido> pedidos = pedidoAdapter.adaptEntities(this.pedidoRepository.findByProdutoId(id));
        this.pedidoRepository.deleteAll(this.pedidoAdapter.adaptPedidos(pedidos));
        this.repository.deleteById(id);
    }
}
