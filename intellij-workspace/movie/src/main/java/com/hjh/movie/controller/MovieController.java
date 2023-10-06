package com.hjh.movie.controller;

import com.hjh.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController
{
    private MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping({"/", "list"})
    public String movieList(Model model)
    {
        model.addAttribute("movieList", movieService.getMovieList());

        return "movie/list";
    }


}
