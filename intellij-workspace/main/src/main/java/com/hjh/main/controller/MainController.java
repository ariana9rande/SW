package com.hjh.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String showIndex()
    {
        return "index";
    }

    @PostMapping("/auth")
    public String getAuthResult(String username, String password)
    {
        System.out.println("username = " + username + ", password = " + password);
        System.out.println(restTemplate.exchange("http://user/auth", HttpMethod.POST, null, String.class, username, password).getBody());

        return "";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test()
    {
        System.out.println("MainController.test");
        return "test";
    }

}