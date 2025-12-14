package com.projetos.fornecimento.controllers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetos.fornecimento.controllers.DTO.ProdutoRequestDTO;
import com.projetos.fornecimento.controllers.adapters.ProdutoDTOAdapter;
import com.projetos.fornecimento.services.ProdutoService;

@Component
public class ProdutoConsumer {
    final private ProdutoDTOAdapter adapter;
    final private ProdutoService service;
    final private Logger logger = LoggerFactory.getLogger(ProdutoConsumer.class);

    public ProdutoConsumer(ProdutoDTOAdapter adapter, ProdutoService service) {
        this.adapter = adapter;
        this.service = service;
    }

    @Bean
    public Consumer<ProdutoRequestDTO> create(){
        return value -> {
            service.create(adapter.adapt(value));
            logger.info("Produto criado com sucesso: " + value.name());
        };
    }

    @Bean
    public Consumer<Integer> cancelamento(){
        return value -> {
             logger.info("Produto excluido com sucesso, id: " + value);
            service.excluirProduto(value);
        };
    }
}
