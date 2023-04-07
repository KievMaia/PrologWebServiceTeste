package br.com.zalf.prolog.webservicetestes.produto.dao;

import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Produto, Long> {
//    @Query("from Produto where codigo=:produtoId")
    Produto findByCodigo(Long produtoId);
}
