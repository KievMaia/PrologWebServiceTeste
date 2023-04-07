package br.com.zalf.prolog.webservicetestes.produtoSubcategoria;

import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.dto.ProdutoSubcategoriaDto;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
import jakarta.validation.constraints.NotNull;

import java.util.function.Function;

public class ProdutoSubcategoriaMapper {

    public static Function<ProdutoSubcategoriaDto, ProdutoSubcategoria> toInsertEntity(@NotNull final Empresa empresa,
                                                                                       @NotNull final Produto produto) {
        return produtoSubcategoriaDto -> ProdutoSubcategoria.builder()
                .withCodigo(produtoSubcategoriaDto.getCodigo())
                .build();
    }
}
