package br.com.zalf.prolog.webservicetestes.category.resource;

import br.com.zalf.prolog.webservicetestes.category._model.dto.CategoriaDto;
import br.com.zalf.prolog.webservicetestes.category.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v3/categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaResource {
    @NotNull
    private final CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto insert(@RequestBody final CategoriaDto categoriaDto){
        return categoriaService.insert(categoriaDto);
    }
}
