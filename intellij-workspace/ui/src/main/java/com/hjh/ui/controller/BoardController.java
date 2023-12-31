package com.hjh.ui.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/write")
    public String write()
    {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(String title, String content, HttpSession session)
    {
        if(session.getAttribute("loginId") == null)
        {
            return "redirect:/";
        }

        JsonObject object = new JsonObject();
        object.addProperty("title", title);
        object.addProperty("content", content);
        object.addProperty("writerId", Integer.parseInt(session.getAttribute("loginId").toString()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(object.toString(), headers);

        String result = restTemplate.postForObject("http://board/write", request, String.class);

        return "/";
    }
}
