package br.com.zalf.prolog.webservicetestes.estoque.resource;

import br.com.zalf.prolog.webservicetestes.estoque._model.dto.EstoqueDto;
import br.com.zalf.prolog.webservicetestes.estoque.service.EstoqueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v3/estoque")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EstoqueResource {
    @NotNull
    private final EstoqueService estoqueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueDto insert(@RequestBody @Valid final EstoqueDto estoqueDto){
        return estoqueService.insert(estoqueDto);
    }
}
