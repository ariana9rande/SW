package com.hjh.spring.controller;

import com.hjh.spring.model.entity.Board;
import com.hjh.spring.model.entity.User;
import com.hjh.spring.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController
{
    BoardService boardService;

    public BoardController(BoardService boardService)
    {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String boardListPage(Model model)
    {
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "board";
    }

    @GetMapping("/add")
    public String writeForm()
    {
        return "write";
    }

    @PostMapping("/add")
    public String writeArticle(HttpSession session,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content)
    {
        Board article = new Board();
        article.setTitle(title);
        article.setContent(content);
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null)
            article.setWriter(loggedInUser.getName());
        else
            article.setWriter("anonymous");

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        article.setWriteDate(formattedDateTime);

        boardService.addArticle(article);

        return "redirect:/board/list";
    }

    @GetMapping("/view/{articleNo}")
    public String viewArticlePage(@PathVariable Long articleNo, Model model)
    {
        boardService.viewArticle(articleNo);
        model.addAttribute("article", boardService.getArticleById(articleNo));

        return "view";
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam("id") Long id,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content)
    {
        Board article = boardService.getArticleById(id);
        article.setTitle(title);
        article.setContent(content);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        article.setWriteDate(formattedDateTime);

        boardService.editArticle(article);

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String removeArticle(@RequestParam("id") Long id)
    {
        Board article = boardService.getArticleById(id);
        boardService.removeArticle(article);

        return "redirect:/board/list";
    }
}
