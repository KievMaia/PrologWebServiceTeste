package br.com.zalf.prolog.webservicetestes.empresa._model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class EmpresaDto {
    @NotNull
    private Long codigo;
    @NotNull
    private String nome;
    @Nullable
    private String logoThumbnailUrl;
    @NotNull
    private OffsetDateTime dataHoraCadastro;
    @Nullable
    private String codAuxiliar;
    @NotNull
    private Boolean statusAtivo;
    @NotNull
    private Boolean logoConstaSiteComercial;
    @Nullable
    private OffsetDateTime dataHoraUltimaAtualizacao;
    @Nullable
    private String responsavelUltimaAtualizacao;
}
