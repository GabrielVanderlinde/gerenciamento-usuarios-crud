package com.senai.gerenciamento_usuarios.dto;

public class ProdutoDto {
    private long id_produto;
    private String nome_produto;
    private Double preco_produto;
    private long id_categoria;

    //Constructors
    public ProdutoDto() {
    }

    public ProdutoDto(long id_produto, String nome_produto, Double preco_produto, long id_categoria) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.id_categoria = id_categoria;
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
}
