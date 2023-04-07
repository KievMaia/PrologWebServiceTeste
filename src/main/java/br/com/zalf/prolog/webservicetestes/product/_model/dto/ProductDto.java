package br.com.zalf.prolog.webservicetestes.product._model.dto;

import br.com.zalf.prolog.webservicetestes.product._model.entity.UnitMeasureEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class ProductDto {
    @NotNull
    private final Long id;
    @NotNull
    private final Long subcategoryId;
    @NotNull
    private final String name;
    @Nullable
    private final String productIdentifier;
    @Nullable
    private final String additionalId;
    @Nullable 
    private final String ncm;
    @NotNull
    private final UnitMeasureEnum unitMeasure;
    @NotNull
    private final Boolean active;
}