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

import com.projetos.api.controllers.adapters.ProdutoAdapter;
import com.projetos.api.controllers.entities.ProdutoRequestDTO;
import com.projetos.api.controllers.entities.ProdutoResponseDTO;
import com.projetos.api.services.ProdutoService;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    final private ProdutoService service;
    final private ProdutoAdapter adapter;
    final private StreamBridge streamBridge;
    final private Logger logger = LoggerFactory.getLogger(PedidoController.class);
    

    public ProdutoController(ProdutoService service, ProdutoAdapter adapter, StreamBridge streamBridge) {
        this.service = service;
        this.adapter = adapter;
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public List<ProdutoResponseDTO> findAll(){
        logger.info("Listando todos os produtos");
        return adapter.adapt(service.findAll());
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO findById(@PathVariable int id){
        logger.info("Buscando produto por id: " + id);
        return adapter.adapt(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProdutoRequestDTO pedido){
        logger.info("Enviando produto para o tópico de criacao de produtos");
        streamBridge.send("criar-produto-topic", pedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        logger.info("Enviando produto para o tópico de exclusao de produtos");
        streamBridge.send("excluir-produto-topic", id);
        return ResponseEntity.ok().build();
    }
}
