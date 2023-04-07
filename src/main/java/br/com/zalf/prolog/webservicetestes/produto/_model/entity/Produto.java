package br.com.zalf.prolog.webservicetestes.produto._model.entity;

import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Table(name = "produto", schema = "public")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "cod_subcategoria", nullable = false, referencedColumnName = "codigo")
    private ProdutoSubcategoria produtoSubcategoria;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "identificador_produto")
    private String productIdentifier;
    @Column(name = "cod_auxiliar")
    private String codAuxiliar;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "unidade_medida")
    @Enumerated(EnumType.STRING)
    private UnitMeasureEnum unitMeasureEnum;
    @NotNull
    private Boolean statusAtivo = true;

    @CreationTimestamp
    @Column(name = "data_hora_cadastro", nullable = false)
    private OffsetDateTime dataHoraCadastro = OffsetDateTime.now();

    @Column(name = "cod_colaborador_cadastro")
    private Long codColaboradorCadastro;

    @Column(name = "origem_cadastro", nullable = false)
    private String origemCadastro;

    @UpdateTimestamp
    @Column(name = "data_hora_ultima_atualizacao", nullable = false)
    private OffsetDateTime dataHoraUltimaAtualizacao = OffsetDateTime.now();

    @Column(name = "cod_colaborador_ultima_atualizacao")
    private Long codColaboradorUltimaAtualizacao;

    @Column(name = "origem_ultima_edicao")
    private String origemUltimaEdicao;

    public void active() {
        setStatusAtivo(true);
    }

    public void disable() {
        setStatusAtivo(false);
    }
}
