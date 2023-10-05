package com.hjh.demo.controller;

import com.hjh.demo.model.BoardDTO;
import com.hjh.demo.model.ReplyDTO;
import com.hjh.demo.model.UserDTO;
import com.hjh.demo.service.BoardService;
import com.hjh.demo.service.ReplyService;
import com.hjh.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController
{
    private ReplyService replyService;
    private BoardService boardService;
    private UserService userService;

    @Autowired
    public ReplyController(ReplyService replyService, BoardService boardService,
                           UserService userService)
    {
        this.replyService = replyService;
        this.boardService = boardService;
        this.userService = userService;
    }

    @PostMapping("{boardId}/write-reply")
    public String writeReply(@PathVariable int boardId, ReplyDTO replyDTO, HttpSession session)
    {
        UserDTO login = (UserDTO) session.getAttribute("login");

        replyDTO.setBoardId(boardId);
        replyDTO.setWriterId(login.getId());

        replyService.insert(replyDTO);

        return "redirect:/board/showOne/" + boardId;
    }
}
