package br.com.zalf.prolog.webservicetestes.category._model.dto;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class CategoriaDto {
    private Long id;
    private String nome;
    private Categoria categoriaPai;
    private List<Categoria> categorias;
}
