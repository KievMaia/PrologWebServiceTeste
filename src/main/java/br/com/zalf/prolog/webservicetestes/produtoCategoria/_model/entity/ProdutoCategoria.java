package br.com.zalf.prolog.webservicetestes.produtoCategoria._model.entity;

import br.com.zalf.prolog.webservicetestes.colaborador._model.entity.Colaborador;
import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto_categoria")
public class ProdutoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_empresa", nullable = false)
    private Empresa empresa;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status_ativo", nullable = false)
    private Boolean statusAtivo = true;

    @Column(name = "data_hora_cadastro", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime dataHoraCadastro = OffsetDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_colaborador_cadastro")
    private Colaborador colaboradorCadastro;

    @Column(name = "data_hora_ultima_atualizacao", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime dataHoraUltimaAtualizacao = OffsetDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_colaborador_ultima_atualizacao")
    private Colaborador colaboradorUltimaAtualizacao;
}
