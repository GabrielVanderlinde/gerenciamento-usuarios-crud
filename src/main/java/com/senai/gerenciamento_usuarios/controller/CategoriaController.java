package com.senai.gerenciamento_usuarios.controller;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.service.CadastroProdutosService;
import com.senai.gerenciamento_usuarios.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    //Injeção de Dependencias
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/categorias")
    public ResponseEntity<String> cadastrar(@RequestBody CategoriaDto categoriaDto) {
        boolean retorno = categoriaService.cadastrarCategoria(categoriaDto);

        if (retorno) {
            return ResponseEntity.ok().body("Categoria Cadastrada com Sucessso");
        } else {
            return ResponseEntity.badRequest().body("Já existe esta Cadastrada!");
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> listarCategorias() {
        List<CategoriaDto> lista = categoriaService.listarCategorias();
        return ResponseEntity.ok(lista);
    }
}
