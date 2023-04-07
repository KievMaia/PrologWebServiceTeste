package br.com.zalf.prolog.webservicetestes.estoque._model.entity;

import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import br.com.zalf.prolog.webservicetestes.product._model.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_produto", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cod_unidade", nullable = false)
    private Empresa company;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal quantidade;

    @Column(name = "preco_custo_medio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoCustoMedio;

    @Column(name = "indice_criticidade", nullable = false)
    private Integer indiceCriticidade;

    @Column(name = "lead_time", nullable = false)
    private Integer leadTime;

    @Column(name = "qtd_estoque_minimo", precision = 10, scale = 2, nullable = false)
    private BigDecimal qtdEstoqueMinimo;

    @Column(nullable = false)
    private String localizacao;
}
