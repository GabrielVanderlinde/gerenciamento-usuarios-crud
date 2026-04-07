package com.senai.gerenciamento_usuarios.dto;

public class CategoriaDto {
    private long id_categoria;
    private String nome_categoria;

    //Constructors
    public CategoriaDto() {
    }

    public CategoriaDto(long id_categoria, String nome_categoria) {
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
    }

    //Get and Sett

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }
}
