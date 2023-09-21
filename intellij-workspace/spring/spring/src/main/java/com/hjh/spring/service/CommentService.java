package com.hjh.spring.service;

import com.hjh.spring.model.entity.Comment;
import com.hjh.spring.model.entity.Post;
import com.hjh.spring.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        newComment.setWriteDate(comment.getWriteDate());
        newComment.setPost(comment.getPost());

        commentRepository.save(newComment);
    }

    public List<Comment> getCommentList()
    {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentListByPost(Post post)
    {
        return commentRepository.findAllByPost(post);
    }

    public void editComment(Comment comment)
    {
        commentRepository.save(comment);
    }

    public void removeComment(Comment comment)
    {
        commentRepository.delete(comment);
    }
}
