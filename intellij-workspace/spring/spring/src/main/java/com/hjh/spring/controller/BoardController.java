package com.hjh.spring.controller;

import com.hjh.spring.model.entity.Board;
import com.hjh.spring.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Board> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);

        return "board";
    }

    @GetMapping("/add")
    public String writeForm()
    {
        return "write";
    }

    @PostMapping("/add")
    public String write(HttpSession session,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content)
    {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
    }
}
