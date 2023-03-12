package br.com.zalf.prolog.webservicetestes.part.service;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import br.com.zalf.prolog.webservicetestes.category.service.CategoriaService;
import br.com.zalf.prolog.webservicetestes.exception.PartNaoEncontradaException;
import br.com.zalf.prolog.webservicetestes.part._model.dto.PartDto;
import br.com.zalf.prolog.webservicetestes.part._model.dto.PartInsertDto;
import br.com.zalf.prolog.webservicetestes.part._model.entity.Part;
import br.com.zalf.prolog.webservicetestes.part.dao.PartDao;
import br.com.zalf.prolog.webservicetestes.part.mapper.PartMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartService {
    @NotNull
    private final PartDao partDao;
    @NotNull
    private final PartMapper partMapper;
    @NotNull
    private final CategoriaService categoriaService;

    @NotNull
    public PartDto insert(@NotNull final PartInsertDto partInsertDto) {
        final Categoria categoria = categoriaService.findById(partInsertDto.getSubcategoryId());
        final var part = partDao.save(partMapper.toEntity(partInsertDto, categoria, partInsertDto.getUnitMeasure()));
        return partMapper.toDto(part);
    }

    public Part findPartById(@NotNull final Long partId) {
        final var part = partDao.findById(partId).orElseThrow(() -> new PartNaoEncontradaException(partId));
        return part;
    }

    public List<PartDto> getAll() {
        final var parts = partDao.findAll();
        return partMapper.toList(parts);
    }

    @NotNull
    @Transactional
    public void active(@NotNull final Long partId) {
        final Part part = this.findPartById(partId);
        part.active();
    }

    @NotNull
    @Transactional
    public void disable(@NotNull final Long partId) {
        final Part part = this.findPartById(partId);
        part.disable();
    }

    @NotNull
    @Transactional
    public void update(@NotNull final PartDto partDto) {
        final Part part = this.findPartById(partDto.getId());
        final Categoria categoria = categoriaService.findById(partDto.getSubcategoryId());
        BeanUtils.copyProperties(partDto, part, "id");
        part.setSubcategoria(categoria);
        part.setUnitMeasureEnum(partDto.getUnitMeasure());
        partDao.save(part);
    }
}
