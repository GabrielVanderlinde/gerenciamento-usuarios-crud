package com.senai.gerenciamento_usuarios.service;

import com.senai.gerenciamento_usuarios.dto.CategoriaDto;
import com.senai.gerenciamento_usuarios.entity.CategoriaEntity;
import com.senai.gerenciamento_usuarios.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrarCategoria(CategoriaDto categoriaDto) {

        CategoriaEntity categoria = new CategoriaEntity();

        int contadorCategoria = 0;
        categoria.setId_categoria(contadorCategoria++);
        categoria.setNome_categoria(categoriaDto.getNome_categoria());

        repository.save(categoria);
        return true;
    }

    public List<CategoriaDto> listarCategorias() {
        List<CategoriaDto> listaDto = new ArrayList<>();

        List<CategoriaEntity> categorias = repository.findAll();

        for (CategoriaEntity c : categorias) {
            listaDto.add(new CategoriaDto(c.getId_categoria(), c.getNome_categoria()));
        }
        return listaDto;
    }

}
