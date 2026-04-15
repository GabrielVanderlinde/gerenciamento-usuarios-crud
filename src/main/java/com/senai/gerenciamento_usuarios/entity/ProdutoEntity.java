package com.senai.gerenciamento_usuarios.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_produto;
    @Column(name = "nome")
    private String nome_produto;
    @Column(name = "preco")
    private Double preco_produto;
    @Column(name = "id_categoria")
    private long id_categoria;

    //Constructors
    public ProdutoEntity() {
    }

    //Get and Set
    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(Double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    //To String
    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "id_produto=" + id_produto +
                ", nome_produto='" + nome_produto + '\'' +
                ", preco_produto=" + preco_produto +
                ", id_categoria=" + id_categoria +
                '}';
    }
}
