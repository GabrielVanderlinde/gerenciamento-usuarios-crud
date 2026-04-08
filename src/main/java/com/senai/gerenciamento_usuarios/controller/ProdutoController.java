package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.dto.ProdutoDto;
import com.senai.gerenciamento_usuarios.service.CadastroProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    //Injeção de Dependencias
    private final CadastroProdutosService cadastroProdutosService;

    public ProdutoController(CadastroProdutosService cadastroProdutosService) {
        this.cadastroProdutosService = cadastroProdutosService;
    }

    @PostMapping("/produtos")
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoDto produtoDto) {

        boolean sucesso = cadastroProdutosService.cadastrarProduto(produtoDto);

        if (sucesso) {
            return ResponseEntity.ok("Produto cadastrado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Categoria não encontrada.");
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> lista = cadastroProdutosService.listarProdutos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<ProdutoDto>> listarCategoria(@PathVariable Long id) {
        List<ProdutoDto> lista = cadastroProdutosService.listarProdutosPorCategoria(id);
        return ResponseEntity.ok(lista);
    }
}
