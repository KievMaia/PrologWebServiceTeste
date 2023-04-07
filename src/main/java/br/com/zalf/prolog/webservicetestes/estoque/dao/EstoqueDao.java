package br.com.zalf.prolog.webservicetestes.estoque.dao;

import br.com.zalf.prolog.webservicetestes.estoque._model.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueDao extends JpaRepository<Estoque, Long> {
}
