package com.projetos.pedido.services;

import org.springframework.stereotype.Service;

import com.projetos.pedido.entities.Pedido;
import com.projetos.pedido.entities.Produto;
import com.projetos.pedido.repositories.PedidoRepository;
import com.projetos.pedido.repositories.ProdutoRepository;
import com.projetos.pedido.services.adapters.PedidoServiceAdapter;
import com.projetos.pedido.services.adapters.ProdutoServiceAdapter;
import com.projetos.pedido.services.exceptions.PedidoException;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoServiceAdapter adapter;
    private final ProdutoRepository produtoRepository;
    private final ProdutoServiceAdapter produtoAdapter;

    public PedidoService(PedidoRepository repository, PedidoServiceAdapter adapter, ProdutoRepository produtoRepository,
            ProdutoServiceAdapter produtoAdapter) {
        this.repository = repository;
        this.adapter = adapter;
        this.produtoRepository = produtoRepository;
        this.produtoAdapter = produtoAdapter;
    }

    public void createPedido(Pedido pedido, int produtoId) throws PedidoException{
        Produto produto = this.produtoAdapter.adapt(this.produtoRepository.findById(produtoId).orElseThrow());

        if(produto.getQtdEstoque() - pedido.getQtd() < 0){
            throw new PedidoException("Não existem produtos suficientes");
        }

        produto.setQtdEstoque(produto.getQtdEstoque() - pedido.getQtd());
        pedido.setProduto(produto);
        repository.save(adapter.adapt(pedido));
        produtoRepository.save(produtoAdapter.adapt(produto));
    }
}
