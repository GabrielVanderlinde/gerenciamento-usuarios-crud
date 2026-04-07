package com.senai.gerenciamento_usuarios.service;

import com.senai.gerenciamento_usuarios.dto.LoginDto;
import com.senai.gerenciamento_usuarios.dto.RespostaUsuarioDto;
import com.senai.gerenciamento_usuarios.dto.TrocaSenhaDto;
import com.senai.gerenciamento_usuarios.dto.UsuarioDto;
import com.senai.gerenciamento_usuarios.entity.UsuarioEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    //ArrayList
    private ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();

    public String cadastrar(UsuarioDto usuarioDto) {

        UsuarioEntity usuario = new UsuarioEntity();

        // Conversão de Dados Dto para Entity
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setNomeCompleto(usuarioDto.getNomeCompleto());
        usuario.setSenha(usuarioDto.getSenha());

        usuarios.add(usuario);

        return "Usuario Cadastrado com sucesso!";
    }

    // Listar todos os usuários
    public List<RespostaUsuarioDto> listarUsuarios() {

        List<RespostaUsuarioDto> resposta = new ArrayList<>();

        for (UsuarioEntity u : usuarios) {
            RespostaUsuarioDto dto = new RespostaUsuarioDto(
                    u.getCpf(),
                    u.getNomeCompleto(),
                    u.getLogin()
            );
            resposta.add(dto);
        }

        return resposta;
    }

    // Buscar usuário por CPF
    public RespostaUsuarioDto buscarUsuarioPorCpf(String cpf) {

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                return new RespostaUsuarioDto(u.getCpf(), u.getNomeCompleto(), u.getLogin());
            }
        }

        return null; // Não encontrado
    }

    // Atualizar usuário por CPF
    public String atualizarUsuario(String cpf, UsuarioDto usuarioDto) {

        // Verifica se o novo login já está em uso por outro usuário
        for (UsuarioEntity u : usuarios) {
            if (u.getLogin().equalsIgnoreCase(usuarioDto.getLogin()) && !u.getCpf().equals(cpf)) {
                return "Erro: já existe um usuário com o login '" + usuarioDto.getLogin() + "'";
            }
        }

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                u.setNomeCompleto(usuarioDto.getNomeCompleto());
                u.setLogin(usuarioDto.getLogin());
                // u.setSenha(usuarioDto.getSenha());
                return "Usuário atualizado com sucesso!";
            }
        }

        return "Erro: usuário com CPF '" + cpf + "' não encontrado.";
    }

    // Remover usuário por CPF
    public String removerUsuario(String cpf) {

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                usuarios.remove(u);
                return "Usuário removido com sucesso!";
            }
        }

        return "Erro: usuário com CPF '" + cpf + "' não encontrado.";
    }

    //Validação de Login
    public boolean validarCredenciais(LoginDto loginDto) {

        for (UsuarioEntity usuarioLogin : usuarios) {
            if (usuarioLogin.getLogin().equals(loginDto.getLogin()) && usuarioLogin.getSenha().equals(loginDto.getSenha())) {
                return true;
            }
        }

        return false;
    }

    //Troca de Senha
    public String trocarSenha(String login, TrocaSenhaDto dto) {
        for (UsuarioEntity u : usuarios) {
            if (u.getLogin().equals(login)) {

                if (!u.getSenha().equals(dto.getSenhaAtual())) {
                    return "Erro ao realizar a troca de senha: senha atual incorreta.";
                }

                if (dto.getSenhaNova() == null || dto.getSenhaNova().length() < 8) {
                    return "Erro ao realizar a troca de senha: a nova senha deve ter pelo menos 8 caracteres.";
                }

                if (!dto.getSenhaNova().equals(dto.getSenhaNovaConfirmada())) {
                    return "Erro: a nova senha e a confirmação não conferem.";
                }

                u.setSenha(dto.getSenhaNova());
                return "Senha alterada com sucesso.";
            }
        }
        return "Erro: Usuário não encontrado.";
    }

}
