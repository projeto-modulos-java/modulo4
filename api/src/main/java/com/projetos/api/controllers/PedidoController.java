package com.projetos.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.api.controllers.adapters.PedidoAdapter;
import com.projetos.api.controllers.entities.PedidoRequestDTO;
import com.projetos.api.controllers.entities.PedidoResponseDTO;
import com.projetos.api.services.PedidoService;

@RestController()
@RequestMapping(path = "/pedido")
public class PedidoController {

    private final PedidoService service;
    private final PedidoAdapter adapter;
    private final StreamBridge streamBridge;
    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    public PedidoController(PedidoService service, PedidoAdapter adapter, StreamBridge streamBridge){
        this.service = service;
        this.adapter = adapter;
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public List<PedidoResponseDTO> findAll(){
        logger.info("Listando todos os pedidos");
        return this.adapter.adaptPedidoResponse(service.findAll());
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO findById(@PathVariable int id){
        logger.info("Buscando pedido por id: {}", id);
        return this.adapter.adaptPedidoResponse(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PedidoRequestDTO requestDTO){
        this.streamBridge.send( "criar-pedido-topic", requestDTO);
        logger.info("Enviando pedido para o topico de criacao de pedidos");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> cancelar(@PathVariable int id){
        this.streamBridge.send("cancelar-pedido-topic", id);
        logger.info("Enviando pedido para o topico de exclusao de pedidos");
        return ResponseEntity.ok().build();
    }
}