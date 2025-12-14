package com.projetos.cancelamento.entities;

public class Produto {
    private Integer id;
    private String nome;
    private String description;
    private int qtdEstoque;

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String nome, String description, int qtdEstoque) {
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

