package com.hjh.spring.service;

import com.hjh.spring.model.entity.Board;
import com.hjh.spring.repository.BoardRepository;
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

    public List<Board> boardList()
    {
        return boardRepository.findAll();
    }

    public void register(Board board)
    {
        Board newBoard = new Board();
        newBoard.setTitle(board.getTitle());
        newBoard.setContent(board.getContent());
        newBoard.setWriter(board.getWriter());
        newBoard.setWriteDate(board.getWriteDate());

        boardRepository.save(newBoard);
    }
}
