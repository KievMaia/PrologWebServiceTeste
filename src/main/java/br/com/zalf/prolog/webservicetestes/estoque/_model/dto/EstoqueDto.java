package br.com.zalf.prolog.webservicetestes.estoque._model.dto;

import br.com.zalf.prolog.webservicetestes.empresa._model.dto.EmpresaDto;
import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class EstoqueDto {
    @Nullable
    private final Long codigo;
    @NotNull
    private final ProdutoDto produtoDto;
    @NotNull
    private final EmpresaDto empresaDto;
    @NotNull
    private final BigDecimal quantidade;
    @NotNull
    private BigDecimal precoCustoMedio;
    @NotNull
    private Integer indiceCriticidade;
    @NotNull
    private Integer leadTime;
    @NotNull
    private BigDecimal qtdEstoqueMinimo;
    @NotNull
    private String localizacao;
}
