package br.com.zalf.prolog.webservicetestes.product.service;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import br.com.zalf.prolog.webservicetestes.category.service.CategoriaService;
import br.com.zalf.prolog.webservicetestes.exception.PartNaoEncontradaException;
import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductDto;
import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductInsertDto;
import br.com.zalf.prolog.webservicetestes.product._model.entity.Product;
import br.com.zalf.prolog.webservicetestes.product.dao.ProductDao;
import br.com.zalf.prolog.webservicetestes.product.mapper.ProductMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    @NotNull
    private final ProductDao partDao;
    @NotNull
    private final ProductMapper partMapper;
    @NotNull
    private final CategoriaService categoriaService;

    @NotNull
    public ProductDto insert(@NotNull final ProductInsertDto partInsertDto) {
        final Categoria categoria = categoriaService.findById(partInsertDto.getSubcategoryId());
        final var part = partDao.save(partMapper.toEntity(partInsertDto, categoria, partInsertDto.getUnitMeasure()));
        return partMapper.toDto(part);
    }

    public Product findPartById(@NotNull final Long partId) {
        final var part = partDao.findById(partId).orElseThrow(() -> new PartNaoEncontradaException(partId));
        return part;
    }

    public List<ProductDto> getAll() {
        final var parts = partDao.findAll();
        return partMapper.toList(parts);
    }

    @NotNull
    @Transactional
    public void active(@NotNull final Long partId) {
        final Product part = this.findPartById(partId);
        part.active();
    }

    @NotNull
    @Transactional
    public void disable(@NotNull final Long partId) {
        final Product part = this.findPartById(partId);
        part.disable();
    }

    @NotNull
    @Transactional
    public void update(@NotNull final ProductDto partDto) {
        final Product part = this.findPartById(partDto.getId());
        final Categoria categoria = categoriaService.findById(partDto.getSubcategoryId());
        BeanUtils.copyProperties(partDto, part, "id");
        part.setSubcategoria(categoria);
        part.setUnitMeasureEnum(partDto.getUnitMeasure());
        partDao.save(part);
    }
}
