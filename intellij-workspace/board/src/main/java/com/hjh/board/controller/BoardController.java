package com.hjh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BoardController
{
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/showAll")
    public String selectAll(Model model)
    {
        

        return "board/showAll";
    }
}
