package com.hjh.movie.controller;

import com.hjh.movie.model.User;
import com.hjh.movie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String signUpForm()
    {
        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(RedirectAttributes redirectAttributes, HttpServletRequest request,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("passwordConfirm") String passwordConfirm,
                         @RequestParam("nickname") String nickname)
    {
        try
        {
            userService.register(username, password, passwordConfirm, nickname);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");

            return "redirect:" + request.getHeader("Referer");
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            redirectAttributes.addFlashAttribute("message", message);

            return "redirect:" + request.getHeader("Referer");
        }
    }

    @GetMapping("/sign-in")
    public String signInForm()
    {
        return "user/sign-in";
    }

    @PostMapping("/sign-in")
    public String signIn(HttpSession session,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         RedirectAttributes redirectAttributes,
                         HttpServletRequest request)
    {
        User login = userService.login(username, password);

        if(login != null)
        {
            session.setAttribute("loggedInUser", login);

            return "redirect:/";
        }
        else
        {
            redirectAttributes.addFlashAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다.");

            return "redirect:" + request.getHeader("Referer");
        }
    }
}
