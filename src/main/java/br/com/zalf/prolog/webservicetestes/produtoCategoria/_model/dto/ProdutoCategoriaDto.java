package br.com.zalf.prolog.webservicetestes.produtoCategoria._model.dto;

import br.com.zalf.prolog.webservicetestes.colaborador._model.dto.ColaboradorDto;
import br.com.zalf.prolog.webservicetestes.empresa._model.dto.EmpresaDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class ProdutoCategoriaDto {
    @NotNull
    private Long codigo;
    @NotNull
    private EmpresaDto empresa;
    @NotNull
    private String nome;
    @NotNull
    private Boolean statusAtivo;
    @NotNull
    private OffsetDateTime dataHoraCadastro;
    @NotNull
    private ColaboradorDto colaboradorCadastro;
    @Nullable
    private OffsetDateTime dataHoraUltimaAtualizacao;
    @Nullable
    private ColaboradorDto colaboradorUltimaAtualizacao;
}
