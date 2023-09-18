package com.hjh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjh.model.entity.Ramen;
import com.hjh.service.RamenService;

@RestController
@RequestMapping("/ramen")
public class RamenController
{
    @Autowired
    RamenService ramenService;

    @GetMapping("/get/{num}")
    public Ramen getRecipe(@PathVariable("num") int no) throws Exception
    {
        Ramen ramen = ramenService.getContent(no);
        return ramen;
    }
}
