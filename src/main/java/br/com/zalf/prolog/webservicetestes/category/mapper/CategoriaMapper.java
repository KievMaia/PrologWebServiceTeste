package br.com.zalf.prolog.webservicetestes.category.mapper;

import br.com.zalf.prolog.webservicetestes.category._model.dto.CategoriaDto;
import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaMapper {
    @NotNull
    public Categoria toEntity(@NotNull final CategoriaDto categoriaDto){
        return Categoria.builder()
                .withNome(categoriaDto.getNome())
                .withCategoriaPai(categoriaDto.getCategoriaPai())
                .withCategorias(categoriaDto.getCategorias())
                .build();
    }

    @NotNull
    public CategoriaDto toDto(@NotNull final Categoria categoria){
        return CategoriaDto.builder()
                .withId(categoria.getId())
                .withNome(categoria.getNome())
                .withCategoriaPai(categoria.getCategoriaPai())
                .withCategorias(categoria.getCategorias())
                .build();
    }

    @NotNull
    public List<CategoriaDto> toDto(@NotNull final List<Categoria> categorias){
        return categorias.stream().map(this::toDto).collect(Collectors.toList());
    }
}
