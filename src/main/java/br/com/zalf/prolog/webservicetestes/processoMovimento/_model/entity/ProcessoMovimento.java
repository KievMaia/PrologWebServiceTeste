package br.com.zalf.prolog.webservicetestes.processoMovimento._model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Entity
@Table(name = "processo_movimento")
public class ProcessoMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "data", nullable = false)
    private OffsetDateTime data = OffsetDateTime.now();

    @Column(name = "cod_unidade", nullable = false)
    private Integer codUnidade;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "cod_usuario", nullable = false)
    private Integer codUsuario;

    @Column(name = "tipo_processo")
    private String tipoProcesso;
}
