package br.com.zalf.prolog.webservicetestes.empresa.dao;

import br.com.zalf.prolog.webservicetestes.empresa._model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa, Long> {
}
