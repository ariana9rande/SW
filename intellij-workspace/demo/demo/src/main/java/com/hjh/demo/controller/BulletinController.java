package com.hjh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hjh.demo.service.BulletinService;

@Controller
public class BulletinController
{
    private BulletinService bulletinService;

    @Autowired
    public BulletinController(BulletinService bulletinService)
    {
        this.bulletinService = bulletinService;
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
        View view = new View();
        view.setPrefix(null);

        mv.setViewName("board/showAll");

        return mv;
    }
}