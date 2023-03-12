package br.com.zalf.prolog.webservicetestes.category._model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Table(name = "categoria", schema = "public")
public class Categoria {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;
    @OneToMany(mappedBy = "categoriaPai", fetch = FetchType.LAZY)
    private List<Categoria> categorias;
}
