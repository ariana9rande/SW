package com.hjh.demo.controller;

import com.hjh.demo.model.UserDTO;
import com.hjh.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/register")
    public String showRegister()
    {
        return "user/register";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO)
    {
        userService.register(userDTO);

        return "redirect:/";
    }

    @PostMapping("/auth")
    public String auth(UserDTO userDTO, HttpSession session)
    {
        UserDTO login = userService.auth(userDTO);

        if(login != null)
        {
            session.setAttribute("login", login);
            return "redirect:/board/showAll";
        }
        else
            return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();

        return "redirect:/board/showAll";
    }
}
