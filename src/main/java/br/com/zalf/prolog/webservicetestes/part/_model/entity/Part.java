package br.com.zalf.prolog.webservicetestes.part._model.entity;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Table(name = "peca", schema = "public")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false, referencedColumnName = "id")
    private Categoria subcategoria;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "identificador_peca")
    private String partIdentifier;
    @Column(name = "id_adicional")
    private String additionalId;
    private String ncm;
    @Column(name = "unidade_medida")
    @Enumerated(EnumType.STRING)
    private UnitMeasureEnum unitMeasureEnum;
    @NotNull
    private Boolean active = true;

    public void active() {
        setActive(true);
    }
    public void disable() {
        setActive(false);
    }
}
