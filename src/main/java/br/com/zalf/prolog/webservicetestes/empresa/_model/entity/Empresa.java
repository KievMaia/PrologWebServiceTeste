package br.com.zalf.prolog.webservicetestes.empresa._model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "logo_thumbnail_url")
    private String logoThumbnailUrl;

    @Column(name = "data_hora_cadastro", nullable = false)
    private OffsetDateTime dataHoraCadastro;

    @Column(name = "cod_auxiliar")
    private String codAuxiliar;

    @Column(name = "status_ativo", nullable = false)
    private Boolean statusAtivo;

    @Column(name = "logo_consta_site_comercial", nullable = false)
    private Boolean logoConstaSiteComercial;

    @Column(name = "data_hora_ultima_atualizacao")
    private OffsetDateTime dataHoraUltimaAtualizacao;

    @Column(name = "responsavel_ultima_atualizacao")
    private String responsavelUltimaAtualizacao;
}
