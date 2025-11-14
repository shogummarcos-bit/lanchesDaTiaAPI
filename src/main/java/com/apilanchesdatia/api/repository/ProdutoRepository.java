package com.apilanchesdatia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apilanchesdatia.api.models.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDisponivelTrue();

    List<Produto> findByDisponivelFalse();

    List<Produto> findByCategoria(String categoria);

    boolean existsByNome(String nome);
}
