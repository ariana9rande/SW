package com.hjh.movie.repository;

import com.hjh.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
    Movie findByTitle(String title);
    Movie findMovieById(Long id);
}
