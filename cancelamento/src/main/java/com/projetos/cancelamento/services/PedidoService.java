package com.projetos.cancelamento.services;

import org.springframework.stereotype.Service;

import com.projetos.cancelamento.entities.Pedido;
import com.projetos.cancelamento.entities.Produto;
import com.projetos.cancelamento.repositories.PedidoRepository;
import com.projetos.cancelamento.repositories.ProdutoRepository;
import com.projetos.cancelamento.services.adapters.PedidoServiceAdapter;
import com.projetos.cancelamento.services.adapters.ProdutoServiceAdapter;



@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoServiceAdapter adapter;
    private final ProdutoRepository produtoRepository;
    private final ProdutoServiceAdapter  produtoAdapter;


    public PedidoService(PedidoRepository repository, PedidoServiceAdapter adapter, ProdutoRepository produtoRepository,
            ProdutoServiceAdapter produtoAdapter) {
        this.repository = repository;
        this.adapter = adapter;
        this.produtoRepository = produtoRepository;
        this.produtoAdapter = produtoAdapter;
    }

    public void cancelarPedido(int id){
        Pedido pedido = this.adapter.adapt(this.repository.findById(id).orElseThrow());
        Produto produto = pedido.getProduto();
        produto.setQtdEstoque(produto.getQtdEstoque() + pedido.getQtd());
        this.repository.deleteById(pedido.getId());
        this.produtoRepository.save(this.produtoAdapter.adapt(produto));
    }
}
