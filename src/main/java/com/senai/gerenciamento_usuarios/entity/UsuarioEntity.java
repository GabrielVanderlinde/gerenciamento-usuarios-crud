package com.senai.gerenciamento_usuarios.entity;

import jakarta.persistence.Entity;

@Entity
public class UsuarioEntity {

    private String cpf;
    private String nomeCompleto;
    private String login;
    private String senha;


    public UsuarioEntity() {
    }

    // Get and Set

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // To String
    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "cpf='" + cpf + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
