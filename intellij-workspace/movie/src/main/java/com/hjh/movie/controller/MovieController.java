package com.hjh.movie.controller;

import com.hjh.movie.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String addMovieForm()
    {
        return "movie/add-form";
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam("title") String title,
                           @RequestParam("director") String director,
                           @RequestParam("summary") String summary,
                           @RequestParam("releasedYear") String releasedYear,
                           @RequestParam("rating") String rating,
                           RedirectAttributes redirectAttributes,
                           HttpServletRequest request)
    {
        try
        {
            movieService.register(title, director, summary, releasedYear, rating);
            redirectAttributes.addFlashAttribute("message", "영화 등록이 완료되었습니다.");

            return "redirect:" + request.getHeader("Referer");
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            redirectAttributes.addFlashAttribute("message", message);

            return "redirect:" + request.getHeader("Referer");
        }
    }

//    @GetMapping("/edit/{id}")
//    public String editMovieForm(Model model, @PathVariable)
//    {
//
//    }
}
