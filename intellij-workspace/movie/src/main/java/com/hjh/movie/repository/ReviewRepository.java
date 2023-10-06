package com.hjh.movie.repository;

import com.hjh.movie.model.Movie;
import com.hjh.movie.model.Review;
import com.hjh.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{
    Review findByUserAndMovie(User user, Movie movie);
    List<Review> findByMovieId(Long movieId);
    @Override
    Review getById(Long id);
}
