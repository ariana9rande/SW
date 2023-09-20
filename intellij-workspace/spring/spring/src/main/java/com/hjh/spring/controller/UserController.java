package com.hjh.spring.controller;

import com.hjh.spring.model.entity.User;
import com.hjh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/sign-up")
    public String signUpForm()
    {
        return "sign-up-form";
    }

    @PostMapping("/sign-up")
    public String signUp(Model model,
                       @RequestParam(value="name") String name,
                       @RequestParam(value="password") String password,
                       @RequestParam(value="passwordConfirm") String passwordConfirm,
                       @RequestParam(value="email") String email,
                       @RequestParam(value="role") String role)
    {
        if(userService.findUserByName(name) != null)
        {
            model.addAttribute("error", "이미 존재하는 ID입니다.");
            return "sign-up-form";
        }

        if(!password.equals(passwordConfirm))
        {
            model.addAttribute("error", "비밀번호 확인이 일치하지 않습니다.");
            return "sign-up-form";
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);

        userService.register(user);

        model.addAttribute("success", "회원 가입 완료");
        return "sign-up-form";
    }

    @GetMapping("/sign-in")
    public String signInForm()
    {
        return "sign-in-form";
    }
}
