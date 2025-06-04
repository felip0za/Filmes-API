package com.filmes.demo.repository;

import com.filmes.demo.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {

    List<Filmes> findByTitulo(String titulo);
}
