package com.hjh.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController
{
    @GetMapping("/showAll")
    public String showAll()
    {
        return "board/showAll";
    }
}
