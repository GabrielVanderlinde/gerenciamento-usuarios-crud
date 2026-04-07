package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.dto.ProdutoDto;
import com.senai.gerenciamento_usuarios.service.CadastroProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProdutoController {

    //Injeção de Dependencias
    private final CadastroProdutosService cadastroProdutosService;

    public ProdutoController(CadastroProdutosService cadastroProdutosService) {
        this.cadastroProdutosService = cadastroProdutosService;
    }

    @PostMapping("/produtos")
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoDto produtoDto) {
        return null;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> listar() {
        return null;
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<CategoriaDto>> listarCategoria(@PathVariable Long id) {
        return null;
    }
}
