package com.hjh.spring.repository;

import com.hjh.spring.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>
{
    public Board findArticleById(Long id);
}
