package com.senai.gerenciamento_usuarios.entity;

public class CategoriaEntity {
    private long id_categoria;
    private String nome_categoria;

    //Constructors
    public CategoriaEntity() {
    }

    //Get and Set
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

    //To String
    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "id_categoria=" + id_categoria +
                ", nome_categoria='" + nome_categoria + '\'' +
                '}';
    }
}
