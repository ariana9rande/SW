package com.hjh.demo.controller;

import com.hjh.demo.model.UserDTO;
import com.hjh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public String auth(UserDTO userDTO)
    {
        UserDTO login = userService.auth(userDTO);
        System.out.println("UserController.auth");
        System.out.println("userDTO = " + userDTO);
        System.out.println("login = " + login);
        if(login != null)
        {
            return "redirect:/board/showAll";
        }
        else
            return "redirect:/";
    }
}
