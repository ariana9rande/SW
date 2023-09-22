package com.hjh.spring.controller;

import com.hjh.spring.model.entity.User;
import com.hjh.spring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String signUp(RedirectAttributes redirectAttributes,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "passwordConfirm") String passwordConfirm,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "role") String role)
    {
        if(userService.findUserByName(name) != null)
        {
            redirectAttributes.addFlashAttribute("message", "이미 존재하는 ID입니다.");
            return "redirect:/user/sign-up";
        }

        if(!password.equals(passwordConfirm))
        {
            redirectAttributes.addFlashAttribute("message", "비밀번호 확인이 일치하지 않습니다.");
            return "redirect:/user/sign-up";
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);

        userService.register(user);

        redirectAttributes.addFlashAttribute("message", "회원 가입 완료");
        return "redirect:/user/sign-up-form";
    }

    @GetMapping("/sign-in")
    public String signInForm()
    {
        return "sign-in-form";
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam("name") String name,
                         @RequestParam("password") String password,
                         RedirectAttributes redirectAttributes, HttpSession session)
    {
        User user = userService.findUserByName(name);
        if(user != null && user.getPassword().equals(password))
        {
            session.setAttribute("loggedInUser", user);
            return "redirect:/board/list";
        }
        else
        {
            redirectAttributes.addFlashAttribute("message", "id 또는 pwd가 잘못되었습니다.");
            return "redirect:/user/sign-in";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }
}
