package com.projetos.pedido.services;

import org.springframework.stereotype.Service;

import com.projetos.pedido.entities.Pedido;
import com.projetos.pedido.entities.Produto;
import com.projetos.pedido.repositories.PedidoRepository;
import com.projetos.pedido.repositories.ProdutoRepository;
import com.projetos.pedido.services.adapters.PedidoServiceAdapter;
import com.projetos.pedido.services.adapters.ProdutoServiceAdapter;

@Service
public class PedidoService {

    final private PedidoRepository repository;
    final private PedidoServiceAdapter adapter;
    final private ProdutoRepository produtoRepository;
    final private ProdutoServiceAdapter produtoAdapter;


    public PedidoService(PedidoRepository repository, PedidoServiceAdapter adapter, ProdutoRepository produtoRepository,
            ProdutoServiceAdapter produtoAdapter) {
        this.repository = repository;
        this.adapter = adapter;
        this.produtoRepository = produtoRepository;
        this.produtoAdapter = produtoAdapter;
    }

    public void createPedido(Pedido pedido, int produtoId) throws Exception{
        Produto produto = this.produtoAdapter.adapt(this.produtoRepository.findById(produtoId).orElseThrow());

        if(produto.getQtdEstoque() - pedido.getQtd() < 0){
            throw new Exception("Não existem produtos suficientes");
        }

        produto.setQtdEstoque(produto.getQtdEstoque() - pedido.getQtd());
        pedido.setProduto(produto);
        System.out.println("id produto"+ pedido.getId());
        repository.save(adapter.adapt(pedido));
        produtoRepository.save(produtoAdapter.adapt(produto));
    }
}
