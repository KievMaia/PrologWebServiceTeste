package br.com.zalf.prolog.webservicetestes.produto.mapper;

import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoDto;
import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoInsertDto;
import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public final class ProductMapper {
    @NotNull
    public static Function<ProdutoInsertDto, Produto> toEntity(final ProdutoSubcategoria produtoSubcategoria){
        return productDto ->  Produto.builder()
                .withProdutoSubcategoria(produtoSubcategoria)
                .withName(productDto.getName())
                .withProductIdentifier(productDto.getProductIdentifier())
                .withNcm(productDto.getNcm())
                .withUnitMeasureEnum(productDto.getUnitMeasure())
                .withStatusAtivo(true)
                .build();
    }

    @NotNull
    public static Function<Produto, ProdutoDto> toDto(){
        return productEntity -> ProdutoDto.builder()
                .withCodigo(productEntity.getCodigo())
                .withSubcategoryId(productEntity.getProdutoSubcategoria().getCodigo())
                .withName(productEntity.getName())
                .withProductIdentifier(productEntity.getProductIdentifier())
                .withNcm(productEntity.getNcm())
                .withUnitMeasure(productEntity.getUnitMeasureEnum())
                .withActive(productEntity.getStatusAtivo())
                .build();
    }

    @NotNull
    public List<ProdutoDto> toList(@NotNull final List<Produto> produtos) {
        List<ProdutoDto> listaProdutos = new ArrayList<>();
        produtos.forEach(produto -> {
            listaProdutos.add(toDto().apply(produto));
        });
        return listaProdutos;
    }
}
