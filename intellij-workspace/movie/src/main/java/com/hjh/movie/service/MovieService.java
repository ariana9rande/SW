package com.hjh.movie.service;

import com.hjh.movie.model.Movie;
import com.hjh.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Movie getMovie(Long id)
    {
        return movieRepository.findMovieById(id);
    }

    public void register(String title, String director, String summary, String releasedYear, String rating) throws Exception
    {

        if(movieRepository.findByTitle(title) != null)
        {
            throw new Exception("이미 등록된 영화입니다.");
        }

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setSummary(summary);
        movie.setReleasedYear(releasedYear);
        movie.setRating(rating);

        movieRepository.save(movie);
    }

    public void update(Movie movie) throws Exception
    {
        if(movieRepository.findByTitle(movie.getTitle()) != null)
        {
            throw new Exception("이미 등록된 영화입니다.");
        }
        else
        {
            movieRepository.save(movie);
        }
    }

    public void delete(Movie movie)
    {
        movieRepository.delete(movie);
    }
}
