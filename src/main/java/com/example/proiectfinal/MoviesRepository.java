package com.example.proiectfinal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<MoviesClass, Long> {

    @Override
    List<MoviesClass> findAll();

    @Query("SELECT m FROM MoviesClass m WHERE m.MovieId = ?1")
    MoviesClass findByMovieId(Long id);
}
