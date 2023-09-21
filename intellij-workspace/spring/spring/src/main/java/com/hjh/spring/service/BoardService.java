package com.hjh.spring.service;

import com.hjh.spring.model.entity.Board;
import com.hjh.spring.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService
{
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoardList()
    {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Board getArticleById(Long id)
    {
        return boardRepository.findArticleById(id);
    }

    public void addArticle(Board article)
    {
        Board newArticle = new Board();
        newArticle.setTitle(article.getTitle());
        newArticle.setContent(article.getContent());
        newArticle.setWriter(article.getWriter());
        newArticle.setWriteDate(article.getWriteDate());

        boardRepository.save(newArticle);
    }

    public void viewArticle(Long id)
    {
        Board article = boardRepository.findArticleById(id);

        article.setViewCount(article.getViewCount() + 1);
        boardRepository.save(article);
    }



    public void editArticle(Board article)
    {
        boardRepository.save(article);
    }

    public void removeArticle(Board article)
    {
        boardRepository.delete(article);
    }
}
