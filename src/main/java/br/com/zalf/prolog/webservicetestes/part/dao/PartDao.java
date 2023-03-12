package br.com.zalf.prolog.webservicetestes.part.dao;

import br.com.zalf.prolog.webservicetestes.part._model.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartDao extends JpaRepository<Part, Long> {
}
