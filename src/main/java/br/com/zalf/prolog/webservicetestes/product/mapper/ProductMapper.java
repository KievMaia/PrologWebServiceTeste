package br.com.zalf.prolog.webservicetestes.product.mapper;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductDto;
import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductInsertDto;
import br.com.zalf.prolog.webservicetestes.product._model.entity.Product;
import br.com.zalf.prolog.webservicetestes.product._model.entity.UnitMeasureEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @NotNull
    public Product toEntity(@NotNull final ProductInsertDto partInsertDto, final Categoria categoria, final UnitMeasureEnum unitMeasureEnum){
        return Product.builder()
                .withSubcategoria(categoria)
                .withName(partInsertDto.getName())
                .withProductIdentifier(partInsertDto.getProductIdentifier())
                .withAdditionalId(partInsertDto.getAdditionalId())
                .withNcm(partInsertDto.getNcm())
                .withUnitMeasureEnum(unitMeasureEnum)
                .withActive(true)
                .build();
    }

    @NotNull
    public ProductDto toDto(@NotNull final Product part){
        final var categoria = part.getSubcategoria();
        final UnitMeasureEnum unitMeasureEnum = part.getUnitMeasureEnum();
        return ProductDto.builder()
                .withId(part.getId())
                .withSubcategoryId(categoria.getId())
                .withName(part.getName())
                .withProductIdentifier(part.getProductIdentifier())
                .withAdditionalId(part.getAdditionalId())
                .withNcm(part.getNcm())
                .withUnitMeasure(unitMeasureEnum)
                .withActive(part.getActive())
                .build();
    }

    @NotNull
    public List<ProductDto> toList(@NotNull final List<Product> products){
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }
}
