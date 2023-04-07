package br.com.zalf.prolog.webservicetestes.product.resource;

import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductDto;
import br.com.zalf.prolog.webservicetestes.product._model.dto.ProductInsertDto;
import br.com.zalf.prolog.webservicetestes.product.mapper.ProductMapper;
import br.com.zalf.prolog.webservicetestes.product.service.ProductService;
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
    private final ProductService partService;
    @NotNull
    private final ProductMapper partMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto insert(@RequestBody @Valid final ProductInsertDto partInsertDto) {
        return partService.insert(partInsertDto);
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return partService.getAll();
    }

    @GetMapping("/{partId}")
    public ProductDto getPartById(@PathVariable final Long partId) {
        return partMapper.toDto(partService.findPartById(partId));
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

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void partUpdate(@RequestBody final ProductDto partDto) {
        this.partService.update(partDto);
    }
}
