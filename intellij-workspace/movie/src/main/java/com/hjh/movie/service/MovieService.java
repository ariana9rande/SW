package com.hjh.movie.service;

import com.hjh.movie.model.Movie;
import com.hjh.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieList()
    {
        return movieRepository.findAll();
    }
}
