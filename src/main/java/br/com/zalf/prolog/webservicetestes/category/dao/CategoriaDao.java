package br.com.zalf.prolog.webservicetestes.category.dao;

import br.com.zalf.prolog.webservicetestes.category._model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
