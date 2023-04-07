package br.com.zalf.prolog.webservicetestes.produtoSubcategoria.service;

import br.com.zalf.prolog.webservicetestes.exception.ProdutoSubcategoriaNaoEncontradaException;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.dto.ProdutoSubcategoriaDto;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria.dao.ProductSubcategoriaDao;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoSubcategoriaService {
    @NotNull
    private final ProductSubcategoriaDao productSubcategoriaDao;

    @NotNull
    public ProdutoSubcategoria findById(@NotNull final Long produtoSubcategoriaId) {
        return productSubcategoriaDao.findById(produtoSubcategoriaId)
                .orElseThrow(() -> new ProdutoSubcategoriaNaoEncontradaException(produtoSubcategoriaId));
    }
}
