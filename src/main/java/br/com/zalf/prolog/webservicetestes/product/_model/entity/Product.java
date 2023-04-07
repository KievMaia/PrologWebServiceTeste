package br.com.zalf.prolog.webservicetestes.product._model.entity;

import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
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
@Table(name = "produto", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cod_subcategoria", nullable = false, referencedColumnName = "codigo")
    private ProdutoSubcategoria subcategoria;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "identificador_produto")
    private String productIdentifier;
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
