package br.com.zalf.prolog.webservicetestes.produto.service;

import br.com.zalf.prolog.webservicetestes.exception.PartNaoEncontradaException;
import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoDto;
import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoInsertDto;
import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import br.com.zalf.prolog.webservicetestes.produto.dao.ProductDao;
import br.com.zalf.prolog.webservicetestes.produto.mapper.ProductMapper;
import br.com.zalf.prolog.webservicetestes.produtoSubcategoria.service.ProdutoSubcategoriaService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {
    @NotNull
    private final ProductDao partDao;
    @NotNull
    private final ProductMapper partMapper;
    @NotNull
    private final ProdutoSubcategoriaService produtoSubcategoriaService;

    @NotNull
    public ProdutoDto insert(@NotNull final ProdutoInsertDto partInsertDto) {
        final var subCategoria = produtoSubcategoriaService.findById(partInsertDto.getSubcategoryId());
        final var part = partDao.save(ProductMapper.toEntity(subCategoria).apply(partInsertDto));
        return ProductMapper.toDto().apply(part);
    }

    public Produto findPartById(@NotNull final Long partId) {
        return partDao.findByCodigo(partId);
    }

    public List<ProdutoDto> getAll() {
        final var parts = partDao.findAll();
        return partMapper.toList(parts);
    }

    @NotNull
    @Transactional
    public void active(@NotNull final Long partId) {
        final Produto part = this.findPartById(partId);
        part.active();
    }

    @NotNull
    @Transactional
    public void disable(@NotNull final Long partId) {
        final Produto part = this.findPartById(partId);
        part.disable();
    }

//    @NotNull
    //    @Transactional
    //    public void update(@NotNull final ProductDto partDto) {
    //        final Product part = this.findPartById(partDto.getId());
    //        final Categoria categoria = categoriaService.findById(partDto.getSubcategoryId());
    //        BeanUtils.copyProperties(partDto, part, "id");
    //        part.setSubcategoria(categoria);
    //        part.setUnitMeasureEnum(partDto.getUnitMeasure());
    //        partDao.save(part);
    //    }
}
