package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.RespostaUsuarioDto;
import com.senai.gerenciamento_usuarios.dto.UsuarioDto;
import com.senai.gerenciamento_usuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    // Injeção de Dependência
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // POST /api/usuario - Cadastrar usuário
    @PostMapping("/usuario")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDto usuarioDto) {
        String resposta = service.cadastrar(usuarioDto);

        if (resposta == null || resposta.startsWith("Erro")) { // startsWith() serve para verificar se uma String começa com um determinado texto.
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

    // GET /api/usuarios - Listar todos os usuários
    @GetMapping("/usuarios")
    public ResponseEntity<List<RespostaUsuarioDto>> listarUsuarios() {
        List<RespostaUsuarioDto> usuarios = service.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    // GET /api/usuario/{cpf} - Buscar usuário por CPF
    @GetMapping("/usuario/{cpf}")
    public ResponseEntity<?> buscarUsuarioPorCpf(@PathVariable String cpf) {
        RespostaUsuarioDto usuario = service.buscarUsuarioPorCpf(cpf);

        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuário com CPF '" + cpf + "' não encontrado.");
        }

        return ResponseEntity.ok().body(usuario);
    }

    // PUT /api/usuario/{cpf} - Atualizar usuário por CPF
    @PutMapping("/usuario/{cpf}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto usuarioDto) {
        String resposta = service.atualizarUsuario(cpf, usuarioDto);

        if (resposta.startsWith("Erro")) {
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

    // DELETE /api/usuario/{cpf} - Remover usuário por CPF
    @DeleteMapping("/usuario/{cpf}")
    public ResponseEntity<String> removerUsuario(@PathVariable String cpf) {
        String resposta = service.removerUsuario(cpf);

        if (resposta.startsWith("Erro")) {
            return ResponseEntity.status(404).body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }
}
