package br.com.zalf.prolog.webservicetestes.estoque.mapper;

import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import br.com.zalf.prolog.webservicetestes.empresa.mapper.EmpresaMapper;
import br.com.zalf.prolog.webservicetestes.estoque._model.dto.EstoqueDto;
import br.com.zalf.prolog.webservicetestes.estoque._model.entity.Estoque;
import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import br.com.zalf.prolog.webservicetestes.produto.mapper.ProductMapper;
import jakarta.validation.constraints.NotNull;

import java.util.function.Function;

public final class EstoqueMapper {

    @NotNull
    public static Function<EstoqueDto, Estoque> toInsertEntity(@NotNull final Empresa empresa,
                                                               @NotNull final Produto produto) {
        return estoqueDto -> Estoque.builder()
                .withProduto(produto)
                .withCompany(empresa)
                .withQuantidade(estoqueDto.getQuantidade())
                .withPrecoCustoMedio(estoqueDto.getPrecoCustoMedio())
                .withIndiceCriticidade(estoqueDto.getIndiceCriticidade())
                .withQtdEstoqueMinimo(estoqueDto.getQtdEstoqueMinimo())
                .withLeadTime(estoqueDto.getLeadTime())
                .withLocalizacao(estoqueDto.getLocalizacao())
                .build();
    }

    @NotNull
    public static Function<Estoque, EstoqueDto> toDto() {
        return estoqueEntity -> EstoqueDto.builder()
                .withCodigo(estoqueEntity.getCodigo())
                .withProdutoDto(ProductMapper.toDto().apply(estoqueEntity.getProduto()))
                .withEmpresaDto(EmpresaMapper.toDto().apply(estoqueEntity.getCompany()))
                .withQuantidade(estoqueEntity.getQuantidade())
                .withPrecoCustoMedio(estoqueEntity.getPrecoCustoMedio())
                .withIndiceCriticidade(estoqueEntity.getIndiceCriticidade())
                .withLeadTime(estoqueEntity.getLeadTime())
                .withQtdEstoqueMinimo(estoqueEntity.getQtdEstoqueMinimo())
                .withLocalizacao(estoqueEntity.getLocalizacao())
                .build();
    }
}
