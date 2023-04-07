package br.com.zalf.prolog.webservicetestes.empresa;

import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import br.com.zalf.prolog.webservicetestes.empresa.dao.EmpresaDao;
import br.com.zalf.prolog.webservicetestes.exception.EmpresaNaoEncontradaException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {
    @NotNull
    private final EmpresaDao empresaDao;

    public Empresa findById(@NotNull final Long empresaId) {
        return empresaDao.findById(empresaId).orElseThrow(() -> new EmpresaNaoEncontradaException(empresaId));
    }
}
