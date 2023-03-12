package br.com.zalf.prolog.webservicetestes.category.service;

import br.com.zalf.prolog.webservicetestes.category._model.dto.CategoriaDto;
import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import br.com.zalf.prolog.webservicetestes.category.dao.CategoriaDao;
import br.com.zalf.prolog.webservicetestes.category.mapper.CategoriaMapper;
import br.com.zalf.prolog.webservicetestes.exception.CategoriaNaoEncontradaException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {
    @NotNull
    private final CategoriaDao categoriaDao;
    @NotNull
    private final CategoriaMapper categoriaMapper;

    @NotNull
    @Transactional
    public CategoriaDto insert(@NotNull final CategoriaDto categoriaDto) {
        final var categoriaEntity = categoriaMapper.toEntity(categoriaDto);
        final var categoria = categoriaDao.save(categoriaEntity);
        return categoriaMapper.toDto(categoria);
    }

    @NotNull
    public Categoria findById(@NotNull final Long categoriaId){
        final Categoria categoria = categoriaDao.findById(categoriaId).orElseThrow(() -> new CategoriaNaoEncontradaException(categoriaId));
        return categoria;
    }
}
