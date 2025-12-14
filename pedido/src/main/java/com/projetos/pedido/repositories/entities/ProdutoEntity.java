package com.projetos.pedido.repositories.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String description;
    private int qtdEstoque;
    
    public ProdutoEntity() {
    }

    public ProdutoEntity(Integer id, String nome, String description, int qtdEstoque) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.qtdEstoque = qtdEstoque;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

}
