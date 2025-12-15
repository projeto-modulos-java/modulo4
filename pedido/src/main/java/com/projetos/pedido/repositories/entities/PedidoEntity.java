package com.projetos.pedido.repositories.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int qtd;
    private String descrition;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
    
    public PedidoEntity() {
    }

    public PedidoEntity(Integer id, int qtd, String descrition, ProdutoEntity produto) {
        this.id = id;
        this.qtd = qtd;
        this.descrition = descrition;
        this.produto = produto;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public String getDescrition() {
        return descrition;
    }
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
    public ProdutoEntity getProduto() {
        return produto;
    }
    public void setProduto(ProdutoEntity pedido) {
        this.produto = pedido;
    }
    
}
