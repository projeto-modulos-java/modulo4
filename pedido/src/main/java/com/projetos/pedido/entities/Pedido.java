package com.projetos.pedido.entities;

public class Pedido {
    private Integer id;
    private String description;
    private int qtd;
    private Produto produto;
    
    public Pedido(Integer id, String description, int qtd, Produto produto) {
        this.id = id;
        this.description = description;
        this.qtd = qtd;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}