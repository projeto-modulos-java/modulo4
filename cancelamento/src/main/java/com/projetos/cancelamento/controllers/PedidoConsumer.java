package com.projetos.cancelamento.controllers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetos.cancelamento.services.PedidoService;

@Component
public class PedidoConsumer {
    private final PedidoService service;
    private final Logger logger = LoggerFactory.getLogger(PedidoConsumer.class);

    public PedidoConsumer(PedidoService service) {
        this.service = service;
    }

    @Bean
    public Consumer<Integer> cancelamento(){
        return value -> {
            logger.info("cancelando pedido com id: " + value);
            service.cancelarPedido(value);
        };
    }
}
