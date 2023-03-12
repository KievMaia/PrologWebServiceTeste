package br.com.zalf.prolog.webservicetestes.part.mapper;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import br.com.zalf.prolog.webservicetestes.part._model.dto.PartDto;
import br.com.zalf.prolog.webservicetestes.part._model.dto.PartInsertDto;
import br.com.zalf.prolog.webservicetestes.part._model.entity.Part;
import br.com.zalf.prolog.webservicetestes.part._model.entity.UnitMeasureEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartMapper {
    @NotNull
    public Part toEntity(@NotNull final PartInsertDto partInsertDto, final Categoria categoria, final UnitMeasureEnum unitMeasureEnum){
        return Part.builder()
                .withSubcategoria(categoria)
                .withName(partInsertDto.getName())
                .withPartIdentifier(partInsertDto.getPartIdentifier())
                .withAdditionalId(partInsertDto.getAdditionalId())
                .withNcm(partInsertDto.getNcm())
                .withUnitMeasureEnum(unitMeasureEnum)
                .withActive(true)
                .build();
    }

    @NotNull
    public PartDto toDto(@NotNull final Part part){
        final var categoria = part.getSubcategoria();
        final UnitMeasureEnum unitMeasureEnum = part.getUnitMeasureEnum();
        return PartDto.builder()
                .withId(part.getId())
                .withSubcategoryId(categoria.getId())
                .withName(part.getName())
                .withPartIdentifier(part.getPartIdentifier())
                .withAdditionalId(part.getAdditionalId())
                .withNcm(part.getNcm())
                .withUnitMeasure(unitMeasureEnum)
                .withActive(part.getActive())
                .build();
    }

    @NotNull
    public List<PartDto> toList(@NotNull final List<Part> parts){
        return parts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
