package com.projetos.pedido.controllers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetos.pedido.controllers.DTO.PedidoRequestDTO;
import com.projetos.pedido.controllers.adapter.PedidoDTOAdapter;
import com.projetos.pedido.entities.Pedido;
import com.projetos.pedido.services.PedidoService;

@Component
public class PedidoConsumer {
    final private PedidoService service;
    final private PedidoDTOAdapter adapter;
    final private Logger logger = LoggerFactory.getLogger(PedidoConsumer.class);

    public PedidoConsumer(PedidoService service, PedidoDTOAdapter adapter) {
        this.service = service;
        this.adapter = adapter;
    }

    @Bean
    public Consumer<PedidoRequestDTO> create(){
        return value -> {
            Pedido pedido = this.adapter.adapt(value);
            try {
                service.createPedido(pedido, pedido.getProduto().getId());
                logger.info("Pedido criado com sucesso");
            } catch (Exception e) {
                logger.info("Pedido nao pode ser realizado: " + e.getMessage());
            }
        };
    }
}
