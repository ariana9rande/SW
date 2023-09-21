package com.hjh.spring.service;

import com.hjh.spring.model.entity.Comment;
import com.hjh.spring.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService
{
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(Long id)
    {
        return commentRepository.findCommentById(id);
    }

    public void addComment(Comment comment)
    {
        Comment newComment = new Comment();
        newComment.setWriter(comment.getWriter());
        newComment.setContent(comment.getContent());

    }
}
