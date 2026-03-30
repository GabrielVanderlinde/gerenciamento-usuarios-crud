package com.senai.gerenciamento_usuarios.dto;

public class RespostaUsuarioDto {

    private String cpf;
    private String nomeCompleto;
    private String login;

    //Constructors
    public RespostaUsuarioDto() {
    }

    public RespostaUsuarioDto(String cpf, String nomeCompleto, String login) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.login = login;
    }

    //Get and Set
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

    //To String
    @Override
    public String toString() {
        return "RespostaUsuarioDto{" +
                "cpf='" + cpf + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
