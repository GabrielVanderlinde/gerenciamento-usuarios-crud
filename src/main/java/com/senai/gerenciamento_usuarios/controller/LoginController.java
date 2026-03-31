package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.LoginDto;
import com.senai.gerenciamento_usuarios.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    //Injeção de Dependencias
    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {

        if (loginDto.getLogin() == null || loginDto.getLogin().isBlank() ||
                loginDto.getSenha() == null || loginDto.getSenha().isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email e senha são obrigatórios.");

        }

        boolean loginValido = service.validarCredenciais(loginDto);

        if (!loginValido) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Erro ao realizar login: credenciais inválidas.");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Login realizado com sucesso.");
    }
}
