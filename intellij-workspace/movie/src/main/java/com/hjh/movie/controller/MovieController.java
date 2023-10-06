package com.hjh.movie.controller;

import com.hjh.movie.model.Movie;
import com.hjh.movie.model.User;
import com.hjh.movie.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/edit/{id}")
    public String editMovieForm(Model model, @PathVariable Long id)
    {
        Movie movie = movieService.getMovie(id);

        model.addAttribute("movie", movie);

        return "movie/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(Model model, @PathVariable Long id,
                            @RequestParam("title") String title,
                            @RequestParam("director") String director,
                            @RequestParam("summary") String summary,
                            @RequestParam("releasedYear") String releasedYear,
                            @RequestParam("rating") String rating,
                            RedirectAttributes redirectAttributes)
    {
        Movie movie = movieService.getMovie(id);

        movie.setTitle(title);
        movie.setDirector(director);
        movie.setSummary(summary);
        movie.setReleasedYear(releasedYear);
        movie.setRating(rating);

        try
        {
            movieService.update(movie);

            model.addAttribute("movie", movie);
            redirectAttributes.addFlashAttribute("message", "영화 정보 수정이 완료되었습니다.");

            return "redirect:/movie/edit/" + id;
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            redirectAttributes.addFlashAttribute("message", message);

            return "redirect:/movie/edit/" + id;
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieConfirm(@PathVariable Long id, Model model)
    {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);

        return "movie/delete-confirm";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttributes,
                              @RequestParam("password") String password,
                              HttpSession session)
    {
        User user = (User)session.getAttribute("loggedInUser");

        if(!user.getPassword().equals(password))
        {
            redirectAttributes.addFlashAttribute("message", "비밀번호가 일치하지 않습니다.");

            return "redirect:/movie/delete/" + id;
        }

        Movie movie = movieService.getMovie(id);
        movieService.delete(movie);

        redirectAttributes.addFlashAttribute("message", "영화 삭제가 완료되었습니다.");

        return "redirect:/movie/list";
    }
}
