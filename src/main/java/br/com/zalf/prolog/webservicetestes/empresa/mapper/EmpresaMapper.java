package br.com.zalf.prolog.webservicetestes.empresa.mapper;

import br.com.zalf.prolog.webservicetestes.empresa._model.dto.EmpresaDto;
import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import jakarta.validation.constraints.NotNull;

import java.util.function.Function;

public class EmpresaMapper {
    @NotNull
    public static Function<EmpresaDto, Empresa> toInsertEntity() {
        return empresaDto -> Empresa.builder()
                .withCodigo(empresaDto.getCodigo())
                .withNome(empresaDto.getNome())
                .withLogoConstaSiteComercial(empresaDto.getLogoConstaSiteComercial())
                .withDataHoraCadastro(empresaDto.getDataHoraCadastro())
                .withCodAuxiliar(empresaDto.getCodAuxiliar())
                .withStatusAtivo(empresaDto.getStatusAtivo())
                .withLogoThumbnailUrl(empresaDto.getLogoThumbnailUrl())
                .withDataHoraUltimaAtualizacao(empresaDto.getDataHoraUltimaAtualizacao())
                .withResponsavelUltimaAtualizacao(empresaDto.getResponsavelUltimaAtualizacao())
                .build();
    }

    @NotNull
    public static Function<Empresa, EmpresaDto> toDto() {
        return empresaEntity -> EmpresaDto.builder()
                .withCodigo(empresaEntity.getCodigo())
                .withNome(empresaEntity.getNome())
                .withLogoThumbnailUrl(empresaEntity.getLogoThumbnailUrl())
                .withDataHoraCadastro(empresaEntity.getDataHoraCadastro())
                .withCodAuxiliar(empresaEntity.getCodAuxiliar())
                .withStatusAtivo(empresaEntity.getStatusAtivo())
                .withLogoConstaSiteComercial(empresaEntity.getLogoConstaSiteComercial())
                .withDataHoraUltimaAtualizacao(empresaEntity.getDataHoraUltimaAtualizacao())
                .withResponsavelUltimaAtualizacao(empresaEntity.getResponsavelUltimaAtualizacao())
                .build();
    }
}
