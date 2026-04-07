package com.senai.gerenciamento_usuarios.dto;

public class TrocaSenhaDto {

    String senhaAtual;
    String senhaNova;
    String senhaNovaConfirmada;

    public TrocaSenhaDto(String senhaAtual, String senhaNova, String senhaNovaConfirmada) {
        this.senhaAtual = senhaAtual;
        this.senhaNova = senhaNova;
        this.senhaNovaConfirmada = senhaNovaConfirmada;
    }

    //Get and Set

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public String getSenhaNovaConfirmada() {
        return senhaNovaConfirmada;
    }

    public void setSenhaNovaConfirmada(String senhaNovaConfirmada) {
        this.senhaNovaConfirmada = senhaNovaConfirmada;
    }
}
