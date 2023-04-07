package br.com.zalf.prolog.webservicetestes.produto.resource;

import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoDto;
import br.com.zalf.prolog.webservicetestes.produto._model.dto.ProdutoInsertDto;
import br.com.zalf.prolog.webservicetestes.produto.mapper.ProductMapper;
import br.com.zalf.prolog.webservicetestes.produto.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v3/part")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductResource {
    @NotNull
    private final ProdutoService partService;
    @NotNull
    private final ProductMapper partMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto insert(@RequestBody @Valid final ProdutoInsertDto partInsertDto) {
        return partService.insert(partInsertDto);
    }

    @GetMapping
    public List<ProdutoDto> getAll(){
        return partService.getAll();
    }

    @GetMapping("/{partId}")
    public ProdutoDto getPartById(@PathVariable final Long partId) {
        final var product = partService.findPartById(partId);
        return ProductMapper.toDto().apply(product);
    }

    @PutMapping("/{partId}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activePart(@PathVariable final Long partId){
        partService.active(partId);
    }

    @PutMapping("/{partId}/disable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void disablePart(@PathVariable final Long partId){
        partService.disable(partId);
    }

//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void partUpdate(@RequestBody final ProductDto partDto) {
//        this.partService.update(partDto);
//    }
}
