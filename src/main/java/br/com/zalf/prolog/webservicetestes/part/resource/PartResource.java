package br.com.zalf.prolog.webservicetestes.part.resource;

import br.com.zalf.prolog.webservicetestes.part._model.dto.PartDto;
import br.com.zalf.prolog.webservicetestes.part._model.dto.PartInsertDto;
import br.com.zalf.prolog.webservicetestes.part.mapper.PartMapper;
import br.com.zalf.prolog.webservicetestes.part.service.PartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v3/part")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartResource {
    @NotNull
    private final PartService partService;
    @NotNull
    private final PartMapper partMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartDto insert(@RequestBody @Valid final PartInsertDto partInsertDto) {
        return partService.insert(partInsertDto);
    }

    @GetMapping
    public List<PartDto> getAll(){
        return partService.getAll();
    }

    @GetMapping("/{partId}")
    public PartDto getPartById(@PathVariable final Long partId) {
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
    public void partUpdate(@RequestBody final PartDto partDto) {
        this.partService.update(partDto);
    }
}
