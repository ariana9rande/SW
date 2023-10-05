package com.hjh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hjh.demo.service.BoardService;

@Controller
public class BoardController
{
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService)
    {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String showHome()
    {
        return "index";
    }

    @GetMapping("/board/showAll")
    public ModelAndView printAll()
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", boardService.selectAll());

        mv.setViewName("board/showAll");

        return mv;
    }
}