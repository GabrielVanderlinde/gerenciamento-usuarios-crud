package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.ProdutoDto;
import com.senai.gerenciamento_usuarios.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    //Injeção de Dependencias
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produtos")
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoDto produtoDto) {

        boolean sucesso = produtoService.cadastrarProduto(produtoDto);

        if (sucesso) {
            return ResponseEntity.ok("Produto cadastrado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Categoria não encontrada.");
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> lista = produtoService.listarProdutos();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        String resposta = produtoService.removerProduto(id);

        if (resposta.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

}
