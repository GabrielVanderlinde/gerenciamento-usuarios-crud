package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.service.CadastroProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CategoriaController {

    //Injeção de Dependencias
    private final CadastroProdutosService cadastroProdutosService;

    public CategoriaController(CadastroProdutosService cadastroProdutosService) {
        this.cadastroProdutosService = cadastroProdutosService;
    }

    @PostMapping("/categorias")
    public ResponseEntity<String> cadastrar(@RequestBody CategoriaDto categoriaDto) {
        return null;
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> listarCategorias() {
        return null;
    }
}
