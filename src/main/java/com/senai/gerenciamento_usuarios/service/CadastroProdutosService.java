package com.senai.gerenciamento_usuarios.service;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.dto.ProdutoDto;
import com.senai.gerenciamento_usuarios.entity.CategoriaEntity;
import com.senai.gerenciamento_usuarios.entity.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroProdutosService {

    //ArrayList - memoria
    private ArrayList<CategoriaEntity> categorias = new ArrayList<>();
    private ArrayList<ProdutoEntity> produtos = new ArrayList<>();

    //Auto Incremento
    private long contadorCategoria = 1;
    private long contadorProduto = 1;


    //Categoria
    public boolean cadastrarCategoria(CategoriaDto categoriaDto) {

        CategoriaEntity categoria = new CategoriaEntity();

        categoria.setId_categoria(contadorCategoria++);
        categoria.setNome_categoria(categoriaDto.getNome_categoria());

        categorias.add(categoria);
        return true;
    }


    //Listar
    public List<CategoriaDto> listarCategorias() {
        List<CategoriaDto> listaDto = new ArrayList<>();

        for (CategoriaEntity c : categorias) {
            listaDto.add(new CategoriaDto(c.getId_categoria(), c.getNome_categoria()));
        }
        return listaDto;
    }

    //Produto
    public boolean cadastrarProduto(ProdutoDto produtoDto) {
        boolean existenciaCategoria = false;
        for (CategoriaEntity c : categorias) {
            if (c.getId_categoria() == produtoDto.getId_categoria()) {
                existenciaCategoria = true;
                break;
            }
        }

        if (!existenciaCategoria) {
            return false;
        }

        //Se a Categoria existe. cadastra
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId_produto(contadorProduto++);
        produto.setNome_produto(produtoDto.getNome_produto());
        produto.setPreco_produto(produtoDto.getPreco_produto());
        produto.setId_categoria(produtoDto.getId_categoria());

        produtos.add(produto);
        return true;
    }

    public List<ProdutoDto> listarProdutos() {
        List<ProdutoDto> listaDto = new ArrayList<>();

        for (ProdutoEntity p : produtos) {
            listaDto.add(new ProdutoDto(p.getId_produto(), p.getNome_produto()));
        }
        return listaDto;
    }

    public List<ProdutoDto> listarProdutosPorCategoria(long id_categoria) {
        List<ProdutoDto> listaDto = new ArrayList<>();

        for (ProdutoEntity p : produtos) {
            if (p.getId_categoria() == id_categoria) {
                listaDto.add(new ProdutoDto(p.getId_produto(), p.getNome_produto(), p.getPreco_produto(), p.getId_categoria()));
            }
        }
        return listaDto;
    }
}
