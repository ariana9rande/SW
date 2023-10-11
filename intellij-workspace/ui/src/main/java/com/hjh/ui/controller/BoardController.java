package com.hjh.ui.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/showAll")
    public String showAll(Model model)
    {
        String result = restTemplate.getForObject("http://board/selectAll", String.class);
        model.addAttribute("result", result);

        return "board/showAll";
    }

    @GetMapping("/showOne/{id}")
    public String showOne(@PathVariable int id, Model model)
    {
        String result = restTemplate.getForObject("http://board/selectOne/" + id, String.class);
        model.addAttribute("result", result);

        return "board/showOne";
    }
}
