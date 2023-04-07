package br.com.zalf.prolog.webservicetestes.colaborador._model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class ColaboradorDto {
    @NotNull
    private String cpf;
    @NotNull
    private String nome;
}
