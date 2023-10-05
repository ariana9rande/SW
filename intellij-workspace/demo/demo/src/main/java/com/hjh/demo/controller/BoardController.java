package com.hjh.demo.controller;

import com.hjh.demo.model.BoardDTO;
import com.hjh.demo.model.ReplyDTO;
import com.hjh.demo.model.UserDTO;
import com.hjh.demo.service.ReplyService;
import com.hjh.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hjh.demo.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController
{
    private BoardService boardService;
    private UserService userService;
    private ReplyService replyService;

    @Autowired
    public BoardController(BoardService boardService, UserService userService, ReplyService replyService)
    {
        this.boardService = boardService;
        this.userService = userService;
        this.replyService = replyService;
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
        mv.addObject("list", boardService.selectAll());

        mv.setViewName("board/showAll");

        return mv;
    }

    @GetMapping("/board/write")
    public String showWrite()
    {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String write(BoardDTO boardDTO, HttpSession session)
    {
        UserDTO login = (UserDTO)session.getAttribute("login");
        if(login != null)
        {
            boardDTO.setWriterId(login.getId());
            boardService.insert(boardDTO);
        }

        return "redirect:/board/showAll";
    }

    @GetMapping("/board/showOne/{id}")
    public String showOne(@PathVariable int id, HttpSession session, Model model)
    {
        BoardDTO boardDTO = boardService.selectOne(id);
        
        model.addAttribute("board", boardDTO);
        model.addAttribute("login", (UserDTO)session.getAttribute("login"));

        List<ReplyDTO> replyList = new ArrayList<>();

        for(ReplyDTO r : replyService.selectAll())
        {
            if(r.getBoardId() == id)
                replyList.add(r);
        }

        model.addAttribute("replyList", replyList);

        return "board/showOne";
    }

    @GetMapping("/board/update/{id}")
    public String showUpdate(@PathVariable int id, Model model)
    {
        BoardDTO boardDTO = boardService.selectOne(id);
        model.addAttribute("board", boardDTO);

        return "board/update";
    }

    @PostMapping("/board/update/{id}")
    public String update(@PathVariable int id, @RequestParam("title") String title, @RequestParam("content") String content)
    {
        BoardDTO boardDTO = boardService.selectOne(id);

        boardDTO.setTitle(title);
        boardDTO.setContent(content);

        boardService.update(boardDTO);

        return "redirect:/board/showOne/" + id;
    }

    @GetMapping("/board/delete/{id}")
    public String showDeleteConfirm(@PathVariable int id, Model model)
    {
        BoardDTO boardDTO = boardService.selectOne(id);
        model.addAttribute("board", boardDTO);

        return "board/deleteConfirm";
    }

    @PostMapping("/board/delete/{id}")
    public String deleteConfirm(@PathVariable int id, @RequestParam("password") String password, Model model)
    {
        BoardDTO boardDTO = boardService.selectOne(id);
        UserDTO writer = userService.selectById(boardDTO.getWriterId());

        if(writer.getPassword().equals(password))
        {
            boardService.delete(id);
            return "redirect:/board/showAll";
        }
        else
        {
            model.addAttribute("board", boardDTO);
            model.addAttribute("message", "비밀번호가 일치하지 않습니다.");

            return "board/deleteConfirm";
        }
    }
}