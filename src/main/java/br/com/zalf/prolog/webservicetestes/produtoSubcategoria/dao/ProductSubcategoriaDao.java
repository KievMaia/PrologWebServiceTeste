package br.com.zalf.prolog.webservicetestes.produtoSubcategoria.dao;

import br.com.zalf.prolog.webservicetestes.produtoSubcategoria._model.entity.ProdutoSubcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubcategoriaDao extends JpaRepository<ProdutoSubcategoria, Long> {
}
