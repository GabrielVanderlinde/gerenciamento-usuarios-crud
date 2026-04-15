package com.senai.gerenciamento_usuarios.service;

import com.senai.gerenciamento_usuarios.dto.ProdutoDto;
import com.senai.gerenciamento_usuarios.entity.CategoriaEntity;
import com.senai.gerenciamento_usuarios.entity.ProdutoEntity;
import com.senai.gerenciamento_usuarios.repositories.CategoriaRepository;
import com.senai.gerenciamento_usuarios.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public boolean cadastrarProduto(ProdutoDto produtoDto) {

        boolean existenciaCategoria = categoriaRepository.existsById(produtoDto.getId_categoria());

        if (!existenciaCategoria) {
            return false;
        }

        //Se a Categoria existe. cadastra
        ProdutoEntity produto = new ProdutoEntity();

        produto.setNome_produto(produtoDto.getNome_produto());
        produto.setPreco_produto(produtoDto.getPreco_produto());
        produto.setId_categoria(produtoDto.getId_categoria());

        repository.save(produto);
        return true;
    }

    public List<ProdutoDto> listarProdutos() {
        List<ProdutoDto> listaDto = new ArrayList<>();

        List<ProdutoEntity> produtos = repository.findAll();

        for (ProdutoEntity p : produtos) {
            listaDto.add(new ProdutoDto(p.getId_produto(), p.getNome_produto()));
        }
        return listaDto;
    }
}

