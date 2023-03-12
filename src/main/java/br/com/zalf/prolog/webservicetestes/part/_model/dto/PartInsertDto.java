package br.com.zalf.prolog.webservicetestes.part._model.dto;

import br.com.zalf.prolog.webservicetestes.part._model.entity.UnitMeasureEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class PartInsertDto {
    @NotNull
    private final Long subcategoryId;
    @NotNull
    private final String name;
    @Nullable
    private final String partIdentifier;
    @Nullable
    private final String ncm;
    @Nullable
    private final String additionalId;
    @NotNull
    private final UnitMeasureEnum unitMeasure;
}
