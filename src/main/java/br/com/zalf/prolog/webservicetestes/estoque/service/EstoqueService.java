package br.com.zalf.prolog.webservicetestes.estoque.service;

import br.com.zalf.prolog.webservicetestes.empresa.EmpresaService;
import br.com.zalf.prolog.webservicetestes.estoque._model.dto.EstoqueDto;
import br.com.zalf.prolog.webservicetestes.estoque.dao.EstoqueDao;
import br.com.zalf.prolog.webservicetestes.estoque.mapper.EstoqueMapper;
import br.com.zalf.prolog.webservicetestes.produto.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EstoqueService {

    @NotNull
    private final EstoqueDao estoqueDao;

    @NotNull
    private final EmpresaService empresaService;

    @NotNull
    private final ProdutoService produtoService;

    @NotNull
    public EstoqueDto insert(@NotNull final EstoqueDto estoqueDto) {
        final var produto = produtoService.findPartById(estoqueDto.getProdutoDto().getCodigo());
        final var empresa = empresaService.findById(estoqueDto.getEmpresaDto().getCodigo());

        return EstoqueMapper.toDto()
                .apply(estoqueDao.save(EstoqueMapper.toInsertEntity(empresa, produto).apply(estoqueDto)));
    }
}
