package br.com.zalf.prolog.webservicetestes.product.dao;

import br.com.zalf.prolog.webservicetestes.product._model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
