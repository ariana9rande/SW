package com.hjh.spring.repository;

import com.hjh.spring.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
    public Comment findCommentById(Long id);
}
