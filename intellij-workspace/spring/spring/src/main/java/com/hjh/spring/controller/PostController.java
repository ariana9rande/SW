package com.hjh.spring.controller;

import com.hjh.spring.model.entity.Comment;
import com.hjh.spring.model.entity.Post;
import com.hjh.spring.model.entity.User;
import com.hjh.spring.service.CommentService;
import com.hjh.spring.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class PostController
{
    PostService postService;
    CommentService commentService;

    public PostController(PostService postService, CommentService commentService)
    {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/list")
    public String postListPage(Model model)
    {
        List<Post> postList = postService.getPostList();
        model.addAttribute("postList", postList);

        return "board";
    }

    @GetMapping("/add")
    public String writeForm(HttpSession session)
    {
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null)
            return "write";
        else
        {
            session.setAttribute("error", "로그인 필요");
            return "redirect:/board/list";
        }
    }

    @PostMapping("/add")
    public String writeArticle(HttpSession session,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content)
    {
        Post article = new Post();
        article.setPostTitle(title);
        article.setPostContent(content);
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null)
            article.setPostWriter(loggedInUser.getName());
        else
            article.setPostWriter("anonymous");

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        article.setPostWriteDate(formattedDateTime);

        postService.addArticle(article);

        return "redirect:/board/list";
    }

    @GetMapping("/view/{id}")
    public String viewArticlePage(@PathVariable Long id, Model model,
                                  @RequestParam("articleNo") String articleNo)
    {
        postService.viewArticle(id);
        model.addAttribute("article", postService.getArticleById(id));
        model.addAttribute("articleNo", articleNo);
        model.addAttribute("commentList", commentService.getCommentListByPost(postService.getArticleById(id)));

        return "view";
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam("id") Long id,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content)
    {
        Post article = postService.getArticleById(id);
        article.setPostTitle(title);
        article.setPostContent(content);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        article.setPostWriteDate(formattedDateTime);

        postService.editArticle(article);

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String removeArticle(@RequestParam("id") Long id)
    {
        Post article = postService.getArticleById(id);
        postService.removeArticle(article);

        return "redirect:/board/list";
    }

    @PostMapping("/add-comment")
    public String addComment(@RequestParam("commentContent") String content,
                             HttpSession session, HttpServletRequest request,
                             @RequestParam("id") Long postId)
    {
        Comment comment = new Comment();
        comment.setContent(content);

        User loggedInUser = (User)session.getAttribute("loggedInUser");
        comment.setWriter(loggedInUser.getName());

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        comment.setWriteDate(formattedDateTime);

        comment.setPost(postService.getArticleById(postId));

        commentService.addComment(comment);

        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping("/edit-comment")
    public String editComment(@RequestParam("id") Long commentId,
                              @RequestParam("content") String content,
                              HttpServletRequest request)
    {
        Comment comment = commentService.getCommentById(commentId);

        comment.setContent(content);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        comment.setWriteDate(formattedDateTime);

        commentService.editComment(comment);

        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping("/remove-comment")
    public String removeComment(@RequestParam("id") Long commentId,
                                HttpServletRequest request)
    {
        Comment comment = commentService.getCommentById(commentId);

        commentService.removeComment(comment);

        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping("/like-post")
    public String likePost(@RequestParam("id") Long postId,
                           HttpServletRequest request)
    {
        postService.likeArticle(postId);

        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping("/like-comment")
    public String likeComment(@RequestParam("id") Long commentId,
                           HttpServletRequest request)
    {
        commentService.likeComment(commentId);

        return "redirect:" + request.getHeader("Referer");
    }
}
