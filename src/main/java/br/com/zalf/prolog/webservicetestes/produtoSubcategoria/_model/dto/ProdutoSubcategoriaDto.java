package br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.dto;

import br.com.zalf.prolog.webservicetestes.colaborador._model.dto.ColaboradorDto;
import br.com.zalf.prolog.webservicetestes.colaborador._model.entity.Colaborador;
import br.com.zalf.prolog.webservicetestes.produtoCategoria._model.dto.ProdutoCategoriaDto;
import br.com.zalf.prolog.webservicetestes.produtoCategoria._model.entity.ProdutoCategoria;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class ProdutoSubcategoriaDto {
    @Nullable
    private Long codigo;
    @NotNull
    private ProdutoCategoriaDto produtoCategoriaDto;
    @NotNull
    private String nome;
    @NotNull
    private Boolean statusAtivo = true;
    @NotNull
    private OffsetDateTime dataHoraCadastro = OffsetDateTime.now();
    @NotNull
    private ColaboradorDto colaboradorCadastroDto;
    @NotNull
    private OffsetDateTime dataHoraUltimaAtualizacao = OffsetDateTime.now();
    @NotNull
    private ColaboradorDto colaboradorUltimaAtualizacaoDto;
}
